import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPlan {
    public static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main (String[]args){
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "loginVacio")
    public static void loginVacio(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);
        loginForm.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(loginForm.getText(), "Atención: Debe ingresar un nombre de usuario");
    }

    @Test(testName = "loginSinPassword")
    public static void loginSinPassword(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);
        loginForm.enterUserName();
        loginForm.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(loginForm.getText(), "Atención: El password no puede estar vacío");

    }

    @Test(testName = "loginSuccessfully")
    public static void loginSuccessfully(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);
        loginForm.enterUserName();
        loginForm.enterPassword();
        loginForm.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        InicioPage inicioPage = new InicioPage(driver);
        Assert.assertEquals(inicioPage.getSubtitulo(),"Bienvenido a OSTH On-Line");
    }

    @Test(testName = "loginPasswordIncorrecto")
    public static void loginPasswordIncorrecto(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);
        loginForm.enterUserName();
        loginForm.enterPasswordIncorrecto();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(loginForm.getText(), "Atención: El password ingresado no es válido");
    }
}
