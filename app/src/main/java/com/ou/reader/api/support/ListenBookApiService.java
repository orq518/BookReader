package com.ou.reader.api.support;

import com.ou.reader.bean.ListenBookDesBean;
import com.ou.reader.bean.ListenBook_ClassificationBean;
import com.ou.reader.bean.ListenBook_HomeBean;
import com.ou.reader.bean.ListenClassDetailBean;
import com.ou.reader.bean.ListenMainZTBean;
import com.ou.reader.bean.ListenRankingBean;
import com.ou.reader.bean.ListenRankingMoreBean;
import com.ou.reader.bean.ListenSearchBean;
import com.ou.reader.bean.ListenVoiceListBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ListenBookApiService {

    //首页
    //http://wellsoftteam.com/voice/main/getmaindata
    @GET("voice/main/getmaindata")
    Call<ListenBook_HomeBean> getListenHome();

    //分类
    //http://wellsoftteam.com/voice/main/getmainfldata
    @GET("voice/main/getmaindata")
    Call<ListenBook_ClassificationBean> getListenClassification();

    //分类详情 types=id
    //http://wellsoftteam.com/voice/list/voicetypepage?pageNum=1&title=&keyword=&types=4028818b451343a10145134427350001&ordercode=
    @GET("voice/list/voicetypepage")
    Call<ListenClassDetailBean> getListenClassDetail(@Query("pageNum") String pageNum,
                                                     @Query("title") String title,
                                                     @Query("keyword") String keyword,
                                                     @Query("types") String types,
                                                     @Query("ordercode") String ordercode);

    //各个排行 categoryindex=1 1：玄幻 2：武侠 .....
    //http://wellsoftteam.com/voice/main/getmainvoicedata?categoryindex=1
    @GET("voice/main/getmainvoicedata")
    Call<ListenRankingBean> getListenRanking(@Query("categoryindex") String categoryindex);

    //单个排行的更多   types=排行的id，上个接口返回
    //http://wellsoftteam.com/voice/list/voicetypepage?pageNum=1&title=&keyword=&types=4028818b451343a10145134427090000&ordercode=updatetime
    @GET("voice/list/voicetypepage")
    Call<ListenRankingMoreBean> getListenRankingMore(
            @Query("pageNum") String pageNum,
            @Query("title") String title,
            @Query("keyword") String keyword,
            @Query("types") String types,
            @Query("ordercode") String ordercode
    );

    //专题
    //http://wellsoftteam.com/voice/main/getmainztdata
    @GET("voice/main/getmainztdata")
    Call<ListenMainZTBean> getmainztdata();

    //专题列表   title=gcd    关键词首页接口返回
    //http://wellsoftteam.com/voice/list/voicesearchpage?pageNum=1&title=gcd
    @GET("voice/list/voicesearchpage")
    Call<ListenMainZTBean> getmainztdataList(@Query("pageNum") String pageNum,
                                             @Query("title") String title);


    //听书的搜索url
    //http://wellsoftteam.com/voice/list/voicesearchpage?pageNum=1&title=陈二狗
    @GET("voice/list/voicesearchpage")
    Call<ListenSearchBean> voicesearchpage(@Query("pageNum") String pageNum,
                                           @Query("title") String title);


    //typeid：id
    //userid：貌似可以乱写
    //书籍信息  包含作者、播音、集数、播放次数以及更新时间等
    //http://wellsoftteam.com/voice/list/voiceview?typeid=402881bc4af4061a014af40db9222f31&userid=00000000-7879-6bf6-c764-cf9f0033c587
    @GET("voice/list/voiceview")
    Call<ListenBookDesBean> getVoiceBookDes(@Query("typeid") String typeid,
                                            @Query("userid") String userid);

    //书籍的声音章节列表   包含总共几页、下载地址、播放地址
    //http://wellsoftteam.com/voice/list/voicepage?pageNum=1&typeid=402881bc4af4061a014af40db9222f31&userid=00000000-7879-6bf6-c764-cf9f0033c587
    @GET("voicepage")
    Call<ListenVoiceListBean> getVoicelist(@Query("pageNum") String pageNum,
                                           @Query("typeid") String typeid,
                                           @Query("userid") String userid);

}