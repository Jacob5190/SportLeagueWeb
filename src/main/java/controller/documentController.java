package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class documentController {
	@RequestMapping("/documents")
	public ModelAndView handleRequest (javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
		ModelAndView mav = new ModelAndView("documents.jsp");
		String ApplicationPath =
				ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
		String filePath = ApplicationPath + "documents";
		File[] files = new File(filePath).listFiles();
		if (files != null) {
			mav.addObject("length", files.length);
			for (int i = 0; i < files.length; i++) {
				if (files[i].isFile()) {
					mav.addObject("filePath" + i, "documents\\" + files[i].getName());
				}
			}
		}
		else {
			mav.addObject("length", 0);
		}
		return mav;
	}

	@RequestMapping("/docUpload")
	@ResponseBody
	public String docUpload(@RequestParam("document")MultipartFile document) throws IOException {
		String ApplicationPath =
				ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
		String filePath =
				ApplicationPath + File.separator + "documents" + File.separator + document.getOriginalFilename();
		document.transferTo(new File(filePath));
		return "success";
	}

	@RequestMapping("/delDoc")
	@ResponseBody
	public void delDoc(@RequestParam("option") String option){
		String ApplicationPath =
				ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
		String filePath = ApplicationPath + File.separator + "documents" + File.separator + option;
		File file = new File(filePath);
		if (file.exists()){
			file.delete();
		}
	}

	@RequestMapping("/reqDocs")
	@ResponseBody
	public String reqDocs () throws JsonProcessingException {
		String[] docNames;
		String ApplicationPath =
				ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
		String filePath = ApplicationPath + "documents";
		File file = new File(filePath);
		File[] files = file.listFiles();
		docNames = new String[files.length];
		if (files != null) {
			for (int i = 0; i < files.length; i++){
				docNames[i] = files[i].getName();
			}
		}
		return new ObjectMapper().writeValueAsString(docNames);
	}
}
