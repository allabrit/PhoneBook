package tests;

import model.Contact;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContactTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$"));
        }

    }

    @Test(invocationCount = 5)
    public void addNewContactSuccess() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;

        Contact contact = Contact.builder()
                .name("Dolly" + i)
                .lastname("Wok")
                .email("wok@mail.com")
                .phone("12345876" + i)
                .address("TelAviv")
                .description("The best friend").build();
        loger.info("Contact is-->" + contact.toString());

        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().saveContact();
        //app.contact().saveContact2();
        Assert.assertTrue(app.contact().isContactAddedByName(contact.getName()));
        Assert.assertTrue(app.contact().isContactAddedByPhone(contact.getPhone()));

    }
}
