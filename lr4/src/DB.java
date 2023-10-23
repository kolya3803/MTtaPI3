import java.sql.*;

public class DB {
    private String dbUrl="jdbc:mysql://localhost:3306/mygame?useSSL=false";
    private String user = "root";
    private String password = "1111";
    private Connection con;

    public DB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con= DriverManager.getConnection(dbUrl,user,password);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void close() {
        try {
            con.close();
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    public boolean isUserExists(String username){
        try {
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT count(*) FROM mygame.users WHERE username='"+username+"';");
            while(rs.next()) {
                if (rs.getInt(1) == 1) return true;
                else return false;
            }
            stmt.close();
            rs.close();
        }catch(Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public boolean check_player(String username, String password){
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("Select Count(*) from mygame.users WHERE username='" + username + "'And password='" + password + "';");
            while (rs.next()) {
                if (rs.getInt(1) == 1) 
                    return true;
                else 
                    return false;
            }
            statement.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}