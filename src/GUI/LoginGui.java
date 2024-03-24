package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import QuizClasses.*;

public class LoginGui extends javax.swing.JFrame{
    String username;
    String password;
    private JPanel jPanel1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JTextField txtusername;
    private JPasswordField txtpassword;
    private JLabel jLabel4;
    private JRadioButton jrTeacher;
    private JRadioButton jrStudent;
    private JButton btnLogin;
    private JButton btnQuit;

    public LoginGui(){
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLoginActionPerformed(e);
            }
        });
    }
    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {
        int ans=JOptionPane.showConfirmDialog(null,"Are You Sure You Want to Quit?","Quitting",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(ans==JOptionPane.YES_OPTION)
        {
            JOptionPane.showMessageDialog(null,"Thank You ! "+UserProfile.getUsername().toUpperCase(),"Success",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt)
    {
        boolean isValidInput=validateInputs();
        if(isValidInput==false)
        {
            JOptionPane.showMessageDialog(null,"username or password cannnot be left blank!","Error!",JOptionPane.ERROR_MESSAGE);
            return;
        }
        String userType=getUserType();
        if(userType==null)
        {
            JOptionPane.showMessageDialog(null,"please select a usertype!","Error!" ,JOptionPane.ERROR_MESSAGE);
            return;
        }
        User user = new User();
        user.setUserId(username);
        user.setPassword(password);
        user.setUserType(userType);
        boolean isValidUser=readUser(username,password);
        if(isValidUser) {
            JOptionPane.showMessageDialog(null, "Login Accepted!", "Success", JOptionPane.INFORMATION_MESSAGE);
            UserProfile.setUsername(username);
            UserProfile.setUsertype(userType);
            if(userType.equalsIgnoreCase(jrTeacher.getText()))
            {
                TeacherGui tframe=new TeacherGui();
                tframe.TeacherFrame();
            }
            else
            {
                StudentGui studentframe=new StudentGui();
                studentframe.StudentFrame();
            }
            this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Invalid UserId/Password!","Error!",JOptionPane.ERROR_MESSAGE);
            return ;
        }
    }
    private boolean readUser(String username,String password)
    {
        if(getUserType().equals(jrTeacher.getText())) {
            int flag = 0, i = 0;
            BufferedReader reader;
            ArrayList<String> token = new ArrayList<String>(2);
            try {
                reader = new BufferedReader(new FileReader("Admin.txt"));
                String line = reader.readLine();
                while (line != null) {
                    StringTokenizer st = new StringTokenizer(line);
                    while (st.hasMoreTokens()) {
                        token.add(st.nextToken());
                    }
                    if (token.get(0).equals(username) && token.get(1).equals(password)) {
                        //System.out.print("Login successfully");
                        flag = 1;
                    } else {
                        flag = 0;
                        //System.out.print(" Login Unsuccessful");
                        token.clear();
                    }
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (flag == 1) {
                return true;
            }
        }
        else if(getUserType().equals(jrStudent.getText()))
        {
            int flag = 0, i = 0;
            BufferedReader reader;
            ArrayList<String> token = new ArrayList<String>(2);
            try {
                reader = new BufferedReader(new FileReader("Student.txt"));
                String line = reader.readLine();
                while (line != null) {
                    StringTokenizer st = new StringTokenizer(line);
                    while (st.hasMoreTokens()) {
                        token.add(st.nextToken());
                    }
                    if (token.get(0).equals(username) && token.get(1).equals(password)) {
                        //System.out.print("Login successfully");
                        flag = 1;
                    } else {
                        flag = 0;
                        //System.out.print(" Login Unsuccessful");
                        token.clear();
                    }
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (flag == 1) {
                return true;
            }
        }
        return false;
    }
    private boolean validateInputs()
    {
        username=txtusername.getText();
        char[] pwd=txtpassword.getPassword();
        if(username.isEmpty() || pwd.length==0)
            return false;
        password=String.valueOf(pwd);
        return true;
    }
    private String getUserType()
    {
        if(jrTeacher.isSelected())
        {
            //System.out.println(jrAdmin.getText());
            return jrTeacher.getText();
        }

        else if(jrStudent.isSelected())
            return jrStudent.getText();
        else
            return null;
    }
    public void LoginFrame()
    {
        JFrame frame = new JFrame("LOGIN");
        frame.setContentPane(new LoginGui().jPanel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(465,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        LoginGui g=new LoginGui();
        g.LoginFrame();
    }
}
