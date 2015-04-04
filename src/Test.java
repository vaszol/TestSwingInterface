/**
 * Created by vas on 04.04.15.
 */
import java.util.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Test extends JFrame implements ListSelectionListener {

    private JList list;

    public Test() {
        // Для инициализации списка нам потребуется вектор - посмотрите коллекции
        Vector v = new Vector();
        v.add("1");
        v.add("2");
        v.add("3");
        v.add("4");
        v.add("5");
        list = new JList(v);

        // Вот здесь выставляем режим выделения одного пункта
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Список будет посылать сообщения форме
        list.addListSelectionListener(this);

        // Добавляем список на панель формы
        getContentPane().add(new JScrollPane(list));

        // Устанавливаем границы
        setBounds(100, 100, 200, 200);
    }

    // Единственный метод, который реализует интерфейс ListSelectionListener
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) { //объект класса ListSelectionEvent имеет метод getValueIsAdjusting который возвращает true если событие вызывается по причине выбора нескольких пунктов
            System.out.println("New index:" + list.getSelectedIndex());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Test t = new Test();
                t.setDefaultCloseOperation(t.EXIT_ON_CLOSE);
                t.setVisible(true);
            }
        });
    }
}