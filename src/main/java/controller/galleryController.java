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

@Controller
public class galleryController{
	@RequestMapping("/gallery")
	public ModelAndView handleRequest (javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
		ModelAndView mav = new ModelAndView("gallery.jsp");
		String ApplicationPath =
				ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
		String filePath = ApplicationPath + "galleryImages";
		File file = new File(filePath);
		File[] files = file.listFiles();
		if (files != null) {
			mav.addObject("length", files.length);
			for (int i = 0; i < files.length; i++) {
				if (files[i].isFile()) {
					mav.addObject("filePath" + i, "galleryImages\\" + files[i].getName());
				}
			}
		}
		else {
			mav.addObject("length", 0);
		}
		return mav;
	}
	@RequestMapping("/imgUpload")
	@ResponseBody
	public String imgUpload (@RequestParam ("picture") MultipartFile picture) throws Exception{
		String ApplicationPath =
				ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
		String filePath = ApplicationPath + File.separator + "galleryImages" + File.separator + picture.getOriginalFilename();
		picture.transferTo(new File(filePath));
		return "success";
	}
	@RequestMapping("/imgDelete")
	@ResponseBody
	public void imgDelete (@RequestParam("option") String option){
		String ApplicationPath =
				ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
		String filePath = ApplicationPath + File.separator + "galleryImages" + File.separator + option;
		File file = new File(filePath);
		if (file.exists()){
			file.delete();
		}
	}

	@RequestMapping("/reqImgs")
	@ResponseBody
	public String reqImgs () throws JsonProcessingException {
		String[] imgNames;
		String ApplicationPath =
				ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
		String filePath = ApplicationPath + "galleryImages";
		File file = new File(filePath);
		File[] files = file.listFiles();
		imgNames = new String[files.length];
		if (files != null) {
			for (int i = 0; i < files.length; i++){
				imgNames[i] = files[i].getName();
			}
		}
		return new ObjectMapper().writeValueAsString(imgNames);
	}
}
