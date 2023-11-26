package bankproject.automation.helper.webdriver;

import bankproject.automation.helper.ConfigurationHelper;
import org.openqa.selenium.WebDriver;

public interface Driver {
    ConfigurationHelper config = ConfigurationHelper.instance();

    WebDriver init();
}
