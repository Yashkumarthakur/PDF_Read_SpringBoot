//package com.mongo.file.service;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.text.PDFTextStripper;
//import org.apache.pdfbox.text.PDFTextStripperByArea;
//
//import com.mongo.file.pojo.FileFormat;
//
//public class FileRead {
//	
//	public void fileread()throws IOException {
//		List<File> list;
//    	File file = new File("C:\\Users\\yashkumar.thakur\\Documents\\Ideathon");
//        // For getting only ".PDF" files 
//        File[] files = file.listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));
//        for(File f: files){
//            System.out.println(f.getName());
//        
//        try (PDDocument document = PDDocument.load(new File(file+"/"+f.getName()))) {
//            document.getClass(); 
//            if (!document.isEncrypted()) {
//                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
//                stripper.setSortByPosition(true);
//                int page_no=0;
//
//                PDFTextStripper tStripper = new PDFTextStripper();
//                
//                String pdfFileInText = tStripper.getText(document);
//                //System.out.println("Text:" + st);
//
//				// split by whitespace
//                String lines[] = pdfFileInText.split("\\r?\\n");
//                for (String line : lines) {
//                    System.out.println(f.getName()+"::"+page_no+":"+line);
//                    FileFormat f1= new FileFormat(f.getName(),page_no,line);
//                    
//                    page_no ++;   
//                }
//            }
//        } 	//new
//    }	
//	}
//	
//
//}
