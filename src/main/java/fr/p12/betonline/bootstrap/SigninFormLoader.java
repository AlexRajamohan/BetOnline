package fr.p12.betonline.bootstrap;

import fr.p12.betonline.beans.SigninForm;
import fr.p12.betonline.repositories.SigninFormRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by audre on 27/04/2017.
 */

@Component
public class SigninFormLoader implements ApplicationListener<ContextRefreshedEvent> {

    private SigninFormRepository signinFormRepository;

    private Logger log = Logger.getLogger(SigninFormLoader.class);

    @Autowired
    public void setSigninFormRepository(SigninFormRepository signinFormRepository) {
        this.signinFormRepository = signinFormRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        SigninForm test = new SigninForm();
        test.setEmail("audrey.seurin91@gmail.com");
        test.setPassword("projet");
        signinFormRepository.save(test);

        log.info("Saved SigninForm - id: " + test.getEmail());

        SigninForm test2 = new SigninForm();
        test2.setEmail("lucie.seurin@gmail.com");
        test2.setPassword("projet2");
        signinFormRepository.save(test2);

        log.info("Saved SigninForm - id: " + test2.getEmail());
    }

}
