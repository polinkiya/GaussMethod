package javaapplication1;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.BorderUIResource;
import javax.swing.table.DefaultTableModel;

public class MyForm extends JFrame{
    GaussMethod sample;
    static JButton button, button2, button3;
    static JLabel lb1, lb2, imageLabel, lb3;
    static JTextField mSize, nSize;
    static JTable table;
    static DefaultTableModel tableModel;
    static JTextPane solution;

    Checked check = new Checked();


    public MyForm() {
        super("Решение СЛАУ методом Гаусса");
        setResizable(false);

        button = new JButton("Заполнить матрицу");
        button2 = new JButton("Решить систему");
        button3 = new JButton("Сохранить в файл");
        mSize= new JTextField("0");
        lb1 = new JLabel("Введите количество уравнений:");
        nSize= new JTextField("0");
        lb2 = new JLabel("Введите количество переменных:");
        lb3 = new JLabel("Решение СЛАУ:");

        solution = new JTextPane();
        imageLabel = new JLabel(new ImageIcon("/Users/polinamorozova/IdeaProjects/Gauss_method/calc.png"));
        imageLabel.setVisible(true);
        imageLabel.setBounds(390,140,150,150);

        setSize(600,570);
        button.setBounds( 350, 20,150,20);
        button2.setBounds( 350, 50,150,20);
        button3.setBounds( 350, 80,150,20);
        // button.setBackground(Color.PINK);
        mSize.setBounds(10,20,200,30);
        nSize.setBounds(10,70,200,30);

        lb1.setBounds(mSize.getX(), mSize.getY() - 20, 300, 20 );
        lb2.setBounds(nSize.getX(), nSize.getY() - 20, 300, 20 );
        lb3.setBounds(10, 310, 300, 20 );

        solution.setBounds(10, 330, 580, 200);


        add(button);
        add(button2);
        add(button3);
        add(mSize);
        add(lb1);
        add(nSize);
        add(lb2);
        add(lb3);
        add(solution);
        add(imageLabel);

        setLayout(null);
        setVisible(true);

        button.addActionListener(check);
        button2.addActionListener(check);
        button3.addActionListener(check);

    }


    private class Checked implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event) {
            if(event.getSource() == button) { // событие произошло у кнопки
                int n = Integer.parseInt(nSize.getText());
                int m = Integer.parseInt(mSize.getText());
                sample = new GaussMethod(m,n);
                tableModel = new DefaultTableModel(m,n+1);
                //System.out.println(m+"\n");
                table = new JTable(tableModel);
                table.setBorder(new LineBorder(new Color(41, 101, 222)));
                table.setSelectionBackground(Color.LIGHT_GRAY);
                table.setVisible(true);
                table.setBounds(10, 130, m*125, n*20);
                add(table);

            }
            if(event.getSource() == button2) {
                Double val = null;
                String str;
                for(int i = 0; i < Integer.parseInt(mSize.getText()); i++) {
                    for(int j = 0; j < Integer.parseInt(nSize.getText())+1; j++) {
                        str = table.getModel().getValueAt(i,j).toString();
                        //System.out.print("STR:" + str + "  ");
                        val = Double.valueOf(str);
                        //System.out.println("DOUBLE:" + val + "  ");
                        sample.set(i,j,val);
                        //System.out.print(table.getModel().getValueAt(i,j) + " ");
                    }
                    //System.out.println();
                }
                System.out.println(sample);
                sample.rightGaussianStroke();
                sample.backGaussianStroke();
                solution.setText(sample.answer());
                System.out.println(sample.answer());
            }
            if(event.getSource() == button3) {
                sample.saveToFile();

            }

            //JOptionPane.showMessageDialog(null, "ok");
        }
    }

}
