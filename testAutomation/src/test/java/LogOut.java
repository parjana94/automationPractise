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

public class LogOut {
    @BeforeTest
    public void setUp (){
        open("https://www.automationexercise.com/");
    }
    @Test (priority = 4)
    public void logOutTest(){
        SelenideElement loginBlock = $(".login-form");
        $(byLinkText("Signup / Login")).click();
        Assert.assertTrue($(byTagAndText("h2","Login to your account")).is(visible), "Verify 'Login to your account' is visible");
        loginBlock.$(byName("email")).setValue("test199406@gmail.com");
        loginBlock.$(byName("password")).setValue("beka");
        $(byTagAndText("button","Login")).click();
        $(byLinkText("Logout")).click();
        Assert.assertTrue($(byTagAndText("h2","Login to your account")).is(visible), "Verify 'Login to your account' is visible");
    }
}
