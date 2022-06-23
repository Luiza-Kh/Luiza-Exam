import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Owner("Luiza-Kh")
@Feature("Добавление товара в корзину через быструю корзину")
public class AddingToCart {

    @Test
    @DisplayName("Добавление товара в корзину, через быструю корзину")
    public void addProductToCard() {
        step("Открыть главную страницу", () -> {
            open("http://automationpractice.com/index.php");
        });

        step("Навести курсор на карточку товара", () -> {
            MainPage.productСards()
                    .hover();
        });

        step("Нажать на кнопку 'Add to cart' в блоке товара", () -> {
            MainPage.buttonAddToCart()
                    .click();
        });

        step("Проверить, наличие модального окна с успешным добавлением в корзину", () -> {
            MainPage.successfulModal()
                    .shouldBe(visible);
        });
    }
}