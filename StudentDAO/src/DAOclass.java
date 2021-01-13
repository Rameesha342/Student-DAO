import java.sql.*;
public class DAOclass 
{
    Connection con=null;
    public void Connection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String constring="jdbc:mysql://localhost:3306/stdtbl";
            con=DriverManager.getConnection(constring,"root","");
        }
        catch (Exception ae)
        {
            System.out.println("Exception"+ae.getMessage());
        }
    }   
    //INSERT   
   public int insert(Student s)
    {
        int a=0;
        try
        {
            Connection();
            String qry="insert into stdtbl values(?,?,?)";
            PreparedStatement pst=con.prepareStatement(qry);
            pst.setInt(1,s.id);
            pst.setString(2,s.name);
            pst.setInt(3,s.age);
            a=pst.executeUpdate();
            
        }
        catch(Exception ae)
        {
            System.out.println(ae);
        }
        return a;
    }
    //END INSERT
    
    //UPDATE
    public int Update(Student s)
    {
        int a=0;
    
        try
        {
            Connection();
            String qry="Update stdtbl set std_name=?,std_age=? where std_id=?";
            PreparedStatement pst=con.prepareStatement(qry);
            pst.setString(1,s.name);
            pst.setInt(2,s.age);
            pst.setInt(3,s.id);
            a=pst.executeUpdate();
            
        }
        catch(Exception ae)
        {
            System.out.println("Error in Update Function");
        }
        return a;
    }
        //END UPDATE
        
        //DELETE
    public int Delete(Student s)
    {
        int a=0;
        try
        {
            Connection();
            String qry="Delete from stdtbl where std_id=?";
            PreparedStatement pst=con.prepareStatement(qry);
            pst.setInt(1,s.id);
            a=pst.executeUpdate();
            
        }
        catch(Exception ae)
        {
            System.out.println("Error in Delete Function");
        }
        return a;
    }
    //END DELETE
    
    //SELECT ALL
    public ResultSet SelectAll(Student s)
    {
        ResultSet rs=null;
        try
        {
            Connection();
            String qry="Select * from stdtbl";
            Statement st=con.createStatement();
            rs=st.executeQuery(qry);
        }
        catch(Exception ae)
        {
            System.out.println("Error in Select All Function");
        }
        return rs;
        //END SELECT ALL
     }
}
