package com.kindless.webspider.dao.Imp;

import com.kindless.webspider.dao.BilibiliDAO;
import com.kindless.webspider.pojo.Bilibili;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BilibiliDAOImp implements BilibiliDAO {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    public BilibiliDAOImp(Connection connection){
        this.connection = connection;
    }
    public Bilibili findByBV(String bv) throws SQLException {

        String sql = "select * from table_bilibili where BV=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,bv);
        ResultSet resultSet = null;
        resultSet = preparedStatement.executeQuery();
        Bilibili bilibili = null;
        while(resultSet.next()){
            bilibili = new Bilibili();
            bilibili.setBv(resultSet.getString(1));
            bilibili.setName(resultSet.getString(2));
            bilibili.setIntroduction(resultSet.getString(3));
        }
        return bilibili;
    }

    public boolean insert(Bilibili bilibili) throws SQLException{
        String sql = "insert into table_bilibili(BV,name,introduction) values(?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        if(preparedStatement.executeUpdate()>0){
            System.out.println("BV:"+bilibili.getBv()+"添加完成");
            return true;
        }
        System.out.println("BV:"+bilibili.getBv()+"添加失败");
        return false;
    }
}
