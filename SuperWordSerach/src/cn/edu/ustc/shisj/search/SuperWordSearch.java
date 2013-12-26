/*
 * This is the instance of super word search
 *  
 * @author shisj 
 * @email senjia1988@126.com
 * @version 0.1
 * @date 2013.12.24
 */

package cn.edu.ustc.shisj.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cn.edu.ustc.shisj.location.Position;
import cn.edu.ustc.shisj.location.Direction;

public abstract class SuperWordSearch {
	protected char[][] wordGrid;
	// row * column WordGrid
	protected int row;
	protected int column;
	private List<String> searchWords;
	private List<Result> searchResults;

	public SuperWordSearch(char[][] wordGrid, int row, int column,
			List<String> searchWords) {
		super();
		this.wordGrid = wordGrid;
		this.row = row;
		this.column = column;
		this.searchWords = searchWords;
		this.searchResults = new ArrayList<Result>(searchWords.size());
	}

	public List search() {
		// TODO Auto-generated method stub
		List<Position> result = new LinkedList<Position>();
		for (String word : searchWords) {

			result = searchWord(word);
			if (result != null) {
				searchResults
						.add(searchWords.indexOf(word),
								new Result(result.get(0), result.get(result
										.size() - 1)));
			}else{
				searchResults.add(searchWords.indexOf(word), null);
			}
		}
		return result;
	}

	public List<Result> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(List<Result> searchResults) {
		this.searchResults = searchResults;
	}

	public List<Position> searchWord(String word) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				Position pp = new Position(i, j);

				for (Direction dir : Direction.values()) {
					List<Position> pos = new LinkedList<Position>();
					char[] ch = word.toCharArray();
					for (int m = 0; m < ch.length; m++) {

						Position p = pp.getPosition(dir, m, this);
						if(p == null)break;
						char now = getChar(p);
						if (pos.contains(p)) {
							break;
						}
						if (now == ch[m]) {
							pos.add(p);
						} else {
							break;
						}

					}
					if (pos.size() == ch.length) {
						return pos;
					}
				}
			}
		}
		return null;

	}

	public abstract Position adjustPosition(int row, int column);

	public char getChar(Position pos) {
		return wordGrid[pos.getRow()][pos.getColumn()];
	}

	public String toString() {
		String result = "";
		result += row + "row " + column + "column\n";

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				result += wordGrid[i][j] + " ";
			}
			result += "\n";
		}
		result += searchWords.toString();

		return result;
	}

	public char[][] getWordGrid() {
		return wordGrid;
	}

	public void setWordGrid(char[][] wordGrid) {
		this.wordGrid = wordGrid;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public List<String> getSearchWords() {
		return searchWords;
	}

	public void setSearchWords(List<String> searchWords) {
		this.searchWords = searchWords;
	}

	private class Result {
		private Position start;
		private Position end;

		public Result(Position start, Position end) {
			super();
			this.start = start;
			this.end = end;
		}

		public Position getStart() {
			return start;
		}

		public void setStart(Position start) {
			this.start = start;
		}

		public Position getEnd() {
			return end;
		}

		public void setEnd(Position end) {
			this.end = end;
		}

		@Override
		public String toString() {
			return start.toString() + " " + end.toString();
		}

	}
}
