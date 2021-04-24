package com.wangjie.dao;

import com.wangjie.model.User;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql="delete from userdb where username=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.executeUpdate(sql);
        ResultSet rs=st.executeQuery();
        if(rs.next()) {
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql="update  usertable set username=? ";
        PreparedStatement st=con.prepareStatement(sql);
        st.executeUpdate(sql);
        ResultSet rs=st.executeQuery();
        if(rs.next()) {
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return 0;
    }
    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql="select username,password,email,gender,birthdate from userdb where username=? and password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs=  st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return null;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql="select username,password,email,gender,birthdate from userdb where username=? ";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,username);
        ResultSet rs=  st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return null;

    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql="select username,password,email,gender,birthdate from userdb where  password=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,password);
        ResultSet rs=  st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return null;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql="select username,password,email,gender,birthdate from userdb where email=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,email);
        ResultSet rs=  st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return null;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql="select username,password,email,gender,birthdate from userdb where gender=? ";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1,gender);
        ResultSet rs=  st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return null;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql="select username,password,email,gender,birthdate from userdb where birthdate=?";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(1, String.valueOf(birthDate));
        ResultSet rs=  st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return null;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql="select username,password,email,gender,birthdate from userdb ";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=  st.executeQuery();
        User user=null;
            user=new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        return null;
    }
}
