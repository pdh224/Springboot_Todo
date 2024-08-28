package com.mysite.todo;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
@RequiredArgsConstructor
@Controller

public class toDoListController {
	private final toDoListService toDoListService;
	@GetMapping("/todolist/list")
    public String list(Model model) {
		List<toDoList> toDoList = this.toDoListService.getList();
        model.addAttribute("toDoList", toDoList); 
		return "index_list";
    }
	
	@PostMapping("/todolist/list")
	public String toDoListCreate(@RequestParam(value="content") String content) {
		this.toDoListService.create(content);
        return "redirect:/todolist/list"; // 질문 저장후 질문목록으로 이동
    }
	
	@PostMapping("todolist/delete/{id}")
	public String toDoListDelete(@PathVariable Integer id) {
		this.toDoListService.delete(id);
        return "redirect:/todolist/list"; // 질문 저장후 질문목록으로 이동
    }
	
    @GetMapping("/")
    public String root() {
        return "redirect:/todolist/list";
    }
}
