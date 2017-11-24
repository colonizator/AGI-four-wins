package Spiel;

import static Spiel.Result.*;
import static Spiel.Chip.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SpielTest {

	private LogicImplementierung logic = new LogicImplementierung();

	@Test
	public void vertikallLinksUntenGewin() {

		assertEquals(NICHTFERTIG, logic.throwChipV(ROT, 0));
		assertEquals(NICHTFERTIG, logic.throwChipV(ROT, 0));
		assertEquals(NICHTFERTIG, logic.throwChipV(ROT, 0));
		assertEquals(NICHTFERTIG, logic.throwChipV(ROT, 0));//delete later

		assertEquals(GEWINEN, logic.throwChipV(ROT, 0));

	}

	@Test
	public void vertikalLinksUntenGewin2() {

		assertEquals(NICHTFERTIG, logic.throwChipV(ROT, 5));
		assertEquals(NICHTFERTIG, logic.throwChipV(ROT, 2));
		assertEquals(NICHTFERTIG, logic.throwChipV(ROT, 5));
		assertEquals(NICHTFERTIG, logic.throwChipV(ROT, 5));
		assertEquals(GEWINEN, logic.throwChipV(ROT, 5));
		
	}
	
	@Test
	public void horizintalLinksUntenGewin() {

		assertEquals(NICHTFERTIG, logic.throwChipH(BLAU, 2));
		assertEquals(NICHTFERTIG, logic.throwChipH(BLAU, 2));
		assertEquals(NICHTFERTIG, logic.throwChipH(BLAU, 2));
		assertEquals(GEWINEN, logic.throwChipH(BLAU, 2));
			
	}
	@Test
	public void horizintalLinksUntenGewinOtherPosition() {

		assertEquals(NICHTFERTIG, logic.throwChipH(BLAU, 0));
		assertEquals(NICHTFERTIG, logic.throwChipH(BLAU, 0));
		assertEquals(NICHTFERTIG, logic.throwChipH(BLAU, 0));
		assertEquals(GEWINEN, logic.throwChipH(BLAU, 0));
			
	}
	
	@Test
	public void diagonalCheck() {

		assertEquals(NICHTFERTIG, logic.throwChipFeld(BLAU, 0,0));
		assertEquals(NICHTFERTIG, logic.throwChipFeld(BLAU,1,1));
		assertEquals(NICHTFERTIG, logic.throwChipFeld(BLAU,2,2));
		//assertEquals(GEWINEN, logic.throwChipFeld(BLAU,3,3));
			
	}
	
}
