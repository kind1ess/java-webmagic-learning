package com.kindless.webspider.task;

import com.kindless.webspider.pojo.Bilibili;
import com.kindless.webspider.service.BilibiliService;
import com.kindless.webspider.service.Imp.BilibiliServiceImp;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class BilibiliPipeline implements Pipeline {

    public void process(ResultItems resultItems, Task task) {
        Bilibili bilibili = resultItems.get("bilibili");

        BilibiliService bilibiliService = new BilibiliServiceImp();
        if(!bilibiliService.isExist(bilibili.getUserName())){
            bilibiliService.save(bilibili);
        }
    }
}
