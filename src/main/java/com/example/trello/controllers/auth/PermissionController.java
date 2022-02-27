package com.example.trello.controllers.auth;

import com.example.trello.controllers.AbstractController;
import com.example.trello.criteria.GenericCriteria;
import com.example.trello.dto.permission.PermissionCreateDto;
import com.example.trello.dto.permission.PermissionDto;
import com.example.trello.services.permission.PermissionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("permission/*")
public class PermissionController extends AbstractController<PermissionService> {

    public PermissionController(PermissionService service) {
        super(service);
    }


}
