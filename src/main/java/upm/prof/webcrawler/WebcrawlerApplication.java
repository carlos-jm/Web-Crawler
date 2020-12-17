package upm.prof.webcrawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WebcrawlerApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(WebcrawlerApplication.class, args);
    }
}
