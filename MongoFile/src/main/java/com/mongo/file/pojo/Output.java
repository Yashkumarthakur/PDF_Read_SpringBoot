package com.mongo.file.pojo;

import java.util.HashMap;

public class Output {
	
	public String filename;
	public HashMap<Integer , Integer> hashval;
	public int finalcount;
	//	public int lineno;
//	public int count;
	
	public Output() {}
	
	public Output(String filename, HashMap<Integer, Integer> hashval, int finalcount) {
		super();
		this.filename = filename;
		this.hashval = hashval;
		this.finalcount=finalcount;
	}



	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}

	public HashMap<Integer, Integer> getHashval() {
		return hashval;
	}

	public void setHashval(HashMap<Integer, Integer> hashval) {
		this.hashval = hashval;
	}
}
