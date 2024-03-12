package br.com.bvss.es6.api.estoque.commons.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties
public class OpenApiInfoLicenseProperty {
    private String name;
    private String url;
}
