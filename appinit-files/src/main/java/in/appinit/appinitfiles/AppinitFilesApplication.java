package in.appinit.appinitfiles;

import in.appinit.appinitfiles.storage.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class AppinitFilesApplication {


    public static void main(String[] args) {
        SpringApplication.run(AppinitFilesApplication.class, args);
        createFolder();
    }

    private static void createFolder() {
        File file = new File(System.getProperty("user.home") + "/appinit-files");
        File workbooks = new File(System.getProperty("user.home") + "/appinit-files/workbooks");
        File images = new File(System.getProperty("user.home") + "/appinit-files/images");

        List<File> directories = new ArrayList<>();
        directories.add(file);
        directories.add(workbooks);
        directories.add(images);

        directories.forEach(
                f -> {
                    if (!f.exists()) {
                        Logger.getLogger("AppInit Files").log(Level.INFO, new StringBuffer().append(f.getName()).append(" created(?) ").append(f.mkdir()).toString());
                    } else {
                        Logger.getLogger("AppInit Files").log(Level.INFO, new StringBuffer().append(f.getName()).append(" exists.").toString());
                    }
                }
        );
    }

}
