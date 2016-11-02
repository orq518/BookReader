package com.ou.reader.bean;

import com.ou.reader.bean.base.ListenBase;

import java.util.List;

/**
 * author：ou on 2016/11/2 10:32
 * todo
 */
public class ListenBook_ClassificationBean extends ListenBase {


    /**
     * categorylist : [{"bz":"1","id":"4028818b451343a10145134427090000","js":482,"name":"鐜勫够","picurl":"/voice/mainpic/fl/4028818b451343a10145134427090000.jpg","url":"/booklist/1.html"},{"bz":"2","id":"4028818b451343a10145134427350001","js":171,"name":"姝︿緺","picurl":"/voice/mainpic/fl/4028818b451343a10145134427350001.jpg","url":"/booklist/2.html"},{"bz":"3","id":"4028818b451343a10145134427360002","js":1179,"name":"閮藉競","picurl":"/voice/mainpic/fl/4028818b451343a10145134427360002.jpg","url":"/booklist/3.html"},{"bz":"4","id":"4028818b451343a10145134427370003","js":508,"name":"瑷\u20ac鎯�","picurl":"/voice/mainpic/fl/4028818b451343a10145134427370003.jpg","url":"/booklist/4.html"},{"bz":"5","id":"4028818b451343a10145134427390004","js":218,"name":"濂崇敓","picurl":"/voice/mainpic/fl/4028818b451343a10145134427390004.jpg","url":"/booklist/38.html"},{"bz":"6","id":"4028818b451343a101451344273a0005","js":115,"name":"绉戝够","picurl":"/voice/mainpic/fl/4028818b451343a101451344273a0005.jpg","url":"/booklist/5.html"},{"bz":"7","id":"4028818b451343a101451344273b0006","js":439,"name":"鎺ㄧ悊","picurl":"/voice/mainpic/fl/4028818b451343a101451344273b0006.jpg","url":"/booklist/6.html"},{"bz":"8","id":"4028818b451343a101451344273d0007","js":777,"name":"鎭愭\u20ac�","picurl":"/voice/mainpic/fl/4028818b451343a101451344273d0007.jpg","url":"/booklist/7.html"},{"bz":"9","id":"4028818b451343a101451344273f0008","js":587,"name":"鎯婃倸","picurl":"/voice/mainpic/fl/4028818b451343a101451344273f0008.jpg","url":"/booklist/8.html"},{"bz":"10","id":"4028818b451343a10145134427400009","js":642,"name":"鍘嗗彶","picurl":"/voice/mainpic/fl/4028818b451343a10145134427400009.jpg","url":"/booklist/9.html"},{"bz":"11","id":"4028818b451343a1014513442742000a","js":192,"name":"鍐涗簨","picurl":"/voice/mainpic/fl/4028818b451343a1014513442742000a.jpg","url":"/booklist/10.html"},{"bz":"12","id":"4028818b451343a1014513442743000b","js":63,"name":"缃戞父","picurl":"/voice/mainpic/fl/4028818b451343a1014513442743000b.jpg","url":"/booklist/11.html"},{"bz":"13","id":"4028818b451343a1014513442745000c","js":826,"name":"閫氫織","picurl":"/voice/mainpic/fl/4028818b451343a1014513442745000c.jpg","url":"/booklist/35.html"},{"bz":"14","id":"4028818b451343a101451344274a000f","js":444,"name":"璇勪功","picurl":"/voice/mainpic/fl/4028818b451343a101451344274a000f.jpg","url":"/booklist/13.html"},{"bz":"15","id":"4028818b451343a101451344274b0010","js":125,"name":"鐩稿０","picurl":"/voice/mainpic/fl/4028818b451343a101451344274b0010.jpg","url":"/booklist/34.html"},{"bz":"16","id":"4028818b451343a101451344274d0011","js":504,"name":"鐧惧璁插潧","picurl":"/voice/mainpic/fl/4028818b451343a101451344274d0011.jpg","url":"/booklist/36.html"}]
     * status : 200
     */

    /**
     * bz : 1
     * id : 4028818b451343a10145134427090000
     * js : 482
     * name : 鐜勫够
     * picurl : /voice/mainpic/fl/4028818b451343a10145134427090000.jpg
     * url : /booklist/1.html
     */

    private List<CategorylistBean> categorylist;


    public List<CategorylistBean> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(List<CategorylistBean> categorylist) {
        this.categorylist = categorylist;
    }

    public static class CategorylistBean {
        private String bz;
        private String id;
        private int js;
        private String name;
        private String picurl;
        private String url;

        public String getBz() {
            return bz;
        }

        public void setBz(String bz) {
            this.bz = bz;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getJs() {
            return js;
        }

        public void setJs(int js) {
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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
