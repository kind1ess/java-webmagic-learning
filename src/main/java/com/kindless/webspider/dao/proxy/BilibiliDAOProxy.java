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
        return bilibiliDAO.findByBV(bv);
    }

    public boolean insert(Bilibili bilibili) throws SQLException {
        return bilibiliDAO.insert(bilibili);
    }
}
