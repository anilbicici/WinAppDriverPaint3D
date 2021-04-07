package app.microsoft;

import io.appium.java_client.windows.WindowsDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class MsPaintBasePage {
    public final Logger logger = LogManager.getLogger(MsPaintBasePage.class);
    private WindowsDriver driver;
    public MsPaintBasePage(){
        this.driver = BaseTest.driver;
    }


    /**  ---------
     D R A W I N G
     --------  **/
    public void clickWithCoordinates() throws InterruptedException{
        new Actions(driver).moveByOffset(100,100).click().build().perform();
    }

    public void drawWithMouse(int positionX, int positionY,
                                 int drawX, int drawY) throws InterruptedException{
        new Actions(driver).moveByOffset(positionX, positionY)
                .clickAndHold().moveByOffset(drawX, drawY)
                .click().build().perform();
    }

    public void resize() throws InterruptedException{
        WebElement resizeable = driver.findElement(By.name("Üstü yeniden boyutlandır"));
        new Actions(driver).moveToElement(resizeable).clickAndHold()
                .moveByOffset(500,500).click().build().perform();
        //new Actions(driver).dragAndDropBy(resizeable,10,200).build().perform();
    }

    public void move() throws InterruptedException{
        Actions move = new Actions(driver);
        move.clickAndHold(driver.findElementByAccessibilityId("InteractorFocusWrapper"))
                .moveByOffset(100,100)
                .release()
                .build().perform();
        Thread.sleep(2000);
    }

    public void stickerRezise() throws InterruptedException{
        Actions move = new Actions(driver);
        move.clickAndHold(driver.findElementByAccessibilityId("TopLeftAnchor"))
                .moveByOffset(1,1)
                .clickAndHold(driver.findElementByAccessibilityId("LeftAnchor"))
                .release()
                .build().perform();
        Thread.sleep(2000);
        logger.info("Sticker yeniden boyutlandırıldı");
    }

    public void textRezise() throws InterruptedException{
        Actions move = new Actions(driver);
        move.clickAndHold(driver.findElementByAccessibilityId("TopLeftAnchor"))
                .moveByOffset(100,0)
                .clickAndHold(driver.findElementByAccessibilityId("LeftAnchor"))
                .release()
                .build().perform();
         Thread.sleep(2000);
        logger.info("Text Area yeniden boyutlandırıldı");
    }



    /**  ---------------
     C O O R D I N A T E
     --------------  **/
    public void coordinateSticker() {
        for (int i = 0; i < 20; i++) {
            driver.findElementByAccessibilityId("InteractorFocusWrapper").sendKeys(Keys.ARROW_UP);
        }logger.info("Sticker Y düzleminde hareket ettirildi");
        for (int j = 0; j < 89; j++) {
            driver.findElementByAccessibilityId("InteractorFocusWrapper").sendKeys(Keys.ARROW_LEFT);
        }logger.info("Sticker -X düzleminde hareket ettirildi");
    }


    /**  ----------
     E L E M E N T
     ----------  **/
    public void clickElementByName(String by) throws InterruptedException{
        driver.findElementByName(by).click();
        logger.info(by + " elementine tiklandi");
    }

    public void clickElementByAccesibilityId(String id) throws InterruptedException{
        driver.findElementByAccessibilityId(id).click();
        logger.info(id + " elementine tiklandi");
    }

    public void setRGB(String rgb) throws InterruptedException{
        driver.findElementByName("Geçerli renk:").click();
        driver.findElementByAccessibilityId("RGBHexTextBox").click();
        driver.findElementByAccessibilityId("RGBHexTextBox").clear();
        Thread.sleep(2000);
        driver.findElementByAccessibilityId("RGBHexTextBox").sendKeys(rgb);
        Thread.sleep(2000);
        driver.findElementByName("Tamam").click();
        logger.info("Onaltılık: " + rgb + " olarak kaydedildi");
    }

    public void selectComboBox(){
        WebElement resizeable = driver.findElement(By.name("Bir yazı tipi seç"));
        resizeable.sendKeys("Showcard Gothic");

    }

    public void writeText(String text) throws InterruptedException{
        driver.findElementByAccessibilityId("PART_ScrollingContent").sendKeys(Keys.ENTER);
        driver.findElementByAccessibilityId("PART_ScrollingContent").sendKeys(Keys.ENTER);
        driver.findElementByAccessibilityId("PART_ScrollingContent").sendKeys(text);
        Thread.sleep(2000);
        logger.info("Metin: " + text + " olarak yazildi");
    }

    public void fileName(String key) throws InterruptedException{
        driver.findElementByAccessibilityId("Toolbar_MenuToggleButton").click();
        driver.findElementByAccessibilityId("Save as").click();
        driver.findElementByAccessibilityId("File_PaintLogoOutline_Large").click();
        Thread.sleep(2000);
        driver.findElementByAccessibilityId("TextEntryBox").click();
        driver.findElementByAccessibilityId("TextEntryBox").sendKeys(key);
        driver.findElementByAccessibilityId("PrimaryBtnG2").click();
        logger.info("Dosya adi: " + key + " olarak kaydedildi");
    }

}
