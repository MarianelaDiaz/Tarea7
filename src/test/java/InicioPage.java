import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InicioPage extends PageObject{

    @FindBy(xpath = "//h3")
    private WebElement subtitulo;

    public InicioPage(WebDriver driver) {
        super(driver);
    }

    public String getSubtitulo(){
        return this.subtitulo.getText();
    }
}
