package me.dongwook.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WevConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*") // 모든 경로 허용
                .allowedOriginPatterns("http://localhost:*") // 어떤 클라이언트 요청 허용 할건지
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true) // 자격 증명 허용
                .maxAge(3600); // preflight 요청 캐시 시간


    }


}
