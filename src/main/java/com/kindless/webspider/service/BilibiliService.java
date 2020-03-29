package com.kindless.webspider.service;

import com.kindless.webspider.pojo.Bilibili;

public interface BilibiliService {

    /**
     * 保存爬取的数据
     * @param bilibili
     */
    public void save(Bilibili bilibili);

    /**
     * 根据作者名查找数据
     * @param userName
     * @return Bilibili
     */
    public Bilibili findByBV(String userName);

    /**
     * 判断数据是否存在
     * @param userName
     * @return boolean
     */
    public boolean isExist(String userName);
}
