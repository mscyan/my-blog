package com.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @RequestMapping("")
    public String TodoIndex(){
        return "/todo/todo.html";
    }

    @RequestMapping("/getTodo")
    @ResponseBody
    public String getTodoList(){
        return "nihao";
    }
}
