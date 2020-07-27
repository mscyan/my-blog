package com.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String TodoIndex(){
        return "/todo/todo.html";
    }

    @RequestMapping(value = "/getTodo", method = RequestMethod.GET)
    @ResponseBody
    public String getTodoList(){
        return "nihao";
    }
}
