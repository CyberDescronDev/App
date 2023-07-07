import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThirdFrame {
    
    

    ThirdFrame(int roomNo){
        SecondFrame lbl = new SecondFrame();
        lbl.roomNo = roomNo;
        JFrame myFrame = new JFrame("Receipt");
        JLabel patient_id = new JLabel();
        JLabel social_security = new JLabel();
        JLabel first_name = new JLabel();
        JLabel last_name = new JLabel();
        JLabel roomNumber = new JLabel("Room No :");
        JLabel roomlbl = new JLabel();
        JLabel patient_idlbl = new JLabel("Patient ID :");
        JLabel social_securitylbl = new JLabel("Social Security NO :");
        JLabel first_namelbl = new JLabel("Firstname :");
        JLabel last_namelbl = new JLabel("LastName :");
        
        
        
        try {
                 String url = "jdbc:mysql://localhost:3306/patients";
                Connection conn = DriverManager.getConnection(url, "root", "root");
                Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                
                
                String query = "select * from patientinfo";
                ResultSet rs = st.executeQuery(query);
                rs.last();
                patient_id.setText(rs.getString("patient_id"));
                social_security.setText(rs.getString("social_security"));
                first_name.setText(rs.getString("first_name"));
                last_name.setText(rs.getString("last_name"));


                conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


        patient_idlbl.setBounds(50, 50, 200, 50);
        patient_idlbl.setFont(new Font("Monospaced", Font.BOLD, 25));

        social_securitylbl.setBounds(50, 150, 300, 50);
        social_securitylbl.setFont(new Font("Monospaced", Font.BOLD, 25));

        first_namelbl.setBounds(50, 250, 200, 50);
        first_namelbl.setFont(new Font("Monospaced", Font.BOLD, 25));

        last_namelbl.setBounds(50, 350, 200, 50);
        last_namelbl.setFont(new Font("Monospaced", Font.BOLD, 25));

        patient_id.setBounds(250, 50, 200, 50);
        patient_id.setFont(new Font("Monospaced", Font.BOLD, 25));

        social_security.setBounds(350, 150, 300, 50);
        social_security.setFont(new Font("Monospaced", Font.BOLD, 25));

        first_name.setBounds(250, 250, 200, 50);
        first_name.setFont(new Font("Monospaced", Font.BOLD, 25));

        last_name.setBounds(250, 350, 200, 50);
        last_name.setFont(new Font("Monospaced", Font.BOLD, 25));

        roomNumber.setBounds(50, 450, 200, 50);
        roomNumber.setFont(new Font("Monospaced", Font.BOLD, 25));

        roomlbl.setText(Integer.toString(lbl.roomNo));
        roomlbl.setBounds(250, 450, 200, 50);
        roomlbl.setFont(new Font("Monospaced", Font.BOLD, 25));

        


        myFrame.add(roomNumber);
        myFrame.add(roomlbl);
        myFrame.add(last_name);
        myFrame.add(first_name);
        myFrame.add(social_security);
        myFrame.add(patient_id);
        myFrame.add(last_namelbl);
        myFrame.add(first_namelbl);
        myFrame.add(social_securitylbl);
        myFrame.add(patient_idlbl);
        myFrame.setLayout(null);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(1000, 700);
        myFrame.setResizable(false);
        myFrame.setVisible(true);
    }
}
