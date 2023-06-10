package testesistema;


import junit.framework.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SeleniumTest {
    
      static WebDriver driver = null;
      
      private static String namePaginaPrincipal ;
    public SeleniumTest() {
    }
    
    @BeforeAll
    public static void setUp() {
         System.setProperty("webdriver.chrome.driver", 
	                "C:\\chromedriver_win32\\chromedriver.exe");
	        
        
         driver = new ChromeDriver();

        driver.get("C:\\Users\\CRISTIANE\\Documents\\MeuPc\\teste_01\\trabalho2-1.html");
    
        namePaginaPrincipal = driver.getWindowHandle();
    }
    
    
    
    @Test
    public void testTituloPaginaLogin(){
    	// arrange
    	driver.get("C:\\Users\\CRISTIANE\\Documents\\MeuPc\\teste_01\\trabalho2-1.html");      
    	String tituloExperado ="Trabalho 2-1"; 
        
    	// act, assert
    	Assert.assertEquals(tituloExperado,driver.getTitle());
    }
    
     @Test
    public void testLogin(){
        driver.get("C:\\Users\\CRISTIANE\\Documents\\MeuPc\\teste_01\\trabalho2-1.html");
        
        WebElement campoNome = driver.findElement(By.id("nome"));
         WebElement campoSenha = driver.findElement(By.id("senha"));
         WebElement submit = driver.findElement(By.id("submit"));
         campoNome.sendKeys("teste");
         campoSenha.sendKeys("123");
         submit.click();
         String codigProximaPagina =  driver.getPageSource();
         Assert.assertTrue(codigProximaPagina.contains("Bem vindo usuario teste"));
    }
    
    @Test
    public void testAlert(){
        driver.get("C:\\Users\\CRISTIANE\\Documents\\MeuPc\\teste_01\\trabalho2-1.html");

        WebElement campoNome = driver.findElement(By.id("nome"));
        WebElement campoSenha = driver.findElement(By.id("senha"));
         WebElement submit = driver.findElement(By.id("submit"));
         campoNome.sendKeys("usuario_invalido");
         campoSenha.sendKeys("senha_invalido");
         submit.click();
       
         Alert alert = driver.switchTo().alert();
         Assert.assertTrue(alert.getText().equals("usuario ou senha invalida"));
            alert.accept();
         
        
        
    }
    @Test
    public void testCampoNomesucesso(){
        driver.get("C:\\Users\\CRISTIANE\\Documents\\MeuPc\\teste_01\\trabalho2-1.html");
        WebElement campoNome = driver.findElement(By.id("nome"));
        WebElement endereco = driver.findElement(By.id("endereco"));
        WebElement sexo = driver.findElement(By.id("sexo"));
        WebElement idade = driver.findElement(By.id("idade"));
        
        campoNome.sendKeys("Cristiane");
        endereco.sendKeys("abc");
        sexo.sendKeys("Femenino");
        idade.sendKeys("26");

        WebElement submit = driver.findElement(By.id("botao_salvar"));
        submit.click();
            Alert alert = driver.switchTo().alert();
        
        Assert.assertEquals("cadastro realizado com sucesso",alert.getText());
       
        
        
   }
    
    @Test
    public void testCampoNomeerror(){
        driver.get("C:\\Users\\CRISTIANE\\Documents\\MeuPc\\teste_01\\trabalho2-1.html");
        WebElement campoNome = driver.findElement(By.id("nome"));
        WebElement endereco = driver.findElement(By.id("endereco"));
        WebElement sexo = driver.findElement(By.id("sexo"));
        WebElement idade = driver.findElement(By.id("idade"));
        
        campoNome.sendKeys("");
        endereco.sendKeys("abc");
        sexo.sendKeys("Femenino");
        idade.sendKeys("26");

        WebElement submit = driver.findElement(By.id("botao_salvar"));
        submit.click();
          
        
        Assert.assertTrue(driver.getPageSource().contains("Preencha o campo nome"));
       
        
        
   }
    @AfterAll
   public static void tearDown() {
        driver.quit();
    }
   
}
