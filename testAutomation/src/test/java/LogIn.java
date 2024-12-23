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
    @Test (priority = 2)
    public void validTest(){
        SelenideElement loginBlock = $(".login-form");
        SelenideElement accDel =$(byTagAndText("b", "Account Deleted!"));

        $(byLinkText("Signup / Login")).click();
        Assert.assertTrue($(byTagAndText("h2","Login to your account")).is(visible), "Verify 'Login to your account' is visible");
        loginBlock.$(byName("email")).setValue("test199406@gmail.com");
        loginBlock.$(byName("password")).setValue("beka");
        $(byTagAndText("button","Login")).click();
        $(byLinkText("Logout")).click();
    }
    @Test (priority = 3)
    public void invalidTest(){
        SelenideElement loginBlock = $(".login-form");
        $(byLinkText("Signup / Login")).click();
        Assert.assertTrue($(byTagAndText("h2","Login to your account")).is(visible), "Verify 'Login to your account' is visible");
        loginBlock.$(byName("email")).setValue("b.parjana@gmail.com");
        loginBlock.$(byName("password")).setValue("beka");
        $(byTagAndText("button","Login")).click();
        $(byTagAndText("p","Your email or password is incorrect!"));

    }
}
