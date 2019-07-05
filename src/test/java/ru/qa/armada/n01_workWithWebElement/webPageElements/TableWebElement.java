package ru.qa.armada.n01_workWithWebElement.webPageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.qa.armada.n01_workWithWebElement.elementDecorator.Element;

import java.util.*;

/**
 * <h1>This class work with Table in software "Armada"</h1>
 *
 * @author KamyninSA
 * @version 1.0
 * <p><b>Graphic representation of the typical table represent below: </b></p>
 * <p>
 * <img src="{@docRoot}/doc-files/TypicalTable.png" alt="TypicalTable.png">
 * </p>
 */
public class TableWebElement extends Element {

  public TableWebElement(WebElement webElement) {
    super(webElement);
  }

   /**
    * Look for the rows with the data "analogue &lt;tr&gt;" in the table separately tabindex = '0'
    * @return array of data rows of the table
    */
  private List<WebElement> getRows(){
    List<WebElement> rows = webElement.findElements(By.xpath("./ancestor::div[@tabindex='0']//div[@class='x-grid3-scroller']//tr"));
    return rows;
  }

  /**
   * Look for the rows with the header "analogue &lt;td&gt;" in the table separately tabindex = '0'
   * @return array of header rows of the table
   */
  private List<WebElement> getHeadings(){
    WebElement headingsRow = webElement.findElement(By.xpath("./ancestor::div[@tabindex='0']//div[@class='x-grid3-header']"));
    List<WebElement> headingColumns = headingsRow.findElements(By.xpath(".//span"));
    return headingColumns;
  }

  /**
   * Getting table elements as an array of arrays WebElement
   * @return array of arrays WebElement
   */
  private List<List<WebElement>> getRowsWithColumns(){
    List<WebElement> rows = getRows();
    List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();
    for (WebElement row : rows){
      List<WebElement> rowWithColumns = row.findElements(By.xpath(".//div"));
      rowsWithColumns.add(rowWithColumns);
    }
    return rowsWithColumns;
  }

  /**
   * Getting table elements as an array of arrays WebElement__USING HEADLINES
   * @return array of arrays WebElement
   */
  private List<Map<String, WebElement>> getRowsWithColumnsByHeadings(){

    List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
    List<Map<String, WebElement>> rowsWithColumnsByHeadings = new ArrayList<Map<String, WebElement>>();
    Map<String, WebElement> rowByHeadings;
    List<WebElement> headingColumns = getHeadings();

    for (List<WebElement> row : rowsWithColumns){
      rowByHeadings = new HashMap<String, WebElement>();
      for (int i = 0; i < headingColumns.size(); i++){
        String heading = headingColumns.get(i).getText();
        WebElement cell = row.get(i);
//        System.out.println("Value header: " + heading + "Value cell: " + cell.getText());
        rowByHeadings.put(heading, cell);
      }
      rowsWithColumnsByHeadings.add(rowByHeadings);
    }
    return rowsWithColumnsByHeadings;

  }

  //region getValueRowsWithColumns
///////////////////////////////////////////////////////////////////
  /**
   * Getting table elements as an array of arrays "text value" of WebElement
   * @return array of arrays "text value"
   */
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

  /**
   * Getting table elements as an array of arrays "text value" WebElement__USING HEADLINES
   * @return array of arrays "text value"
   */
  public List<Map<String, String>> getValueRowsWithColumnsByHeadings(){

    List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
    List<Map<String, String>> rowsWithColumnsByHeadings = new ArrayList<Map<String, String>>();
    Map<String, String> rowByHeadings;
    List<WebElement> headingColumns = getHeadings();

    for (List<WebElement> row : rowsWithColumns){
      rowByHeadings = new HashMap<String, String>();
      for (int i = 0; i < headingColumns.size(); i++){
        String heading = headingColumns.get(i).getText();
        String cell = row.get(i).getText();
//        System.out.println("Value header: " + heading + "Value cell: " + cell.getText());
        rowByHeadings.put(heading, cell);
      }
      rowsWithColumnsByHeadings.add(rowByHeadings);
    }
    return rowsWithColumnsByHeadings;

  }
///////////////////////////////////////////////////////////////////
//endregion

  //region checkValueInTheTable
///////////////////////////////////////////////////////////////////

  /**
   * Checking for the existence of a value in the table
   * @param objectSearch the text you are looking for in the table
   * @return the boolean value of finding an element in the table
   */
  public boolean checkValueInTheTable(String objectSearch){
    List<List<String>> tableValue = getValueRowsWithColumns();
    Iterator<List<String>> tableIterator = tableValue.iterator();
    while(tableIterator.hasNext()) {
      List<String> rowValue = tableIterator.next();
      Iterator<String> columnIterator= rowValue.iterator();
      while (columnIterator.hasNext()) {
        System.out.println("transmitted: " + objectSearch + "received: " + columnIterator);
        if (columnIterator.next().equalsIgnoreCase(objectSearch)) {
          return true;
        }
      }
    }
    return  false;
  }

  /**
   * Checking for the existence of a value in the table__USING HEADLINES
   * @param objectSearch the text you are looking for in the table
   * @param columnName the name of the column in which the search is performed
   * @return the boolean value of finding an element in the table
   */
  public boolean checkingValuesInTheTableByColumnName(String objectSearch, String columnName){
    List<Map<String, String>> tableValue = getValueRowsWithColumnsByHeadings();
    Iterator<Map<String, String>> tableIterator = tableValue.iterator();
    while(tableIterator.hasNext()) {
      for(Map.Entry<String, String> item : tableIterator.next().entrySet()){
//        System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue());
        if(item.getValue().equals(objectSearch) && item.getKey().equals(columnName)){
          return true;
        }
      }
    }
    return  false;
  }

  /**
   * Checking for the existence of a value in the table use two column
   * @param objectSearchOne the text you are looking for in the table
   * @param columnNameOne the name of the column_1 in which the search is performed
   * @param objectSearchTwo the text you are looking for in the table
   * @param columnNameTwo the name of the column_2 in which the search is performed
   * @return the boolean value of finding an element in the table
   */
  public boolean checkingValuesInTheTableByTwoColumnName(String objectSearchOne, String columnNameOne,String objectSearchTwo, String columnNameTwo){
    List<Map<String, String>> tableValue = getValueRowsWithColumnsByHeadings();
    Iterator<Map<String, String>> tableIterator = tableValue.iterator();
    while(tableIterator.hasNext()) {
      boolean firstSearchCondition = false;
      boolean secondSearchCondition = false;
      for(Map.Entry<String, String> item : tableIterator.next().entrySet()){
//        System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue());
        if(item.getValue().equals(objectSearchOne) && item.getKey().equals(columnNameOne)){
          firstSearchCondition = true;
        }
        if(item.getValue().equals(objectSearchTwo) && item.getKey().equals(columnNameTwo)){
          secondSearchCondition = true;
        }
      }
      if(firstSearchCondition && secondSearchCondition){
        return true;
      }
    }
    return  false;
  }

///////////////////////////////////////////////////////////////////
//endregion

  //region getValueFromCell
///////////////////////////////////////////////////////////////////

  /**
   * Getting the value of a table cell
   * @param rowNumber set table row
   * @param columnNumber set table column
   * @return text value of a table cell
   */
  public String getValueFromCell(int rowNumber, int columnNumber){
    List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
    WebElement cell = rowsWithColumns.get(rowNumber - 1).get(columnNumber - 1);
    return cell.getText();
  }

  /**
   * Getting the value of a table cell
   * @param rowNumber set table row
   * @param columnName set table column
   * @return text value of a table cell
   */
  public String getValueFromCell(int rowNumber, String columnName){
    List<Map<String, WebElement>> rowsWithColumnsByHeadings = getRowsWithColumnsByHeadings();
    WebElement cell = rowsWithColumnsByHeadings.get(rowNumber - 1).get(columnName);
    return cell.getText();
  }
///////////////////////////////////////////////////////////////////
//endregion

  //region clickCell
///////////////////////////////////////////////////////////////////

  /**
   * Click on table cell
   * @param rowNumber set table row
   * @param columnNumber  set table column
   */
  public void clickCell(int rowNumber, int columnNumber) {
    List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
    WebElement cell = rowsWithColumns.get(rowNumber - 1).get(columnNumber - 1);
    cell.click();
  }

  /**
   * Click on table cell__USING HEADLINES
   * @param rowNumber set table row
   * @param columnName  set table column
   */
  public void clickCell(int rowNumber, String columnName) {
    List<Map<String, WebElement>> rowsWithColumnsByHeadings = getRowsWithColumnsByHeadings();
    WebElement cell = rowsWithColumnsByHeadings.get(rowNumber - 1).get(columnName);
    cell.click();
  }

  /**
   * Click on table cell
   * @param objectSearch cell text parameter
   */
  public void clickCell(String objectSearch) {
      int IndexRowSearching = gettingIndexRowOfMatch(objectSearch);
      int IndexColumnSearching = gettingIndexColumnOfMatch(objectSearch);
      List<List<WebElement>> rowsWithColumns = getRowsWithColumns();
      WebElement cell = rowsWithColumns.get(IndexRowSearching - 1).get(IndexColumnSearching - 1);
      cell.click();
  }
///////////////////////////////////////////////////////////////////
//endregion

  //region gettingIndex
///////////////////////////////////////////////////////////////////

  /**
   * Get column index on match
   * @param objectSearch cell text parameter
   * @return the required index column or -1
   */
  public int gettingIndexColumnOfMatch(String objectSearch){
      List<List<String>> tableValue = getValueRowsWithColumns();
      Iterator<List<String>> tableIterator = tableValue.iterator();
      while(tableIterator.hasNext()) {
          List<String> rowValue = tableIterator.next();
          ListIterator<String> columnIterator = rowValue.listIterator();
          while (columnIterator.hasNext()) {
              System.out.println("transmitted: " + objectSearch + "received: " + columnIterator);
              if (columnIterator.next().equalsIgnoreCase(objectSearch)) {
                  return columnIterator.nextIndex();
              }
          }
      }
      return  -1;
  }

  /**
   * Get row index on match
   * @param objectSearch cell text parameter
   * @return the required index row or -1
   */
  public int gettingIndexRowOfMatch(String objectSearch){
      List<List<String>> tableValue = getValueRowsWithColumns();
      ListIterator<List<String>> tableIterator = tableValue.listIterator();
      while(tableIterator.hasNext()) {
          List<String> rowValue = tableIterator.next();
          ListIterator<String> columnIterator = rowValue.listIterator();
          while (columnIterator.hasNext()) {
              System.out.println("transmitted: " + objectSearch + "received: " + columnIterator);
              if (columnIterator.next().equalsIgnoreCase(objectSearch)) {
                  return tableIterator.nextIndex();
              }
          }
      }
      return  -1;
  }
///////////////////////////////////////////////////////////////////
//endregion
}
