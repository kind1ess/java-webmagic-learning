package com.kindless.webspider.factory;

import com.kindless.webspider.dao.BilibiliDAO;
import com.kindless.webspider.dao.proxy.BilibiliDAOProxy;

import java.sql.SQLException;

public class DAOFactory {
    public static BilibiliDAO getBiliBiliDAOInstance() throws SQLException, ClassNotFoundException {
        return new BilibiliDAOProxy();
    }
}
