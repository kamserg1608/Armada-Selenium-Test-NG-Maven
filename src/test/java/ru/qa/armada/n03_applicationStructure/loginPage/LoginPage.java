/**
 * Domain classes used to produce .....
 * <p>
 * These classes contain the ......
 * </p>
 *
 * @since 1.0
 * @author somebody
 * @version 1.0
 */
package ru.qa.armada.n03_applicationStructure.loginPage;

import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.CustomFieldDecorator;
import ru.qa.armada.n01_workWithWebElement.webPageElements.Button;
import ru.qa.armada.n01_workWithWebElement.webPageElements.TextField;
import ru.qa.armada.n01_workWithWebElement.webPageElements.WaitElement;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWaitingItem;
import ru.qa.armada.n02_appManagerForTest.workWithDriver.SingletonWebDriver;

/**
 * <h1>This class work with "login form of Armada"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the page object pattern: </b></p>
 * <p>
 * <img src="{@docRoot}/doc-files/LoginPage.png" alt="LoginPage.png">
 * </p>
 */

public class LoginPage {

  private Logger logger;
  @FindBy(tagName = "select")
  private Select select;

  //region elementDefinitionBlock
///////////////////////////////////////////////////////////////////
//  By sessionExpired = By.xpath("//div[@id='stylized']/h2[text()='Время сеанса истекло, необходима авторизация']");
  @FindBy(xpath = "//div[@id='stylized']/h2[text()='Время сеанса истекло, необходима авторизация']")
  private WaitElement sessionExpired;
  /**
   * Locator -  Main tree "Command centre"
   */

  @FindBy(xpath = "//h1[@id='armadaLoginTitle']")
  private WaitElement labelLoginPage;
  /**
   * Locator -  Main tree "Command centre"
   */
  @FindBy(xpath = "//span[text()='Радиоконтроль']")
  private WaitElement commandCentre;

  /**
   * Locator -  Element for wait loading services
   */
  @FindBy(xpath = "//span[text()='Радиоконтроль']")
  private WaitElement labelLoading;

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
   * Locator - Button "Authorization" of window "Session Expired"
   */
  @FindBy(id = "sessionExpiredLink")
  private Button authorization;

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
//
//  /**
//   * WaitElement Command Center of main windows Armada
//   */
//  public boolean waitMainPage() {
//    return SingletonWaitingItem.waitElementVisiblyOrError(commandCentre);
//  }
//  public boolean waitLoginPage(){
//    return SingletonWaitingItem.waitElementVisiblyOrError(labelLoginPage);
//  }


  /**
   * Global function including all steps to enter the main window Armada
   *
   * <h3>Uses the following functions.</h3>
   * <div>
   *   <ul>
   *     <li> Use the {@link #writeUserName(String) } method.</li>
   *     <li> Use the {@link #writePassword(String) } method. </li>
   *     <li> Use the {@link #submitLogin() } method. </li>
   *   </ul>
   * </div>
   *
   * @param username Use Login "admin"
   * @param password Use Password "admin"
   */
  @Step("login in Armada login form")
  public void submitAutorization(String username, String password) {
    logger.debug("Work with submit Autorization");
    Assert.assertTrue(SingletonWaitingItem.waitElementVisiblyOrError(labelLoginPage));
    assert SingletonWaitingItem.waitElementVisiblyOrError(labelLoginPage);
//    Assert.assertTrue( waitLoginPage() );
    writeUserName(username);
    writePassword(password);
    submitLogin();
    assert SingletonWaitingItem.waitElementVisiblyOrError(commandCentre);
  }

  @Step("CheckSessionExpired")
  public void checkSessionExpired() {
    if(SingletonWaitingItem.waitElementVisibly(sessionExpired)){
      Assert.assertTrue(SingletonWaitingItem.waitElementVisiblyOrError(sessionExpired));
      authorization.click();
    } else {
      Assert.assertTrue(SingletonWaitingItem.waitElementInvisiblyOrError(sessionExpired));
    }
  }
}
