package cama.core;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class JudgeTest {
    public JudgeTest(){
    
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
    public void testGetCell(){
        JudgeImpl instance = new JudgeImpl();
        String[][] ar = instance.getField();

        for(int i=0; i<ar.length;i++){
            for(int j=0; j<ar.length;j++){
                switch(i){
                    case 0: assertEquals(ar[i][j], Texts.Wh); break;
                    case 1: assertEquals(ar[i][j], Texts.Em); break;
                    case 2: assertEquals(ar[i][j], Texts.Bl); break;
                }
            }
        }
    }

    @Test
    public void testIsCorrect(){
        JudgeImpl instance = new JudgeImpl();
        Step st = new Step(0, 0, 0, 1);
        assertTrue(instance.isStepCorrect(st, true));
        st = new Step(0,0,0,0);
        assertFalse(instance.isStepCorrect(st, true));
        st = new Step(0,2,0,1);
        assertTrue(instance.isStepCorrect(st, false));
    }
    
    @Test
    public void testGetSize() {
        JudgeImpl instance = new JudgeImpl();
        assertEquals(instance.getSize(), 3);
    }

    @Test
    public void testHandleStep(){
        JudgeImpl instance = new JudgeImpl();
        Step st = new Step(0,0,0,1);
        instance.handleStep(st, true);
        String[][] ar = instance.getField();
        assertEquals(ar[0][0], Texts.Em);
        assertEquals(ar[1][0], Texts.Wh);
    }



    public class JudgeImpl extends Judge{

        JudgeImpl(){
           super();
        }
    }
}