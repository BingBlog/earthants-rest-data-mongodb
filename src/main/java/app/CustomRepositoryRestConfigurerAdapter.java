package app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.Validator;

@Configuration
public class CustomRepositoryRestConfigurerAdapter extends RepositoryRestConfigurerAdapter {

   @Bean
   public Validator validator() {
       return new LocalValidatorFactoryBean();
   }

   @Override
   public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
       validatingListener.addValidator("afterCreate", validator());
       validatingListener.addValidator("beforeCreate", validator());
       validatingListener.addValidator("afterSave", validator());
       validatingListener.addValidator("beforeSave", validator());
   }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//        System.out.println("=============================\n");
//        System.out.println(config);
//        System.out.println("=============================\n");

//        config.setBasePath("/api");

        config.setRepositoryDetectionStrategy(
            RepositoryDetectionStrategy.RepositoryDetectionStrategies.ANNOTATED
        );
    }

}
