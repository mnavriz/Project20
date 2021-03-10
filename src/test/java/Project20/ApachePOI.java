package Project20;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ApachePOI {
    static WebDriver driver;

    private Workbook workbook;
    private Sheet sheet;

    public ApachePOI(String pathname) throws IOException {
        FileInputStream inputStream = new FileInputStream(pathname);
        workbook = WorkbookFactory.create(inputStream);
        sheet = workbook.getSheetAt(0);
    }

    public List<List<String>> getDataFromTable() {
        System.setProperty("webdriver.chrome.driver", "/Users/MN/Desktop/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        // Navigate to https://test.campus.techno.study/
        driver.get("https://test.campus.techno.study/");

        // Dismiss the cookie message by clicking on "Got it!" button
        driver.findElement(By.cssSelector("a[aria-label=\"dismiss cookie message\"]")).click();

        // Login by the credentials (username = "daulet2030@gmail.com" and password = "TechnoStudy123@")
        String username = "daulet2030@gmail.com";
        String password = "TechnoStudy123@";
        driver.findElement(By.cssSelector("input[formcontrolname=\"username\"]")).sendKeys(username);
        driver.findElement(By.cssSelector("input[formcontrolname=\"password\"]")).sendKeys(password);
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();

        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//span[text()='Human Resources']"))));
        driver.findElement(By.xpath("//span[text()='Human Resources']")).click();
        driver.findElement(By.xpath("//span[text()='Employees']")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> list = driver.findElements(By.xpath("//table/tbody/tr"));
        List<List<String>> listoflist = new ArrayList<>();

        for (int i = 1; i <= list.size(); i++) {
            List<String> listStr = new ArrayList<>();

            List<WebElement> list1 = driver.findElements(By.xpath("//table/tbody/tr["+i+"]/td"));

            for (int j = 2; j < list1.size()-1; j++) {
                listStr.add(list1.get(j).getText());
            }
            listoflist.add(listStr);
        }
        return listoflist;
    }


    public List<List<String>> getTheData(){
        List<List<String>> listOfLists = new ArrayList<>();

        Row row;
//        Cell cell;

        int totalRowCount = sheet.getPhysicalNumberOfRows();

        for(int i = 1 ; i<totalRowCount ; i++){
            List<String> list = new ArrayList<>();
            row = sheet.getRow(i);
            int totalCellCount = row.getPhysicalNumberOfCells();
            for (int j = 2; j <= totalCellCount; j++) {

                String cell="";
                try {
                    cell = row.getCell(j).toString();
                }catch(NullPointerException ex){
                    cell = "null";
                }
                list.add(cell);

            }

            listOfLists.add(list);

        }

        return listOfLists;
    }
}
