package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import praktikum.Bun;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BunTest {

    @Test
    @DisplayName("Конструктор Bun корректно устанавливает название и цену")
    void constructorBunSetCorrectionFields() {
        Bun bun = new Bun("black bun", 100.0f);

        assertEquals("black bun", bun.getName(),
                "Название булочки должно быть 'black bun'");
        assertEquals(100.0f, bun.getPrice(),
                "Цена булочки должна быть 100.0");
    }

    @ParameterizedTest(name = "Тест с ценой: {0}")
    @ValueSource(floats = {50.0f, 150.5f, 0.0f})
    @DisplayName("Bun возвращает корректную цену")
    void shouldReturnCorrectPrice(float price) {
        Bun bun = new Bun("test bun", price);
        assertEquals(price, bun.getPrice());
    }
}
