package sit.int204.classicmodelservice.exceptions;

import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public abstract class loginNotfoundException implements AuthenticationEntryPoint {

//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        response.setContentType("application/json;charset=UTF-8");
//        response.getWriter().write("{\"message\": \"Invalid username or password\"}");
//    }
}

