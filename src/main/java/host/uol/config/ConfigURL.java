package host.uol.config;

import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
public class ConfigURL {

    public void config() throws IOException {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        }
        String vingadores = properties.getProperty("vingadores.url");
        String ligaDaJustica = properties.getProperty("ligaDaJustica.url");
    }
}
