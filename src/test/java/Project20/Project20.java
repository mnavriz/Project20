package Project20;


import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class Project20 {
    /*This project does not require Page Object Model
You do not have to use Cucumber (Java, Selenium and TestNG seem pretty enough but you are free to use other tools too)
You will need to use ApachePOI libraries to handle excel file*/
    /*- Setup your project (dependencies, driver, etc)

- Login to https://test.campus.techno.study

- Navigate to Employees page under Human Resources menu


- Click on the three dots button on the left bottom of the Employees page

- Click on Excel Export and save the excel file about the employees listed in the page
  By default, there will be info (No, Full Name, Status, Employee Type, Gender) about first 10 employees in the excel file.

- (Optional step!) Try to save the excel file into a folder whose path is defined by you.
  So that, your test will not depend on Download folder in your computer but can be downloaded in a folder we define.
  This will be very helpful since this test will not be specific to your computer but it can run in any computer.*/

  /*  @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/MN/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        // Navigate to https://test.campus.techno.study/
        driver.get("https://test.campus.techno.study");

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

        driver.findElement(By.xpath("//*[@id=\"ms-table-1\"]/div/div/div/button")).click();
        driver.findElement(By.cssSelector("button>fa-icon>svg[data-icon = \"file-excel\"]")).click();
    }*/

/*
- Read from the excel file and to validate all the information on the Employees page correctly saved/exported.
  The way you validate each info is up to you! You are the tester.
  (Obviously the photos will not be in the excel file, ignore the photos. Selenium cannot test the graphical content anyway)

- (Optional) Try to use only only one test case because you are actually testing only one thing: Export Excel functionality

Good luck!
 */

    @Test
    public void ValidationEmployeesExport() throws IOException {

        //Connection to Excel file
        File file = new File("/Users/MN/Downloads/SheetJS.xlsx");
        Workbook workbook = WorkbookFactory.create(file);

        //Connection to specific Sheet
        Sheet sheet = workbook.getSheetAt(0);

        List<String> titles = new ArrayList<>();
        Row titleRow = sheet.getRow(0); // reading the first row
        for (int i = 0; i < titleRow.getPhysicalNumberOfCells(); i++) {
            Cell titleCell = titleRow.getCell(i);
            titles.add(titleCell.toString());
            System.out.println(titleCell.toString());
        }

        List<Map<String, String>> listOfMaps = new ArrayList<>();
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) { // staring from second row
            Map<String, String> map = new HashMap<>();

            Row row = sheet.getRow(i);
            for (int j = 0; j < titles.size(); j++) {
                String key = titles.get(j);
                String value = row.getCell(j).toString();
                map.put(key, value);
            }

            // save the map inside a list
            listOfMaps.add(map);

        }

        //printing the Excel table more as a table in
        for (Map<String, String> map : listOfMaps){
            System.out.println(map);
        }




    }
}








