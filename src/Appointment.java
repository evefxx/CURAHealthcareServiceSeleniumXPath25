import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class MakeAppointment {

    @Test
    void appointment_Success() throws InterruptedException {
        WebDriver driver = null;
        
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        
        driver.findElement(By.xpath("//*[@id=\"btn-make-appointment\"]")).click();
        
        driver.findElement(By.xpath("//*[@id=\"txt-username\"]")).sendKeys("John Doe");
        driver.findElement(By.xpath("//*[@id=\"txt-password\"]")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.xpath("//*[@id=\"btn-login\"]")).click();
        
        driver.findElement(By.xpath("//*[@id=\"combo_facility\"]")).sendKeys("Tokyo CURA Healthcare Center");
        driver.findElement(By.xpath("//*[@id=\"appointment\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"txt_visit_date\"]")).sendKeys("11/01/2023"); 
        driver.findElement(By.xpath("//*[@id=\"txt_comment\"]")).sendKeys("Heart");
        driver.findElement(By.xpath("//*[@id=\"btn-book-appointment\"]")).click();
        
        String result = driver.findElement(By.id("comment")).getText();
        
        if(result.equalsIgnoreCase("Heart"))
            System.out.print("Pass");
        else
            System.out.print("Fail");
        
        Thread.sleep(5000);
        driver.quit();
        
    }
}