package web4mo.whatsgoingon.config.Authentication;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException, java.io.IOException {
        // 유효한 자격증명을 제공하지 않고 접근하려 할때 401 UNAUTHORIZED 에러를 리턴
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
