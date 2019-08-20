package thangnm.routing;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class MyRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String keyDS = (String) request.getAttribute("keyDS");
        System.out.println("Key DS: "+keyDS);
        if( keyDS == null ){
            keyDS = "STUDENT_DS";
        }
        return keyDS;
    }
}
