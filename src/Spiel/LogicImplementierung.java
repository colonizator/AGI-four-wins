package Spiel;

import static Spiel.Result.*;

public class LogicImplementierung implements Logic {

	Chip spielfeld[][];
	Result ergebnis;
	

	public LogicImplementierung() {
		spielfeld = new Chip[6][7];
	}

				
		// Check if there is an element in the ROW
				public boolean istZeileGefuelt() {
					int zeile = 0;
					while (zeile < 7) {
						if (spielfeld[0][zeile] == null) {
							return false;
						}
					}
					return true;
				}

	// Check the result in a Row
	public Result ergebnisInZeilePruefen(Chip chip, int spalte) {

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
	
	
	// Override the Vetical playing methode
	@Override
	public Result throwChipV(Chip chip, int spalte) {

		
		// Check Result in ROW
		for (int i = spielfeld.length - 1; i >= 0; i--) {
			if (spielfeld[i][spalte] == null) {
				spielfeld[i][spalte] = chip;
				i = -1;
			}
		}
		
		ergebnis =  ergebnisInZeilePruefen(chip, spalte);
		
		if (ergebnis == GEWINEN) {
			return ergebnis;
		} else if (ergebnis == NICHTFERTIG) {
			return ergebnis;
		} else {
			return UNENTSCHIEDEN;
		}

		
		
	}
	

	
	// Check if there is an element in the Column
		public boolean istSpalteGefuelt() {
			int spalte = 0;
			while (spalte < 7) {
				if (spielfeld[spalte][0] == null) {
					return false;
				}
			}
			return true;
		}
	// Check the result in a column 
	public Result ergebnisInSpaltenPruefen(Chip chip, int zeile) {

		if (istSpalteGefuelt())
			return UNENTSCHIEDEN;

		for (int i = spielfeld.length - 1; i >= 0; i--) {
			if (spielfeld[zeile][i] == chip) {
				if (i >= spielfeld.length - 3) {
					if (spielfeld[zeile][i-1] == chip && spielfeld[zeile][i-2] == chip
							&& spielfeld[zeile][i-3] == chip) {
						return GEWINEN;
					}
				}
			}
		}

		return NICHTFERTIG;
	}


	

	// Override the horizontal playing methode
	@Override
	public Result throwChipH(Chip chip, int zeile) {
		//Check Result in Column
				for (int i = spielfeld.length - 1; i >= 0; i--) {
					if (spielfeld[zeile][i] == null) {
						spielfeld[zeile][i] = chip;
						i = -1;
					}
				}
											
				Result ergebnis = ergebnisInSpaltenPruefen(chip, zeile);
				
				if (ergebnis == GEWINEN) {
					return ergebnis;
				} else if (ergebnis == NICHTFERTIG) {
					return ergebnis;
				} else {
					return UNENTSCHIEDEN;
				}
	}

	
	
// Check if there is an element in the Fiel
			public boolean istFeldGefuelt() {
				int spalte = 0;
				int zeile =0;
				while (spalte < 7 || zeile < 6) {
					if (spielfeld[spalte][zeile] == null) {
						return false;
					}
				}
				return true;
			}

			
			
			/*
			int offset is how many diagonals away from the middle diagonal the current diagonal is
			int axis specifies on which side of the middle diagonal the current diagonal is
			*/
			public  Result ergebnisInFeldPruefen(Chip chip, int zeile, int spalte){
				
				int count = 0; //counts the diagonals
				if (istFeldGefuelt())
					return UNENTSCHIEDEN;

				
				for(int i = 0; i < spielfeld.length - 1; i++){
					if(count == 4)
						return GEWINEN;
					
					if(spielfeld[i+zeile][i+spalte] == chip)
						count++;
					else
						count = 0;
					return NICHTFERTIG;
					
				}
				
				return UNENTSCHIEDEN;
				
			}
			
		
	@Override
	public Result throwChipFeld(Chip chip, int zeile, int spalte) {

//		
//		if(ergebnisInFeldPruefen(chip, 1, 0, 1) == ergebnis)
//			return NICHTFERTIG;
//		if(ergebnisInFeldPruefen(chip, 0, 1, 1) == ergebnis)
//			return NICHTFERTIG;
//		if(ergebnisInFeldPruefen(spielfeld, chip, 0, 0, 0) == ergebnis)
//			return GEWINEN;
//	
		
		Result ergebnis = ergebnisInFeldPruefen(chip, zeile, spalte);
		
		if (ergebnis == GEWINEN) {
			return ergebnis;
		} else if (ergebnis == NICHTFERTIG) {
			return ergebnis;
		} else {
			return UNENTSCHIEDEN;
		}
	}
	
	
	


	
}
