/*
 * This is the builder for SuperWordSearch bean.It is based on 
 * the WordBuilder interface.
 * 
 * @author shisj 
 * @email senjia1988@126.com
 * @version 0.1
 * @date 2013.12.24
 */
package cn.edu.ustc.shisj.builder;

import java.util.List;

import cn.edu.ustc.shisj.search.NoWrapSearch;
import cn.edu.ustc.shisj.search.SuperWordSearch;
import cn.edu.ustc.shisj.search.WrapSearch;

public class SuperWordBuilder implements WordBuilder {
	private char[][] WordGrid;
	private boolean Wrap;
	// row * column WordGrid
	private int row;
	private int column;
	private List<String> searchWords;

	@Override
	public SuperWordSearch builder() {
		SuperWordSearch sws = null;
		if (this.Wrap) {
			sws = new WrapSearch(this.WordGrid, this.row, this.column,
					this.searchWords);
		}else{
			sws = new NoWrapSearch(this.WordGrid, this.row, this.column,
					this.searchWords);
		}

		return sws;
	}

	public char[][] getWordGrid() {
		return WordGrid;
	}

	public void setWordGrid(char[][] wordGrid) {
		WordGrid = wordGrid;
	}

	public boolean isWrap() {
		return Wrap;
	}

	public void setWrap(boolean wrap) {
		Wrap = wrap;
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

}
