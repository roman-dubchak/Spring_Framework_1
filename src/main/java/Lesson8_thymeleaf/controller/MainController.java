package Lesson8_thymeleaf.controller;

import Lesson8_thymeleaf.entities.Product;
import Lesson8_thymeleaf.repo.Repo;
import Lesson8_thymeleaf.exception.ProductNotFoundException;
import Lesson8_thymeleaf.dto.ErrorDto;
import Lesson8_thymeleaf.dto.ProductInput;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController("/api/v1/product")
public class MainController {
/*     TODO 1. Перенести проект на RestController
*/
    private final Repo repo;

    public MainController(Repo repo) {
        this.repo = repo;
    }


    @GetMapping("/products/{id}")
    public Product findProductById(@PathVariable("id") Long id){
        return repo.findById(id).orElseThrow(()
                -> new ProductNotFoundException(String.format("Not found Product by this id %s", id)));
    }

    @ExceptionHandler
    public ErrorDto handlerNotSuchElementException (ProductNotFoundException e){
        return new ErrorDto(e.getMessage());
    }

    @ExceptionHandler
    public ErrorDto handlerNotSuchElementException (MethodArgumentNotValidException e){
        return new ErrorDto(e.getMessage());
    }

    @GetMapping("/shop")
    public List<Product> findAllProduct(){
       return repo.findAll();
    }

    @PostMapping("/all")
    public List<Product> findAllProductById(@RequestParam("id") List<Long> id){
        return repo.findAllById(id);
    }

    @GetMapping("/products/delete/{id}")
    public void deleteProductById(@PathVariable("id") Long id){
        repo.deleteById(id);
    }

    @PostMapping("/save")
    public Long saveProduct(@RequestBody @Valid Product productInput){
        return repo.save(productInput).getId();
    }


    /*

        @GetMapping("/products/{id}")
    public String findProductById(Model model, @PathVariable("id") Long id){
        model.addAttribute("selectProduct", repo.findById(id).get());
        System.out.println("Find by " + id + " is product: " + repo.findById(id));
        return "products";
    }

    @GetMapping("/shop")
    public String findAllProduct(Model model, @RequestParam(defaultValue = "0") int page){
//        PageRequest pageRequest = PageRequest.of(page, 4);
        model.addAttribute("products", repo.findAll(PageRequest.of(page, 4)));
        System.out.println("Find by all product: " + repo.findAll());
        model.addAttribute("currentPage", page);
        return "shop";
//        return findPaginated(1, model);
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated (@PathVariable("pageNo") int page, Model model){
        int pageSize = 4;

        Page<Product> productPage = repo.findPaginated(page, pageSize);
        List<Product> productsList = productPage.getContent();

        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("totalItems", productPage.getTotalElements());
        model.addAttribute("productsList", productsList);

        return "shop";
    }


    @GetMapping("/products/delete/{id}")
    public String deleteProductById(Model model, @PathVariable("id") Long id){
        repo.deleteById(id);
        System.out.println("Delete product by id: " + id);
        return "redirect:/shop";
    }

    @PostMapping("/save")
    public String saveProduct(Product product){
        repo.save(product);
        System.out.println("Delete product by id: " + product.getId());
        return "redirect:/shop";
    }

//    @GetMapping("/findOne")
//    @ResponseBody
//    public Product findOne (Long Id){
//        return repo.findOne(id);
//    }


    @GetMapping("/form")
    public String form(Product product, Model model){
        model.addAttribute("product", product);
        return "form";
    }

    @PostMapping(value = "/form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String form(Product product){
        repo.save(product);
        System.out.println("POST save product - " + product);
        return "redirect:/shop";
    }



//    @PostMapping("/form")
//    @ResponseBody
//    public Long saveProduct(@RequestBody Product product, Model model){
////        model.addAttribute("product", product);
//        System.out.println("POST saveProduct product - " + product);
//        return repo.save(product).getId();
//    }

     */
}
