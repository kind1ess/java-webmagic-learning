package com.kindless.webspider.dao;

import com.kindless.webspider.pojo.Bilibili;

import java.sql.SQLException;

public interface BilibiliDAO {
    public Bilibili findByBV(String bv) throws SQLException;
    public boolean insert(Bilibili bilibili) throws SQLException;
}
