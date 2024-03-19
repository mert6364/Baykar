import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Career {
    public static void main(String[] args) {


        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://kariyer.baykartech.com/tr/basvuru/acik-pozisyonlar/");

        String birim = "Üretim Yönetimi";
        searchByUnit(driver, birim);

        String pozisyon = "Yazılım";
        searchByPosition(driver, pozisyon);

        driver.quit();
    }


    public static void searchByUnit(WebDriver driver, String unit) {
        WebElement birimDropdown = driver.findElement(By.xpath("//*[@title='Birim Ara']"));
        birimDropdown.sendKeys(unit);
        birimDropdown.sendKeys(Keys.ENTER);
        System.out.println("Birim Filtreleme Arama Sonuçları:");
        printSearchResults(driver.findElements(By.className("checkbox")));
    }

    public static void searchByPosition(WebDriver driver, String position) {
        WebElement searchBox = driver.findElement(By.className("main-input"));
        searchBox.sendKeys(position);
        searchBox.sendKeys(Keys.ENTER);
        System.out.println("Pozisyon Arama Sonuçları:");
        printSearchResults(driver.findElements(By.className("filtr-container")));
    }

    public static void printSearchResults(List<WebElement> searchResults) {
        for (WebElement result : searchResults) {
            System.out.println(result.getText());
        }
    }
}