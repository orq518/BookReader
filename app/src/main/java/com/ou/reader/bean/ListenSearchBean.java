package com.ou.reader.bean;

import com.ou.reader.bean.base.ListenBase;

import java.util.List;

/**
 * author：ou on 2016/11/2 10:49
 * todo
 */
public class ListenSearchBean extends ListenBase {


    /**
     * totalpage : 1
     * voicelist : [{"by":"鎾煶锛氭垜褰遍殢椋�,棣ㄥ効","content":"","des":"","id":"402881bc4af4061a014af40db9222f31","js":"92","name":"闄堜簩鐙楃殑濡栧浜虹敓2","picurl":"http://static.ting89.com/pic/upload/2014-6/10380.jpg","sc":"0","tj":"0","types":"4028818b451343a10145134427360002","updatetime":"2015-01-16 23:00:00","url":"","viewtime":"50062","zt":"鐘舵\u20ac侊細杩炶浇涓�","zz":"浣滆\u20ac咃細鐑界伀鎴忚渚�"},{"by":"鎾煶:鎴戝奖闅忛","content":"","des":"","id":"40283c81451c08f601451c095a1c01fc","js":"291","name":"闄堜簩鐙楃殑濡栧浜虹敓","picurl":"http://static.ting89.com/pic/upload/2010-12/201012210432174564.jpg","sc":"0","tj":"0","types":"4028818b451343a10145134427360002","updatetime":"2014-04-05 12:03:31","url":"","viewtime":"371863","zt":"鐘舵\u20ac�:瀹岀粨","zz":"浣滆\u20ac�:鐑界伀鎴忚渚�"}]
     */

    private String totalpage;
    /**
     * by : 鎾煶锛氭垜褰遍殢椋�,棣ㄥ効
     * content :
     * des :
     * id : 402881bc4af4061a014af40db9222f31
     * js : 92
     * name : 闄堜簩鐙楃殑濡栧浜虹敓2
     * picurl : http://static.ting89.com/pic/upload/2014-6/10380.jpg
     * sc : 0
     * tj : 0
     * types : 4028818b451343a10145134427360002
     * updatetime : 2015-01-16 23:00:00
     * url :
     * viewtime : 50062
     * zt : 鐘舵€侊細杩炶浇涓�
     * zz : 浣滆€咃細鐑界伀鎴忚渚�
     */

    private List<VoicelistBean> voicelist;

    public String getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(String totalpage) {
        this.totalpage = totalpage;
    }

    public List<VoicelistBean> getVoicelist() {
        return voicelist;
    }

    public void setVoicelist(List<VoicelistBean> voicelist) {
        this.voicelist = voicelist;
    }

    public static class VoicelistBean {
        private String by;
        private String content;
        private String des;
        private String id;
        private String js;
        private String name;
        private String picurl;
        private String sc;
        private String tj;
        private String types;
        private String updatetime;
        private String url;
        private String viewtime;
        private String zt;
        private String zz;

        public String getBy() {
            return by;
        }

        public void setBy(String by) {
            this.by = by;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getJs() {
            return js;
        }

        public void setJs(String js) {
            this.js = js;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        public String getSc() {
            return sc;
        }

        public void setSc(String sc) {
            this.sc = sc;
        }

        public String getTj() {
            return tj;
        }

        public void setTj(String tj) {
            this.tj = tj;
        }

        public String getTypes() {
            return types;
        }

        public void setTypes(String types) {
            this.types = types;
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

        public String getViewtime() {
            return viewtime;
        }

        public void setViewtime(String viewtime) {
            this.viewtime = viewtime;
        }

        public String getZt() {
            return zt;
        }

        public void setZt(String zt) {
            this.zt = zt;
        }

        public String getZz() {
            return zz;
        }

        public void setZz(String zz) {
            this.zz = zz;
        }
    }
}
