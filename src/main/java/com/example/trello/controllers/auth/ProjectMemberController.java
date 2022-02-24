package com.example.trello.controllers.auth;


import com.example.trello.controllers.AbstractController;
import com.example.trello.dto.project.ProjectMemberDto;
import com.example.trello.services.auth.AuthUserService;
import com.example.trello.services.project.ProjectMemberService;
import com.example.trello.services.project.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/projectmember/*")
public class ProjectMemberController extends AbstractController<ProjectMemberService> {

    private final AuthUserService authUserService;
    private final ProjectService projectService;

    public ProjectMemberController(ProjectMemberService service, AuthUserService authUserService, ProjectService projectService) {
        super(service);
        this.authUserService = authUserService;
        this.projectService = projectService;
    }

    @RequestMapping(value = "add/{id}",method = RequestMethod.GET)
    public String addPage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("project",projectService.get(id));
        return "add/project/member";
    }


    @RequestMapping(value = "add/{id}",method = RequestMethod.POST)
    public String addMember(ProjectMemberDto dto, @PathVariable(name = "id") Long id) {
        dto.setProjectId(id);
        service.add(dto);
        return "redirect: add/project/member";
    }

    @RequestMapping(value = "get",method = RequestMethod.GET)
    public String getMembers(Model model,@PathVariable Long id){
        model.addAttribute("members",service.get(id));
        return "project/member/list";
    }
}
