package mx.veterinaria.chichen.itzamna.itzamna10.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class GlobalConfig {
    @Bean
    public ModelMapper modelMapper(){return new ModelMapper();}

}
