package Lesson3_MVC_WEB_Start.entities;

public class Product {

    /* TODO:
1. Разобраться с примером проекта на Spring MVC.
2. Создать класс Товар (Product), с полями id, title, cost. Товары необходимо хранить в репозитории (класс, в котором в виде List<Product> хранятся товары). Репозиторий должен уметь выдавать список всех товаров и товар по id.
3. Сделать форму для добавления товара в репозиторий и логику работы этой формы.
4. Сделать страницу, на которой отображаются все товары из репозитория.

1. Есть класс Product (id, название, цена).
2. Товары хранятся в бине ProductRepository, в виде Map<Product>, при старте в него нужно добавить 5 любых товаров.
3. ProductRepository позволяет получить весь список или один товар по id.
4. Создаем бин Cart (который обращается к ProductRepository - методом - на вход id), в который можно добавлять и удалять товары по id.
5. Написать консольное приложение, позволяющее управлять корзиной.

*/
    private Integer id;
    private String name;
    private Integer cost;

    public Product(Integer id, String title, Integer cost) {
        this.id = id;
        this.name = title;
        this.cost = cost;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return String.format("id - %d\n; name - %s\n; cost - %d\n.",id, name, cost);
    }
}
