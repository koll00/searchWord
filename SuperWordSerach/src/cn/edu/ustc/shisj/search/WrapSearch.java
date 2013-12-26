package cn.edu.ustc.shisj.search;

import java.util.LinkedList;
import java.util.List;

import cn.edu.ustc.shisj.location.Direction;
import cn.edu.ustc.shisj.location.Position;

public class WrapSearch extends SuperWordSearch {

	public WrapSearch(char[][] wordGrid, int row, int column,
			List<String> searchWords) {
		super(wordGrid, row, column, searchWords);
	}

	@Override
	public Position adjustPosition(int row, int column) {
		if(row<0) row += this.getRow();
		if(column<0) column += this.getColumn();
		row %= this.getRow();
		column %= this.getColumn();
		return new Position(row, column);
	}

}
