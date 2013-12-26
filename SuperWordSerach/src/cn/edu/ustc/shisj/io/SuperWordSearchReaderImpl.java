/*
 * It is helpful for reading the SuperWordSearch input file.
 * 
 * @author shisj 
 * @email senjia1988@126.com
 * @version 0.1
 * @date 2013.12.24
 */
package cn.edu.ustc.shisj.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.ustc.shisj.builder.WordBuilder;

public class SuperWordSearchReaderImpl implements WordSearchReader {
	private WordBuilder swb;

	public SuperWordSearchReaderImpl(WordBuilder builder) {
		this.swb = builder;
	}

	@Override
	public void readInput(String filePath) {
		File file = new File(filePath);
		BufferedReader reader = null;
		String in = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			int count = 0;
			String gridtmp = "";
			while ((in = reader.readLine()) != null) {
				if (count == 0) {
					//deal with the row and column.
					int sep = in.indexOf(' ');
					swb.setRow(Integer.parseInt(in.substring(0, sep)));
					swb.setColumn(Integer.parseInt(in.substring(sep + 1,
							in.length())));
					count++;
				} else if (count != 0 && count < swb.getRow() + 1) {
					gridtmp += in;
					count++;
				} else if (count == swb.getRow() + 1) {
					//deal with the WRAP status
					swb.setWrap(in.equals("WRAP") ? true : false);
					count++;
				} else if (count == swb.getRow() + 2){
					//deal with the search words number
					List<String> list = new ArrayList<String>(Integer.parseInt(in));
					swb.setSearchWords(list);
					count++;
				} else{
					//deal with the search words
					swb.getSearchWords().add(in);
					count ++;
				}
			}
			swb.setWordGrid(transferToGrid(gridtmp));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private char[][] transferToGrid(String in){
		char[][] result = new char[swb.getRow()][swb.getColumn()];
		for(int i = 0; i < swb.getRow(); i ++){
			for(int j = 0; j< swb.getColumn(); j ++){
				result[i][j] = in.toCharArray()[i*swb.getColumn() + j];
			}
		}
		return result;
	}

}
