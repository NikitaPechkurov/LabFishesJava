package sample;

import model.Ball;
import model.PanelPaint;
import model.Producer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JTextField textField_device_name;
        JButton btn_testing_start;

        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PanelPaint panel = new PanelPaint(10,100);
        frame.add(panel);
        frame.setVisible(true);
        //frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        for (Ball b : panel.ball)    b.start();
        for (Producer p : panel.producers) p.start();
        System.out.println("Больше не нажимать!");

        /*frame.setBounds(100, 100, 700, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        textField_device_name = new JTextField();
        textField_device_name.setFont(new Font("Tahoma", Font.PLAIN, 24));
        textField_device_name.setBounds(12, 74, 408, 40);
        frame.getContentPane().add(textField_device_name);
        textField_device_name.setColumns(10);

        JLabel lbl_enter_device_name = new JLabel("Введите название устройства");
        lbl_enter_device_name.setFont(new Font("Times New Roman", Font.BOLD, 22));
        lbl_enter_device_name.setBounds(12, 28, 356, 33);
        frame.getContentPane().add(lbl_enter_device_name);

        PanelPaint panel = new PanelPaint();
        panel.setBounds(20,50,frame.getWidth(),frame.getHeight()-lbl_enter_device_name.getHeight()-textField_device_name.getHeight());
        frame.getContentPane().add(panel);

        btn_testing_start = new JButton("Start");
        btn_testing_start.setBounds(20,50,100,30);
        btn_testing_start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Ball b : panel.ball)    b.start();
                System.out.println("Больше не нажимать!");
            }
        });
        frame.getContentPane().add(btn_testing_start);
        frame.setVisible(true);*/
    }
}
