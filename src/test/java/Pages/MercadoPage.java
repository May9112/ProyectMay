package Pages;

import camiseta.Camiseta;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MercadoPage extends BasePage {

    private String searchTextField = "//input[@id='cb1-edit']";
    private String searchButton = "//header/div[1]/form[1]/button[1]/div[1]";
    private String items = "ui-search-layout__item";
    private String price ="price-tag-fraction";
    private String link ="ui-search-link";
    private String name ="ui-search-item__title";
    private String next="//body/main[@id='root-app']/div[1]/div[1]/section[1]/div[3]/ul[1]/li[3]/a[1] ";


    public MercadoPage() {
        super(driver);
    }

    public void navigateToMercadoLibre() {
        navigateTo("https://www.mercadolibre.com.uy");
    }

    public void enterSearchCriteria(String criteria) {
        write(searchTextField, "camiseta");
    }

    public void enterSearchButton() {
        clickElement(searchButton);
    }

    public List<WebElement> selectAllItemPage() {

        List<WebElement> webElementList = new ArrayList<WebElement>();
        webElementList.addAll(allItem(items));
        nextPage();
        webElementList.addAll(allItem(items));
        nextPage();
        webElementList.addAll(allItem(items));
        return webElementList;
    }
        public List <Camiseta> returnListCamiseta (List <WebElement> webElementList ){
        List<Camiseta> camisetas = new ArrayList<Camiseta>();
        for (WebElement e : webElementList) {
            Camiseta camiseta= new Camiseta();
            camiseta.setName(text(e, name).getText());
            camiseta.setPrice(text(e, price).getText());
            camiseta.setLink(text(e,link).getText());
            camisetas.add(camiseta);
        }
        return camisetas;

    }
    public void nextPage(){
       clickElement(next);
    }
    //Metodo para el envio de los datos en excel
   /* public void writeExcel(String file, String sheetName ,List<String> camiseta) throws IOException {
        File file1 = new File(file);
        FileInputStream inputS = new FileInputStream(file1);
        XSSFWorkbook newWorkB= new XSSFWorkbook(inputS);
        XSSFSheet newSheet= newWorkB.getSheet(sheetName);
        int rowCont=newSheet.getLastRowNum()-newSheet.getFirstRowNum();
        XSSFRow row1= newSheet.getRow(0);
        XSSFRow row2= newSheet.createRow(rowCont+1);
        for (int i = 0; i < row1.getFirstCellNum() ; i++) {
            XSSFCell newCell=row2.createCell(i);
            newCell.setCellValue(camiseta.get(i));

        }
        inputS.close();
        FileOutputStream outputStream= new FileOutputStream(file1);
        newWorkB.write(outputStream);
        outputStream.close();
    }

    */
}
