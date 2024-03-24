package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import QuizClasses.*;

public class QuizType {
    private JPanel jPanel1;
    private JLabel jTitle;
    private JButton btnLogout;
    private JLabel Jlabel2;
    private JRadioButton MCQTESTRadioButton;
    private JRadioButton FILLINTHEBLANKSRadioButton;
    private JRadioButton TRUEFALSERadioButton;
    private JButton NEXTButton;
    private JButton btnBack;

    public QuizType() {
        jTitle.setText("Hello " + UserProfile.getUsername());
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TeacherGui f = new TeacherGui();
                f.setVisible(true);
                //this.dispose();
            }
        });
        NEXTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ans = 0;
                System.out.println(MCQTESTRadioButton.getText()+"sre");
                //String qType=ButtonGroup.getSelectedItem().toString();
                if (MCQTESTRadioButton.isSelected()) {
                    System.out.println(MCQTESTRadioButton.getText());
                    ans = JOptionPane.showConfirmDialog(null, "You have Selected  :" + MCQTESTRadioButton.getText() + "\nIs this ok?", "Confirm?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (ans == JOptionPane.YES_NO_OPTION) {
                    /*try
                    {
                        String examId=ExamDAO.getExamID();
                        Exam exam=new Exam(examId,subject,que);
                        EditPaper edit=new EditPaper(exam);
                        edit.setVisible(true);
                        this.dispose();

                    }catch(SQLException e)
                    {
                        JOptionPane.showMessageDialog(null,"DB error!","Set Paper Error!",JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                    }*/
                    }
                } else if (FILLINTHEBLANKSRadioButton.isSelected()) {
                    ans = JOptionPane.showConfirmDialog(null, "You have Selected  :" + FILLINTHEBLANKSRadioButton.getText() + "\nIs this ok?", "Confirm?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (ans == JOptionPane.YES_NO_OPTION) {
                    /*try
                    {
                        String examId=ExamDAO.getExamID();
                        Exam exam=new Exam(examId,subject,que);
                        EditPaper edit=new EditPaper(exam);
                        edit.setVisible(true);
                        this.dispose();

                    }catch(SQLException e)
                    {
                        JOptionPane.showMessageDialog(null,"DB error!","Set Paper Error!",JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                    }*/
                    }
                } else if (TRUEFALSERadioButton.isSelected()) {

                    ans = JOptionPane.showConfirmDialog(null, "You have Selected  :" + TRUEFALSERadioButton.getText() + "\nIs this ok?", "Confirm?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (ans == JOptionPane.YES_NO_OPTION) {
                    /*try
                    {
                        String examId=ExamDAO.getExamID();
                        Exam exam=new Exam(examId,subject,que);
                        EditPaper edit=new EditPaper(exam);
                        edit.setVisible(true);
                        this.dispose();

                    }catch(SQLException e)
                    {
                        JOptionPane.showMessageDialog(null,"DB error!","Set Paper Error!",JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                    }*/
                    }
                }
            }
        });


        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TeacherGui f = new TeacherGui();
                f.TeacherFrame();
                //this.dispose();
            }
        });


        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                LoginGui f = new LoginGui();
                f.LoginFrame();
                //this.dispose();
            }
        });
    }
    public void QuizTypeFrame()
    {
        JFrame frame = new JFrame("QuizType");
        frame.setContentPane(new QuizType().jPanel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(465,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
       QuizType qt=new QuizType();
       qt.QuizTypeFrame();
    }
}