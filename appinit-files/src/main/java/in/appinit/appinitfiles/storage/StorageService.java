package in.appinit.appinitfiles.storage;

import in.appinit.appinitfiles.model.FileType;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

    void init();

    String uploadFile(MultipartFile file);

    String uploadFile(MultipartFile file, FileType fileType);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();

}
