package in.appinit.appinitfiles.services;

import in.appinit.appinitfiles.model.FileType;
import in.appinit.appinitfiles.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadServices {

    @Autowired
    StorageService storageService;

    public String uploadFile(MultipartFile multipartFile) {
        try {
            return storageService.uploadFile(multipartFile);
        } catch (Exception e) {
            return "Failed";
        }
    }

    public String uploadFile(MultipartFile multipartFile, FileType fileType) {
        try {
            return storageService.uploadFile(multipartFile, fileType);
        } catch (Exception e) {
            return "Failed";
        }
    }
}
