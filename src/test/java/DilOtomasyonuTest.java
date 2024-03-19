import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DilOtomasyonuTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();


        driver.get("https://baykartech.com/tr/");
        Thread.sleep(2000);

        WebElement closeButton = driver.findElement(By.className("close"));
        closeButton.click();
        Thread.sleep(2000);

        WebElement dilSecimi = driver.findElement(By.className("lang"));
        dilSecimi.click();

        WebElement closeeButton = driver.findElement(By.className("close"));
        closeeButton.click();
        Thread.sleep(2000);


        String[] diller = {"Türkçe", "English"};


        for (String dil : diller) {

            WebElement dilSecenek = driver.findElement(By.className("lang"));
            dilSecenek.click();

            WebElement closeeeButton = driver.findElement(By.className("close"));
            closeeeButton.click();
            Thread.sleep(2000);


            WebElement baslikElementi = driver.findElement(By.xpath("//h2"));
            String baslikMetni = baslikElementi.getText();

            if (baslikMetni.contains("Haberler") && dil.equals("Türkçe")) {
                System.out.println(dil + " diline başarılı bir şekilde geçildi.");
            } else if (!baslikMetni.contains("NEWS") && dil.equals("English")) {
                System.out.println(dil + " diline başarılı bir şekilde geçildi.");
            } else {
                System.out.println(dil + " diline geçiş sağlanamadı veya başlık yanlış gösterildi.");
            }


            driver.navigate().back();
            Thread.sleep(2000);

            WebElement closeeeeButton = driver.findElement(By.className("close"));
            closeeeeButton.click();
            Thread.sleep(2000);
        }


        driver.quit();
    }
}