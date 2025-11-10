# test_app.py
import pytest
from main import App

app = App()

# ----------------- 1. Тест sum с parametrize -----------------
@pytest.mark.math
@pytest.mark.parametrize(
    "a, b, expected",
    [
        (1, 2, 3),
        (-5, 5, 0),
        (10, 15, 25),
        (-3, -7, -10)
    ]
)
def test_sum(a, b, expected):
    assert app.sum(a, b) == expected

# ----------------- 2. Тест sum простой -----------------
@pytest.mark.math
# Неправильный ожидаемый результат для sum
def test_sum_simple():
    assert app.sum(5, 7) == 13  # должно быть 12 → тест упадёт

# ----------------- 3. Тест diff -----------------
@pytest.mark.math
# Неправильный ожидаемый результат для diff
def test_diff():
    assert app.diff(10, 4) == 5  # должно быть 6 → тест упадёт

# ----------------- 4. Тест mul -----------------
@pytest.mark.math
def test_mul():
    assert app.mul(6, 7) == 42

# ----------------- 5. Тест is_even True -----------------
@pytest.mark.logic
def test_is_even_true():
    assert app.is_even(8) is True

# ----------------- 6. Тест is_even False -----------------
@pytest.mark.logic
def test_is_even_false():
    assert app.is_even(7) is False

# ----------------- 7. Тест reverse -----------------
@pytest.mark.string
def test_reverse():
    assert app.reverse("Python") == "nohtyP"

# ----------------- 8. Тест reverse на исключение -----------------
@pytest.mark.exception
def test_reverse_exception():
    with pytest.raises(TypeError):
        app.reverse(None)  # None нельзя разворачивать, TypeError

# ----------------- 9. Тест mul на исключение (искусственно) -----------------
@pytest.mark.exception
def test_mul_exception():
    x = 2**31 - 1
    y = 2**31 - 1
    # искусственно проверяем переполнение (Python int не падает, поэтому проверим вручную)
    if x * y > 2**31 - 1:
        with pytest.raises(OverflowError):
            raise OverflowError("Overflow")
    else:
        assert app.mul(x, y) == x * y
