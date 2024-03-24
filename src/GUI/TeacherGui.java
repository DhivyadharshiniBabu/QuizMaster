package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeacherGui extends javax.swing.JFrame{
    private JPanel TeacherPanel;
    private JLabel JTeacher;
    private JRadioButton btnSetPpaer;
    private JRadioButton btnEditPpaer;
    private JRadioButton btnGrades;
    private JButton btnSelect;
    private JButton btnLogout;

    public TeacherGui() {
        btnSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(btnSetPpaer.isSelected()==true)
                {
                    SetPaperGui sf=new SetPaperGui();
                    sf.SetPaperFrame();
                    //this.dispose();
                }
                /*if(btnEditPpaer.isSelected()==true)
                {
                    PaperEditing p=new PaperEditing();
                    p.setVisible(true);
                    this.dispose();
                }
                if(btnGrades.isSelected()==true)
                {
                    ViewScores v=new ViewScores();
                    v.setVisible(true);
                    this.dispose();
                }*/
            }
        });
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginGui f=new LoginGui();
                f.setVisible(true);
                f.dispose();
            }
        });

    }
    public void TeacherFrame()
    {
        JFrame frame = new JFrame("TEACHER PANEL");
        frame.setContentPane(new TeacherGui().TeacherPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(465,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        /*JFrame frame = new JFrame("TEACHER PANEL");
        frame.setContentPane(new TeacherGui().TeacherPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(465,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);*/
    }
}
