package com.kindless.webspider.task;

import com.kindless.webspider.pojo.Bilibili;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;

import us.codecraft.webmagic.processor.PageProcessor;

import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

public class BilibiliProcessor implements PageProcessor {

    private String url = "https://search.bilibili.com/all?keyword=%E7%BD%97%E7%BF%94&from_source=nav_search_new";

    private Bilibili bilibili = new Bilibili();
    public void process(Page page) {
        String html = page.getHtml().toString();
        List<Selectable> list = page.getHtml().css("div.mixin-list ul li.video-item a.title").nodes();
        if (list.size()==0){
            this.saveBilibili(page);
        }
        else {
            for(Selectable selectable:list) {
                String videoUrl = selectable.links().toString();
                page.addTargetRequest(videoUrl);
            }
        }
    }

    public void saveBilibili(Page page){
        Bilibili bilibili = new Bilibili();
        Html html = page.getHtml();
        String timeString = html.css("div.video-data span","text").nodes().get(1).toString();
        String userNameString = html.css("div.name a.username","text").toString();
        String userName = userNameString+" "+timeString;
        String title = html.css("span.tit","text").toString();
        String introduction = html.css("div.info","text").nodes().get(0).toString();
        bilibili.setUserName(userName);
        bilibili.setTitle(title);
        bilibili.setIntroduction(introduction);
        page.putField("bilibili",bilibili);
    }
    private Site site = Site.me()
            .setCharset("UTF-8")//设置编码，防止中文显示乱码
            .setRetrySleepTime(1000)//设置重试间隔时间
            .setRetryTimes(3)//设置重试次数
            .setTimeOut(10000);//设置超时时间
    public Site getSite() {
        return site;
    }
}
