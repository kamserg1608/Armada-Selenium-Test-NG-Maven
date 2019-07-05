package ru.qa.armada.n01_workWithWebElement.webPageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.Element;

public class DoubleTypicalTaskComboBox extends Element {
    public DoubleTypicalTaskComboBox(WebElement webElement) {
        super(webElement);
    }

    private WebElement getMainElement(){
        WebElement tempItem = webElement.findElement(By.xpath("./ancestor::div[contains(@class,'x-form-item')]//table"));

        return tempItem;
    }

    public void  getValueLeftColumn(){

        WebElement mainItem = getMainElement();
        WebElement leftElement = mainItem.findElement(By.xpath("//input"));
        String ert = leftElement.getAttribute("value");
        leftElement.sendKeys("123");
    }

}
