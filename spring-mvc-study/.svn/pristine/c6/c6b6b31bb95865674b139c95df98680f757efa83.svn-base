package com.suoyi.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.CharEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.suoyi.model.Student;
import com.suoyi.service.Service;

@Controller
@RequestMapping("/hello")
public class ServiceController {
	private Service service;

	@Autowired
	public void setService(Service service) {
		this.service = service;
	}

	@RequestMapping("/getString")
	public String testView(@RequestParam("id") Integer id, Model model) {
		String result = service.getXXX(id);
		model.addAttribute("result", result);
		return "test2";
	}

	@RequestMapping("/getString/{id}")
	public String testView2(@PathVariable("id") Integer id, Model model) {
		String result = service.getXXX(id);
		model.addAttribute("result", result);
		return "test2";
	}

	@RequestMapping("/requestTest")
	public String testView3(HttpServletRequest request) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		request.setAttribute("result", service.getXXX(id));
		return "test2";
	}

	@RequestMapping(value = "/inputtest", method = RequestMethod.POST)
	public String testView4(Student student, Model model) {

		System.out.println("info of input {id:" + student.getId() + ",name:"
				+ student.getName() + "}");
		// try {
		// student.setName(new String(
		// student.getName().getBytes("ISO-8859-1"), "utf-8"));
		// } catch (UnsupportedEncodingException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		model.addAttribute("student", student);
		return "test2";
	}

	@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	public String doUpload(@RequestParam("file") MultipartFile multipartFile)
			throws IOException {
		if (!multipartFile.isEmpty()) {
			FileUtils.copyInputStreamToFile(multipartFile.getInputStream(),
					new File("D:\\file", System.currentTimeMillis() + "-currentTimeMillis-"
							+ multipartFile.getOriginalFilename()));
			return "success";
		} else {
			return "sayHello";
		}
	}

	@RequestMapping("/getJson")
	public @ResponseBody
	Student getJson() {
		Student student = new Student();
		student.setId("1");
		student.setName("张三");
		return student;
	}

	@RequestMapping("/download")
	public ResponseEntity<byte[]> download() throws IOException {
		String path = "d:\\file\\1444218991860-currentTimeMillis-个人简历-邱相师.doc";

		File file = new File(path);

		HttpHeaders headers = new HttpHeaders();
//		headers.setAcceptCharset(acceptableCharsets)
		StringBuilder sb = new StringBuilder();

		String[] tempname = path.split("-currentTimeMillis-");

		for (int i = 1; i < tempname.length; i++) {
			sb.append(tempname[i]);
		}

		String filename = new String(sb.toString().getBytes("utf-8"),
				"ISO-8859-1");

		System.out.println(filename);

		headers.setContentDispositionFormData("attachment", filename);
		// headers.setContentDispositionFormData("filename", "");
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

		ResponseEntity<byte[]> result = new ResponseEntity<byte[]>(
				FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);

		return result;
	}
}
