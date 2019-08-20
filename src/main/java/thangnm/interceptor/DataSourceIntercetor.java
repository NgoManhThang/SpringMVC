package thangnm.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataSourceIntercetor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String contexPath = request.getContextPath();

        // DataSource database student
        String prefixStudent = contexPath + "/student";

        // DataSource database teacher
        String prefixTeacher = contexPath + "/teacher";

        String uri = request.getRequestURI();
        System.out.println("URI: "+uri);
        if ( uri.startsWith(prefixStudent) ){
            request.setAttribute("keyDS", "STUDENT_DS");
        } else {
            request.setAttribute("keyDS", "TEACHER_DS");
        }
        return true;
    }
}
