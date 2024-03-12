package br.com.bvss.es6.api.estoque.commons.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties
public class OpenApiInfoProperty {
    private String title;
    private String version;
    private String description;
    private OpenApiInfoLicenseProperty license;
}
