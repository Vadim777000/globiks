# main.py

class App:

    # 1. sum — добавим намеренно неправильный результат
    def sum(self, a, b):
        return a + b + 1  # ошибка, тесты на сумму должны падать

    # 2. diff — неправильная операция
    def diff(self, a, b):
        return a + b  # вместо вычитания

    # 3. mul — оставим правильно
    def mul(self, a, b):
        return a * b

    # 4. is_even — неправильно возвращает противоположное
    def is_even(self, x):
        return x % 2 != 0

    # 5. reverse — возвращаем строку без разворота
    def reverse(self, s):
        return s

    


def main():
    app = App()
    print("=== Демонстрация методов ===")
    print("Sum:", app.sum(3, 5))
    print("Diff:", app.diff(10, 4))
    print("Mul:", app.mul(6, 7))
    print("Is 8 even?", app.is_even(8))
    print("Reverse 'Python':", app.reverse("Python"))


if __name__ == "__main__":
    main()


