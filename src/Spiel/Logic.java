package Spiel;

public interface Logic {
	
	public Result throwChipV(Chip chip, int spalte);
	
	public Result throwChipH(Chip chip, int zeile);
	
	public Result throwChipFeld(Chip chip, int zeile, int spalte);

}

