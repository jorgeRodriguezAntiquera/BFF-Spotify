package cl.uv.ici.arq.spotify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@SpringBootApplication
@EnableFeignClients
@ConfigurationProperties
@PropertySources({
        @PropertySource("classpath:rest.properties") 
})
public class BffPlaylistApplication {

	public static void main(String[] args) {
		SpringApplication.run(BffPlaylistApplication.class, args);
	}

}
