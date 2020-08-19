package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.fileService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class documentController {
	@Autowired
	fileService fileService;
	static final String PATH = "documents";
	@RequestMapping("/documents")
	public ModelAndView handleRequest (javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
		ModelAndView mav = new ModelAndView("documents");
		File[] files = fileService.listFile(PATH);
		if (files != null) {
			mav.addObject("length", files.length);
		}else {
			mav.addObject("length", 0);
		}
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				mav.addObject("filePath" + i, "documents\\" + files[i].getName());
			}
		}
		return mav;
	}

	@RequestMapping("admin/docUpload")
	@ResponseBody
	public String docUpload(@RequestParam("document")MultipartFile document) throws IOException {
		fileService.saveFile(document, PATH);
		return "success";
	}

	@RequestMapping("admin/delDoc")
	@ResponseBody
	public void delDoc(@RequestParam("option") String option){
		fileService.delFile(option, PATH);
	}

	@RequestMapping("admin/reqDocs")
	@ResponseBody
	public String reqDocs () throws JsonProcessingException {
		List<String> docNames = new ArrayList<>();
		File[] files = fileService.listFile(PATH);
		for (File file : files){
			docNames.add(file.getName());
		}
		return new ObjectMapper().writeValueAsString(docNames);
	}

	@RequestMapping("/admin/documents")
	public ModelAndView documentsAdmin(){
		return new ModelAndView("documentsAdmin");
	}
}
