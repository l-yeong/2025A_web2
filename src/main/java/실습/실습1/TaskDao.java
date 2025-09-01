package 실습.실습1;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class TaskDao {
    private String db_url = "jdbc:mysql://localhost:3306/springweb2";
    private String db_user = "root";
    private String db_pwd = "1234";

    public Connection conn;

    public TaskDao() {
        connect();
    }

    private void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, db_user, db_pwd);
            System.out.println("Dao.connect");
        } catch (Exception e) {
            System.out.println(e);
        }//catch end
    }//func end

    public void productCount(){
        try{
            String sql = "update products set stock_quantity = stock_quantity -3;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {System.out.println(e);}//catch end
    }

    public List<Map<String, String>> productPrint() {
        List<Map<String, String>> list = new ArrayList<>();
        try {
            String sql = "SELECT *FROM products;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Map<String, String> map = new HashMap<>();
                map.put("id", rs.getString("product_id"));
                map.put("name", rs.getString("product_name"));
                map.put("stock", rs.getString("stock_quantity"));
                list.add(map);
            }//while end
        } catch (Exception e) {System.out.println(e);}//catch end
        return list;
    }//func end

    public void productCountTwo(){
        try{
            String sql = "update products set stock_quantity = stock_quantity +20 where stock_quantity = stock_quantity <=10 ;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {System.out.println(e);}//catch end
    }
}//class end
