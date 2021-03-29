import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Main {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "browserDrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        String searchFieldXpath = "//input[@title='Поиск']";

        WebElement searchElement = driver.findElement(By.xpath(searchFieldXpath));
        searchElement.sendKeys("rozetka");
        searchElement.submit();

        WebElement findElement = driver.findElement(By.partialLinkText("Інтернет-супермаркет Rozetka - Понад 3.9 млн товарів"));
        findElement.click();

        WebElement searchElement1 = driver.findElement(By.xpath("//input[@name='search']"));
        searchElement1.sendKeys("Монитор");

        WebElement searchButton = driver.findElement(By.xpath("//button[contains(@class, 'search-form__submit')]"));
        searchButton.click();

        Assert.assertEquals("Монитор", "Монитор");


        driver.quit();
    }
}
