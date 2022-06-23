import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pages.MainPage;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Owner("Luiza-Kh")
public class Newsletter {

    @MethodSource("testData")
    @ParameterizedTest(name = "{displayName} используя {0}")
    @DisplayName("Негативные кейсы для поля Newsletter")
    void newsInputTest(String type, String searchData) {

        step("Открыть главную страницу магазина", () -> {
            open("http://automationpractice.com/index.php");
        });

        step("Ввести данные в новостную рассылку" + searchData + " и нажать Enter", () -> {
                    MainPage.spamInput()
                            .sendKeys(searchData);
                    MainPage.spamInput()
                            .pressEnter();
                });

        step("Появляется плашка, что почта некорректна", () -> {
                MainPage.errorMessage()
                        .shouldBe(visible)
                        .shouldHave(text("Newsletter : Invalid email address."));
            });
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                arguments("цифры", "1004"),
                arguments("символы", "^_^"),
                arguments("некорректный почтовый адрес", "LuLuLu@")
        );
    }
}