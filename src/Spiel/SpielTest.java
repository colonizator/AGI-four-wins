package Spiel;

import static Spiel.Result.*;
import static Spiel.Chip.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SpielTest {

	private LogicImplementierung logic = new LogicImplementierung();

	@Test
	public void vertikallLinksUntenGewin() {

		assertEquals(NICHTFERTIG, logic.throwChip(ROT, 0));
		assertEquals(NICHTFERTIG, logic.throwChip(ROT, 0));
		assertEquals(NICHTFERTIG, logic.throwChip(ROT, 0));
		assertEquals(GEWINEN, logic.throwChip(ROT, 0));

	}

	@Test
	public void vertikalLinksUntenGewin2() {

		assertEquals(NICHTFERTIG, logic.throwChip(ROT, 2));
		assertEquals(NICHTFERTIG, logic.throwChip(ROT, 2));
		assertEquals(NICHTFERTIG, logic.throwChip(ROT, 2));
		assertEquals(GEWINEN, logic.throwChip(ROT, 2));

	}

}
