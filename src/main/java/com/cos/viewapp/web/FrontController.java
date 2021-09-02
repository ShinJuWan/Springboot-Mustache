package com.cos.viewapp.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// RestController (데이터를 리턴한다)
// Controller (파일을 리턴한다)

@Controller
public class FrontController {

		// http://localhost:8080/home
		// 디스패쳐 서블릿 /home 파싱(주소를 분석)
	 	// ioC 컨테이너에 @RestController, @Controller로 생성된 객체만 찾는다. 
	 	// /home 메소드를 response(호출)
		// Controller에서는 전역변수를 사용하지 않는다. 충돌이 발생할 수 있다. 
	
		@GetMapping("/home")
		public String home(Model model) {	// request == model
			// ViewResolver 클래스 = view를 해결해주는 class
			// src/main/resources/templates (prefix = 앞에 붙는다.)
			// . mustache (suffix = 뒤에 붙는다.)
			
			String name = "신주완";
			model.addAttribute("name", name);
			
			List<Board> boards = new ArrayList<>();
			boards.add(new Board(1, "제목1"));
			boards.add(new Board(2, "제목3"));
			
			model.addAttribute("boards", boards);
			
			return "home"; // RequestDispatcher가 자동 작동
		}
}











