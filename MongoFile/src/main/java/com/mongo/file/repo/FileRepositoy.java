package com.mongo.file.repo;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.mongo.file.pojo.FileFormat;

public interface FileRepositoy extends MongoRepository<FileFormat, String> {
	//public List<FileFormat> FindbyVal(String Val);
	public List<FileFormat> findByvalLike(String val);
}
