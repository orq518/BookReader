package com.ou.reader.bean;

import com.ou.reader.bean.base.ListenBase;

/**
 * author：ou on 2016/11/2 10:49
 * todo
 */
public class ListenBookDesBean extends ListenBase {


    /**
     * des : 2009骞翠竴閮ㄣ€婇檲浜岀嫍鐨勫瀛戒汉鐢熴€嬮闈＄綉缁滐紝鐒惰€岀粨灞€骞朵笉灏戒汉鎰忥紝鐑界伀缁堜簬鍦ㄤ竴鐗囧懠澹颁腑閫€鍑轰簡缁綔銆傞鐭ヤ簩鐙椾互鍚庣殑璺€庝箞璧帮紝钂硅懎鐨勫懡杩愬浣曪紝鏁鏀跺惉銆婇檲浜岀嫍鐨勫瀛戒汉鐢�2銆嬨€�
     * nozannum : 0
     * pagecount : 30
     * totalpage : 5
     * userpage : 1
     * vippage : 0
     * voicenum : 92
     * zannum : 7
     */

    private String des;
    private int nozannum;
    private String pagecount;
    private String totalpage;
    private String userpage;
    private String vippage;
    private int voicenum;
    private int zannum;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getNozannum() {
        return nozannum;
    }

    public void setNozannum(int nozannum) {
        this.nozannum = nozannum;
    }

    public String getPagecount() {
        return pagecount;
    }

    public void setPagecount(String pagecount) {
        this.pagecount = pagecount;
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

    public String getVippage() {
        return vippage;
    }

    public void setVippage(String vippage) {
        this.vippage = vippage;
    }

    public int getVoicenum() {
        return voicenum;
    }

    public void setVoicenum(int voicenum) {
        this.voicenum = voicenum;
    }

    public int getZannum() {
        return zannum;
    }

    public void setZannum(int zannum) {
        this.zannum = zannum;
    }
}
