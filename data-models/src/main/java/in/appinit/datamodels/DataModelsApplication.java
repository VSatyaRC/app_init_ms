package in.appinit.datamodels;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DataModelsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataModelsApplication.class, args);
    }

    @Bean
    Gson gson() {
        return new Gson();
    }

}
