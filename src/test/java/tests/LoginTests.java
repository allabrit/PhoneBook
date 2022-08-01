package tests;

import org.testng.Assert;
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
    public void loginSuccess(){
//open form
    app.getHelperUser().openLoginRegistrationForm();
    //fill form + valid data
    app.getHelperUser().fillLoginRegistrationForm("noa@gmail.com", "Nnoa12345$");
    //submit login
    app.getHelperUser().submit();
    //Assert
    Assert.assertTrue(app.getHelperUser().isLogged());
}


@Test
    public void loginNegativeTestsWrongEmail(){
    app.getHelperUser().openLoginRegistrationForm();
    app.getHelperUser().fillLoginRegistrationForm("allagmail.com", "Aalla12345$");
    app.getHelperUser().submit();


    Assert.assertFalse(app.getHelperUser().isLogged());
    Assert.assertTrue(app.getHelperUser().isAlertDisplayed());
    Assert.assertTrue(app.getHelperUser().isErrorFormatDisplayed());


}


}
