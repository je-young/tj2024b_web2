package web.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 빈 등록 // 스프링 시작될때 해당 클래스를 읽어드린다.
public class CorsConfig implements WebMvcConfigurer {
    // (1) implements WebMvcConfigurer : spring mvc 관련 설정값을 수정하는 인터페이스
    // (2) CORS 관련 설정값 수정 , 오버라이딩(재정의) , addCorsMappings 매소드

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 모든 스프링 컨트롤러의 매핑에 대해서
                .allowedOrigins("http://localhost:5173" , "http://localhost:5174") // 허용할 출처(도메인)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메소드
                .allowedHeaders("*") // 허용할 HTTP 허더(body)
                .allowCredentials(true); // cookie, session 고유
    } // end addCorsMappings
} // end class
