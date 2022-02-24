package com.example.trello.controllers.auth;

import com.example.trello.controllers.AbstractController;
import com.example.trello.dto.task.TaskMemberDto;
import com.example.trello.services.auth.AuthUserService;
import com.example.trello.services.task.TaskMemberService;
import com.example.trello.services.task.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/taskmember/*")
public class TaskMemberController extends AbstractController<TaskMemberService> {

    private final AuthUserService userService;
    private final TaskService taskService;

    public TaskMemberController(TaskMemberService service, AuthUserService userService, TaskService taskService) {
        super(service);
        this.userService = userService;
        this.taskService = taskService;
    }


    @RequestMapping(value = "add/{id}",method = RequestMethod.GET)
    public String addPage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("task",taskService.get(id));
        return "add/task/member";
    }


    @RequestMapping(value = "add/{id}",method = RequestMethod.POST)
    public String addMember(TaskMemberDto dto, @PathVariable(name = "id") Long id) {
        dto.setTaskId(id);
        service.add(dto);
        return "redirect: add/task/member";
    }

    @RequestMapping(value = "get",method = RequestMethod.GET)
    public String getMembers(Model model,@PathVariable Long id){
        model.addAttribute("members",service.get(id));
        return "task/member/list";
    }
}
