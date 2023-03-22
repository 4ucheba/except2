import ru.netology.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestExcept {
    ShopRepository repo2 = new ShopRepository();
    Product item1 = new Product(1, "хлеб", 100);
    Product item2 = new Product(22, "булка", 200);
    Product item3 = new Product(3, "картошка", 170);
    Product item4 = new Product(44, "бананы", 150);
    Product[] products = new Product[0];


    @Test
    public void shouldGoToException() {

        repo2.add(item1);
        repo2.add(item2);
        repo2.add(item3);
        repo2.add(item4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo2.remove(100);

        });
    }

    @Test
    public void shouldRemoveProduct() {
        repo2.add(item1);
        repo2.add(item2);
        repo2.add(item3);
        repo2.add(item4);
        repo2.remove(22);

        Product[] expected = {item1, item3, item4};
        Product[] actual = repo2.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }


}
