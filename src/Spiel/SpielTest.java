package Spiel;
import static Spiel.Result.*;
import static Spiel.Chip.*;
import static org.junit.Assert.*;


import org.junit.Test;


public class SpielTest {
	
	private Logic logic = new LogicImplementierung();

	@Test
	public void horizontalLinksUnten() {
	
		
		assertEquals(GEWINEN, logic.throwChip(ROT, 7));
	//	assertEquals(NICHTFERTIG, logic.throwChip(ROT, 1));
	//	assertEquals(NICHTFERTIG, logic.throwChip(ROT, 2));
	//	assertEquals(GEWINEN, logic.throwChip(ROT, 3));
		
	}

}
