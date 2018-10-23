package com.mongo.file.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mongo.file.pojo.FileFormat;
import com.mongo.file.pojo.Output;
import com.mongo.file.repo.FileRepositoy;

@Service
public class FileService{
	
	@Autowired
	private FileRepositoy filereo;
	public List<Output> out1=new ArrayList<>();
	
	public List<Output> Getinfo(String word){
		List <FileFormat> f1=filereo.findByvalLike(word);	
		return Wordcount(f1,word);
	}
	
	// File loading 
	public void fileread() {
		filereo.deleteAll();
		//Folder Directory 
    	File file = new File("C:\\Users\\yashkumar.thakur\\Documents\\Ideathon");
        // For getting only ".PDF" files 
        File[] files = file.listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));
        for(File f: files){
            System.out.println(f.getName());
        try (PDDocument document = PDDocument.load(new File(file+"/"+f.getName()))) {
            document.getClass(); 
            if (!document.isEncrypted()) {
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                int page_no=0;
                PDFTextStripper tStripper = new PDFTextStripper();
                String pdfFileInText = tStripper.getText(document);
                //System.out.println("Text:" + st);
				// split by whitespace
                String lines[] = pdfFileInText.split("\\r?\\n");
                for (String line : lines) {
                    System.out.println(f.getName()+"::"+page_no+":"+line);
                    FileFormat f1= new FileFormat(f.getName(),page_no,line);
                    filereo.save(f1);
                    page_no ++;   
                }
            }
        } 	//new
 catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }	
	}
	
	// Counting occurence 
	public List<Output> Wordcount(List<FileFormat> f1, String word){
		out1.clear();
		String s1="";
		HashMap<Integer , Integer>	hashtemp=new HashMap<>();
		for (int iter=0;iter < f1.size();iter ++) {
			s1=f1.get(iter).getFileName();
			//System.out.print(f.getFileName()+"::"+f.getLineNo()+":"+f.getValue());
			   Pattern pattern = Pattern.compile(word);
			   Matcher matcher = pattern.matcher(f1.get(iter).getValue());
			   int count = 0;
			   int i = 0;
			   while (matcher.find(i)) {
			       count++;
			       i = matcher.start() + 1;
			   }
			 if (iter+1 != f1.size()) {
				 if(s1.equals(f1.get(iter+1).getFileName())) {
					 hashtemp.put(f1.get(iter).getLineNo(), count);
//					 System.out.println("in if");
					 System.out.println("\n File Name ="+f1.get(iter).getFileName()+"::: Line No = "+f1.get(iter).getLineNo()+":: Line = "+f1.get(iter).getValue()+": Word Count = "+count+"\n");	 
				 }
				 else {
					 hashtemp.put(f1.get(iter).getLineNo(), count);
					 System.out.println("\n File Name ="+f1.get(iter).getFileName()+"::: Line No = "+f1.get(iter).getLineNo()+":: Line = "+f1.get(iter).getValue()+": Word Count = "+count+"\n");
					 Output o1 = new Output(f1.get(iter).getFileName(),hashtemp,FinalCount(hashtemp));
//					 System.out.println("only else");
					 out1.add(o1);
					 hashtemp=new HashMap<>();
				 }
			 }
			 else {
				 hashtemp.put(f1.get(iter).getLineNo(), count);
				 System.out.println("\n File Name ="+f1.get(iter).getFileName()+"::: Line No = "+f1.get(iter).getLineNo()+":: Line = "+f1.get(iter).getValue()+": Word Count = "+count+"\n");
				 Output o1 = new Output(f1.get(iter).getFileName(),hashtemp,FinalCount(hashtemp));
				 out1.add(o1);
//				 System.out.println("Final else");
			 }
		}
		
		
//		for(FileFormat f:f1) {
//			HashMap<Integer , Integer>	hashtemp=new HashMap<>();
//			hashtemp.clear();
//			//System.out.print(f.getFileName()+"::"+f.getLineNo()+":"+f.getValue());
//			   Pattern pattern = Pattern.compile(word);
//			   Matcher matcher = pattern.matcher(f.getValue());
//			   int count = 0;
//			   int i = 0;
//			   while (matcher.find(i)) {
//			       count++;
//			       i = matcher.start() + 1;
//			   }
//			   
//			 hashtemp.put(f.getLineNo(), count);
//			 System.out.println("\n File Name ="+f.getFileName()+"::: Line No = "+f.getLineNo()+":: Line = "+f.getValue()+": Word Count = "+count+"\n");
//			 Output o1 = new Output(f.getFileName(),hashtemp);
//			 out1.add(o1);
//		}
//		
		System.out.println("Done");
		return out1;
	}
	
	public int FinalCount(HashMap<Integer, Integer> temp) {
		int sum = 0;
		for (int val : temp.values()){
		    sum += val;
		}
		return sum;
	}
	
	
	





}


