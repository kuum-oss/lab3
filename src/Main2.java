// Main2.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime; // Використаємо для встановлення початкового часу

/**
 * ВИМОГА 5: Вивід даних здійснити у графічне вікно з нового класу Main2 {}
 */
public class Main2 {

    private ClockExt2 clock; // Наш об'єкт годинника
    private JLabel timeLabel; // Мітка для відображення часу

    public Main2() {
        // Створюємо екземпляр годинника і встановлюємо поточний час
        LocalTime now = LocalTime.now();
        clock = new ClockExt2(
                now.getHour(),
                now.getMinute(),
                now.getSecond(),
                now.getNano() / 1_000_000 // Наносекунди -> Мілісекунди
        );

        // --- ВИМОГА 4: Побудувати новий графічний інтерфейс ---
        JFrame frame = new JFrame("Електронний годинник");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 150); // Розмір вікна
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30)); // Центрування

        // Створюємо JLabel для відображення часу
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Monospaced", Font.BOLD, 50)); // Великий шрифт
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        updateLabelText(); // Встановлюємо початковий текст

        frame.add(timeLabel);
        frame.setLocationRelativeTo(null); // Вікно по центру екрана
        frame.setVisible(true);

        // --- ВИМОГА 6: Частота зміни даних за таймером - 100 millisecond ---
        int timerDelay = 100; // 100 мілісекунд

        Timer timer = new Timer(timerDelay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Цей код виконується кожні 100 мс
                // Додаємо 100 мс до нашого годинника
                clock.addMilliseconds(timerDelay);
                // Оновлюємо текст на екрані
                updateLabelText();
            }
        });
        timer.start(); // Запускаємо таймер
    }

    // Допоміжний метод для оновлення тексту в JLabel
    private void updateLabelText() {
        timeLabel.setText(clock.toString());
    }

    // Головний метод для запуску програми
    public static void main(String[] args) {
        // Запускаємо GUI в безпечному потоці (Event Dispatch Thread)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main2();
            }
        });
    }
}