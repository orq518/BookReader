package com.ou.reader.bean;

import com.ou.reader.bean.base.ListenBase;

import java.util.List;

/**
 * author：ou on 2016/11/2 10:49
 * todo
 */
public class ListenRankingBean extends ListenBase {

    /**
     * categoryid : 4028818b451343a10145134427090000
     * categoryname : 鐜勫够
     * tjlist : [{"by":"鎾煶:鍗庨 鏍楀瓙灏忓崟","content":"","des":"","id":"4028818b45135ffa0145136017e50002","js":"187","name":"娲崚绁栧帆鐑涗節闃翠紶","picurl":"http://static.ting89.com/pic/upload/2014-2/9730.jpg","sc":"0","tj":"1","types":"4028818b451343a10145134427090000","updatetime":"2015-01-16 23:00:00","url":"","viewtime":"101867","zt":"鐘舵\u20ac�:杩炶浇涓�","zz":"浣滆\u20ac�:灏忓皬濡栭亾"},{"by":"鎾煶:绗戝鍙\u20ac�","content":"","des":"","id":"4028818b451360c501451360e99f0008","js":"1031","name":"鏉\u20ac绁�","picurl":"http://static.ting89.com/pic/upload/2012-10/3611.gif","sc":"0","tj":"1","types":"4028818b451343a10145134427090000","updatetime":"2015-01-16 23:00:00","url":"","viewtime":"3021128","zt":"鐘舵\u20ac�:瀹岀粨","zz":"浣滆\u20ac�:閫嗚媿澶�"},{"by":"鎾煶:澶ф枌","content":"","des":"","id":"4028818b451360c501451360e9a10009","js":"529","name":"閭鏇�","picurl":"http://static.ting89.com/pic/upload/2011-12/201112152232034127.jpg","sc":"0","tj":"1","types":"4028818b451343a10145134427090000","updatetime":"2014-04-05 12:03:31","url":"","viewtime":"983451","zt":"鐘舵\u20ac�:瀹岀粨","zz":"浣滆\u20ac�:琛\u20ac绾�"},{"by":"鎾煶:鏈変竴澶寸唺","content":"","des":"","id":"4028818b451360c501451360ea88000d","js":"265","name":"璋侀兘鍒児鎴�","picurl":"http://static.ting89.com/pic/upload/2013-12/20131211721595219.jpg","sc":"0","tj":"1","types":"4028818b451343a10145134427090000","updatetime":"2015-07-19 16:00:00","url":"","viewtime":"353832","zt":"鐘舵\u20ac�:杩炶浇涓�","zz":"浣滆\u20ac�:寮犲皬鑺�"},{"by":"鎾煶:绠℃仼浜�","content":"","des":"","id":"4028818b451360c501451360eb96001b","js":"303","name":"澶╅壌淇","picurl":"http://static.ting89.com/pic/upload/2011-12/2946.jpg","sc":"0","tj":"1","types":"4028818b451343a10145134427090000","updatetime":"2015-03-15 12:00:00","url":"","viewtime":"544347","zt":"鐘舵\u20ac�:杩炶浇涓�","zz":"浣滆\u20ac�:澶╄潕"},{"by":"鎾煶:鐧芥湪,鍗楅煶","content":"","des":"","id":"4028818b451360c501451360ec940029","js":"39","name":"娈嬭","picurl":"http://static.ting89.com/pic/upload/2014-1/9592.jpg","sc":"0","tj":"1","types":"4028818b451343a10145134427090000","updatetime":"2014-04-05 12:03:31","url":"","viewtime":"31109","zt":"鐘舵\u20ac�:杩炶浇涓�","zz":"浣滆\u20ac�:椋庡尽涔濈"},{"by":"鎾煶:鑰佸疄涔︾敓","content":"","des":"","id":"4028818b451360c501451360ed900031","js":"348","name":"涓浗榫欑粍","picurl":"http://static.ting89.com/pic/upload/2013-9/2013925555246184.jpg","sc":"0","tj":"1","types":"4028818b451343a10145134427090000","updatetime":"2014-04-05 12:03:31","url":"","viewtime":"456112","zt":"鐘舵\u20ac�:瀹岀粨","zz":"浣滆\u20ac�:椋庡崕鐖靛＋"},{"by":"鎾煶:鏌犳","content":"","des":"","id":"4028818b451360c501451360eea20044","js":"158","name":"鍞愰棬灏忓笀鍏�","picurl":"http://static.ting89.com/pic/upload/2013-5/8915.gif","sc":"0","tj":"1","types":"4028818b451343a10145134427090000","updatetime":"2014-04-05 12:03:31","url":"","viewtime":"40335","zt":"鐘舵\u20ac�:杩炶浇涓�","zz":"浣滆\u20ac�:鎳掓噿鐏倝"},{"by":"鎾煶:閮憺","content":"","des":"","id":"4028818b451360c501451360f1790061","js":"219","name":"鎴愪粰浜嗗埆鏉ユ壘鎴�","picurl":"http://static.ting89.com/pic/upload/2013-4/8849.jpg","sc":"0","tj":"1","types":"4028818b451343a10145134427090000","updatetime":"2014-04-05 12:03:31","url":"","viewtime":"108819","zt":"鐘舵\u20ac�:瀹岀粨","zz":"浣滆\u20ac�:绉嬪崄涓�"}]
     */

    private List<TjBean> tj;

    public List<TjBean> getTj() {
        return tj;
    }

    public void setTj(List<TjBean> tj) {
        this.tj = tj;
    }

    public static class TjBean {
        private String categoryid;
        private String categoryname;
        /**
         * by : 鎾煶:鍗庨 鏍楀瓙灏忓崟
         * content :
         * des :
         * id : 4028818b45135ffa0145136017e50002
         * js : 187
         * name : 娲崚绁栧帆鐑涗節闃翠紶
         * picurl : http://static.ting89.com/pic/upload/2014-2/9730.jpg
         * sc : 0
         * tj : 1
         * types : 4028818b451343a10145134427090000
         * updatetime : 2015-01-16 23:00:00
         * url :
         * viewtime : 101867
         * zt : 鐘舵€�:杩炶浇涓�
         * zz : 浣滆€�:灏忓皬濡栭亾
         */

        private List<TjlistBean> tjlist;

        public String getCategoryid() {
            return categoryid;
        }

        public void setCategoryid(String categoryid) {
            this.categoryid = categoryid;
        }

        public String getCategoryname() {
            return categoryname;
        }

        public void setCategoryname(String categoryname) {
            this.categoryname = categoryname;
        }

        public List<TjlistBean> getTjlist() {
            return tjlist;
        }

        public void setTjlist(List<TjlistBean> tjlist) {
            this.tjlist = tjlist;
        }

        public static class TjlistBean {
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
}
