/*
 * This is main test.
 * @author shisj 
 * @email senjia1988@126.com
 * @version 0.1
 * @date 2013.12.24
 */
package cn.edu.ustc.shisj.test;

import cn.edu.ustc.shisj.builder.SuperWordBuilder;
import cn.edu.ustc.shisj.builder.WordBuilder;
import cn.edu.ustc.shisj.io.WordSearchReader;
import cn.edu.ustc.shisj.io.SuperWordSearchReaderImpl;
import cn.edu.ustc.shisj.search.SuperWordSearch;

public class WordTest {

	public static void main(String[] args) {
		String filePath = "./data/input_WRAP.dat";
		
		WordBuilder builder = new SuperWordBuilder();
		WordSearchReader reader = new SuperWordSearchReaderImpl(builder);
		reader.readInput(filePath);
		SuperWordSearch sws = builder.builder();
		sws.search();
		for(int i =0; i< sws.getSearchResults().size(); i++){
			System.out.println((sws.getSearchResults().get(i)!=null)?sws.getSearchResults().get(i):"NOT FOUND");
		}
		
	}

}
