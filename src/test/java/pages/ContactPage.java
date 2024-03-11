package pages;

import model.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage extends BasePage{

    @FindBy(xpath = "//button[contains(text(),'Sign')]")
    WebElement signOutButton;

    public ContactPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    public boolean getDataFromContactList(Contact contact){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement nameInContact = wait.until(ExpectedConditions.
                visibilityOfElementLocated(
                        By.xpath("//input[contains(text(), ' "
                                +contact.getName().toString() +" ')]")));
        nameInContact.click();
        WebElement editButton = driver.findElement
                (By.xpath("//button[contains(text(),'Edit')]"));
        editButton.click();
        WebElement elementName = driver.findElement(By.xpath
                ("//input[@placeholder='Name']"));
        String elementNameValue = elementName.getAttribute("value");

        WebElement elementLastName = driver.findElement(By.xpath
                ("//input[@placeholder='Last Name']"));
        String elementLastNameValue = elementLastName.getAttribute("value");

        WebElement elementPhone = driver.findElement(By.xpath
                ("//input[@placeholder='Phone']"));
        String elementPhoneValue = elementPhone.getAttribute("value");

        WebElement elementEmail = driver.findElement(By.xpath
                ("//input[@placeholder='Email']"));
        String elementEmailValue = elementEmail.getAttribute("value");

        WebElement elementAddress = driver.findElement(By.xpath
                ("//input[@placeholder='Phone']"));
        String elementAddressValue = elementPhone.getAttribute("value");

        WebElement elementDescription = driver.findElement(By.xpath
               ("//input[@placeholder='Description']"));
        String elementDescriptionValue = elementPhone.getAttribute("value");


        Contact listContact = new Contact();
        listContact.setName(elementNameValue);
        listContact.setLastName(elementLastNameValue);
        listContact.setPhone(elementPhoneValue);
        listContact.setAddress(elementAddressValue);
        listContact.setDescription(elementDescriptionValue);
        boolean result = listContact.equals(contact); // Выполняется сравнение переданного объекта Contact с объектом listContact, созданным на основе данных, полученных со страницы.
        return result;
    }

}
