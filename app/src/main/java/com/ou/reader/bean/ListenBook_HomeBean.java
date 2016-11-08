package com.ou.reader.bean;

import com.ou.reader.bean.base.ListenBase;

import java.util.List;

/**
 * author：ou on 2016/11/2 10:32
 * todo
 */
public class ListenBook_HomeBean extends ListenBase {


    private String categorysize;
    //主播
    private List<ByBean> by;
    //排行
    private List<PhlistBean> phlist;
    //最近更新
    private List<UpdatelistBean> updatelist;
    //专题
    private List<ZtBean> zt;
    //周排行
    private List<ZxlistBean> zxlist;

    public String getCategorysize() {
        return categorysize;
    }

    public void setCategorysize(String categorysize) {
        this.categorysize = categorysize;
    }



    public List<ByBean> getBy() {
        return by;
    }

    public void setBy(List<ByBean> by) {
        this.by = by;
    }


    public List<PhlistBean> getPhlist() {
        return phlist;
    }

    public void setPhlist(List<PhlistBean> phlist) {
        this.phlist = phlist;
    }

    public List<UpdatelistBean> getUpdatelist() {
        return updatelist;
    }

    public void setUpdatelist(List<UpdatelistBean> updatelist) {
        this.updatelist = updatelist;
    }

    public List<ZtBean> getZt() {
        return zt;
    }

    public void setZt(List<ZtBean> zt) {
        this.zt = zt;
    }

    public List<ZxlistBean> getZxlist() {
        return zxlist;
    }

    public void setZxlist(List<ZxlistBean> zxlist) {
        this.zxlist = zxlist;
    }

    public static class ByBean {
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

    public static class PhlistBean {
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
        private String web;
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

        public String getWeb() {
            return web;
        }

        public void setWeb(String web) {
            this.web = web;
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

    public static class UpdatelistBean {
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

    public static class ZtBean {
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

    public static class ZxlistBean {
        private String by;
        private String content;
        private String createtime;
        private String des;
        private String id;
        private String js;
        private String name;
        private String picurl;
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

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
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
