package service;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Repository("fileService")
public interface fileService {
	String APPLICATION_PATH = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
	File[] listFile(String path);
	void saveFile(MultipartFile document, String path) throws IOException;
	void delFile(String option, String path);
}
