package tests;

import model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logOut();
        }
    }

    @Test
    public void registrationSuccess() {

        int i = (int) System.currentTimeMillis() / 1000;
        User user = new User().setEmail("alla" + i + "@gmail.com").setPassword("Aalla12345$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);

       app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submit();


    }


}
