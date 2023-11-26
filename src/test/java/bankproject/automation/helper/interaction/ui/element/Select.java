package bankproject.automation.helper.interaction.ui.element;

import bankproject.automation.helper.interaction.ui.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Select {
    org.openqa.selenium.support.ui.Select select;

    public Select(WebDriver driver, By by) {
        Selenium selenium = Selenium.Init(driver);
        WebElement element = selenium.waitUntil(by).visible();
        select = new org.openqa.selenium.support.ui.Select(element);
    }

    public void byText(String text) {
        select.selectByVisibleText(text);
    }

}
