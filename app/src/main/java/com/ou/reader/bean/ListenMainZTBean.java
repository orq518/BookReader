package com.ou.reader.bean;

import com.ou.reader.bean.base.ListenBase;

import java.util.List;

/**
 * author：ou on 2016/11/2 10:49
 * todo
 */
public class ListenMainZTBean extends ListenBase {

    /**
     * id : 1
     * istj : 1
     * keyword : gcd
     * name : 楝煎惞鐏�
     * picurl : /voice/mainpic/zt/gcd.jpg
     */

    private List<ZtlistBean> ztlist;

    public List<ZtlistBean> getZtlist() {
        return ztlist;
    }

    public void setZtlist(List<ZtlistBean> ztlist) {
        this.ztlist = ztlist;
    }

    public static class ZtlistBean {
        private String id;
        private String istj;
        private String keyword;
        private String name;
        private String picurl;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIstj() {
            return istj;
        }

        public void setIstj(String istj) {
            this.istj = istj;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
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
    }
}
