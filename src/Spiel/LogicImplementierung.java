package Spiel;

import static Spiel.Result.*;
import static Spiel.Chip.*;

public class LogicImplementierung implements Logic{

	int spielfeld[][];
		
	public LogicImplementierung() {
		spielfeld = new int[6][7];
		
		spielfeld[0][0] = 1;
		spielfeld[1][0] = 1;
		spielfeld[2][0] = 1;
		spielfeld[3][0] = 1;
		
		
	}

	
	@Override
	public Result throwChip(Chip chip, int spalte) {

		if(spielfeld[0][0] == spielfeld[1][0]
		&& spielfeld[1][0] == spielfeld[2][0] 
		&& spielfeld[2][0] == spielfeld[3][0]){
			
			return GEWINEN;
			
		}
		
		return Result.NICHTFERTIG;
	}

}
