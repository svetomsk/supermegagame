package cama;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    public PlayerTest() {
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

	/**
	 * Test of getName method, of class Player.
	 */
	@Test
	public void testGetSetName() {
		System.out.println("getSetName");
		Player instance = new PlayerImpl(false);

		instance.setName("petya");

		assertEquals("petya", instance.getName());
	}

	@Test
	public void testIsModulePlayer()
	{
		System.out.println("isModulePlayer");
		Player instance = new PlayerImpl(true);
		boolean result = instance.isModulePlayer();
		assertTrue(result);

		instance = new PlayerImpl(false);
		result = instance.isModulePlayer();
		assertFalse(result);
	}

	/**
	 * Test of setModulePlayer method, of class Player.
	 */
	@Test
	public void testSetModulePlayer() {
		System.out.println("setModulePlayer");
		Player instance = new PlayerImpl(false);
		instance.setModulePlayer(true);

		boolean result1 = instance.isModulePlayer();


		instance.setModulePlayer(false);
		boolean result2 = instance.isModulePlayer();

		assertTrue(result1);
		assertFalse(result2);
	}

	public class PlayerImpl extends Player 
	{
		PlayerImpl(boolean isModulePlayer)
		{
			setModulePlayer(isModulePlayer);
		}

		public void doStep(boolean isWhite){}
	}
}