import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends PageObject{
   private final String USERNAME = "dumbridge";
   private final String PASSWORD ="tomriddle";

    @FindBy(id="username")
    private WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(xpath = "//button")
    private WebElement button;

    @FindBy(id="estado")
    private WebElement estadoLogin;

    public LoginForm(WebDriver driver) {
        super (driver);
    }

    public void enterUserName(){
        this.username.sendKeys(USERNAME);
    }

    public void enterPassword(){
        this.password.sendKeys(PASSWORD);
    }
    public void enterPasswordIncorrecto(){
        this.password.sendKeys("hola");
    }

    public void pressLoginButton(){
        this.button.click();
    }

    public String getText(){
       return this.estadoLogin.getText();
    }
}
