package com.lsxs.canserver.jna;

public class CanLibraryUrl {

    static String getUrl(){
        String url = CanLibraryUrl.class.getClassLoader().getResource("ControlCAN64.dll").getPath().substring(1); //头上会多一个/符号
        System.out.println(url);
        return url;

    }
}
