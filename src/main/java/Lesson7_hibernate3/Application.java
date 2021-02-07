package Lesson7_hibernate3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
// TODO 1.Создать сущность «Товар» (id, название, стоимость) и соответствующую таблицу в БД.
//  Заполнить таблицу тестовыми данными (20 записей).(через ликвибейз)
//  2. Сделать RestController позволяющий выполнять следующий набор операции над этой сущностью:
//  получение товара по id [ GET .../app/products/{id} ]
//  получение всех товаров [ GET .../app/products ]
//  создание нового товара [ POST .../app/products ]
//  удаление товара по id.[ DELETE .../app/products/delete/{id} ]
//  3.* К запросу всех товаров добавьте возможность фильтрации по минимальной и максимальной цене
//  (в трех вариантах: товары дороже min цены, товары дешевле max цены,
//  или товары, цена которых находится в пределах min-max).
//  (** Сделать через запросы к бд или ******через Criteria API)
public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
}
}
