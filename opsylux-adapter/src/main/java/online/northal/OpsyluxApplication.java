package online.northal;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OpsyluxApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpsyluxApplication.class, args);
        System.out.println("Opsylux Application started successfully!");
        System.out.println("Visit: http://localhost:8080/v1/api/docs/index.html for API documentation.");
    }
}
