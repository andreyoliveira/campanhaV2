package br.com.conceptmx.campanhaV2.config;

import io.swagger.models.Contact;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    public Docket detalheApi(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.select()
                .apis(RequestHandlerSelectors.basePackage("br.com.conceptmx"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.informacoesApi().build());

        return docket;
    }

    private ApiInfoBuilder informacoesApi(){

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("API Campanha");
        apiInfoBuilder.description("Api para CRUD de Campanha.");
        apiInfoBuilder.version("1.0");

        /*Contact contact = new Contact();
        contact.name("Andrey Silva de Oliveira");
        contact.url("https://www.linkedin.com/in/andrey-silva-de-oliveira-3389a38/");
        contact.email("andrey.oliveira@gmail.com");
        apiInfoBuilder.contact(contact);*/

        return apiInfoBuilder;
    }

}
