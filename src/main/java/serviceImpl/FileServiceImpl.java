package serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import service.fileService;

import java.io.File;
import java.io.IOException;

@Service
public class FileServiceImpl implements fileService {
	@Override
	public File[] listFile (String path) {
		String filePath = APPLICATION_PATH + path;
		File file = new File(filePath);
		return file.listFiles();
	}

	@Override
	public void saveFile (MultipartFile document, String path) throws IOException {
		String filePath =
				APPLICATION_PATH + File.separator + path + File.separator + document.getOriginalFilename();
		document.transferTo(new File(filePath));
	}

	@Override
	public void delFile (String option, String path) {
		String filePath =
				APPLICATION_PATH + File.separator + path + File.separator + option;
		File file = new File(filePath);
		if (file.exists()){
			file.delete();
		}
	}
}
