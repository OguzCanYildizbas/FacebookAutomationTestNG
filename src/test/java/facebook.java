        import org.testng.annotations.Test;
        import static org.testng.Assert.*;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.By;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import java.time.Duration;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeOptions;
        import java.util.Collections;
        import java.util.List;
        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.BeforeMethod;
        import java.util.Scanner;
        import javax.swing.JOptionPane; // javax.swing.JOptionPane
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.Keys;




        public class facebook {
            WebDriver driver; // WebDriver nesnesi
            WebDriverWait wait; // WebDriverWait nesnesi
            String email = System.getenv("EMAIL");
            String password = System.getenv("PASSWORD");

            @BeforeMethod
            public void setUp() {

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-notifications");
                options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
                options.setExperimentalOption("useAutomationExtension", false);
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
                driver = new ChromeDriver(options);
                wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.pollingEvery(Duration.ofMillis(500));



            }
            @Test
            public void testCreateFacebookAccount() {
                driver.get("https://www.facebook.com/");
                // İlk öğeyi seçmek için
                // Sayfadaki tüm "Allow all cookies" butonlarını al
                List<WebElement> allButtons = driver.findElements(By.xpath("//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft' and text()='Allow all cookies']"));
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("Bekleme işlemi kesintiye uğradı: " + e.getMessage());
                }

    // İkinci öğeyi seçmek için, index 1 kullanabilirsiniz (0 ile başlar)
                WebElement secondButton = allButtons.get(1); // İkinci öğe
                secondButton.click();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Bekleme işlemi kesintiye uğradı: " + e.getMessage());
                }


                WebElement newRegister =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]")));
                newRegister.click();
                WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name=\"firstname\"]")));
                firstName.sendKeys("testjoaquin");
                WebElement lastName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name=\"lastname\"]")));
                lastName.sendKeys("sanchez");
                WebElement birthday = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name=\"birthday_day\"]/option[@value=\"1\"]")));
                birthday.click();
                WebElement month = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name=\"birthday_month\"]/option[@value=\"1\"]")));
                month.click();
                WebElement birthdayYear = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name=\"birthday_year\"]/option[@value=\"1990\"]")));
                birthdayYear.click();
                WebElement gender = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value=\"2\"]")));
                gender.click();
                WebElement newEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name=\"reg_email__\"]")));
                newEmail.sendKeys(email);
                WebElement newPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@autocomplete=\"new-password\"]")));
                newPassword.sendKeys(password);
                WebElement register = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name=\"websubmit\"]")));
                register.click();

                String verificationCode = JOptionPane.showInputDialog("Lütfen e-posta adresinize gelen doğrulama kodunu girin:");
                if (verificationCode.length() == 5) {
                    WebElement verificationInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=\"code_in_cliff\"]")));
                    verificationInput.sendKeys(verificationCode);
                    WebElement verifyButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name=\"confirm\"]")));
                    verifyButton.click();
                    WebElement okeyButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"_42ft _42fu layerCancel uiOverlayButton selected _42g- _42gy\"]")));
                    okeyButton.click();
                } else {
                    WebElement verificationInput2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=\"recovery_code_entry\"]")));
                    verificationInput2.sendKeys(verificationCode);
                    WebElement verifyButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name=\"reset_action\"]")));
                    verifyButton2.click();
                    WebElement AccountClosedCancel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id=\"checkpointSubmitButton\"]")));
                    AccountClosedCancel.click();
                }
                WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft' and text()='Allow all cookies']")));
                acceptCookies.click();

                /*try {
                    String verificationCode2 = JOptionPane.showInputDialog("Lütfen e-posta adresinize gelen doğrulama kodunu girin:");
                    WebElement verificationInput2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=\"recovery_code_entry\"]")));
                    verificationInput2.sendKeys(verificationCode2);
                    WebElement verifyButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name=\"reset_action\"]")));
                    verifyButton2.click();
                    WebElement AccountClosedCancel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id=\"checkpointSubmitButton\"]")));
                    AccountClosedCancel.click();
                } catch (java.lang.Exception e) {
                    System.out.println("there is no confirmation screen " + e.getMessage());
                } */

            }
            @Test
            public void testUpdateFacebookAccount () {
                driver.get("https://www.facebook.com/");
                List<WebElement> allButtons = driver.findElements(By.xpath("//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft' and text()='Allow all cookies']"));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Bekleme işlemi kesintiye uğradı: " + e.getMessage());
                }
                // İkinci öğeyi seçmek için, index 1 kullanabilirsiniz (0 ile başlar)
                WebElement secondButton = allButtons.get(1); // İkinci öğe
                secondButton.click();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Bekleme işlemi kesintiye uğradı: " + e.getMessage());
                }

                WebElement facebookSignInEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-label=\"Email or phone number\"]")));
                facebookSignInEmail.sendKeys(email);
                WebElement facebookSignInPassword = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-label=\"Password\"]")));
                facebookSignInPassword.sendKeys(password);
                try {
                    // İlk XPath ile öğeyi bulmaya çalış
                    WebElement facebookSignIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='royal_login_button']")));
                    facebookSignIn.click();  // Tıklama işlemi

                } catch (Exception e) {
                    // Eğer bir hata oluşursa, ikinci XPath ile tekrar dene
                    System.out.println("İlk XPath ile öğe bulunamadı, alternatif XPath ile denenecek.");

                    WebElement facebookSignIn2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id=\"loginbutton\"]")));  // Alternatif XPath
                    facebookSignIn2.click();  // Alternatif XPath ile tıklama işlemi
                }

                WebElement profileIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"x1lliihq x6ikm8r x10wlt62 x1n2onr6\" and text()=\"Testjoaquin Sanchez\"]")));
                profileIcon.click();
                for (int i = 0; i < 5; i++) {
                    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);"); // Her seferinde 500px kaydır
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("Bekleme işlemi kesintiye uğradı: " + e.getMessage());
                    }
                }
                WebElement editBio = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft\" and text()='Edit bio']")));
                editBio.click();

                WebElement areaBio = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@aria-label=\"Enter bio text\"]")));
                areaBio.sendKeys(Keys.COMMAND + "a"); // Mac için Command + A

// 2. Seçilen metni silmek için BACK_SPACE tuşunu simüle et
                areaBio.sendKeys(Keys.BACK_SPACE);
                String testBio = JOptionPane.showInputDialog("please enter some knwoledge for your bio");
                areaBio.sendKeys(testBio);
                System.out.println("Girilen bio: " + testBio);
                WebElement saveBio = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft\" and text()='Save']")));
                saveBio.click();

            }
            @AfterMethod
            public void tearDown() {
                driver.quit();
            }

        }
