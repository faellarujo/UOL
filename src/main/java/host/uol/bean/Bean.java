package host.uol.bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class Bean {

    @org.springframework.context.annotation.Bean
    public WebServiceTemplate webServiceTemplate() {
        return new WebServiceTemplate();
    }



}
