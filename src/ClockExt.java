// ClockExt.java
// Цей клас успадковується від Clock і служить батьківським для ClockExt2
public class ClockExt extends Clock {

    // Конструктор за замовчуванням
    public ClockExt() {
        super(); // Виклик конструктора Clock()
    }

    // Конструктор з параметрами
    public ClockExt(int hours, int minutes, int seconds) {
        super(hours, minutes, seconds); // Виклик конструктора Clock(h, m, s)
    }

    // Можна додати додаткові методи, якщо потрібно,
    // наприклад, універсальний метод встановлення часу:
    public void setTime(int hours, int minutes, int seconds) {
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }
}