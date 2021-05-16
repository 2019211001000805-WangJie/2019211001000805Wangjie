package com.wangjie.dao;

import com.wangjie.model.Product;

import java.io.InputStream;
import java.sql.*;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            pt.setBinaryStream(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryId());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }
    @Override
    public int delete(Integer productId, Connection con) {
        String sql = "delete from product where productId='productId'" ;
        PreparedStatement pt = null;
        try {
            pt = con.prepareStatement(sql);
            pt.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    @Override
    public int update(Product instance, Connection con) {
        String sql="update  product set productName='"+instance.getProductName()+"',productDescription='"+instance.getProductDescription()+"'," +
                "picture='"+instance.getPicture()+"',price='"+instance.getPrice()+"',categoryId="+instance.getCategoryId();
        PreparedStatement pt= null;
        try {
            pt = con.prepareStatement(sql);
            pt.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public Product findById(Integer productId, Connection con) {
        String sql = "select * from product where productId=?";
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(sql);
            st.setInt(1, productId);
            ResultSet rs = st.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();}
            Product product = null;
            ResultSet rs = null;
            try {
                rs = st.executeQuery();
                if (rs.next()) {
                    product.setProductId(rs.getInt("productId"));
                    product.setProductName(rs.getString("productName"));
                    product.setProductDescription(rs.getString("productDescription"));
                    product.setPicture(rs.getAsciiStream("picture"));
                    product.setPrice(rs.getDouble("price"));
                    product.setCategoryId(rs.getInt("categoryId"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return product;
        }
    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) {
        return null;
    }



    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {

        return null;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        return null;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        return null;
    }
}
