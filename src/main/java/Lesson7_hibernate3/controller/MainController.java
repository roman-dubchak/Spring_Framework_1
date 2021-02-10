package Lesson7_hibernate3.controller;

import Lesson7_hibernate3.entities.Product;
import Lesson7_hibernate3.repo.Repo;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
/*     TODO 1.Создать сущность «Товар» (id, название, стоимость) и соответствующую таблицу в БД.
        Заполнить таблицу тестовыми данными (20 записей).(через ликвибейз)
        2. Сделать RestController позволяющий выполнять следующий набор операции над этой сущностью:
        получение товара по id [ GET .../app/products/{id} ]
        получение всех товаров [ GET .../app/products ]
        создание нового товара [ POST .../app/products ]
        удаление товара по id.[ DELETE .../app/products/delete/{id} ]
        3.* К запросу всех товаров добавьте возможность фильтрации по минимальной и максимальной цене
        (в трех вариантах: товары дороже min цены, товары дешевле max цены,
        или товары, цена которых находится в пределах min-max).
        (** Сделать через запросы к бд или ******через Criteria API)
*/
    private final Repo repo;

    public MainController(Repo repo) {
        this.repo = repo;
    }

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

//    @GetMapping("/page/{pageNo}")
//    public String findPaginated (@PathVariable("pageNo") int page, Model model){
//        int pageSize = 4;
//
//        Page<Product> productPage = repo.findPaginated(page, pageSize);
//        List<Product> productsList = productPage.getContent();
//
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", productPage.getTotalPages());
//        model.addAttribute("totalItems", productPage.getTotalElements());
//        model.addAttribute("productsList", productsList);
//
//        return "shop";
//    }


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
}
