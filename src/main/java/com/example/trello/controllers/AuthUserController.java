package com.example.trello.controllers;

import com.example.trello.controllers.AbstractController;
import com.example.trello.criteria.GenericCriteria;
import com.example.trello.dto.auth.UserCreateDto;
import com.example.trello.dto.auth.UserUpdateDto;
import com.example.trello.services.auth.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/auth/*")
public class AuthUserController extends AbstractController<AuthUserService> {

    @Autowired
    public AuthUserController(AuthUserService service) {
        super(service);
    }


    @RequestMapping(value = "create/", method = RequestMethod.POST)
    public String create(@ModelAttribute UserCreateDto dto, HttpServletRequest request,@ModelAttribute(name = "organizationId") String orgId) {
        System.out.println(orgId);
        String referer = request.getHeader("Referer").substring(22);
        service.create(dto);
        return "redirect:/"+referer;
    }


    @RequestMapping(value = "delete/{id}/", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id") Long id, HttpServletRequest request) {
        String referer = request.getHeader("Referer").substring(22);
        service.delete(id);
        return  "redirect:/"+referer;
    }


    @RequestMapping(value = "update/{id}/", method = RequestMethod.GET)
    public String updatePage(Model model , @PathVariable (name = "id") Long id) {
        model.addAttribute("user",service.get(id));
        return "auth/update";
    }

    @RequestMapping(value = "update/", method = RequestMethod.POST)
    public String update(@ModelAttribute UserUpdateDto dto) {
        service.update(dto);
        return "redirect: auth/list";
    }

    @RequestMapping("detail/{id}/")
    public String detail(@PathVariable Long id) {
        return "auth/detail";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String listPage(Model model) {
        model.addAttribute("users", service.getAll(new GenericCriteria()));
        return "auth/list";
    }

    @RequestMapping(value = "block/{id}",method = RequestMethod.POST)
    public String block(@PathVariable (name = "id") Long id) {
        service.block(id);
        return "redirect: auth/list";
    }

    @RequestMapping(value = "unblock/{id}",method = RequestMethod.POST)
    public String unblock(@PathVariable (name = "id") Long id) {
        service.unblock(id);
        return "redirect: auth/list";
    }

    @RequestMapping(value = "getbyorgid/{id}",method = RequestMethod.GET)
    public String getAllByOrgId (Model model,@PathVariable(name = "id") Long id) {
        model.addAttribute("users",service.getAllByOrgId(id));
        return "redirect: auth/list";
    }

}
