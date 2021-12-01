package com.company.servermanager;

import com.company.servermanager.enums.Server;
import com.company.servermanager.model.Status;
import com.company.servermanager.repo.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class ServerManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerManagerApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ServerRepo serverRepo){
        return args -> {
            serverRepo.save(new Server(null, "172.17.0.1","Docker", "16GB", "Container",
                    "http://localhost:8080/server/image/server1.png", Status.SERVER_UP));
            serverRepo.save(new Server(null, "127.0.0.1","Kali", "64GB", "Web Server",
                    "http://localhost:8080/server/image/server2.png", Status.SERVER_UP));
            serverRepo.save(new Server(null, "192.168.100.4","WLan", "32GB", "Dell Tower",
                    "http://localhost:8080/server/image/server3.png", Status.SERVER_UP));
            serverRepo.save(new Server(null, "192.168.1.48","Mac OS", "16GB", "Mail Server",
                    "http://localhost:8080/server/image/server4.png", Status.SERVER_UP));
        };
    }

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000","http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin","Content-Type",
                "Accept","Jwt-Token", "Authorization","Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin","Content-Type","Accept", "Jwt-TOken",
                "Authorization","Access-Control-Allow-Origin","Access-Control-Allow-Credentials","Filename"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","PATCH","DELETE","OPTIONS"));
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
