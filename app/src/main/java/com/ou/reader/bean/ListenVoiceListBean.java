package com.ou.reader.bean;

import com.ou.reader.bean.base.ListenBase;

import java.util.List;

/**
 * author：ou on 2016/11/2 10:49
 * todo
 */
public class ListenVoiceListBean extends ListenBase {
    /**
     * pageSize : 20
     * totalpage : 5
     * userpage : 1
     * voicelist : [{"content":"http://vr.tudou.com/v2proxy/v2?it=194919316&st=52&pw=dd7891243","downurl":"http://vr.tudou.com/v2proxy/v2?it=194919316&st=52&pw=dd7891243","id":"402881bc4af4061a014af40dba562f32","title":"绗�01闆�","typeid":"402881bc4af4061a014af40db9222f31","updatetime":"2015-01-16 23:00:00","url":"/playbook/?10380-0-0.html","vid":"0","viewtime":0,"zj":1},{"content":"http://vr.tudou.com/v2proxy/v2?it=194919433&st=52&pw=dd7891243","downurl":"http://vr.tudou.com/v2proxy/v2?it=194919433&st=52&pw=dd7891243","id":"402881bc4af4061a014af40dbb752f33","title":"绗�02闆�","typeid":"402881bc4af4061a014af40db9222f31","updatetime":"2015-01-16 23:00:00","url":"/playbook/?10380-0-1.html","vid":"0","viewtime":0,"zj":2},{"content":"http://vr.tudou.com/v2proxy/v2?it=194919440&st=52&pw=dd7891243","downurl":"http://vr.tudou.com/v2proxy/v2?it=194919440&st=52&pw=dd7891243","id":"402881bc4af4061a014af40dbbbb2f34","title":"绗�03闆�","typeid":"402881bc4af4061a014af40db9222f31","updatetime":"2015-01-16 23:00:00","url":"/playbook/?10380-0-2.html","vid":"0","viewtime":0,"zj":3},{"content":"http://vr.tudou.com/v2proxy/v2?it=194919562&st=52&pw=dd7891243","downurl":"http://vr.tudou.com/v2proxy/v2?it=194919562&st=52&pw=dd7891243","id":"402881bc4af4061a014af40dbc062f35","title":"绗�04闆�","typeid":"402881bc4af4061a014af40db9222f31","updatetime":"2015-01-16 23:00:00","url":"/playbook/?10380-0-3.html","vid":"0","viewtime":0,"zj":4},{"content":"http://vr.tudou.com/v2proxy/v2?it=194919643&st=52&pw=dd7891243","downurl":"http://vr.tudou.com/v2proxy/v2?it=194919643&st=52&pw=dd7891243","id":"402881bc4af4061a014af40dbc4c2f36","title":"绗�05闆�","typeid":"402881bc4af4061a014af40db9222f31","updatetime":"2015-01-16 23:00:00","url":"/playbook/?10380-0-4.html","vid":"0","viewtime":0,"zj":5},{"content":"http://vr.tudou.com/v2proxy/v2?it=194919644&st=52&pw=dd7891243","downurl":"http://vr.tudou.com/v2proxy/v2?it=194919644&st=52&pw=dd7891243","id":"402881bc4af4061a014af40dbc932f37","title":"绗�06闆�","typeid":"402881bc4af4061a014af40db9222f31","updatetime":"2015-01-16 23:00:00","url":"/playbook/?10380-0-5.html","vid":"0","viewtime":0,"zj":6},{"content":"http://vr.tudou.com/v2proxy/v2?it=194919725&st=52&pw=dd7891243","downurl":"http://vr.tudou.com/v2proxy/v2?it=194919725&st=52&pw=dd7891243","id":"402881bc4af4061a014af40dbcda2f38","title":"绗�07闆�","typeid":"402881bc4af4061a014af40db9222f31","updatetime":"2015-01-16 23:00:00","url":"/playbook/?10380-0-6.html","vid":"0","viewtime":0,"zj":7},{"content":"http://vr.tudou.com/v2proxy/v2?it=194919733&st=52&pw=dd7891243","downurl":"http://vr.tudou.com/v2proxy/v2?it=194919733&st=52&pw=dd7891243","id":"402881bc4af4061a014af40dbd212f39","title":"绗�08闆�","typeid":"402881bc4af4061a014af40db9222f31","updatetime":"2015-01-16 23:00:00","url":"/playbook/?10380-0-7.html","vid":"0","viewtime":0,"zj":8},{"content":"http://vr.tudou.com/v2proxy/v2?it=194919863&st=52&pw=dd7891243","downurl":"http://vr.tudou.com/v2proxy/v2?it=194919863&st=52&pw=dd7891243","id":"402881bc4af4061a014af40dbd6a2f3a","title":"绗�09闆�","typeid":"402881bc4af4061a014af40db9222f31","updatetime":"2015-01-16 23:00:00","url":"/playbook/?10380-0-8.html","vid":"0","viewtime":0,"zj":9},{"content":"http://vr.tudou.com/v2proxy/v2?it=194919873&st=52&pw=dd7891243","downurl":"http://vr.tudou.com/v2proxy/v2?it=194919873&st=52&pw=dd7891243","id":"402881bc4af4061a014af40dbdb22f3b","title":"绗�10闆�","typeid":"402881bc4af4061a014af40db9222f31","updatetime":"2015-01-16 23:00:00","url":"/playbook/?10380-0-9.html","vid":"0","viewtime":0,"zj":10},{"content":"http://vr.tudou.com/v2proxy/v2?it=194967108&st=52&pw=dd7891243","downurl":"http://vr.tudou.com/v2proxy/v2?it=194967108&st=52&pw=dd7891243","id":"402881bc4af4061a014af40dbdfb2f3c","title":"绗�11闆�","typeid":"402881bc4af4061a014af40db9222f31","updatetime":"2015-01-16 23:00:00","url":"/playbook/?10380-0-10.html","vid":"0","viewtime":0,"zj":11},{"content":"http://vr.tudou.com/v2proxy/v2?it=194967241&st=52&pw=dd7891243","downurl":"http://vr.tudou.com/v2proxy/v2?it=194967241&st=52&pw=dd7891243","id":"402881bc4af4061a014af40dbe422f3d","title":"绗�12闆�","typeid":"402881bc4af4061a014af40db9222f31","updatetime":"2015-01-16 23:00:00","url":"/playbook/?10380-0-11.html","vid":"0","viewtime":0,"zj":12},{"content":"http://vr.tudou.com/v2proxy/v2?it=195216884&st=52&pw=dd7891243","downurl":"http://vr.tudou.com/v2proxy/v2?it=195216884&st=52&pw=dd7891243","id":"402881bc4af4061a014af40dbe8a2f3e","title":"绗�13闆�","typeid":"402881bc4af4061a014af40db9222f31","updatetime":"2015-01-16 23:00:00","url":"/playbook/?10380-0-12.html","vid":"0","viewtime":0,"zj":13},{"content":"http://vr.tudou.com/v2proxy/v2?it=195216922&st=52&pw=dd7891243","downurl":"http://vr.tudou.com/v2proxy/v2?it=195216922&st=52&pw=dd7891243","id":"402881bc4af4061a014af40dbed02f3f","title":"绗�14闆�","typeid":"402881bc4af4061a014af40db9222f31","updatetime":"2015-01-16 23:00:00","url":"/playbook/?10380-0-13.html","vid":"0","viewtime":0,"zj":14},{"content":"http://vr.tudou.com/v2proxy/v2?it=195278626&st=52&pw=dd7891243","downurl":"http://vr.tudou.com/v2proxy/v2?it=195278626&st=52&pw=dd7891243","id":"402881bc4af4061a014af40dbf182f40","title":"绗�15闆�","typeid":"402881bc4af4061a014af40db9222f31","updatetime":"2015-01-16 23:00:00","url":"/playbook/?10380-0-14.html","vid":"0","viewtime":0,"zj":15},{"content":"http://vr.tudou.com/v2proxy/v2?it=195278646&st=52&pw=dd7891243","downurl":"http://vr.tudou.com/v2proxy/v2?it=195278646&st=52&pw=dd7891243","id":"402881bc4af4061a014af40dbf5f2f41","title":"绗�16闆�","typeid":"402881bc4af4061a014af40db9222f31","updatetime":"2015-01-16 23:00:00","url":"/playbook/?10380-0-15.html","vid":"0","viewtime":0,"zj":16},{"content":"http://vr.tudou.com/v2proxy/v2?it=195755307&st=52&pw=dd7891243","downurl":"http://vr.tudou.com/v2proxy/v2?it=195755307&st=52&pw=dd7891243","id":"402881bc4af4061a014af40dbfa72f42","title":"绗�17闆�","typeid":"402881bc4af4061a014af40db9222f31","updatetime":"2015-01-16 23:00:00","url":"/playbook/?10380-0-16.html","vid":"0","viewtime":0,"zj":17},{"content":"http://vr.tudou.com/v2proxy/v2?it=195755856&st=52&pw=dd7891243","downurl":"http://vr.tudou.com/v2proxy/v2?it=195755856&st=52&pw=dd7891243","id":"402881bc4af4061a014af40dbfee2f43","title":"绗�18闆�","typeid":"402881bc4af4061a014af40db9222f31","updatetime":"2015-01-16 23:00:00","url":"/playbook/?10380-0-17.html","vid":"0","viewtime":0,"zj":18},{"content":"http://vr.tudou.com/v2proxy/v2?it=195855469&st=52&pw=dd7891243","downurl":"http://vr.tudou.com/v2proxy/v2?it=195855469&st=52&pw=dd7891243","id":"402881bc4af4061a014af40dc0342f44","title":"绗�19闆�","typeid":"402881bc4af4061a014af40db9222f31","updatetime":"2015-01-16 23:00:00","url":"/playbook/?10380-0-18.html","vid":"0","viewtime":0,"zj":19},{"content":"http://vr.tudou.com/v2proxy/v2?it=195855883&st=52&pw=dd7891243","downurl":"http://vr.tudou.com/v2proxy/v2?it=195855883&st=52&pw=dd7891243","id":"402881bc4af4061a014af40dc07c2f45","title":"绗�20闆�","typeid":"402881bc4af4061a014af40db9222f31","updatetime":"2015-01-16 23:00:00","url":"/playbook/?10380-0-19.html","vid":"0","viewtime":0,"zj":20}]
     * voicenum : 92
     */

    private String pageSize;
    private String totalpage;
    private String userpage;
    private int voicenum;
    /**
     * content : http://vr.tudou.com/v2proxy/v2?it=194919316&st=52&pw=dd7891243
     * downurl : http://vr.tudou.com/v2proxy/v2?it=194919316&st=52&pw=dd7891243
     * id : 402881bc4af4061a014af40dba562f32
     * title : 绗�01闆�
     * typeid : 402881bc4af4061a014af40db9222f31
     * updatetime : 2015-01-16 23:00:00
     * url : /playbook/?10380-0-0.html
     * vid : 0
     * viewtime : 0
     * zj : 1
     */

    private List<VoicelistBean> voicelist;

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(String totalpage) {
        this.totalpage = totalpage;
    }

    public String getUserpage() {
        return userpage;
    }

    public void setUserpage(String userpage) {
        this.userpage = userpage;
    }

    public int getVoicenum() {
        return voicenum;
    }

    public void setVoicenum(int voicenum) {
        this.voicenum = voicenum;
    }

    public List<VoicelistBean> getVoicelist() {
        return voicelist;
    }

    public void setVoicelist(List<VoicelistBean> voicelist) {
        this.voicelist = voicelist;
    }

    public static class VoicelistBean {
        private String content;
        private String downurl;
        private String id;
        private String title;
        private String typeid;
        private String updatetime;
        private String url;
        private String vid;
        private int viewtime;
        private int zj;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDownurl() {
            return downurl;
        }

        public void setDownurl(String downurl) {
            this.downurl = downurl;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTypeid() {
            return typeid;
        }

        public void setTypeid(String typeid) {
            this.typeid = typeid;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public int getViewtime() {
            return viewtime;
        }

        public void setViewtime(int viewtime) {
            this.viewtime = viewtime;
        }

        public int getZj() {
            return zj;
        }

        public void setZj(int zj) {
            this.zj = zj;
        }
    }
}
