//package api.bookcatalogue.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//@Component
//public class BasicAuthenticationPoint extends BasicAuthenticationEntryPoint {
//
//
//    @Autowired
//    HttpSession httpSession;
//
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
//            throws IOException, ServletException {
//        response.addHeader( "WWW-Authenticate", "Basic realm=" +getRealmName());
//        System.out.println("alo basicAuthentication");
//        System.out.println(this.httpSession.getAttribute("name"));
//
//        if(this.httpSession.getAttribute("name") !=null ){
//            response.setStatus(HttpServletResponse.SC_ACCEPTED);
//        }
//        else {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            PrintWriter writer = response.getWriter();
//            writer.println("HTTP Status 401 - " + authEx.getMessage());
//        }
//    }
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        setRealmName("user");
//        super.afterPropertiesSet();
//    }
//}
