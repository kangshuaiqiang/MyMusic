package test.bwie.com.mymusic.Presenter;

/**
 * Created by 黑白 on 2017/9/29.
 */

public class Api {

    public static final String METHOD = "method";
    public static final String TYPE = "type";
    public static final String SIZE = "size";
    public static final String OFFSET = "offset";

    public static final String HTTPURL = "http://tingapi.ting.baidu.com/v1/restserver/ting?";
    public static final String GETLIST = HTTPURL + "?format=json&method=baidu.ting.billboard.billList&type=1&size=10&offset=0";
}
