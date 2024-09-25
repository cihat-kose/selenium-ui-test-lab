package _08_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static utility.BaseDriver.driver;
import static utility.BaseDriver.waitAndClose;

public class ImplicitWaitExample{
/**
    Task : Implicit Wait

    Görev:
    "https://www.saucedemo.com/" sitesine gidiniz.
    Kullanıcı adı ve şifreyi giriniz:
    Kullanıcı adı: standard_user
    Şifre: secret_sauce
    Login butonuna tıklayınız.
    Sonrasında gelen sayfada ilk ürünün yüklendiğini ve göründüğünü doğrulayınız.
*/
    @Test
    public void implicitWaitTask() {
        // 1. Adım: Web sitesine git
        driver.get("https://www.saucedemo.com/");

        // 2. Adım: Implicit Wait tanımla (maksimum 10 saniye)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 3. Adım: Giriş bilgilerini doldur ve giriş yap
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        // 4. Adım: İlk ürünün yüklendiğini kontrol et
        WebElement firstProduct = driver.findElement(By.xpath("//div[@class='inventory_item'][1]"));
        System.out.println("firstProduct.getText() = " + firstProduct.getText());

        // 5. Adım: İlk ürünün göründüğünü doğrula
        Assert.assertTrue("İlk ürün görünmedi!",firstProduct.isDisplayed());

        waitAndClose();  // Tarayıcıyı kapat
    }
}