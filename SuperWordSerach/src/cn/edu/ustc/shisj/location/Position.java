package cn.edu.ustc.shisj.location;

import cn.edu.ustc.shisj.location.Direction;
import cn.edu.ustc.shisj.search.NoWrapSearch;
import cn.edu.ustc.shisj.search.SuperWordSearch;
import cn.edu.ustc.shisj.search.WrapSearch;

public class Position {
	private int row;
	private int column;

	public Position(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public Position getPosition(Direction dir, int i, SuperWordSearch  sws) {
		Position p = null;
		int row =this.row;
		int column = this.column;
		switch (dir) {
		case WEST:
			column -= i;
			break;
		case NORTH:
			row -= i;
			break;
		case EAST:
			column += i;
			break;
		case SOUTH:
			row += i;
			break;
		case NORTHWEST:
			row -= i;
			column -= i;
			break;
		case NORTHEAST:
			row -= i;
			column += i;
			break;
		case SOUTHWEST:
			row += i;
			column -= i;
			break;
		case SOUTHEAST:
			row += i;
			column += i;
			break;
		}
		p = sws.adjustPosition(row, column);
		return p;
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

	public String toString() {
		String result = "";
		result += "( " + row + "," + column + " )";
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	
	
}
