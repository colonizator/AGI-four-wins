package Spiel;

import static Spiel.Result.*;

public class LogicImplementierung implements Logic {

	Chip spielfeld[][];
	Result ergebnis;

	public LogicImplementierung() {
		spielfeld = new Chip[6][7];
	}

	public boolean istZeileGefuelt() {
		int zeile = 0;
		while (zeile < 7) {
			if (spielfeld[0][zeile] == null) {
				return false;
			}
		}
		return true;
	}

	public Result ergebnisPruefen(Chip chip, int spalte) {

		if (istZeileGefuelt())
			return UNENTSCHIEDEN;

		for (int i = spielfeld.length - 1; i >= 0; i--) {
			if (spielfeld[i][spalte] == chip) {
				if (i >= spielfeld.length - 3) {
					if (spielfeld[i - 1][spalte] == chip && spielfeld[i - 2][spalte] == chip
							&& spielfeld[i - 3][spalte] == chip) {
						return GEWINEN;
					}
				}
			}
		}

		return NICHTFERTIG;
	}

	@Override
	public Result throwChip(Chip chip, int spalte) {

		for (int i = spielfeld.length - 1; i >= 0; i--) {
			if (spielfeld[i][spalte] == null) {
				spielfeld[i][spalte] = chip;
				i = -1;
			}
		}
		
		ergebnis =  ergebnisPruefen(chip, spalte);
		
		if (ergebnis == GEWINEN) {
			return ergebnis;
		} else if (ergebnis == NICHTFERTIG) {
			return ergebnis;
		} else {
			return UNENTSCHIEDEN;
		}

		/*
		 * if(spielfeld[0][0] == spielfeld[1][0] & spielfeld[0][0] ==
		 * spielfeld[2][0] & spielfeld[0][0] == spielfeld[3][0]){
		 * 
		 * return GEWINEN;
		 * 
		 * } else { return NICHTFERTIG; }
		 */

	}

}
