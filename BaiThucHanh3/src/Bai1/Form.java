package Bai1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.*;
public class Form extends JFrame implements ActionListener{
    JLabel lbl1, lbl2, lbl3, lblresult1, lblresult2;
    JTextField tf;
    JButton b;
    public Form()
    {
        super("Form bài 1");
        this.setLayout(new GridLayout(7, 1));

        lbl1 = new JLabel("Nhập mảng");
        this.add(lbl1);

        tf = new JTextField();
        this.add(tf);

        b = new JButton("sắp xếp và tìm các số khác nhau");
        b.addActionListener(this);
        this.add(b);

        lbl2 = new JLabel("Mảng đã sắp xếp: ");
        this.add(lbl2);

        lblresult1 = new JLabel();
        this.add(lblresult1);

        lbl3 = new JLabel("Các số trong mảng: ");
        this.add(lbl3);

        lblresult2 = new JLabel();
        this.add(lblresult2);
    }
    public ArrayList<Integer> getArray()
    {
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(tf.getText());
        while(st.hasMoreTokens())
        {
            list.add(Integer.parseInt(st.nextToken()));
        }
        return list;
    }
    public ArrayList<Integer> sort()
    {
        ArrayList<Integer> list = getArray();
        Collections.sort(list);
        return list;
    }
    public HashSet<Integer> distinct()
    {
        HashSet<Integer> unique = new HashSet<>(getArray());
        return unique;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        lblresult1.setText(sort().toString());
        lblresult1.setForeground(Color.RED);
        lblresult2.setText(distinct().toString());
        lblresult2.setForeground(Color.BLUE);
    }

    public static void main(String[] args) {
        Form f = new Form();
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setSize(200, 200);
        f.setVisible(true);
    }
}
