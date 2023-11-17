package mx.veterinaria.chichen.itzamna.itzamna10.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GlobalConfig {
    @Bean
    public ModelMapper modelMapper(){return new ModelMapper();}

}
