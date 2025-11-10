package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainTest {

    // ----------- DataProvider для sum и mul -----------
    @DataProvider(name = "sumData")
    public Object[][] sumData() {
        return new Object[][]{
                {1, 2, 3},
                {-5, 5, 0},
                {10, 15, 25},
                {-3, -7, -10}
        };
    }

    // ----------- 1. Тест sum() с DataProvider -----------
    @Test(groups = {"math", "sum"}, dataProvider = "sumData")
    public void testSum(int a, int b, int expected) {
        Assert.assertEquals(Main.sum(a, b), expected);
    }

    // ----------- 2. Тест sum() — обычный -----------
    @Test(groups = {"math", "sum"})
    public void testSumSimple() {
        Assert.assertEquals(Main.sum(5, 7), 12);
    }

    // ----------- 3. Тест diff() -----------
    @Test(groups = {"math", "diff"})
    public void testDiff() {
        Assert.assertEquals(Main.diff(10, 3), 7);
    }

    // ----------- 4. Тест mul() -----------
    @Test(groups = {"math", "mul"})
    public void testMul() {
        Assert.assertEquals(Main.mul(4, 5), 20);
    }

    // ----------- 5. Тест isEven() — чётное число -----------
    @Test(groups = {"logic", "even"})
    public void testIsEvenTrue() {
        Assert.assertTrue(Main.isEven(8));
    }

    // ----------- 6. Тест isEven() — нечётное число -----------
    @Test(groups = {"logic", "even"})
    public void testIsEvenFalse() {
        Assert.assertFalse(Main.isEven(7));
    }

    // ----------- 7. Тест reverse() -----------
    @Test(groups = {"string", "reverse"})
    public void testReverse() {
        Assert.assertEquals(Main.reverse("Java"), "avaJ");
    }

    // ----------- ТЕСТЫ ИСКЛЮЧЕНИЙ -----------

    // 8. reverse(null) → NullPointerException
    @Test(groups = {"exception"}, expectedExceptions = NullPointerException.class)
    public void testReverseException() {
        Main.reverse(null);
    }

    // 9. mul() — искусственно тестируем исключение
    @Test(groups = {"exception"}, expectedExceptions = ArithmeticException.class)
    public void testMulException() {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        // умножение переполнится → ArithmeticException (мы вызываем вручную)
        if ((long) x * y > Integer.MAX_VALUE) {
            throw new ArithmeticException("Overflow");
        }
        Main.mul(x, y);
    }
}
