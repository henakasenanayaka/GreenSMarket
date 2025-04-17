package com.servlets;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserDBUtil {
    
    private static String url = "jdbc:mysql://localhost:3306/green";
    private static String user = "root";
    private static String pass = "";
    private static boolean isSuccess=false;
    
    
    public static boolean login(String email, String password){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "Select * from user where email='"+email+"' and pass='"+password+"'";
            ResultSet rs = stmt.executeQuery(sql);
                
            if(rs.next()){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
            return isSuccess;
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        return isSuccess;
    }
    
    public static int getId(String email, String password){
        int userId = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "Select u_id from user where email='"+email+"' and pass='"+password+"'";
            ResultSet rs = stmt.executeQuery(sql);
                
            if(rs.next()){
                userId = rs.getInt("u_id");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return userId;
    }
    
    public static boolean signup(String fname, String lname, String email, String password, String add, String phone){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "insert into user values(0,'"+fname+"','"+lname+"','"+email+"','"+password+"','"+add+"','"+phone+"')";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static List<Map<String, String>> userDetails(String email) {
        List<Map<String, String>> userDetails = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "select * from user where email='" + email + "'";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                Map<String, String> userMap = new HashMap<>();
                userMap.put("id", rs.getString(1));
                userMap.put("fName", rs.getString(2));
                userMap.put("lName", rs.getString(3));
                userMap.put("email", rs.getString(4));
                userMap.put("password", rs.getString(5));
                userMap.put("add", rs.getString(6));
                userMap.put("mobile", rs.getString(7));

                userDetails.add(userMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userDetails;
    }
    
    public static List<Map<String, String>> categorySet() {
        List<Map<String, String>> categories = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "select category_name,category_image from category";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> categoryMap = new HashMap<>();
                categoryMap.put("category_name", rs.getString(1));
                categoryMap.put("image", rs.getString(2));
                categories.add(categoryMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categories;
    }
    
    public static List<Map<String, String>> getProductList(String  category_name) {
        List<Map<String, String>> productList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "SELECT a.p_id, a.pName, a.image, a.price FROM product a INNER JOIN category b ON a.c_id = b.c_id WHERE b.category_name = '"+category_name+"'";
            PreparedStatement pstmt = con.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Map<String, String> productMap = new HashMap<>();
                productMap.put("id", rs.getString("a.p_id"));
                productMap.put("pName", rs.getString("a.pName"));
                productMap.put("image", rs.getString("a.image"));
                productMap.put("price", rs.getString("a.price"));

                productList.add(productMap);
            }

            // Close resources...

        } catch (Exception e) {
            e.printStackTrace();
        }

        return productList;
    }
    
    public static boolean userupdate(int id, String fname, String lname, String email, String password, String add,int mobile){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "update user set fName='"+fname+"', lName='"+lname+"', email='"+email+"', pass='"+password+"', address='"+add+"', pNo='"+mobile+"' where u_id='"+id+"'";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }else{
                isSuccess = false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static List<Map<String, String>> updateduserDetails(int id) {
        List<Map<String, String>> updateduserDetails = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "select * from user where u_id='" + id + "'";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                Map<String, String> userMap = new HashMap<>();
                userMap.put("id", rs.getString(1));
                userMap.put("fName", rs.getString(2));
                userMap.put("lName", rs.getString(3));
                userMap.put("email", rs.getString(4));
                userMap.put("password", rs.getString(5));
                userMap.put("add", rs.getString(6));
                userMap.put("mobile", rs.getString(7));

                updateduserDetails.add(userMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return updateduserDetails;
    }
    
    public static boolean cartadd(int u_id, int p_id){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "insert into cart (p_id,date,u_id,quantity,status) values ('"+p_id+"',CURRENT_TIMESTAMP(),'"+u_id+"',1,'YES')";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }else{
                isSuccess = false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static boolean allredyaddedtocart(int u_id, int p_id){
            try{Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "select u_id,p_id from cart where u_id='"+u_id+"' and p_id='"+p_id+"'";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
                isSuccess = true;
            }else{
                isSuccess = false;
            }
            
            }catch(Exception e){
                e.printStackTrace();
            }
            return isSuccess;
    }
    
    public static List<Map<String, String>> getcart(int u_id){
        List<Map<String, String>> mycart = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "select b.image,b.pName,b.price,a.quantity,a.date,b.p_id from cart a inner join product b on a.p_id=b.p_id where u_id='"+u_id+"'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> cartMap = new HashMap<>();
                cartMap.put("im", rs.getString(1));
                cartMap.put("pn", rs.getString(2));
                cartMap.put("pr", rs.getString(3));
                cartMap.put("qu", rs.getString(4));
                cartMap.put("da", rs.getString(5));
                cartMap.put("productId", rs.getString(6));
                mycart.add(cartMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mycart;
    }
    
    public static boolean contactus(int id, String message){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "insert into usermsg (u_id,u_msg) values ('"+id+"','"+message+"')";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }else{
                isSuccess = false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static boolean updatequantity(int u_id, int p_id, int quantity){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "update cart set quantity='"+quantity+"' where u_id='"+u_id+"' and p_id='"+p_id+"'";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }else{
                isSuccess = false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static boolean isaddedorderdet(int u_id){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM orderdet WHERE orderStatus='Added' AND u_id='"+u_id+"'";
            ResultSet rs = stmt.executeQuery(sql);
                
            if(rs.next()){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
            return isSuccess;
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static boolean addorderdet(double total, int u_id){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "insert into orderdet values(0,CURRENT_DATE,'"+total+"','Added','"+u_id+"')";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static int getorderdetid(int u_id){
        int orderId = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "select o_id from orderdet where u_id='"+u_id+"' AND orderstatus='Added'";
            ResultSet rs = stmt.executeQuery(sql);
                
            if(rs.next()){
                orderId = rs.getInt("o_id");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return orderId;
    }
    
    public static boolean addtoorderproduct(int u_id,int o_id){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "INSERT INTO orderproduct (o_id, p_id, quantity) SELECT '"+o_id+"', a.p_id, a.quantity FROM cart a INNER JOIN product b ON a.p_id = b.p_id WHERE a.u_id ='"+u_id+"'";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static boolean deletecartdet(int u_id){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "DELETE FROM cart WHERE u_id ='"+u_id+"'";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static boolean deletecartpro(int u_id, int p_id){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "DELETE FROM cart WHERE p_id ='"+p_id+"' AND u_id='"+u_id+"'";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static List<Map<String, String>> getorder(int u_id){
        List<Map<String, String>> mycart = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "select b.date,c.pName,a.quantity,c.price*a.quantity from orderproduct a inner join orderdet b on a.o_id=b.o_id inner join product c on a.p_id=c.p_id where b.u_id='"+u_id+"' AND b.orderstatus='Added'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> cartMap = new HashMap<>();
                cartMap.put("date", rs.getString(1));
                cartMap.put("pname", rs.getString(2));
                cartMap.put("quantity", rs.getString(3));
                cartMap.put("total", rs.getString(4));
                mycart.add(cartMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mycart;
    }
    
    public static boolean orderset(int u_id){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "UPDATE orderdet SET orderStatus = 'Processing' WHERE u_id='"+u_id+"' AND orderStatus = 'Added'";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static boolean orderdel(int o_id){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "DELETE orderdet, orderproduct FROM orderdet JOIN orderproduct ON orderdet.o_id = orderproduct.o_id WHERE orderdet.o_id ='"+o_id+"' AND orderdet.orderStatus='Added'";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static List<Map<String, String>> getorderdet(int u_id){
        List<Map<String, String>> myorder = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "select * from orderdet where u_id='"+u_id+"'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> orderMap = new HashMap<>();
                orderMap.put("o_id", rs.getString(1));
                orderMap.put("date", rs.getString(2));
                orderMap.put("total", rs.getString(3));
                orderMap.put("orderstatus", rs.getString(4));
                myorder.add(orderMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myorder;        
    }
    
    public static List<Map<String, String>> orderlistproducts(int u_id, int o_id){
        List<Map<String, String>> myorderlist = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "select b.pName,a.quantity,b.price from orderproduct a inner join product b on a.p_id=b.p_id inner join orderdet c on c.o_id=a.o_id where c.u_id='"+u_id+"' AND a.o_id='"+o_id+"'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> orderproMap = new HashMap<>();
                orderproMap.put("pname", rs.getString(1));
                orderproMap.put("quantity", rs.getString(2));
                orderproMap.put("price", rs.getString(3));
                myorderlist.add(orderproMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myorderlist;        
    }
    
    public static List<Map<String, String>> adminshoworder(){
        List<Map<String, String>> adminshoworder = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "select * from orderdet";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> adminorderMap = new HashMap<>();
                adminorderMap.put("o_id", rs.getString(1));
                adminorderMap.put("date", rs.getString(2));
                adminorderMap.put("total", rs.getString(3));
                adminorderMap.put("status", rs.getString(4));
                adminshoworder.add(adminorderMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminshoworder;  
    }
    
    public static boolean adminlogin(String email, String password){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "Select * from admin where a_email='"+email+"' and a_pass='"+password+"'";
            ResultSet rs = stmt.executeQuery(sql);
                
            if(rs.next()){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
            return isSuccess;
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        return isSuccess;
    }
    
    public static boolean checkadmin(String email){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "Select * from admin where a_email='"+email+"'";
            ResultSet rs = stmt.executeQuery(sql);
                
            if(rs.next()){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
            return isSuccess;
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        return isSuccess;
    }
    
    public static List<Map<String, String>> adminorderprolist(int o_id){
        List<Map<String, String>> adminorderlist = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "select b.pName,a.quantity,b.price from orderproduct a inner join product b on a.p_id=b.p_id inner join orderdet c on c.o_id=a.o_id where a.o_id='"+o_id+"'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> adminorderproMap = new HashMap<>();
                adminorderproMap.put("pname", rs.getString(1));
                adminorderproMap.put("quantity", rs.getString(2));
                adminorderproMap.put("price", rs.getString(3));
                adminorderlist.add(adminorderproMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminorderlist;        
    }
    
    public static boolean adminorderupdate(String msg, int o_id){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "UPDATE orderdet SET orderStatus = '"+msg+"' WHERE o_id='"+o_id+"'";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static List<Map<String, String>> adminorderuserlist(int o_id){
        List<Map<String, String>> adminorderuserlist = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "select b.fName,b.lName,b.email,b.address,b.pNo from orderdet a inner join user b on a.u_id=b.u_id where o_id ='"+o_id+"'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> adminorderproMap = new HashMap<>();
                adminorderproMap.put("fname", rs.getString(1));
                adminorderproMap.put("lname", rs.getString(2));
                adminorderproMap.put("email", rs.getString(3));
                adminorderproMap.put("address", rs.getString(4));
                adminorderproMap.put("phone", rs.getString(5));
                adminorderuserlist.add(adminorderproMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminorderuserlist;        
    }
    
    public static List<Map<String, String>> adminsms(){
        List<Map<String, String>> adminmsg = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "select a.msg_id,b.fName,b.lName,b.email,a.u_msg from usermsg a inner join user b on a.u_id=b.u_id";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> adminmsgMap = new HashMap<>();
                adminmsgMap.put("msg_id", rs.getString(1));
                adminmsgMap.put("fname", rs.getString(2));
                adminmsgMap.put("lname", rs.getString(3));
                adminmsgMap.put("email", rs.getString(4));
                adminmsgMap.put("msg", rs.getString(5));
                adminmsg.add(adminmsgMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminmsg;        
    }
    
    public static boolean adminsmsdel(int m_id){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "delete from usermsg where msg_id='"+m_id+"'";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static List<Map<String, String>> admingetusers(){
        List<Map<String, String>> adminugetuser = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "select * from user";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> adminuserMap = new HashMap<>();
                adminuserMap.put("u_id", rs.getString(1));
                adminuserMap.put("fname", rs.getString(2));
                adminuserMap.put("lname", rs.getString(3));
                adminuserMap.put("email", rs.getString(4));
                adminuserMap.put("pass", rs.getString(5));
                adminuserMap.put("add", rs.getString(6));
                adminuserMap.put("phone", rs.getString(7));
                adminugetuser.add(adminuserMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminugetuser;
    }
    
    public static List<Map<String, String>> adminuseredit(int u_id){
        List<Map<String, String>> adminuseredit = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "select * from user where u_id = '"+u_id+"'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> adminuMap = new HashMap<>();
                adminuMap.put("u_id", rs.getString(1));
                adminuMap.put("fname", rs.getString(2));
                adminuMap.put("lname", rs.getString(3));
                adminuMap.put("email", rs.getString(4));
                adminuMap.put("pass", rs.getString(5));
                adminuMap.put("add", rs.getString(6));
                adminuMap.put("phone", rs.getString(7));
                adminuseredit.add(adminuMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminuseredit;
    }
    
    public static List<Map<String, String>> admingetadmins(){
        List<Map<String, String>> admingetadmins = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "select * from admin";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> adminadminMap = new HashMap<>();
                adminadminMap.put("a_id", rs.getString(1));
                adminadminMap.put("email", rs.getString(2));
                adminadminMap.put("pass", rs.getString(3));
                admingetadmins.add(adminadminMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admingetadmins;
    }
    
    public static List<Map<String, String>> adminadminedit(int a_id){
        List<Map<String, String>> adminadminedit = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "select * from admin where a_id = '"+a_id+"'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> adminaMap = new HashMap<>();
                adminaMap.put("a_id", rs.getString(1));
                adminaMap.put("email", rs.getString(2));
                adminaMap.put("pass", rs.getString(3));
                adminadminedit.add(adminaMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminadminedit;
    }
    
    public static boolean adminuserupdate(int id, String email, String password){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "update admin set a_email='"+email+"', a_pass='"+password+"' where a_id='"+id+"'";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }else{
                isSuccess = false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static boolean addadmin(String email, String password){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "insert into admin(a_email,a_pass) values('"+email+"','"+password+"')";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }else{
                isSuccess = false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static boolean admindel(int a_id){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "delete from admin where a_id='"+a_id+"'";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static List<Map<String, String>> adminpro(){
        List<Map<String, String>> adminpro = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "select a.p_id,a.image,a.pName,a.stock,a.price,a.availability,b.category_name from product a inner join category b on a.c_id=b.c_id";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> adminproMap = new HashMap<>();
                adminproMap.put("id", rs.getString(1));
                adminproMap.put("img", rs.getString(2));
                adminproMap.put("name", rs.getString(3));
                adminproMap.put("stock", rs.getString(4));
                adminproMap.put("price", rs.getString(5));
                adminproMap.put("availability", rs.getString(6));
                adminproMap.put("c_name", rs.getString(7));
                adminpro.add(adminproMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminpro;
    }
    
    public static List<Map<String, String>> adminproedit(int p_id){
        List<Map<String, String>> adminproedit = new ArrayList<>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "select a.p_id,a.image,a.pName,a.stock,a.price,a.availability,b.category_name from product a inner join category b on a.c_id=b.c_id where a.p_id = '"+p_id+"'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> adminproeditMap = new HashMap<>();
                adminproeditMap.put("id", rs.getString(1));
                adminproeditMap.put("img", rs.getString(2));
                adminproeditMap.put("name", rs.getString(3));
                adminproeditMap.put("stock", rs.getString(4));
                adminproeditMap.put("price", rs.getString(5));
                adminproeditMap.put("availability", rs.getString(6));
                adminproeditMap.put("c_name", rs.getString(7));
                adminproedit.add(adminproeditMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminproedit;
    }
    
    public static boolean adminupdatepro(int p_id, String img, String name, int stock, int price, String availability){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "update product set image='"+img+"', pName='"+name+"', stock='"+stock+"', price='"+price+"', availability='"+availability+"' where p_id='"+p_id+"'";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }else{
                isSuccess = false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static boolean adminprodel(int p_id){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "delete from product where p_id='"+p_id+"'";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static List<Map<String, String>> adminprocategory() {
        List<Map<String, String>> categories = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "select c_id,category_name from category";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> categoryMap = new HashMap<>();
                categoryMap.put("c_id", rs.getString(1));
                categoryMap.put("c_name", rs.getString(2));
                categories.add(categoryMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categories;
    }
    
    public static boolean adminsavepro(int c_id,String pname,String img,int stock,int price,String availability){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "insert into product (c_id,pName,image,stock,price,availability) values ('"+c_id+"','"+pname+"','"+img+"','"+stock+"','"+price+"','"+availability+"')";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static List<Map<String, String>> admincategorySet() {
        List<Map<String, String>> categories = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "select * from category";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> categoryMap = new HashMap<>();
                categoryMap.put("id", rs.getString(1));
                categoryMap.put("name", rs.getString(2));
                categoryMap.put("image", rs.getString(3));
                categories.add(categoryMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categories;
    }
    
    public static List<Map<String, String>> admincategoryedit(int c_id) {
        List<Map<String, String>> categories = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "select * from category where c_id='"+c_id+"'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> categoryMap = new HashMap<>();
                categoryMap.put("id", rs.getString(1));
                categoryMap.put("name", rs.getString(2));
                categoryMap.put("image", rs.getString(3));
                categories.add(categoryMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categories;
    }
    
    public static boolean admincategoryeditcheck(int c_id, String name, String image){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "update category set category_name='"+name+"', category_image='"+image+"' where c_id='"+c_id+"'";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }else{
                isSuccess = false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static boolean admincatdel(int c_id){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "delete from category where c_id='"+c_id+"'";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static String getemailbyoid(int o_id){
        String email = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "select b.email from orderdet a inner join user b on a.u_id=b.u_id where o_id='"+o_id+"'";
            ResultSet rs = stmt.executeQuery(sql);
                
            if(rs.next()){
                email = rs.getString("b.email");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return email;
    }
    
    public static boolean adminaddcat(String cname, String img){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement stmt = con.createStatement();
            String sql = "insert into category values (0,'"+cname+"','"+img+"')";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }else{
                isSuccess = false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
//    public static boolean stockmanagement(){
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection(url, user, pass);
//            Statement stmt = con.createStatement();
//            String sql = "UPDATE product SET stock = stock - ( SELECT SUM(quantity) FROM orderproduct WHERE product.p_id = orderproduct.p_id ) WHERE p_id IN ( SELECT DISTINCT p_id FROM orderproduct );";
//            int rs = stmt.executeUpdate(sql);
//            
//            if(rs > 0){
//                isSuccess = true;
//            }else{
//                isSuccess = false;
//            }
//            
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return isSuccess;
//    }
    
    
}
