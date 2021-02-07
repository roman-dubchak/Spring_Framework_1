package Lesson7_hibernate3.controller;

import Lesson7_hibernate3.entities.Product;
import Lesson7_hibernate3.repo.Repo;
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
        Optional <Product> selectProduct = repo.findById(id);
        model.addAttribute("selectProduct", selectProduct);
        System.out.println("Find by " + id + " is product: " + selectProduct);
        return "products";
    }

    @GetMapping("/shop")
    public String findAllProduct(Model model){
        Iterable <Product> allProduct = repo.findAll();
        model.addAttribute("products", allProduct);
        System.out.println("Find by all product: " + allProduct);
        return "shop";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProductById(Model model, @PathVariable("id") Long id){
        repo.deleteById(id);
        System.out.println("Delete product by id: " + id);
        return "redirect:/shop";
    }

    @PostMapping("/form")
    @ResponseBody
    public String create(@RequestBody Product product, Model model){
        product = new Product();
        System.out.println("POST product - " + product);
        model.addAttribute("product", product);
        repo.save(product);
        return "result";
    }
}
