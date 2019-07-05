package ru.qa.armada.n01_workWithWebElement.webPageElements;

import org.openqa.selenium.WebElement;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.Element;

/**
 * <h1>This class work with CheckBox in software "Armada"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the typical table represent below: </b></p>
 * <p>
 * <img src="{@docRoot}/doc-files/.png" alt="TypicalCheckBox.png">
 * </p>
 */
public class CheckBox extends Element {

  public CheckBox(WebElement webElement) {
    super(webElement);
  }

  /**
   * Установить значение чекбокса
   * @param value значение чекбокса
   */
  public void setChecked(boolean value) {
    if (value != getStatus()) {
      webElement.click();
    }
  }

  /**
   * вернуть значение чекбокса
   * @return статус чекбокса
   */
  public boolean getStatus() {
    return webElement.isSelected();
  }
}
