package com.kindless.webspider.service.Imp;

import com.kindless.webspider.factory.DAOFactory;
import com.kindless.webspider.pojo.Bilibili;
import com.kindless.webspider.service.BilibiliService;
import com.kindless.webspider.tools.DatabaseConnection;

import java.sql.SQLException;

public class BilibiliServiceImp implements BilibiliService {
    public void save(Bilibili bilibili) {
        try {
            DAOFactory.getBiliBiliDAOInstance().insert(bilibili);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Bilibili findByBV(String userName) {
        Bilibili bilibili = null;
        try {
            bilibili = DAOFactory.getBiliBiliDAOInstance().findByBV(userName);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bilibili;
    }

    public boolean isExist(String userName) {
        return findByBV(userName) != null;
    }
}
