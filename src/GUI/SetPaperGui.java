package GUI;
import QuizClasses.QuestionSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import QuizClasses.*;

public class SetPaperGui extends javax.swing.JFrame{

    private Exam newexam;
    private QuestionSet qSet;
    private HashMap<String, String> options;
    private int qno;
    private String question, option1, option2, option3, option4, correctoption;
    private JPanel SetPaper;
    private JLabel jquestion;
    private JLabel jchoices;
    private JTextArea textArea;
    private JButton btnadd;
    private JButton btnSave;
    private JButton btnExit;
    private JPanel choicePanel;
    private JLabel crtLabel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JComboBox crctans;
    private JButton btnLogout;
    private JLabel option1Label;
    private JLabel option2Label;
    private JButton nextButton;
    private JLabel option3Label;
    private JLabel option4Label;
    private JLabel jusername;
    private JLabel jquesno;
    private JLabel jTitle;

    public SetPaperGui() {
        jusername.setText("Hello "+UserProfile.getUsername());
        qSet=new QuestionSet();
        options=new HashMap<>();
        options.put("option 1","answer1");
        options.put("option 2","answer2");
        options.put("option 3","answer3");
        options.put("option 4","answer4");

        qno=1;
        jquesno.setText(jquesno.getText()+qno);
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginGui f=new LoginGui();
                f.LoginFrame();
                //this.dispose();
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validateInput()==false)
                {
                    JOptionPane.showMessageDialog(null,"Please enter all the fields","ERROR!",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String optionName=options.get(correctoption);
                Question obj=new Question(newexam.getExamId(),newexam.getLanguage(),qno,question,option1,option2,option3,option4,optionName);
                qSet.addQuestion(obj);
                System.out.println(obj);
                System.out.println(optionName);
                clearAll();
                jTitle.setText((newexam.getTotalQuestions()-qno)+" Questions Remaining");
                qno++;
                if(qno>newexam.getTotalQuestions())
                {
                    disableAll();
                    JOptionPane.showMessageDialog(null,"Your questions has been prepared successfully!\nPress the done button to add them in our database","Exam Preparing Done!",JOptionPane.INFORMATION_MESSAGE);

                }
                else
                {
                    jquestion.setText("Question no: "+qno);
                }
            }
        });
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(qno<=newexam.getTotalQuestions())
                {
                    int x=newexam.getTotalQuestions()-qno+1;
                    JOptionPane.showMessageDialog(null,"Your still have "+x+"Questions remaining:","Please fill all Questions!",JOptionPane.ERROR_MESSAGE);
                    return ;
                }
                System.out.println("NO problem");
                /*try
                {
                    boolean done=ExamDAO.addExam(newexam);
                    if(done==false)
                    {
                        JOptionPane.showMessageDialog(null,"Exam not Added in the DB ","Try Again!",JOptionPane.ERROR_MESSAGE);

                        return;
                    }
                    QuestionDAO.addQuestions(qstore);

                    JOptionPane.showMessageDialog(null,"YOUR Question Have been successfullt added","Question Added!",JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(qSet);
                    TeacherGui f=new TeacherGui();
                    f.TeacherFrame(true);
                    //this.dispose();

                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,"Database Error!\nCannot fill the records Error","Error!",JOptionPane.INFORMATION_MESSAGE);
                    e.printStackTrace();
                }*/
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*SetPaperFrame f1=new SetPaperFrame();
                f1.setVisible(true);
                this.dispose();*/
            }
        });
    }
    public SetPaperGui(Exam exam)
    {
        this();
        newexam=exam;
        jTitle.setText(newexam.getTotalQuestions()+" :Question Remaining");
    }
    private void disableAll()
    {
        textArea.setText("");
        textArea.setEnabled(false);
        option1Label.setEnabled(false);
        option2Label.setEnabled(false);
        option3Label.setEnabled(false);
        option4Label.setEnabled(false);
        crctans.setEnabled(false);
        nextButton.setEnabled(false);
    }
    public void clearAll()
    {
        option1Label.setText("");
        option2Label.setText("");
        option3Label.setText("");
        option4Label.setText("");
        crctans.setSelectedIndex(0);
        textArea.requestFocus();

    }
    private boolean validateInput()
    {

        question=textArea.getText().trim();
        option1=option1Label.getText().trim();
        option2=option2Label.getText().trim();
        option3 =option3Label.getText().trim();
        option4=option4Label.getText().trim();
        System.out.println("getters");
        System.out.println(option1);
        System.out.println(option2);
        System.out.println(option3);
        System.out.println(option4);
        System.out.println(question);

        correctoption=crctans.getSelectedItem().toString();

        if(question.isEmpty()||option1.isEmpty()||option2.isEmpty()||option3.isEmpty()||option4.isEmpty()||correctoption.isEmpty())

            return false;

        return true;


    }
    public void SetPaperFrame() {
        JFrame frame = new JFrame("SetPaperGui");
        frame.setContentPane(new SetPaperGui().SetPaper);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(570,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        SetPaperGui set=new SetPaperGui();
        set.SetPaperFrame();
    }


}

