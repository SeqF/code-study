package com.study.blog.controller.admin;

import com.study.blog.service.BlogService;
import com.study.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    TypeService typeService;

    @RequestMapping("/blogs")
    public String blogs(@RequestParam(required = true,defaultValue = "1") Integer pageNum, Integer typeId, String title, Boolean recommend, Model model) {
        model.addAttribute("page",blogService.listBlog(pageNum,typeId,title,recommend));
        model.addAttribute("types",typeService.listType());
        return "admin/blogadmin";
    }

    @RequestMapping("/blogs/search")
    public String search(@RequestParam(required = true,defaultValue = "1") Integer pageNum, Integer typeId, String title, Boolean recommend, Model model) {
        model.addAttribute("page",blogService.listBlog(pageNum,typeId,title,recommend));
        return "admin/blogadmin :: blogList";
    }
}
