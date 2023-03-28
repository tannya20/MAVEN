import org.example.BonusService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BonusServiceTest {
    // получение бонуксов менимальный тлатеж
    @Test
    void shouldCalculateForRegisteredAndOverLimitWithAmount99t() {
        BonusService service = new BonusService();
        long amount = 99;
        boolean registered = true;
        long expected = 2;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimitWithAmount99() {
        BonusService service = new BonusService();
        long amount = 99;
        boolean registered = false;
        long expected = 0;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimitWithAmount100t() {
        BonusService service = new BonusService();
        long amount = 100;
        boolean registered = true;
        long expected = 3;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    void shouldCalculateForRegisteredAndOverLimitWithAmount100() {
        BonusService service = new BonusService();
        long amount = 100;
        boolean registered = false;
        long expected = 1;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    // не зарегестрированные пользователи
    @Test
    void shouldCalculateForRegisteredAndOverLimitWithAmount1kk10() {
        BonusService service = new BonusService();
        long amount = 1_000_010;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimitWithAmount_1kkf() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimitWithAmount9kk() {
        BonusService service = new BonusService();
        long amount = 999_999;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimitWithAmount999f() {
        BonusService service = new BonusService();
        long amount = 999;
        boolean registered = false;
        long expected = 9;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimitWithAmount1001f() {
        BonusService service = new BonusService();
        long amount = 1001;
        boolean registered = false;
        long expected = 10;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    // зарегестрированые пользоватили
    @Test
    void shouldCalculateForRegisteredAndOverLimitWithAmount2_kk() {
        BonusService service = new BonusService();
        long amount = 2_000_000;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimitWithAmount999() {
        BonusService service = new BonusService();
        long amount = 999;
        boolean registered = true;
        long expected = 29;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimitWithAmount1010() {
        BonusService service = new BonusService();
        long amount = 1001;
        boolean registered = true;
        long expected = 30;
        long actual = service.calculate(amount, registered);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndUnderLimitWithAmount99_999() {
        BonusService service = new BonusService();

        long amount = 99_999;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndUnderLimitWithAmount_1k() {
        BonusService service = new BonusService();

        long amount = 1000;
        boolean registered = true;
        long expected = 30;
        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimitWithAmount_1kk() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }
}
