package Spiel;

public class LogicImplementierung implements Logic{

	
	public Chip[][] field;

	private InitialClasse gameType;
	
	public LogicImplementierung() {
		this.gameType = InitialClasse.FOURWINS;
		field = new Chip[gameType.getCol()][gameType.getRows()];
	}
	
	public LogicImplementierung(InitialClasse gameType) {
		this.gameType = gameType;
		field = new Chip[gameType.getCol()][gameType.getRows()];
	}
	
	@Override
	public Result throwChip(Chip chip, int column) {
		System.out.println(this.gameType.getCol());
		if (column >= this.gameType.getCol() || column < 0)
			return Result.ERROR;
		int row = 0;
		while (field[column][row] != null) {
			if (++row >= this.gameType.getRows()) {
				return Result.ERROR;
			}
		}
		field[column][row] = chip;

		Result result = Result.UNENTSCHIEDEN;

		result = checkFourInColumn(chip, column, row);

		if (result != Result.GEWONEN) {
			result = checkFourInRow(chip, column, row);
		}

		if (result != Result.GEWONEN) {
			result = checkFourInDiagonal(chip, column, row);
		}

		return result;
	}
	


	private Result checkFourInRow(Chip chip, int column, int row) {
		int foundChipsInRow = 0;
		for (int i = 0; i < this.gameType.getCol(); i++) {
			if (field[i][row] == chip) {
				if (++foundChipsInRow >= this.gameType.getWon()) {
					return Result.GEWONEN;
				}
			} else {
				foundChipsInRow = 0;
			}
		}
		return Result.UNENTSCHIEDEN;
	}

	private Result checkFourInColumn(Chip chip, int column, int row) {
		int foundChipsInRow = 0;
		for (int i = 0; i < this.gameType.getRows(); i++) {
			if (field[column][i] == chip) {
				if (++foundChipsInRow >= this.gameType.getWon()) {
					return Result.GEWONEN;
				}
			} else {
				foundChipsInRow = 0;
			}
		}
		return Result.UNENTSCHIEDEN;
	}

	private Result checkFourInDiagonal(Chip chip, int column, int row) {
		int columnCheck = column;
		int rowCheck = row;
		Result result = Result.UNENTSCHIEDEN;

		result = checkFourInDiagonalLeft(chip, columnCheck, rowCheck);
		if (result != Result.GEWONEN) {
			result = checkFourInDiagonalRight(chip, columnCheck, rowCheck);
		}
		return result;
	}

	private Result checkFourInDiagonalLeft(Chip chip, int columnCheck, int rowCheck) {
		while (rowCheck > 0 && columnCheck > 0) {
			rowCheck--;
			columnCheck--;
		}
		int foundChipsInDiagonal = 0;
		while (rowCheck < this.gameType.getRows() && columnCheck < this.gameType.getCol()) {
			if (field[columnCheck][rowCheck] == chip) {
				if (++foundChipsInDiagonal >= this.gameType.getWon()) {
					return Result.GEWONEN;
				}
			} else {
				foundChipsInDiagonal = 0;
			}
			rowCheck++;
			columnCheck++;
		}
		return Result.UNENTSCHIEDEN;
	}
	
	private Result checkFourInDiagonalRight(Chip chip, int columnCheck, int rowCheck) {
		while (rowCheck < this.gameType.getRows() -1 && columnCheck > 0) {
			rowCheck++;
			columnCheck--;
		}
		int foundChipsInDiagonal = 0;
		while (rowCheck >= 0 && columnCheck < this.gameType.getCol()) {
			if (field[columnCheck][rowCheck] == chip) {
				if (++foundChipsInDiagonal >= this.gameType.getWon()) {
					return Result.GEWONEN;
				}
			} else {
				foundChipsInDiagonal = 0;
			}
			rowCheck--;
			columnCheck++;
		}
		return Result.UNENTSCHIEDEN;
	}

}
