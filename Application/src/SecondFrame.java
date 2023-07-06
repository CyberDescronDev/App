
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class SecondFrame {


    
    
    SecondFrame(){
        JFrame myFrame = new JFrame("Department");
        JLabel label = new JLabel("Select Department");
        JButton btn = new JButton("Dental Department");
        JButton btn1 = new JButton("General Examination");
        JButton btn2 = new JButton("Urology");
        JLabel docs = new JLabel("Meet our Doctors");
        docs.setBounds(350, 275, 400, 50);
        docs.setFont(new Font("Monospaced", Font.BOLD, 25));

        JLabel lbl1 = new JLabel("-Doc Hakan");
        JLabel lbl2 = new JLabel("-Doc Simge Gezer");
        JLabel lbl3 = new JLabel("-Doc Oğuz Barış");

        JLabel lbl4 = new JLabel("-Doc Sebattin");
        JLabel lbl5 = new JLabel("-Doc Baattin");
        JLabel lbl6 = new JLabel("-Doc heheh");

        JLabel lbl7 = new JLabel("-Doc Nebahat");
        JLabel lbl8 = new JLabel("-Doc Gülsen");
        JLabel lbl9 = new JLabel("-Doc Kağan");

        lbl1.setBounds(90, 350, 200, 50);
        lbl1.setFont(new Font("Monospaced", Font.BOLD, 20));

        lbl2.setBounds(90, 450, 200, 50);
        lbl2.setFont(new Font("Monospaced", Font.BOLD, 20));

        lbl3.setBounds(90, 550, 200, 50);
        lbl3.setFont(new Font("Monospaced", Font.BOLD, 20));

        lbl4.setBounds(340, 350, 200, 50);
        lbl4.setFont(new Font("Monospaced", Font.BOLD, 20));

        lbl5.setBounds(340, 450, 200, 50);
        lbl5.setFont(new Font("Monospaced", Font.BOLD, 20));

        lbl6.setBounds(340, 550, 200, 50);
        lbl6.setFont(new Font("Monospaced", Font.BOLD, 20));

        lbl7.setBounds(630, 350, 200, 50);
        lbl7.setFont(new Font("Monospaced", Font.BOLD, 20));

        lbl8.setBounds(630, 450, 200, 50);
        lbl8.setFont(new Font("Monospaced", Font.BOLD, 20));

        lbl9.setBounds(630, 550, 200, 50);
        lbl9.setFont(new Font("Monospaced", Font.BOLD, 20));




        label.setBounds(350, 50, 300, 100);  
        label.setFont(new Font("Monospaced", Font.BOLD, 25));

        btn.setBounds(75, 150, 250, 100);
        btn.setFont(new Font("Monospaced", Font.BOLD, 20));

        btn1.setBounds(325, 150, 300, 100);
        btn1.setFont(new Font("Monospaced", Font.BOLD, 20));

        btn2.setBounds(625, 150, 250, 100);
        btn2.setFont(new Font("Monospaced", Font.BOLD, 20));


         btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                myFrame.setVisible(false);
            try {
                 String url = "jdbc:mysql://localhost:3306/patients";
                Connection conn = DriverManager.getConnection(url, "root", "root");
                Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                
                
                String query = "select * from patientinfo";
                ResultSet rs = st.executeQuery(query);
                rs.last();
                System.out.println("PAtient Id : "+rs.getString("patient_id"));
                conn.close();
            } catch (Exception ee) {
                System.out.println(ee.getMessage());
            }
                
                
            }
            
        });

         btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                myFrame.setVisible(false);
                
                
                
            }
            
        });

         btn2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                myFrame.setVisible(false);
                
            }
            
        });
        





        myFrame.add(lbl1);
        myFrame.add(lbl2);
        myFrame.add(lbl3);

        myFrame.add(lbl4);
        myFrame.add(lbl5);
        myFrame.add(lbl6);

        myFrame.add(lbl7);
        myFrame.add(lbl8);
        myFrame.add(lbl9);


        myFrame.add(docs);
        myFrame.add(btn);
        myFrame.add(btn2);
        myFrame.add(btn1);
        myFrame.add(label);
        myFrame.setLayout(null);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(1000, 700);
        myFrame.setResizable(false);
        myFrame.setVisible(true);
    }
}
