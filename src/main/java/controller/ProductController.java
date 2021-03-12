package controller;


import com.sun.org.apache.xpath.internal.operations.Mod;
import model.Category;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.ICategoryService;
import service.IProductService;

import java.util.List;


@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ModelAndView list(){
        ModelAndView modelAndView=new ModelAndView("list","p",productService.findAll());
        return modelAndView;
    }

    @ModelAttribute("listCategory")
    public List<Category>listC(){
        return categoryService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView formCreate(){
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("p",new Product());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Product product){
        ModelAndView modelAndView=new ModelAndView("redirect:/products");
        productService.save(product);
        return modelAndView;
    }

    @GetMapping("edit/{id}")
    public String formEdit(@PathVariable Long id, Model model){
        model.addAttribute("p",productService.findById(id));
        return "/edit";
    }

    @PostMapping("edit/{id}")
    public ModelAndView edit(@ModelAttribute Product product,@PathVariable Long id){
        ModelAndView modelAndView=new ModelAndView("redirect:/products");
        product.setId(id);
        productService.save(product);
        return modelAndView;
    }
    @GetMapping("delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        ModelAndView modelAndView=new ModelAndView("redirect:/products");
        productService.delete(id);
        return modelAndView;
    }

    @PostMapping("")
    public ModelAndView search(@RequestParam String name){
        ModelAndView modelAndView=new ModelAndView("list");
        List<Product>products=productService.findByName(name);
        modelAndView.addObject("p",products);
        return modelAndView;
    }
    @PostMapping("productNew")
    public ModelAndView findProduct(){
        ModelAndView modelAndView=new ModelAndView("list");
        modelAndView.addObject("p",productService.productNew());
        return modelAndView;
    }

}
