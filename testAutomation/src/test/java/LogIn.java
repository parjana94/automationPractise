import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class LogIn {
    @BeforeTest
    public void setUp(){
        open("https://www.automationexercise.com/");
    }
    @Test
    public void validTest(){
        SelenideElement loginBlock = $(".login-form");
        SelenideElement accDel =$(byTagAndText("b", "Account Deleted!"));

        $(byLinkText("Signup / Login")).click();
        Assert.assertTrue($(byTagAndText("h2","Login to your account")).is(visible), "Verify 'Login to your account' is visible");
        loginBlock.$(byName("email")).setValue("test1122211@gmail.com");
        loginBlock.$(byName("password")).setValue("1212");
        $(byTagAndText("button","Login")).click();
        $(byLinkText("Delete Account")).click();
        Assert.assertEquals(accDel.getText(), "ACCOUNT DELETED!", "Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button");
    }
    @Test
    public void invalidTest(){
        SelenideElement loginBlock = $(".login-form");
        $(byLinkText("Signup / Login")).click();
        Assert.assertTrue($(byTagAndText("h2","Login to your account")).is(visible), "Verify 'Login to your account' is visible");
        loginBlock.$(byName("email")).setValue("b.parjana@gmail.com");
        loginBlock.$(byName("password")).setValue("beka");
        $(byTagAndText("button","Login")).click();
        $(byTagAndText("p","Your email or password is incorrect!"));

        sleep(5000);
    }
}
