package com.study.blog.controller.admin;


import com.github.pagehelper.PageHelper;
import com.study.blog.po.Type;
import com.study.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class TypeController {


    @Autowired
    TypeService typeService;


    @RequestMapping("/types")
    public String types(@RequestParam(required = true,defaultValue = "1") Integer pageNum, Model model) {
        model.addAttribute("pageInfo", typeService.listType(pageNum));
        return "admin/typeadmin";
    }

    @RequestMapping("/types/input")
    public String input(Model model) {
        model.addAttribute("type",new Type());
        return "admin/types-input";
    }

    @RequestMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        typeService.deleteType(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redict:/admin/typeadmin";
    }

    @RequestMapping("/typesadd")
    public String post(@Validated Type type, BindingResult result, RedirectAttributes attributes) {
        Type type1=typeService.getTypeByName(type.getName());
        if(type1!=null){
            result.rejectValue("name","nameError","该分类已存在");
        }
        if (result.hasErrors()){
            return "admin/types-input";
        }
        int res = typeService.saveType(type);
        if (res == 0) {
            attributes.addFlashAttribute("message","新增失败");
        }else {
            attributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/types/1";
    }

    @RequestMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id,Model model){
        model.addAttribute("type",typeService.getType(id));
        return "admin/types-input";
    }

    @RequestMapping("/typesupdate/{id}")
    public String editPost(@Validated Type type, BindingResult result,@PathVariable Long id , RedirectAttributes attributes) {
        Type type2=typeService.getTypeByName(type.getName());
        if(type2!=null){
            result.rejectValue("name","nameError","该分类已存在");
        }
        if (result.hasErrors()){
            return "admin/types-input";
        }
        int res = typeService.updateType(id,type);
        if (res == 0) {
            attributes.addFlashAttribute("message","更新失败");
        }else {
            attributes.addFlashAttribute("message","更新成功");
        }
        return "redirect:/admin/types";
    }

}
