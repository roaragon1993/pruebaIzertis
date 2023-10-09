package testing;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTest {
	public static String FIRST_AUTO_PROCESS_YEAR = "1785";

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.google.com");

		WebElement cookiesBtn = driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]"));
		WebElement textBox = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
		cookiesBtn.click();
		textBox.sendKeys("automatización");
		WebElement searchBtn = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
		searchBtn.click();
		
		driver.findElement(By.partialLinkText("Automatización - Wikipedia, la enciclopedia libre")).click();
		
		Thread.sleep(3000);
		
		String text = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/p[33]")).getText();
		
		if(text.indexOf(FIRST_AUTO_PROCESS_YEAR)>=0) {
			System.out.println("El año es correcto.");
		} else {
			System.out.println("El año NO es correcto.");
		}
		
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("wiki_screenshot.jpg"));

		driver.close();

	}

}