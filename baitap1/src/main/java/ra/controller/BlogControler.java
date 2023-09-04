package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Blog;
import ra.model.service.IGenericService;

import java.util.List;

@Controller

public class BlogControler {
    @Autowired
    private IGenericService blogService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("blogs", (List<Blog>) blogService.findAll());
        return "home";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Long id) {
        Blog blog = (Blog) blogService.findByID(id);
        return new ModelAndView("detail", "blog", blog);
    }

    @GetMapping("/add")
    public ModelAndView add() {

        return new ModelAndView("add", "blog", new Blog());
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        return new ModelAndView("edit", "blog",(Blog) blogService.findByID(id));
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        blogService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/";
    }

}
