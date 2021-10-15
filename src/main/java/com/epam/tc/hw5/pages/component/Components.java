package com.epam.tc.hw5.pages.component;


import com.epam.tc.hw5.pages.HomePage;
import com.epam.tc.hw5.pages.UserProperties;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Components {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public Components(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10L);
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@class='dropdown-toggle']")
    private WebElement serviceHeaderMenuItemDropdown;

    @FindBy(xpath = "//a[@href='different-elements.html']")
    private WebElement differentElementsButton;

    @FindBy(xpath = "//a[@href='user-table.html']")
    private WebElement userTableButton;

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement loginUsernameField;

    @FindBy(id = "password")
    private WebElement loginUserPasswordField;

    @FindBy(id = "login-button")
    private WebElement enterButton;

    @FindBy(id = "user-name")
    private WebElement loginedUsername;

    @FindBy(xpath = "//li[text()[contains(.,'%s: %s changed to %s')]]")
    private List<WebElement> logRows;

    public void clickServiceMenuItem() {
        serviceHeaderMenuItemDropdown.click();
    }

    public void clickDifferentElementItem() {
        differentElementsButton.click();
    }

    public void clickUserTableItem() {
        userTableButton.click();
    }

    public HomePage login() {
        userIcon.click();
        loginUsernameField.sendKeys(UserProperties.getUsername());
        loginUserPasswordField.sendKeys(UserProperties.getPassword());
        enterButton.click();
        return new HomePage(driver);
    }

    public String getLoginedUsername() {
        return loginedUsername.getText();
    }

    public List<WebElement> getLogRows() {
        return logRows;
    }
}
