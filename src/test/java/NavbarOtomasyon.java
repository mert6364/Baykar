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
        // WebDriver'ı başlatma
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Ana sayfayı açma
        driver.get("https://baykartech.com/tr/");

        // Bekleme süresi
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        // Kapatma butonunu bulma ve tıklama
        WebElement closeButton = driver.findElement(By.className("close"));
        closeButton.click();

        // NavbarOtomasyon elementlerini bulma
        List<WebElement> navLinkElements = driver.findElements(By.cssSelector(".navbar-nav.ml-auto .nav-item.nav-link"));

        // Her bir navbar linkine tıklama ve popup kontrolü
        for (int i = 0; i < navLinkElements.size(); i++) {
            // NavbarOtomasyon linkine tıklama
            navLinkElements.get(i).click();

            // Geri dönme
            driver.navigate().back();

            // Sayfanın yüklenmesini beklemek için bir süre bekleyin
            try {
                Thread.sleep(2000); // Örnek olarak 2 saniye bekleme
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // NavbarOtomasyon linkine tıklanıp tıklanmadığını kontrol etme
            System.out.println("NavbarOtomasyon linkine tıklandı mı? " + (i + 1) + ": " + driver.getCurrentUrl());

            // Popup kontrolü ve kapatma
            try {
                WebElement popupElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("close")));
                if (popupElement.isDisplayed()) {
                    // Popup görüldüğünde kapatma işlemi yapılır
                    WebElement popupCloseButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("close")));
                    popupCloseButton.click();
                    System.out.println("Popup başarıyla kapatıldı.");
                }
            } catch (Exception e) {
                // Popup bulunamadı veya görünür değil
                System.out.println("Popup bulunamadı veya görünür değil.");
            }

            // NavbarOtomasyon elementlerini tekrar bulma
            navLinkElements = driver.findElements(By.cssSelector(".navbar-nav.ml-auto .nav-item.nav-link"));
        }

        // WebDriver'ı kapatma
        driver.quit();
    }
}