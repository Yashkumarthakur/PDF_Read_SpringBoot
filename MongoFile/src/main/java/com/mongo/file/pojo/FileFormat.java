package com.mongo.file.pojo;

import org.springframework.data.annotation.Id;

public class FileFormat {
	
	@Id
	public String _id;
	
	public String fileName;
	public int lineNo;
	public String val;
	
	//Constructor
	public FileFormat() {}
	public FileFormat(String fileName,int lineNo, String val) {
		//this._id=_id;
		this.fileName=fileName;
		this.lineNo=lineNo;
		this.val=val;
	}
	
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getLineNo() {
		return lineNo;
	}
	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}
	public String getValue() {
		return val;
	}
	public void setValue(String value) {
		this.val = value;
	}
	
	

}
