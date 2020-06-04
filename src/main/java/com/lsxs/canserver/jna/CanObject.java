package com.lsxs.canserver.jna;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CanObject extends Structure {

    public static class ByReference extends CanObject implements Structure.ByReference{
    }

    public static class ByValue extends CanObject implements Structure.ByValue{

    }

    public byte []Data = new byte[8];
    public byte DataLen;
    public byte ExternFlag;
    public int ID;
    public byte RemoteFlag;
    public byte []Reserved = new byte[3];
    public byte SendType;
    public byte TimeFlag;
    public int TimeStamp;

    @Override
    protected List<String> getFieldOrder() {
        List<String> field = new ArrayList<>();
        field.add("ID");
        field.add("TimeStamp");
        field.add("TimeFlag");
        field.add("SendType");
        field.add("RemoteFlag");
        field.add("ExternFlag");
        field.add("DataLen");
        field.add("Data");
        field.add("Reserved");

        return field;
    }

    @Override
    public String toString() {
        return "CanObject{" +
                "ID=" + ID +
                ", TimeStamp=" + TimeStamp +
                ", TimeFlag=" + TimeFlag +
                ", SendType=" + SendType +
                ", RemoteFlag=" + RemoteFlag +
                ", ExternFlag=" + ExternFlag +
                ", DataLen=" + DataLen +
                ", Data=" + Arrays.toString(Data) +
                ", Reserved=" + Arrays.toString(Reserved) +
                '}';
    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(int timestamp) {
//        this.timestamp = timestamp;
//    }
//
//    public byte getTimeFlag() {
//        return timeFlag;
//    }
//
//    public void setTimeFlag(byte timeFlag) {
//        this.timeFlag = timeFlag;
//    }
//
//    public byte getSendType() {
//        return sendType;
//    }
//
//    public void setSendType(byte sendType) {
//        this.sendType = sendType;
//    }
//
//    public byte getRemoteFlag() {
//        return remoteFlag;
//    }
//
//    public void setRemoteFlag(byte remoteFlag) {
//        this.remoteFlag = remoteFlag;
//    }
//
//    public byte getExternFlag() {
//        return externFlag;
//    }
//
//    public void setExternFlag(byte externFlag) {
//        this.externFlag = externFlag;
//    }
//
//    public byte getDlc() {
//        return dlc;
//    }
//
//    public void setDlc(byte dlc) {
//        this.dlc = dlc;
//    }
//
//    public byte[] getData() {
//        return data;
//    }
//
//    public void setData(byte[] data) {
//        this.data = data;
//    }
//
//    public byte[] getReserved() {
//        return reserved;
//    }
//
//    public void setReserved(byte[] reserved) {
//        this.reserved = reserved;
//    }
}
