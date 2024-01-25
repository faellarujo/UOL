package host.uol.config;

import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
public class ConfigURL {

    private String vingadoresUrl;
    private String ligaDaJusticaUrl;


    public ConfigURL() throws IOException {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        }
        this.vingadoresUrl     = properties.getProperty("vingadores.url");
        this.ligaDaJusticaUrl  = properties.getProperty("ligaDaJustica.url");
    }

    public String getVingadoresUrl() {
        return vingadoresUrl;
    }

    public String getLigaDaJusticaUrl() {
        return ligaDaJusticaUrl;
    }
}
