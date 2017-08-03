package com.rt3.rtsystem.constant;

/**
 * Created by RT3
 * on 2017/8/1.
 */

public class Constants {

    public static final String BASE_URL = "http://112.92.40.173";

    //RequestBody
    public static final String BODY_JSON = "{\"gooidKey\":\"QHOKPPTHPGPLPDTPRQTOOEEO\"}";
    /**
     * 当天预约人数
     */
    public static final String TODAY_ORDER_COUNT = BASE_URL + "/wxPlasmaBespeak.do?method=findBespeakTodayCount";

    /**
     * 近一个月预约人数
     */
    public static final String MONTH_ORDER_COUNT = BASE_URL + "/wxPlasmaBespeak.do?method=findBespeakMonthCount";

    /**
     * 当天报名人数
     */
    public static final String TODAY_REGIST_COUNT = BASE_URL + "/wxPersonal.do?method=findRegistTodayCount";
    /**
     * 取近一月报名人数
     */
    public static final String MONTH_REGIST_COUNT = BASE_URL + "/wxPersonal.do?method=findRegistMonthCount";

    /**
     * 当天建档人数
     */
    public static final String TODAY_CREATE_COUNT = BASE_URL + "/wxPersona.do?method=findCreateTodayCount";

    /**
     * 近一月建档人数
     */
    public static final String MONTH_CREATE_COUNT = BASE_URL + "/wxPersona.do?method=findCreateMonthCount";
    /**
     * 近一月不合格人数
     */
    public static final String MONTH_CANCEL_COUNT = BASE_URL + "/wxPersona.do?method=findCancelMonthCount";

    /**
     * 当天不合格人数
     */
    public static final String TODAY_CANCEL_COUNT = BASE_URL + "/wxPersona.do?method=findCancelTodayCount";



    /**
     * 取当天采浆袋数
     */

    public static final String TODAY_COLLECT_PLASMA = BASE_URL + "/wxPlasma.do?method=findPlasmaTodayCount";

    /**
     * 取最近一个月采浆袋数
     */
    public static final String MONTH_COLLECT_PLASMA = BASE_URL + "/wxPlasma.do?method=findPlasmaMonthCount";


//    public static final String URL="http://112.92.40.173/wxPlasma.do?method=findPlasmaRank";
}
