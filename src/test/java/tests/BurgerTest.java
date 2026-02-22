package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BurgerTest {

    private Burger burger;
    @Mock
    private Bun bunMock;
    @Mock
    private Ingredient ingredientMock1;
    @Mock
    private Ingredient ingredientMock2;

    @BeforeEach
    void setUp() {
        burger = new Burger();
        when(bunMock.getName()).thenReturn("mock bun");
        when(bunMock.getPrice()).thenReturn(100.0f);
        when(ingredientMock1.getName()).thenReturn("mock sauce");
        when(ingredientMock1.getPrice()).thenReturn(50.0f);
        when(ingredientMock1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredientMock1.getName()).thenReturn("mock cutlet");
        when(ingredientMock1.getPrice()).thenReturn(150.0f);
        when(ingredientMock1.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    @DisplayName("setBuns устанавливает булочку")
    void shouldSetBun() {
        burger.setBuns(bunMock);
        assertNotNull(burger.bun);
        assertEquals("mock bun", burger.bun.getName());
    }

    @Test
    @DisplayName("addIngredient добавляет ингредиент")
    void shouldAddIngredient() {
        burger.addIngredient(ingredientMock1);
        assertEquals(1, burger.ingredients.size());
        assertEquals("mock sauce", burger.ingredients.get(0).getName());
    }
}
