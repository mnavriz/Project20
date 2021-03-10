package Project20.EmployeesPage;

import Project20.Project20;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Employees {

    WebDriver driver;

    @FindBy(xpath = "//table/tbody/tr[1]/td[3]")
    private WebElement FullNameROW1;
    @FindBy(xpath = "//table/tbody/tr[1]/td[4]")
    private WebElement StatusROW1;
    @FindBy(xpath = "//table/tbody/tr[1]/td[5]")
    private WebElement EmployeeTypeROW1;
    @FindBy(xpath = "//table/tbody/tr[1]/td[6]")
    private WebElement GenderROW1;

    @FindBy(xpath = "//table/tbody/tr[2]/td[3]")
    private WebElement FullNameROW2;
    @FindBy(xpath = "//table/tbody/tr[2]/td[4]")
    private WebElement StatusROW2;
    @FindBy(xpath = "//table/tbody/tr[2]/td[5]")
    private WebElement EmployeeTypeROW2;
    @FindBy(xpath = "//table/tbody/tr[2]/td[6]")
    private WebElement GenderROW2;

    @FindBy(xpath = "//table/tbody/tr[3]/td[3]")
    private WebElement FullNameROW3;
    @FindBy(xpath = "//table/tbody/tr[3]/td[4]")
    private WebElement StatusROW3;
    @FindBy(xpath = "//table/tbody/tr[3]/td[5]")
    private WebElement EmployeeTypeROW3;
    @FindBy(xpath = "//table/tbody/tr[3]/td[6]")
    private WebElement GenderROW3;

    @FindBy(xpath = "//table/tbody/tr[4]/td[3]")
    private WebElement FullNameROW4;
    @FindBy(xpath = "//table/tbody/tr[4]/td[4]")
    private WebElement StatusROW4;
    @FindBy(xpath = "//table/tbody/tr[4]/td[5]")
    private WebElement EmployeeTypeROW4;
    @FindBy(xpath = "//table/tbody/tr[4]/td[6]")
    private WebElement GenderROW4;


public void findTableElements(String elementName){
    switch (elementName){
        case "FullName":
            driver.findElement(By.xpath("//table/tbody/tr/td[3]")).getText();
            break;
        case "Status":
            driver.findElement(By.xpath("//table/tbody/tr/td[4]")).getText();
            break;
        case "EmployeeType":
            driver.findElement(By.xpath("//table/tbody/tr/td[5]")).getText();
            break;
        case "Gender":
            driver.findElement(By.xpath("//table/tbody/tr/td[6]")).getText();
            break;
        default:
            System.out.println("Not found");

    }
}
}
