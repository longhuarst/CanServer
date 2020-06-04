package com.lsxs.canserver.jna;

import com.sun.jna.Structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CanInitConfig extends Structure {

    public static class ByReference extends CanInitConfig implements Structure.ByReference{

    }

    public static class ByValue extends CanInitConfig implements Structure.ByValue{

    }


    public int accCode;
    public int accMask;
    public byte filter;

    public byte mode;

    public int reserved;
    public byte timing0;
    public byte timing1;

    @Override
    protected List<String> getFieldOrder() {
        List<String> filed = new ArrayList<>();
        filed.add("accCode");
        filed.add("accMask");
        filed.add("reserved");
        filed.add("filter");
        filed.add("timing0");
        filed.add("timing1");
        filed.add("mode");
        return filed;
    }

    //    public int getAccCode() {
//        return accCode;
//    }
//
//    public void setAccCode(int accCode) {
//        this.accCode = accCode;
//    }
//
//    public int getAccMask() {
//        return accMask;
//    }
//
//    public void setAccMask(int accMask) {
//        this.accMask = accMask;
//    }
//
//    public int getReserved() {
//        return reserved;
//    }
//
//    public void setReserved(int reserved) {
//        this.reserved = reserved;
//    }
//
//    public byte getFilter() {
//        return filter;
//    }
//
//    public void setFilter(byte filter) {
//        this.filter = filter;
//    }
//
//    public byte getTiming0() {
//        return timing0;
//    }
//
//    public void setTiming0(byte timing0) {
//        this.timing0 = timing0;
//    }
//
//    public byte getTiming1() {
//        return timing1;
//    }
//
//    public void setTiming1(byte timing1) {
//        this.timing1 = timing1;
//    }
//
//    public byte getMode() {
//        return mode;
//    }
//
//    public void setMode(byte mode) {
//        this.mode = mode;
//    }
}
