package ru.qa.armada.n03_applicationStructure.loginPage;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n01_workWithWebElement.webPageElements.Button;
import ru.qa.armada.n01_workWithWebElement.webPageElements.TextField;
import ru.qa.armada.n01_workWithWebElement.webPageElements.WaitElement;
import ru.qa.armada.n02_appManagerForTest.SingletonWaitingItem;
import ru.qa.armada.n02_appManagerForTest.SingletonWebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <h1>This class work with "login form of Armada"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 * <img src="{@docRoot}/doc-files/LoginPage.png" alt="альтернативный текст">
 * </p>
 */

public class LoginPage {

    private Logger logger;


  //region elementDefinitionBlock
///////////////////////////////////////////////////////////////////
  @FindBy(xpath = "//h1[@id='armadaLoginTitle']")
  private WaitElement labelLoginPage;
  /**
   * Locator -  Main tree "Command centre"
   */
  @FindBy(xpath = "//span[text()='Радиоконтроль']")
  private WaitElement commandCentre;

  /**
   * Locator -  Login field
   */
  @FindBy(id = "j_username")
  private TextField loginLocator;

  /**
   * Locator -  Password field
   * */
  @FindBy(id = "j_password")
  private TextField passwordLocator;

  /**
   * Locator - Button "Enter" of window "LoginPage"
   */
  @FindBy(id = "loginButton")
  private Button buttonLogin;

  /**
   * Locator - Allert Access is denied
   */
  @FindBy(xpath = "//h2[contains(text(),'Доступ запрещен, необходима авторизация.')]")
  private TextField incorrectMessage;

/////////////////////////////////////////////////////////////////
//endregion

  //region constructorDefinitionBlock
///////////////////////////////////////////////////////////////////

  /**
   * Initializes webElement Use Annotation @FindBy
   */

  public LoginPage() {
    PageFactory.initElements(new CustomFieldDecorator(SingletonWebDriver.driver), this);
    this.logger = LoggerFactory.getLogger(LoginPage.class);
  }

/////////////////////////////////////////////////////////////////
//endregion

  /**
   * enter "Name" in the login field
   *
   * @param username Use Login "admin"
   */
  public void writeUserName(String username) {
    loginLocator.setText(username);
  }

  /**
   * enter "Password" in the password field
   *
   * @param password Use Password "admin"
   */
  public void writePassword(String password) {
    passwordLocator.setText(password);
  }

  /**
   * Click button "enter the armada"
   */
  public void submitLogin() {
    buttonLogin.click();
  }

  /**
   * WaitElement Command Center of main windows Armada
   */
  public void waitMainPage() {
    SingletonWaitingItem.waitElementVisibly(commandCentre);
  }
  public void waitLoginPage(){
    SingletonWaitingItem.waitElementVisibly(labelLoginPage);
  }


  /**
   * Global function including all steps to enter the main window Armada
   *
   * <h3>Uses the following functions.</h3>
   * <div>
   *   <ul>
   *     <li> Use the {@link #writeUserName(String) } method.</li>
   *     <li> Use the {@link #writePassword(String) } method. </li>
   *     <li> Use the {@link #submitLogin() } method. </li>
   *     <li> Use the {@link #waitMainPage() } method. </li>
   *   </ul>
   * </div>
   *
   * @param username Use Login "admin"
   * @param password Use Password "admin"
   */
  public void submitAutorization(String username, String password) {
    boolean aa = true;
    int a = 0;
    while(aa){
      try {
        waitLoginPage();
        aa = false;
        a += 20;
      } catch (Exception e) {
          logger.debug("Request Exceeded {}" , a);
      }
    }
    writeUserName(username);
    writePassword(password);
    submitLogin();
    waitMainPage();
  }
}
