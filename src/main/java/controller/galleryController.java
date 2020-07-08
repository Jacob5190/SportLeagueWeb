package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.fileService;

import java.io.File;

@Controller
public class galleryController{
	@Autowired
	fileService fileService;
	static final String PATH = "galleryImages";
	@RequestMapping("/gallery")
	public ModelAndView handleRequest (javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
		ModelAndView mav = new ModelAndView("gallery");
		File[] files = fileService.listFile(PATH);
		mav.addObject("length", files.length);
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				mav.addObject("filePath" + i, "galleryImages\\" + files[i].getName());
			}
		}
		return mav;
	}
	@RequestMapping("/admin/imgUpload")
	@ResponseBody
	public String imgUpload (@RequestParam ("picture") MultipartFile picture) throws Exception{
		fileService.saveFile(picture, PATH);
		return "success";
	}
	@RequestMapping("/admin/imgDelete")
	@ResponseBody
	public void imgDelete (@RequestParam("option") String option){
		fileService.delFile(option, PATH);
	}

	@RequestMapping("/admin/reqImgs")
	@ResponseBody
	public String reqImgs () throws JsonProcessingException {
		String[] imgNames;
		String ApplicationPath =
				ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
		String filePath = ApplicationPath + PATH;
		File file = new File(filePath);
		File[] files = fileService.listFile(PATH);
		imgNames = new String[files.length];
		if (files != null) {
			for (int i = 0; i < files.length; i++){
				imgNames[i] = files[i].getName();
			}
		}
		return new ObjectMapper().writeValueAsString(imgNames);
	}

	@RequestMapping("/admin/gallery")
	public String galleryAdmin() {
		return "galleryAdmin";
	}
}
