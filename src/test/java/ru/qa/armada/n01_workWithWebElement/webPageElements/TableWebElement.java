package ru.qa.armada.n01_workWithWebElement.webPageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.Element;

import java.util.*;

public class TableWebElement extends Element {

  public TableWebElement(WebElement webElement) {
    super(webElement);
  }

  public List<WebElement> getRows(){
    List<WebElement> rows = webElement.findElements(By.xpath("./ancestor::div[@tabindex='0']//div[@class='x-grid3-scroller']//tr"));
    return rows;
  }
  public List<WebElement> getHeadings(){
    WebElement headingsRow = webElement.findElement(By.xpath("./ancestor::div[@tabindex='0']//div[@class='x-grid3-header']"));
    List<WebElement> headingColumns = headingsRow.findElements(By.xpath(".//span"));
    return headingColumns;
  }

  public List<List<WebElement>> getRowsWithColumns(){
    List<WebElement> rows = getRows();
    List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
    for (WebElement row : rows){
      List<WebElement> rowWithColumns = row.findElements(By.xpath(".//div"));
      rowsWithColumns.add(rowWithColumns);
    }
    return rowsWithColumns;
  }
  public List<Map<String, WebElement>> getRowsWithColumnsByHeadings(){

    List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
    List<Map<String, WebElement>> rowsWithColumnsByHeadings = new ArrayList<Map<String, WebElement>>();
    Map<String, WebElement> rowByHeadings;
    List<WebElement> headingColumns = getHeadings();

    for (List<WebElement> row : rowsWithColumns){
      rowByHeadings = new HashMap<String, WebElement>();
      for (int i = 0; i < headingColumns.size(); i++){
        String heading = headingColumns.get(i).getText();
        WebElement cell = row.get(i);
        rowByHeadings.put(heading, cell);
      }
      rowsWithColumnsByHeadings.add(rowByHeadings);
    }
    return rowsWithColumnsByHeadings;

  }

  public List<List<String>> getValueRowsWithColumns(){
    List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
    Iterator<List<WebElement>> rowIterator = rowsWithColumns.iterator();
    List<List<String>> rowValue = new ArrayList<List<String>>();

    while(rowIterator.hasNext()) {
      List<WebElement> row = rowIterator.next();
      Iterator<WebElement> columnIterator = row.iterator();
      List<String> columnValue = new ArrayList<String>();
      while (columnIterator.hasNext()) {
         columnValue.add(columnIterator.next().getText());
      }
      rowValue.add(columnValue);
    }
    return  rowValue;
  }

//  public boolean checkValueInTheTable(String objectSearch){
//    List<List<String>> tableValue = getValueRowsWithColumns();
//    Iterator<List<String>> tableIterator = tableValue.iterator();
//    while(tableIterator.hasNext()) {
//      List<String> rowValue = tableIterator.next();
//      Iterator<String> rowIterator = rowValue.iterator();
//        while (columnIterator.hasNext()) {
//        columnValue.add(columnIterator.next().getText());
//      }
//      rowValue.add(columnValue);
//    }
//    return  rowValue;
//  }


  public String getValueFromCell(int rowNumber, int columnNumber){
    List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
    WebElement cell = rowsWithColumns.get(rowNumber - 1).get(columnNumber - 1);
    return cell.getText();
  }
  public String getValueFromCell(int rowNumber, String columnName){
    List<Map<String, WebElement>> rowsWithColumnsByHeadings = getRowsWithColumnsByHeadings();
    WebElement cell = rowsWithColumnsByHeadings.get(rowNumber - 1).get(columnName);
    return cell.getText();
  }

  public void clickCell(int rowNumber, int columnNumber) {
    List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
    WebElement cell = rowsWithColumns.get(rowNumber - 1).get(columnNumber - 1);
    cell.click();
  }
  public void clickCell(int rowNumber, String columnName) {
    List<Map<String, WebElement>> rowsWithColumnsByHeadings = getRowsWithColumnsByHeadings();
    WebElement cell = rowsWithColumnsByHeadings.get(rowNumber - 1).get(columnName);
    cell.click();
  }

}
