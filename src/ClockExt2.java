// ClockExt2.java
// ВИМОГА 1: Створити новий клас ClockExt2, який має унаслідуватись від класу ClockExt.
public class ClockExt2 extends ClockExt {

    // Нове поле для мілісекунд
    protected int milliseconds;

    // --- ВИМОГА 2: Створити всі необхідні конструктори ---

    // Конструктор за замовчуванням
    public ClockExt2() {
        super(); // Виклик конструктора ClockExt()
        this.milliseconds = 0;
    }

    // Конструктор з усіма параметрами
    public ClockExt2(int hours, int minutes, int seconds, int milliseconds) {
        super(hours, minutes, seconds); // Виклик конструктора ClockExt(h, m, s)
        setMilliseconds(milliseconds); // Встановлюємо мілісекунди через setter
    }

    // --- ВИМОГА 2: Створити методи get/set ---

    public int getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(int milliseconds) {
        if (milliseconds >= 0 && milliseconds < 1000) {
            this.milliseconds = milliseconds;
        } else {
            this.milliseconds = 0; // Скидання при некоректних даних
        }
    }

    /**
     * ВИМОГА 3: Здійснити реалізацію методу void nextMillisecond(){}
     * Цей метод додає одну мілісекунду до часу.
     */
// Анотацію @Override видалено, оскільки це новий метод
    public void nextMillisecond() {
        this.milliseconds++;
        if (this.milliseconds == 1000) {
            this.milliseconds = 0;
            super.nextSecond();
        }
    }

    /**
     * Допоміжний метод для додавання одразу певної кількості мілісекунд.
     * Це потрібно для таймера, який спрацьовує кожні 100 мс.
     *
     * @param ms Кількість мілісекунд для додавання
     */
    public void addMilliseconds(int ms) {
        this.milliseconds += ms;
        if (this.milliseconds >= 1000) {
            // Рахуємо, скільки секунд потрібно додати
            int secondsToAdd = this.milliseconds / 1000;
            // Залишаємо залишок мілісекунд
            this.milliseconds %= 1000;

            // Додаємо потрібну кількість секунд, викликаючи батьківський метод
            for (int i = 0; i < secondsToAdd; i++) {
                super.nextSecond();
            }
        }
    }

    /**
     * Перевизначений метод toString() для відображення 4 параметрів.
     * Формат: HH:MM:SS:mmm
     */
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d:%03d",
                super.getHours(),
                super.getMinutes(),
                super.getSeconds(),
                this.milliseconds);
    }
}