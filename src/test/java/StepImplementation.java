import com.thoughtworks.gauge.Step;
import app.microsoft.MsPaintBasePage;
import java.util.concurrent.TimeUnit;


public class StepImplementation {
    private MsPaintBasePage msPaintBasePage;
    public StepImplementation(){
        msPaintBasePage =new MsPaintBasePage();}


    @Step("byName göre <key> elementi tıkla")
    public void clickName(String key) throws InterruptedException{
        msPaintBasePage.clickElementByName(key);
    }

    @Step("byId göre <key> elementi tıkla")
    public void clickId(String key) throws InterruptedException{
        msPaintBasePage.clickElementByAccesibilityId(key);
    }

    @Step("byName göre <key1> ve <key2> elementleri tıkla")
    public void clickNames(String key1, String key2) throws InterruptedException{
        msPaintBasePage.clickElementByName(key1);
        msPaintBasePage.clickElementByName(key2);
    }

    @Step("<colour> seç")
    public void setColor(String colour) throws InterruptedException{
        msPaintBasePage.setRGB(colour);
    }

    @Step("<text> yaz")
    public void setText(String text) throws InterruptedException{
        msPaintBasePage.writeText(text);
    }

    @Step("Yazı tipi seç")
    public void dropDown() throws InterruptedException{
        msPaintBasePage.selectComboBox();
    }

    @Step("Sticker için konumlandırma yap")
    public void coor() throws InterruptedException{
        msPaintBasePage.coordinateSticker();
    }

    @Step("Sticker için yeniden boyutlandır")
    public void stickerArearesize() throws InterruptedException{
        msPaintBasePage.stickerRezise();
    }
    @Step("Text area için yeniden boyutlandır")
    public void textAreaResizes() throws InterruptedException{
        msPaintBasePage.textRezise();
    }

    @Step("Verilen koordinatına tıkla")
    public void clickCoordinates() throws InterruptedException{
        msPaintBasePage.clickWithCoordinates();
    }

    @Step("Ciz")
    public void drawing() throws InterruptedException{
        msPaintBasePage.drawWithMouse(137, 130, 137, 500);
    }

    @Step("<positionX>,<positionY> den <drawX>,<drawY> kadar çiz")
    public void drawing(int positionX, int positionY, int drawX, int drawY) throws InterruptedException{
        msPaintBasePage.drawWithMouse(positionX, positionY, drawX, drawY);
    }

    @Step("<key> saniye bekle")
    public void timeUnitSeconds(int key) {
        try {
            TimeUnit.SECONDS.sleep(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("Dosya adı <key> olarak kaydet")
    public void saveFile(String key) throws InterruptedException {
        msPaintBasePage.fileName(key);
    }

}
