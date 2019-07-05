package ru.qa.armada.n01_workWithWebElement.webPageElements;

//import com.sun.xml.internal.bind.v2.TODO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.Element;

import java.util.*;

public class AccordionElement extends Element {

    public AccordionElement(WebElement webElement) {
        super(webElement);
    }

    private List<WebElement> getRows(){
        List<WebElement> rows = webElement.findElements(By.xpath("./ancestor::div[contains(@class,'x-panel-noborder')]//table[@class='x-grid3-row-table']"));
        return rows;
    }

    @Deprecated
    //TODO: check use this method
    private List<List<WebElement>> getRowsWithColumns(){
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
        for (WebElement row : rows){
            List<WebElement> rowWithColumns = row.findElements(By.xpath(".//td//div"));
            rowsWithColumns.add(rowWithColumns);
        }
        return rowsWithColumns;
    }

    public List<Boolean> getValueCheckBoxRows(){
        List<WebElement> rows = getRows();
        List<Boolean> valueRowsCheckBox = new ArrayList<Boolean>();
        for(WebElement row : rows){

            boolean currentCheckBoxValue = false;
            String enableCheckBox = "x-grid3-check-col-on";
            String attributeParameter = "class";
            WebElement fullPathToCheckBoxValue = row.findElement(By.xpath(".//div[contains(@class,'x-grid3-col-used')]/div"));
            String valueOfAllClassElements = fullPathToCheckBoxValue.getAttribute(attributeParameter);
            int resultCollapsed = valueOfAllClassElements.indexOf(enableCheckBox);

            if(resultCollapsed != -1){
                currentCheckBoxValue = true;
            } else {
                currentCheckBoxValue = false;
            }
            valueRowsCheckBox.add(currentCheckBoxValue);
        }
        return  valueRowsCheckBox;
    }
    public List<WebElement> getWebElementCheckBoxRows(){
        List<WebElement> rows = getRows();
        List<WebElement> webElementCheckBox = new ArrayList<WebElement>();
        for(WebElement row : rows){
            WebElement fullPathToCheckBoxValue = row.findElement(By.xpath(".//div[contains(@class,'x-grid3-col-used')]/div"));
            webElementCheckBox.add(fullPathToCheckBoxValue);
        }
        return  webElementCheckBox;
    }

    public List<String> getValueNameRows(){
        List<WebElement> rows = getRows();
        List<String> valueRows = new ArrayList<String>();
        for(WebElement row : rows){
            String aaa = row.findElement(By.xpath(".//div[contains(@class,'x-grid3-col-name')]")).getText();
            valueRows.add(aaa);
        }
        return  valueRows;
    }

//    public List<Map<String, Boolean>> getStatusOfLinesWithName(){
//
//        List<String> nameRow = getValueNameRows();
//        List<Boolean> valueCheckBox = getValueCheckBoxRows();
//
//        List<Map<String, Boolean>> rowsWithStates = new ArrayList<Map<String, Boolean>>();
//
//        ListIterator<String> iteratorNameRow = nameRow.listIterator();
//        ListIterator<Boolean> iteratorCheckBox = valueCheckBox.listIterator();
//
//        while(iteratorNameRow.hasNext() && iteratorCheckBox.hasNext()){
//            Map<String, Boolean> tempItem = new HashMap<String, Boolean>();
//            tempItem.put(iteratorNameRow.next(),iteratorCheckBox.next());
//            rowsWithStates.add(tempItem);
//        }
//        return rowsWithStates;
//    }
    public Map<String, Boolean> getStatusOfLinesWithName(){

        List<String> nameRow = getValueNameRows();
        List<Boolean> valueCheckBox = getValueCheckBoxRows();

        Map<String, Boolean> rowsWithStates = new HashMap<String, Boolean>();

        ListIterator<String> iteratorNameRow = nameRow.listIterator();
        ListIterator<Boolean> iteratorCheckBox = valueCheckBox.listIterator();

        while(iteratorNameRow.hasNext() && iteratorCheckBox.hasNext()){
            rowsWithStates.put(iteratorNameRow.next(),iteratorCheckBox.next());
        }
        return rowsWithStates;
    }

    public Map<String, WebElement> getNameRowAndCheckBoxElemet(){

        List<String> nameRow = getValueNameRows();
        List<WebElement> valueCheckBox = getWebElementCheckBoxRows();

        Map<String, WebElement> rowsWithWebElement = new HashMap<String, WebElement>();

        ListIterator<String> iteratorNameRow = nameRow.listIterator();
        ListIterator<WebElement> iteratorCheckBox = valueCheckBox.listIterator();

        while(iteratorNameRow.hasNext() && iteratorCheckBox.hasNext()){
            rowsWithWebElement.put(iteratorNameRow.next(),iteratorCheckBox.next());
        }
        return rowsWithWebElement;
    }

    public boolean checkStatusRow(String nameRow){
        Map<String, Boolean> tabel = getStatusOfLinesWithName();
        return tabel.get(nameRow);
    }

    public void activateRow(String nameRow){
        Map<String, WebElement> rowsWithElement = getNameRowAndCheckBoxElemet();
//        Map<String, Boolean> rowsWithState = getStatusOfLinesWithName();
        if(!checkStatusRow(nameRow)) {
            rowsWithElement.get(nameRow).click();
        }
    }
    public void deactivateRow(String nameRow){
        Map<String, WebElement> rowsWithElement = getNameRowAndCheckBoxElemet();
//        Map<String, Boolean> rowsWithState = getStatusOfLinesWithName();
        if(checkStatusRow(nameRow)) {
            rowsWithElement.get(nameRow).click();
        }
    }










    public void click() {
        webElement.click();
    }

    public boolean isEnabled(){
        WebElement fullRow = webElement.findElement(By.xpath("./ancestor::div[contains(@class,'x-panel-noborder')]"));
        String bbb = "x-panel-collapsed";
        String aaa = fullRow.getAttribute("class");
        int resultCollapsed = aaa.indexOf(bbb);
        if(resultCollapsed != -1){
            return false ;
        }
        return true;
    }
    public void openTab(){
        if( !isEnabled() ){
            click();
        }
    }
    public void closeTab(){
        if( isEnabled() ){
            click();
        }
    }

}
