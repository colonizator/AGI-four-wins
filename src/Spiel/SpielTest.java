package Spiel;

import org.junit.Test;

import junit.framework.TestCase;

public class SpielTest extends TestCase {

	@Test
	public void tesLeft() {
		Logic spiel = new LogicImplementierung();
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, 0));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, 0));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, 0));
		assertEquals(Result.GEWONEN, spiel.throwChip(Chip.BLAU, 0));
	}

	@Test
	public void testRight() {
		Logic spiel = new LogicImplementierung();
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, 6));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, 6));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, 6));
		assertEquals(Result.GEWONEN, spiel.throwChip(Chip.BLAU, 6));
	}

	@Test
	public void testSpalteGefuelt() {
		Logic spiel = new LogicImplementierung();
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, 6));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, 6));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, 6));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 6));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 6));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 6));

	}

	@Test
	public void testSpalteUeberlauf() {
		Logic spiel = new LogicImplementierung();
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, 6));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, 6));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, 6));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 6));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 6));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 6));
		assertEquals(Result.ERROR, spiel.throwChip(Chip.BLAU, 6));
	}

	@Test
	public void testLinksOben() {
		Logic spiel = new LogicImplementierung();
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, 0));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, 0));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 0));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 0));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 0));
		assertEquals(Result.GEWONEN, spiel.throwChip(Chip.ROT, 0));
	}

	@Test
	public void testRechtsOben() {
		Logic spiel = new LogicImplementierung();
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, 6));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, 6));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 6));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 6));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 6));
		assertEquals(Result.GEWONEN, spiel.throwChip(Chip.ROT, 6));
	}

	@Test
	public void testHorizontalLinks() {
		Logic spiel = new LogicImplementierung();
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 0));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 1));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 2));
		assertEquals(Result.GEWONEN, spiel.throwChip(Chip.ROT, 3));
	}

	@Test
	public void testHorizontalRechts() {
		Logic spiel = new LogicImplementierung();
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 3));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 4));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 5));
		assertEquals(Result.GEWONEN, spiel.throwChip(Chip.ROT, 6));
	}

	@Test
	public void testHorizontalRechtsUeberlauf() {
		Logic spiel = new LogicImplementierung();
		assertEquals(Result.ERROR, spiel.throwChip(Chip.ROT, 7));
	}

	@Test
	public void testHorizontalLinksFalsheEingabe() {
		Logic spiel = new LogicImplementierung();
		assertEquals(Result.ERROR, spiel.throwChip(Chip.ROT, -1));
	}

	@Test
	public void testHorizontalMitte() {
		Logic spiel = new LogicImplementierung();
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 3));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 6));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 5));
		assertEquals(Result.GEWONEN, spiel.throwChip(Chip.ROT, 4));
	}

	@Test
	public void testHorizontalMitteGroessealsVier() {
		Logic spiel = new LogicImplementierung();
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 1));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 2));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 4));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 5));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 6));
		assertEquals(Result.GEWONEN, spiel.throwChip(Chip.ROT, 3));
	}

	@Test
	public void testHorizontalLinksOben() {
		Logic spiel = new LogicImplementierung();
		for (int i = 0; i < 3; i++) {
			assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, i));
			assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, i));
			assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, i));
			assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, i));
			assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, i));
			assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, i));
		}
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 3));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 3));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, 3));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, 3));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 3));
		assertEquals(Result.GEWONEN, spiel.throwChip(Chip.BLAU, 3));
	}

	@Test
	public void testHorizontalRechtsOben() {
		Logic spiel = new LogicImplementierung();
		for (int i = 6; i > 3; i--) {
			assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, i));
			assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, i));
			assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, i));
			assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, i));
			assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, i));
			assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, i));
		}
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 3));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 3));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, 3));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, 3));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 3));
		assertEquals(Result.GEWONEN, spiel.throwChip(Chip.BLAU, 3));
	}

	@Test
	public void testDiagonal1() {
		Logic spiel = new LogicImplementierung();
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 0));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 1));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 1));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 2));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 2));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 2));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, 3));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 3));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 3));
		assertEquals(Result.GEWONEN, spiel.throwChip(Chip.ROT, 3));
	}

	@Test
	public void testDiagonal2() {
		Logic spiel = new LogicImplementierung();
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 0));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 1));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 1));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, 3));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 3));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 3));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 3));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 2));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 2));
		assertEquals(Result.GEWONEN, spiel.throwChip(Chip.ROT, 2));
	}

	@Test
	public void testDiagonal3() {
		Logic spiel = new LogicImplementierung();
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 6));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 5));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 5));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.BLAU, 3));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 3));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 3));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 3));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 4));
		assertEquals(Result.UNENTSCHIEDEN, spiel.throwChip(Chip.ROT, 4));
		assertEquals(Result.GEWONEN, spiel.throwChip(Chip.ROT, 4));
	}
}
