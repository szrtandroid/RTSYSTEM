package com.rt3.rtsystem.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by RT3
 * on 2017/8/2.
 */

public class MonthCollectPlasma implements Serializable{

    /**
     * code : success
     * msg : 请求成功
     * result : [{"count":46,"date":"201707020000000"},{"count":12,"date":"201707030000000"},{"count":43,"date":"201707040000000"},{"count":8,"date":"201707050000000"},{"count":14,"date":"201707060000000"},{"count":27,"date":"201707070000000"},{"count":42,"date":"201707090000000"},{"count":17,"date":"201707100000000"},{"count":29,"date":"201707110000000"},{"count":17,"date":"201707120000000"},{"count":19,"date":"201707130000000"},{"count":23,"date":"201707140000000"},{"count":44,"date":"201707160000000"},{"count":8,"date":"201707170000000"},{"count":45,"date":"201707180000000"},{"count":12,"date":"201707190000000"},{"count":13,"date":"201707200000000"},{"count":18,"date":"201707210000000"},{"count":41,"date":"201707230000000"},{"count":9,"date":"201707240000000"},{"count":25,"date":"201707250000000"},{"count":14,"date":"201707260000000"},{"count":18,"date":"201707270000000"},{"count":14,"date":"201707280000000"},{"count":47,"date":"201707300000000"},{"count":9,"date":"201707310000000"},{"count":44,"date":"201708010000000"}]
     */

    private String code;
    private String msg;
    private List<ResultBean> result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable{
        /**
         * count : 46
         * date : 201707020000000
         */

        private int count;
        private String date;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}
