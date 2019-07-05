package ru.qa.armada.n01_workWithWebElement.webPageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.Element;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class SingleTypicalTaskComboBox extends Element {
    public SingleTypicalTaskComboBox(WebElement webElement) {
        super(webElement);
    }

    private WebElement getMainElement(){
        WebElement tempItem = webElement.findElement(By.xpath("./ancestor::div[contains(@class,'x-form-item')]//div[@role='combobox']"));

        return tempItem;
    }

    private Map<String, WebElement> getValueRowsValueAndElement(){

        WebElement row = getMainElement();
        //open list
        row.click();
        List<WebElement> rows = row.findElements(By.xpath("//div[@role='listitem']"));
        ListIterator<WebElement> rowIterator = rows.listIterator();

        Map<String, WebElement> rowsWithStates = new HashMap<String, WebElement>();
        while (rowIterator.hasNext()){
            WebElement currentItem = rowIterator.next();
            rowsWithStates.put(currentItem.getText(),currentItem);
        }

        return  rowsWithStates;
    }

    public void selectElement(String objectSelect){
        Map<String, WebElement> rowsValueAndElement = getValueRowsValueAndElement();
        rowsValueAndElement.get(objectSelect).click();
    }

    public String getValueOfSelectedItem(){
        WebElement mainElement = getMainElement();
        mainElement.click();
        WebElement item = webElement.findElement(By.xpath("//div[@role='listitem' and contains(@class,'x-combo-selected')]"));
        String valueSelectItem = item.getText();
        item.click();

        return valueSelectItem;
    }


}
