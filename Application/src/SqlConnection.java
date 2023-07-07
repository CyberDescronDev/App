import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class SqlConnection extends Frame{
    
    public void register(String social_Security,String first_Name,String last_Name){
       
        this.socialSecurity = social_Security;
        this.firstName = first_Name;
        this.lastName = last_Name;

        try {
            String url = "jdbc:mysql://localhost:3306/patients";
            
        
            Connection conn = DriverManager.getConnection(url, "root", "root");
            Statement st = conn.createStatement();
          
            String SQL = String.format("INSERT INTO patientinfo (social_security,first_name,last_name) VALUES ('%s','%s','%s')",social_Security,first_Name,last_Name );
            
            st.executeUpdate(SQL);
           
            System.out.println("Updated Successfully");
            conn.close(); 
           
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        }
    }
}
