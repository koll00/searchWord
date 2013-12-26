/*
 * This is the builder for word bean.
 * 
 * @author shisj 
 * @email senjia1988@126.com
 * @version 0.1
 * @date 2013.12.24
 */
package cn.edu.ustc.shisj.builder;

import java.util.List;

import cn.edu.ustc.shisj.search.SuperWordSearch;

public interface WordBuilder {
	public SuperWordSearch builder();
	
	public char[][] getWordGrid();
	public void setWordGrid(char[][] wordGrid);
	public boolean isWrap();
	public void setWrap(boolean wrap);
	public int getRow();
	public void setRow(int row);
	public int getColumn();
	public void setColumn(int column);
	public List<String> getSearchWords();
	public void setSearchWords(List<String> searchWords);
}
