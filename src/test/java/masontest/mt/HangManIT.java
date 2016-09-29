package masontest.mt;

import org.junit.Test;
import static org.junit.Assert.*;

//http://hangmanwebapp-env.us-west-2.elasticbeanstalk.com/hangman.html

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HangManIT {
/*
 * As a user, entering guess "A" can add a guess to the bank. 
 * 
 */
	public HangManIT(){
      super();
  }
  /*Following test cases should assert true and false, it gets the URL of the hangman app
   * then uses JUNIT and WebDriver to test the inputs A and B asserting both true and false.
   * 
   * 
   **/
  @Test 
  public void testingGuesses(){
      //String user = System.getProperty("user");
      //String pass = System.getProperty("pass");

      WebDriver driver = new ChromeDriver();
      driver.get("http://hangmanwebapp-env.us-west-2.elasticbeanstalk.com/" + 
                  "hangman.html");
      System.out.println("Page title is... " + driver.getTitle());
      driver.findElement(By.id("newGuesses")).sendKeys("A");
      driver.findElement(By.id("submit")).click();
      /*(new WebDriverWait(driver, 10)).until(
              ExpectedConditions.presenceOfElementLocated(
                      By.name("username")));*/
      String tester = driver.findElement(By.id("oldGuesses")).getText();
      assertTrue(tester.equals("A"));
      
      driver.findElement(By.id("newGuesses")).sendKeys("B");
      driver.findElement(By.id("submit")).click();
      String testerTwo = driver.findElement(By.id("oldGuesses")).getText();
      assertFalse(tester.equals("AC"));
      
      driver.quit();
  }
}

