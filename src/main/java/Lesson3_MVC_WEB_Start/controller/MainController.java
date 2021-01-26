package Lesson3_MVC_WEB_Start.controller;

import Lesson3_MVC_WEB_Start.entities.Product;
import Lesson3_MVC_WEB_Start.servies.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {
    //TODO
//1. Разобраться с примером проекта на Spring MVC;
//2. Создать класс Товар (Product), с полями id, title, cost;
//3. Товары необходимо хранить в репозитории (класс, в котором в виде List<Product> хранятся товары).
// Репозиторий должен уметь выдавать список всех товаров и товар по id;
//4. Сделать страницу, на которой отображаются все товары из репозитория.
//***5. Сделать форму для добавления товара в репозиторий и логику работы этой формы;

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String shopPage(Model model){
        List<Product> allProducts = productService.getListProducts();
        model.addAttribute("products", allProducts);
        return "index";
    }

    //    @RequestMapping(value = "/form", method = RequestMethod.GET)
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String getForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        System.out.println("Get product - " + product);
        return "form";
    }

    //    @PostMapping("/form")
    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String create(@ModelAttribute Product product, Model model){
        System.out.println("POST product - " + product);
        model.addAttribute("product", product);
//        Product addProd = new Product(product.getId(), product.getName(),  product.getCost());
//        productService.saveProduct(addProd);
//        return "redirect:/";
        return "result";
    }

}
