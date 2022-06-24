package in.appinit.appinitpages;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AppinitPagesApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppinitPagesApplication.class, args);
    }

    @Bean
    public Gson gson() {
        return new GsonBuilder().create();
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
