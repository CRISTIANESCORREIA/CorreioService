/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package testesistema;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import sistema.CorreioService;
import static org.mockito.Mockito.when;


/**
 *
 * @author CRISTIANE
 */
public class CorreioServiceTest extends TestCase {
    

    
    @Test
    public void test1(){
        CorreioService correioService = Mockito.mock(CorreioService.class);
        when(correioService.buscaEndereco("9000000")).thenReturn("Porto Alegre");
        
        assertEquals("Porto Alegre", correioService.buscaEndereco("9000000"));
              
        
    }
    
}
