package Project20;

import org.openqa.selenium.WebElement;

import java.util.List;

public class EmployeeList {

    protected void handleTable(List<WebElement> KeyList, List<WebElement> TargetList, String SearchInput) {

        for (int i = 0; i < KeyList.size(); i++) {

            if (KeyList.get(i).getText().contains(SearchInput)) {
                System.out.println(KeyList.get(i).getText());
                System.out.println(TargetList.get(i).getText());
            }
        }
    }
}
