package CalculadoraGoogle;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Alejandro
 */
public class Main {

    public static void main(String[] args) {
        
        System.setProperty("webdriver.chrome.driver", "./dirvers/chromedriver.exe"); //Enlazar el ejecutable Chrome Driver
        
        WebDriver navegador = new ChromeDriver();
        //navegador.quit(); //Cierra el navegador
        
        navegador.manage().window().maximize(); //Maximiza la ventana (fullscreen (pantalla completa)
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //(Implicito: va por etiquetas) - Tiempo de espera por si no encuntra el elemento, y vuelve a intentar durante el tiempo que le pongamos (se aplica a todas las acciones del programa)
        
        navegador.get("https://www.google.es/"); //Abrir una pagina
        
        navegador.findElement(By.id("L2AGLb")).click();
        
        WebElement cajaGoogle = navegador.findElement(By.id("APjFqb"));
        cajaGoogle.sendKeys("Calculadora"); 
        cajaGoogle.sendKeys(Keys.ENTER);
        
        WebElement cajaCalculadora = navegador.findElement(By.className("jlkklc"));
        double base = 123.4564;
        double altura = 324.5456;
        
        cajaCalculadora.sendKeys(String.valueOf(base));
        cajaCalculadora.sendKeys("*");
        cajaCalculadora.sendKeys(String.valueOf(altura));
        cajaCalculadora.sendKeys("/");
        cajaCalculadora.sendKeys("2");

        cajaCalculadora.sendKeys(Keys.ENTER);
        
        //Leemos resultado
        String resultado = cajaCalculadora.getText();
        System.out.println(resultado);
        
        try {
            Thread.sleep(3000); //Dromir el hilo del procesox
        } catch (InterruptedException e) {
            System.out.println("Fallito tonto jeje god cabron");
        }
        
        
        //Cambiamos de pagina
        navegador.get("https://web2.0calc.es/");
        navegador.findElement(By.xpath("/html/body/div[7]/div[2]/div[1]/div[2]/div[2]/button[1]")).click();
        
        WebElement caja2 = navegador.findElement(By.id("input"));
        caja2.sendKeys(String.valueOf(base) + "*" + String.valueOf(altura) + "/2");
        caja2.click();
        caja2.sendKeys(Keys.ENTER);
        
        caja2.click();
        
        try {
            Thread.sleep(1000); //Dromir el hilo del procesox
        } catch (InterruptedException e) {
            System.out.println("Fallito tonto jeje god cabron");
        }
        
        String resultado2 = caja2.getAttribute("value");
        System.out.println(resultado2);
        
        //Cerramos
        try {
            Thread.sleep(20000); //Dromir el hilo del procesox
        } catch (InterruptedException e) {
            System.out.println("Fallito tonto jeje god cabron");
        }
        
        navegador.close();
        
        //COMENTARIO AGREGADO
    }
    
}
