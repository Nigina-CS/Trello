package com.example.trello.controllers;

import com.example.trello.criteria.GenericCriteria;
import com.example.trello.dto.organization.OrganizationCreateDto;
import com.example.trello.dto.organization.OrganizationUpdateDto;
import com.example.trello.services.auth.AuthUserService;
import com.example.trello.services.organization.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/organization/*")
public class OrganizationController extends AbstractController<OrganizationService> {

    AuthUserService userService;

    @Autowired
    public OrganizationController(OrganizationService service, AuthUserService userService) {
        super(service);
        this.userService = userService;
    }

    @RequestMapping(value = "create/", method = RequestMethod.POST)
    public String create(@ModelAttribute OrganizationCreateDto dto) {
        service.create(dto);
        return "redirect:/organization/list/";
    }

    @RequestMapping(value = "delete/{id}/", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/organization/list/";
    }

    @RequestMapping(value = "update/{id}/", method = RequestMethod.POST)
    public String update(@ModelAttribute OrganizationUpdateDto dto,@PathVariable Long id) {
        service.update(dto);
        return "redirect:/organization/detail/"+id+"/";
    }


    @RequestMapping("detail/{id}/")
    public String detail(Model model, @PathVariable Long id) {
        model.addAttribute("organization",service.get(id));
        model.addAttribute("users",userService.getAllByOrgId(id));
        return "org/detail";
    }

    @RequestMapping(value = "list/", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("organizations", service.getAll(new GenericCriteria()));
        return "org/list";
    }

    @RequestMapping(value = "listWithAdmins/", method = RequestMethod.GET)
    public String adminsPage(Model model) {
        model.addAttribute("organizations", service.getAll(new GenericCriteria()));
        model.addAttribute("users",userService.getAll(new GenericCriteria()));
        return "org/admin";
    }

    @RequestMapping(value = "block/{id}",method = RequestMethod.POST)
    public String block(@PathVariable (name = "id") Long id) {
        service.block(id);
        return "organization/list";
    }

    @RequestMapping(value = "unblock/{id}",method = RequestMethod.POST)
    public String unblock(@PathVariable (name = "id") Long id) {
        service.unblock(id);
        return "organization/list";
    }
}
