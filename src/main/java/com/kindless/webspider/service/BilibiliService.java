package com.kindless.webspider.service;

import com.kindless.webspider.pojo.Bilibili;

public interface BilibiliService {


    public void save(Bilibili bilibili);
    public Bilibili findByBV(String bv);
    public boolean isExist(String bv);
}
