package com.github.excellent.dao;

import com.github.excellent.po.User;
import com.github.excellent.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther plg
 * @date 2019/8/12 9:03
 */
public class UserDao {
    private Connection connection = null;
    public UserDao(){
        connection = JDBCUtils.getConnection();
    }

    public List<User> queryuser(){
        ResultSet set = null;
        List<User> list = new ArrayList<>();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("select * from user ");
            set = statement.executeQuery();
            while(set.next()){
                User user = new User();
                Integer id = set.getInt("id");
                String username = set.getString("username");
                String address = set.getString("address");
                user.setId(id);
                user.setUsername(username);
                user.setAddress(address);
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(connection,statement,set);
        }
        return null;
    }

    public static void main(String[] args) {
        UserDao dao = new UserDao();
        List<User> list = dao.queryuser();
        for(User user : list){
            System.out.println(user);
        }
    }
}
