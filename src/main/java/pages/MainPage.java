package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public static SelenideElement productСards() {
        return $(byText("Faded Short Sleeve T-shirts")).as("Название товара");
    }

    public static SelenideElement buttonAddToCart() {
        return $("[title='Add to cart']").as("Кнопка добавления в корзину");
    }

    public static SelenideElement successfulModal() {
        return $("#layer_cart .clearfix").as("Модальное окно об успешном добавлении в корзину");
    }

    public static SelenideElement spamInput() {
        return $(".newsletter-input").as("Поле ввода для почты на рассылку новостей");
    }

    public static SelenideElement errorMessage() {
        return $(".alert-danger").as("Плашка об ошибке");
    }
}
