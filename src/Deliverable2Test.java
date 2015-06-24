import junit.framework.TestCase;

import static org.mockito.Mockito.*;

import org.junit.*;

public class Deliverable2Test extends TestCase {
	
	
    // Test for Room
    
    // Test hasSugar()
	// hasSugar() should return false when there's no sugar in the room
	@Test
    public void testHasSugar(){
    	Room room = new Room(false, false, false, true, true);
    	assertFalse(room.hasSugar());
    }
    
    // Test hasCream()
    // hasCream() should return false when there's no cream in the room
	@Test
	public void testHasCream(){
    	Room room = new Room(false, false, false, true, true);
    	assertFalse(room.hasCream());
    }
    
    // Test hasCoffee()
    // hasCoffee() should return false when there's no coffee in the room
	@Test
	public void testHasCoffee(){
    	Room room = new Room(false, false, false, true, true);
    	assertFalse(room.hasCoffee());
    }
    
    // Test hasItem()
    // hasItem() should return false when there's nothing in the room
	@Test
	public void testHasItem_None(){
    	Room room = new Room(false, false, false, true, true);
    	assertFalse(room.hasItem());
    }
    
    // Test hasItem()
    // hasItem() should return true when all the three ingredients are in the room
	@Test
	public void testHasItem_All(){
    	Room room = new Room(true, true, true, true, true);
    	assertTrue(room.hasItem());
    }
    
    // Test hasItem()
    // hasItem() should return true when there's only one item in the room, let's say, Sugar
	@Test
	public void testHasItem_Sugar(){
    	Room room = new Room(true, false, false, true, true);
    	assertTrue(room.hasItem());
    }
    
    
    // Test northExit()
	// northExit() should return true when there exists a north exit
	@Test
	public void testNorthExit(){
    	Room room = new Room(false, false, false, true, true);
    	assertTrue(room.northExit());
    }
    
    // Test southExit()
	@Test
	public void testSouthExit(){
    	Room room = new Room(false, false, false, true, true);
    	assertTrue(room.southExit());
    }
    
//   Test getDescription()
//	 This will eventually check the descriptions
	@Test
	public void testGetDescription_southExit(){
    	Room room = new Room(false, false, false, false, true);
    	String st = room.getDescription();
    	assertTrue(st.contains("You see a"));
    	assertTrue(st.contains("room."));
    	assertTrue(st.contains("It has a"));
    	assertTrue(st.contains("door leads South."));
    }
    
    
    
	
	
	
	
	
    // Test for Player
    
    // Test hasAllItems()
    // hasAllItems() should return false when there's nothing in the player's inventory
	@Test
	public void testHasAllItems_nothing(){
    	Player player = new Player(false, false, false);
    	assertFalse(player.hasAllItems());
    }
    
    // Test hasAllItems()
    // hasAllItems() should return false when there's only one thing, say, Sugar in the player's inventory
	@Test
	public void testHasAllItems_sugar(){
    	Player player = new Player(true, false, false);
    	assertFalse(player.hasAllItems());
    }
    
    // Test hasAllItems()
    // hasAllItems() should return false when there are two items, say Sugar and Cream in the player's inventory
	@Test
	public void testHasAllItems_sugar_cream(){
    	Player player = new Player(true, true, false);
    	assertFalse(player.hasAllItems());
    }
    
    // Test drink()
    // drink() should return false when the player has nothing in his/her inventory
	@Test
	public void testDrink_nothing(){
    	Player player = new Player(false, false, false);
    	assertFalse(player.drink());
    }
    
    // Test drink()
    // drink() should return false when the player has only Sugar in his/her inventory
	@Test
	public void testDrink_sugar(){
    	Player player = new Player(true, false, false);
    	assertFalse(player.drink());
    }
    
    // Test drink()
    // drink() should return false when the player has only Sugar in his/her inventory
	@Test
	public void testDrink_all(){
    	Player player = new Player(true, true, true);
    	assertTrue(player.drink());
    }
    
    
	
	
	
    
    // Test for CoffeeMaker
    
    // Test runArgs()
	// This tests that runArgs always return 0.
	@Test
	public void testRunArgs(){
    	CoffeeMaker cm = new CoffeeMaker();
    	int returnVal = cm.runArgs("d");
    	assertEquals(returnVal, 0);
    }
	
	
	
	
	
	
	// Test for House
	
	// This will eventually check descriptions
	@Test
	public void testGetDescription(){
		Room r = mock(Room.class);
		when(r.getDescription()).thenReturn("TEST");  // This means getDesciption() method is stubbed
		Room[] rooms = new Room[1];
		rooms[0] = r;
		House h = new House(rooms);
		String result = h.getCurrentRoomInfo();
		assertEquals(result, "TEST");
	}
	
	// This tests the generateRooms method
	@Test
	public void testGenerateRooms(){
		House h = new House(2);
		Room[] roomList = h.generateRooms(2);
		assertTrue(roomList[0].hasCream());
	}
	
	
	
	
	
	
	
	// Test for Game
	
	// This test doSomething(), moveNorth
	@Test
	public void testDoSomething(){
		// Preconditions
		Player p = mock(Player.class);
		House h = mock(House.class);
		Game g = new Game(p, h);
	
		
		// Execution step
		int result = g.doSomething("N");
		
		// Assertion
		verify(h, times(1)).moveNorth();
		verify(h, never()).moveSouth();
		assertEquals(result, 0);
	}

    
	
}
