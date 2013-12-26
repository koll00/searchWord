package cn.edu.ustc.shisj.search;

import java.util.LinkedList;
import java.util.List;

import cn.edu.ustc.shisj.location.Direction;
import cn.edu.ustc.shisj.location.Position;

public class NoWrapSearch extends SuperWordSearch {

	public NoWrapSearch(char[][] wordGrid, int row, int column,
			List<String> searchWords) {
		super(wordGrid, row, column, searchWords);
	}

	@Override
	public Position adjustPosition(int row, int column) {
		if (row >= 0 && row < getRow()
				&& column >= 0 && column < this.getColumn()) {
			return new Position(row, column);
		} else {
			return null;
		}
	}

}
