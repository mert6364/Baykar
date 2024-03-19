import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class NavbarOtomasyon {

    public static void main(String[] args) {
        
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        
        driver.get("https://baykartech.com/tr/");

        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        
        WebElement closeButton = driver.findElement(By.className("close"));
        closeButton.click();

        
        List<WebElement> navLinkElements = driver.findElements(By.cssSelector(".navbar-nav.ml-auto .nav-item.nav-link"));

        
        for (int i = 0; i < navLinkElements.size(); i++) {
            
            navLinkElements.get(i).click();

            
            driver.navigate().back();

            
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            
            System.out.println("NavbarOtomasyon linkine tıklandı mı? " + (i + 1) + ": " + driver.getCurrentUrl());

            
            try {
                WebElement popupElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("close")));
                if (popupElement.isDisplayed()) {
                    
                    WebElement popupCloseButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("close")));
                    popupCloseButton.click();
                    System.out.println("Popup başarıyla kapatıldı.");
                }
            } catch (Exception e) {
                
                System.out.println("Popup bulunamadı veya görünür değil.");
            }

            
            navLinkElements = driver.findElements(By.cssSelector(".navbar-nav.ml-auto .nav-item.nav-link"));
        }

        
        driver.quit();
    }
}
