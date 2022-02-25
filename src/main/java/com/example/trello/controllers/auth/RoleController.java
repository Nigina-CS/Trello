package com.example.trello.controllers.auth;

import com.example.trello.controllers.AbstractController;
import com.example.trello.dto.role.RoleCreateDto;
import com.example.trello.dto.role.RoleUpdateDto;
import com.example.trello.services.role.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/role/*")
public class RoleController extends AbstractController<RoleService> {

    public RoleController(RoleService service) {
        super(service);
    }

    @GetMapping("create/")
    public String createPage() {
        return "auth/role/create";
    }

    @PostMapping("create/")
    public String create(@ModelAttribute RoleCreateDto roleCreateDto) {
        Long id = service.create(roleCreateDto);
        return "redirect:/auth/role/";
    }

    @GetMapping("update/{id}/")
    public String update() {
        return "auth/role/update";
    }

    @PostMapping("update/")
    public String update(@ModelAttribute RoleUpdateDto roleUpdateDto) {
        service.update(roleUpdateDto);
        return "redirect:/auth/role/";
    }

}
