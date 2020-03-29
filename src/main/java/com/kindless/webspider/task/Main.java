package com.kindless.webspider.task;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;

public class Main {
    public static void main(String[] args) {
        Spider.create(new BilibiliProcessor())
                .addUrl("https://search.bilibili.com/all?keyword=%E8%8B%B1%E9%9B%84%E8%81%94%E7%9B%9F&from_source=nav_search_new")
                .setScheduler(new QueueScheduler().setDuplicateRemover(new BloomFilterDuplicateRemover(100000)))
                .thread(100)
                .addPipeline(new BilibiliPipeline())
                .run();
    }
}
