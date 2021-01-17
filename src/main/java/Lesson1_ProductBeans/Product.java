package Lesson1_ProductBeans;

public class Product {

    /* TODO:
1. Разобраться с примером проекта на Spring MVC.
2. Создать класс Товар (Product), с полями id, title, cost. Товары необходимо хранить в репозитории (класс, в котором в виде List<Product> хранятся товары). Репозиторий должен уметь выдавать список всех товаров и товар по id.
3. Сделать форму для добавления товара в репозиторий и логику работы этой формы.
4. Сделать страницу, на которой отображаются все товары из репозитория.
*/

    private final String id;
    private final String title;
    private final String cost;

    public Product(String id, String title, String cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCost() {
        return cost;
    }

}
