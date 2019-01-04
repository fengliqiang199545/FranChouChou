package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static java.sql.DriverManager.getConnection;

public class TestJDBC {

    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("test/db");

        //driver
        String driver = resourceBundle.getString("jdbc.driver");

        //ur;
        String url = resourceBundle.getString("jdbc.url");

        //username
        String username = resourceBundle.getString("jdbc.username");

        //password
        String password = resourceBundle.getString("jdbc.password");

        //加载数据库驱动
        try{
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("没有找到数据库驱动");
        }

        //测试，连接数据库
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("连接数据库成功");


        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }


    }

}
