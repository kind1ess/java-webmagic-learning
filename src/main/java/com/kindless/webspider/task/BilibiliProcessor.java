package com.kindless.webspider.task;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;

public class BilibiliProcessor implements PageProcessor {

    private Pipeline pipeline = new BilibiliPipeline();

    public void process(Page page) {

    }

    public Site getSite() {
        return null;
    }
}
