package com.kindless.webspider.dao.proxy;

import com.kindless.webspider.dao.BilibiliDAO;
import com.kindless.webspider.dao.Imp.BilibiliDAOImp;
import com.kindless.webspider.pojo.Bilibili;
import com.kindless.webspider.tools.DatabaseConnection;

import java.sql.SQLException;

public class BilibiliDAOProxy implements BilibiliDAO {
    private BilibiliDAO bilibiliDAO = null;
    private DatabaseConnection databaseConnection = null;

    public BilibiliDAOProxy() throws SQLException, ClassNotFoundException {
        databaseConnection = new DatabaseConnection();
        bilibiliDAO = new BilibiliDAOImp(databaseConnection.getConnection());
    }

    public Bilibili findByBV(String bv) throws SQLException {
        Bilibili bilibili = null;
        try {
            bilibili = bilibiliDAO.findByBV(bv);
        } catch (SQLException e) {
            throw e;
        } finally {
            DatabaseConnection.close(databaseConnection.getConnection());
        }

        return bilibili;
    }

    public boolean insert(Bilibili bilibili) throws SQLException {
        boolean flag = false;
        try {
            flag = bilibiliDAO.insert(bilibili);
        } catch (SQLException e) {
            throw e;
        } finally {
            DatabaseConnection.close(databaseConnection.getConnection());
        }
        return flag;
    }
}
