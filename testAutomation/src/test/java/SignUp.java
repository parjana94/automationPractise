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

public class SignUp {
    public String mail = "testing21548@gmail.com";
    public String pass = "beka";
    @BeforeTest
    public void SetUp(){
        open("https://www.automationexercise.com/");
    }
    @Test (priority = 1)
    public void SignUpTest(){
        SelenideElement signUpBtn = $(".fa-lock");
        SelenideElement signUpBlock= $(".signup-form");
        SelenideElement name = $(byName("name"));
        SelenideElement regBtn = signUpBlock.$(byText("Signup"));
        SelenideElement accInfo = $(byTagName("h2")).$(byText("Enter Account Information"));
        SelenideElement gender = $("#uniform-id_gender1");
        SelenideElement accDel =$(byTagAndText("b", "Account Deleted!"));

        signUpBtn.click();
        Assert.assertEquals(signUpBlock.$(byTagName("h2")).getText(), "New User Signup!", "Verify 'New User Signup!' is visible");
        name.setValue("Beka");
        signUpBlock.$(byName("email")).setValue(mail);
        regBtn.click();
        Assert.assertTrue(accInfo.is(visible), "Verify that 'ENTER ACCOUNT INFORMATION' is visible");
        gender.click();
        $("#password").setValue(pass);
        $("#days").selectOption("6");
        $("#months").selectOption("July");
        $("#years").selectOption("1994");
        $("#newsletter").click();
        $("#optin").click();
        $("#first_name").setValue("Beka");
        $("#last_name").setValue("Smith");
        $("#company").setValue("Corp");
        $("#address1").setValue("New York");
        $("#address2").setValue("New York");
        $("#country").selectOption("United States");
        $("#state").setValue("NY");
        $("#city").setValue("Tbilisi");
        $("#zipcode").setValue("484");
        $("#mobile_number").setValue("464984521");
        $(byTagAndText("Button", "Create Account")).click();
        $(byLinkText("Continue")).click();
        $(byLinkText("Delete Account")).click();
        Assert.assertEquals(accDel.getText(), "ACCOUNT DELETED!", "Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button");

    }
}
