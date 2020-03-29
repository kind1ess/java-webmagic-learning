package com.kindless.webspider.service;

import com.kindless.webspider.pojo.Bilibili;

public interface BilibiliService {

    /**
     * 保存爬取的数据
     * @param bilibili
     */
    public void save(Bilibili bilibili);

    /**
     *
     * @param userName
     * @return Bilibili
     */
    public Bilibili findByBV(String userName);
    public boolean isExist(String userName);
}
