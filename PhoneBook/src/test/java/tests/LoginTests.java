package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logOut();
        }
    }

@Test
    public void loginASuccess(){
//open form
    app.getHelperUser().openLoginRegistrationForm();
    //fill form + valid data
    app.getHelperUser().fillLoginRegistrationForm("noa@gmail.com","Nnoa12345$");
    //submit login
    app.getHelperUser().submitLogin();
    //Assert
}


@Test
    public void loginNegativeTestsWrongEmail(){
    app.getHelperUser().openLoginRegistrationForm();
    app.getHelperUser().fillLoginRegistrationForm("noagmail.com","Nnoa12345$");
    app.getHelperUser().submitLogin();
}


}
