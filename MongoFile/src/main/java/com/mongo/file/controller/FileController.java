package com.mongo.file.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mongo.file.pojo.Output;
import com.mongo.file.service.FileService;

@RestController
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	private FileService fileser;
	
	@RequestMapping("/")
	public void Loadile() {
		//return "done";
			fileser.fileread();
	}
	
	@RequestMapping(value="/{word}", method=RequestMethod.GET)
	public List<Output> Getinfo(@PathVariable("word") String word){
		return fileser.Getinfo(word);
	}
	
	
	
}
