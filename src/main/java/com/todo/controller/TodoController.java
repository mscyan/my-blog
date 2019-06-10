package com.todo.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Controller
@RequestMapping("/todo")
@EnableSwagger2
@Api(value = "Todo", description = "Todo Controller", tags = "todolist包下的内容")
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
