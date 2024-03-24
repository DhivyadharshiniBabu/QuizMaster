package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGui extends javax.swing.JFrame{
    private JPanel Studentpanel;
    private JRadioButton btnTakeTest;
    private JRadioButton btnScores;
    private JButton btnSelect;
    private JButton btnLogout;

    public StudentGui() {
        btnSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!validateInput())
                {
                    JOptionPane.showMessageDialog(null,"Please select an option ","Error!",JOptionPane.ERROR_MESSAGE);
                    return;
                }

                /*if(btnTakeTest.isSelected())
                {
                    ChooseTest s=new ChooseTest();
                    s.setVisible(true);
                    this.dispose();
                }
                else if(btnScoresn.isSelected())
                {
                    ViewScores v=new ViewScores();
                    v.setVisible(true);
                    this.dispose();
                }*/
            }
        });
    }
    private boolean validateInput()
    {
        if(btnTakeTest.isSelected()==false && btnScores.isSelected()==false )
        {
            return false;
        }
        return true;
    }
    public void StudentFrame()
    {
        JFrame frame = new JFrame("StudentGui");
        frame.setContentPane(new StudentGui().Studentpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(465,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {

    }
}
