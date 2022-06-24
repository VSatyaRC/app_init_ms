package in.appinit.appinitfiles.controller;

import in.appinit.appinitfiles.model.FileType;
import in.appinit.appinitfiles.services.UploadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UploadController {

    @Autowired
    UploadServices uploadServices;

    @Value("${resource.url}")
    String resourceURL;

    @RequestMapping(path = "/upload", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("file") MultipartFile multipartFile) {

        System.out.println("Uploading file");
        Map<String, String> response = new HashMap<>();
        String uploadedFile = uploadServices.uploadFile(multipartFile);
        if (!uploadedFile.matches("Failed")) {
            response.put("message", "upload successful");
            response.put("filename", resourceURL + uploadedFile);
            return ResponseEntity.ok(response);
        }
        response.put("message", "Upload failed");
        return ResponseEntity.internalServerError().body(response);
    }

    @RequestMapping(path = "/upload/{fileType}", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> uploadWorkbook(@PathVariable String fileType, @RequestParam("file") MultipartFile multipartFile) {

        System.out.println("Uploading file");
        Map<String, String> response = new HashMap<>();
        String uploadedFile = uploadServices.uploadFile(multipartFile, FileType. valueOf(fileType.toUpperCase()));
        if (!uploadedFile.matches("Failed")) {
            response.put("message", "upload successful");
            response.put("filename", resourceURL + fileType + "/" + uploadedFile);
            return ResponseEntity.ok(response);
        }
        response.put("message", "Upload failed");
        return ResponseEntity.internalServerError().body(response);
    }

}
