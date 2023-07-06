import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Frame{
    public String socialSecurity;
    public String firstName;
    public String lastName;
    
    Frame(){

        JFrame myframe = new JFrame("Registration"); // frame
        JLabel label = new JLabel("Enter your 11 digit social security number"); // Label for social security
        JLabel label1 = new JLabel("Social Security Number :"); // Label for 2nd social security
        JLabel fname = new JLabel("First Name :"); // Label for first name
        JLabel lname = new JLabel("Last Name :"); // Label for last name
        JTextField textField = new JTextField(); // Textfield for social security
        JTextField textField1 = new JTextField(); // textfield for fname
        JTextField textField2 = new JTextField(); // textfield for lname
        JButton btn = new JButton("Register"); // button for register



        label.setBounds(165, 50, 800, 100);  // social security attributes
        label.setFont(new Font("Monospaced", Font.BOLD, 25));

        label1.setBounds(200, 200, 350, 50); // 2nd social security attributes
        label1.setFont(new Font("Monospaced",Font.BOLD,18));
        
        textField.setBounds(475, 205, 250, 40); // attributes for textfield
        textField.setFont(new Font("Monospaced",Font.BOLD,18));
        
        fname.setBounds(200, 300, 350, 50); // attributes for fname
        fname.setFont(new Font("Monospaced",Font.BOLD,18));

        lname.setBounds(200, 400, 350, 50); // attributes for lname
        lname.setFont(new Font("Monospaced",Font.BOLD,18));        

        textField1.setBounds(475, 305, 250, 40); // attributes for textfield fname
        textField1.setFont(new Font("Monospaced",Font.BOLD,18));

        textField2.setBounds(475, 405, 250, 40); // attributes for textfield lname
        textField2.setFont(new Font("Monospaced",Font.BOLD,18));

        btn.setBounds(420, 500, 150, 75); // register button attributes
        btn.setFont(new Font("Monospaced",Font.BOLD,17));
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SqlConnection con = new SqlConnection();
                socialSecurity = textField.getText();
                try {
                    if(socialSecurity.length()!= 11){
                    System.err.println("Please provide 11 digit social security number");
                    return;
                    }
                } catch (Exception ee) {
                    System.out.println(ee.getMessage());
                }
                firstName = textField1.getText();
                lastName = textField2.getText();
                con.register(socialSecurity, firstName, lastName);
                //myframe.dispatchEvent(new WindowEvent(myframe, WindowEvent.WINDOW_CLOSING));
                myframe.setVisible(false);
                new SecondFrame();
            }
            
        });





        myframe.add(textField1);
        myframe.add(textField2);
        myframe.add(fname);
        myframe.add(lname);
        myframe.add(btn);
        myframe.add(label1);
        myframe.add(textField);
        myframe.add(label); 
        myframe.setLayout(null);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setSize(1000, 700);
        myframe.setResizable(false);
        myframe.setVisible(true);
        
    }
}
