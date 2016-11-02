
新加听书的url

首页
http://wellsoftteam.com/voice/main/getmaindata

    主播的   title=“主播名”
    http://wellsoftteam.com/voice/list/voicesearchpage?pageNum=1&title=%E9%9D%92%E9%9B%AA



分类
http://wellsoftteam.com/voice/main/getmainfldata
返回有id

    单个分类url  types=id
    http://wellsoftteam.com/voice/list/voicetypepage?pageNum=1&title=&keyword=&types=4028818b451343a10145134427350001&ordercode=


各个排行
http://wellsoftteam.com/voice/main/getmainvoicedata?categoryindex=1
http://wellsoftteam.com/voice/main/getmainvoicedata?categoryindex=2
http://wellsoftteam.com/voice/main/getmainvoicedata?categoryindex=3

    单个排行的更多   types=排行的id，上个接口返回
    http://wellsoftteam.com/voice/list/voicetypepage?pageNum=1&title=&keyword=&types=4028818b451343a10145134427090000&ordercode=updatetime


专题
http://wellsoftteam.com/voice/main/getmainztdata

    推荐专题   title=gcd    关键词首页接口返回
    http://wellsoftteam.com/voice/list/voicesearchpage?pageNum=1&title=gcd



听书的搜索url
http://wellsoftteam.com/voice/list/voicesearchpage?pageNum=1&title=陈二狗


{
    "status": "200",
    "totalpage": "1",
    "voicelist": [
        {
            "by": "鎾煶锛氭垜褰遍殢椋�,棣ㄥ効",
            "content": "",
            "des": "",
            "id": "402881bc4af4061a014af40db9222f31",
            "js": "92",
            "name": "闄堜簩鐙楃殑濡栧浜虹敓2",
            "picurl": "http://static.ting89.com/pic/upload/2014-6/10380.jpg",
            "sc": "0",
            "tj": "0",
            "types": "4028818b451343a10145134427360002",
            "updatetime": "2015-01-16 23:00:00",
            "url": "",
            "viewtime": "50047",
            "zt": "鐘舵€侊細杩炶浇涓�",
            "zz": "浣滆€咃細鐑界伀鎴忚渚�"
        }
    ]
}


typeid：id
userid：貌似可以乱写

书籍信息  包含作者、播音、集数、播放次数以及更新时间等
http://wellsoftteam.com/voice/list/voiceview?typeid=402881bc4af4061a014af40db9222f31&userid=00000000-7879-6bf6-c764-cf9f0033c587

书籍的声音章节列表   包含总共几页、下载地址、播放地址  
http://wellsoftteam.com/voice/list/voicepage?pageNum=1&typeid=402881bc4af4061a014af40db9222f31&userid=00000000-7879-6bf6-c764-cf9f0033c587

