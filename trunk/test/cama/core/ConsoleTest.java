package cama.core;

import cama.console_cama.Console;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConsoleTest {
    public ConsoleTest(){
        
    }
    
    	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}
        
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testPrintField(){
        ConsoleImpl instance = new ConsoleImpl();
        
    }



    public class ConsoleImpl extends Console{

        ConsoleImpl(){
            super(new Judge());
        }
    }
}
