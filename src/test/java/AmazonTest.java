import com.selenium.ChromeDriver;
import com.selenium.FirefoxDriver;
import com.selenium.utils.WebDriver;

public class AmazonTest {

	public static void main(String[] args) {
		
		/*
		 * initializing WebDriver reference 'driver' 
		 * by calling constructor of ChromeDriver class
		 */
		WebDriver driver = new ChromeDriver();
			driver.get("http://www.amazon.com");
		
			driver.findElement("name");	
			
			driver.close();
			
			driver.quit();
			
	//do the same with FF Driver class	
		WebDriver driver2 = new FirefoxDriver();

	}

}
