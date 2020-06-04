package com.lsxs.canserver.jna;

public class CanLibraryPath {

    static String getPath() {

        String path = CanLibraryPath.class.getClassLoader().getResource("ControlCAN64.dll").getPath().substring(1); //头部会多一个/
        System.out.println(path);
        return path;
    }


}
