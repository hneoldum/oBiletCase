package stepDefinition;

import PageObjectModel.SingUpPage;
import io.cucumber.java.en.When;

public class SingUpSteps {

public SingUpPage singUpPage= new SingUpPage();
    @When("Click Member Login")
    public void clickMemberLogin()
    {
        singUpPage.clickMemberLogin();
    }

    @When("Click Register Button")
    public void clickRegisterButton()
    {
        singUpPage.clickRegisterButton();
    }

    @When("Type e-mail {string}")
    public void typeEmail(String email)
    {
        singUpPage.typeEmail(email);
    }

    @When("Type password {string}")
    public void typePassword(String password)
    {
        singUpPage.typePassword(password);
    }
    @When("Click Contract Checkbox")
    public void clickContractCheckbox()
    {
        singUpPage.clickContractCheckbox();
    }

    @When("Check HomePage")
    public void checkHomePage()
    {
        singUpPage.checkHomePage();
    }
}
