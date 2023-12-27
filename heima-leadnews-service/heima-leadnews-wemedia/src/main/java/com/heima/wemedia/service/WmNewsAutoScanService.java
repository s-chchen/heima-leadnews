package com.heima.wemedia.service;

public interface WmNewsAutoScanService {


    /**
     * 自媒体文章审核
     * @param id 自媒体文章 id
     */
    public void autoScanWmNews(Integer id);


    /**
     * 消费延迟队列数据
     */
    public void scanNewsByTask();

}
