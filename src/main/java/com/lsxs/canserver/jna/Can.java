package com.lsxs.canserver.jna;


import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.IntByReference;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Can {


    private void error(int errcode) throws CanException{
        switch (errcode){
            case 0:
                throw new CanException("operate failed");
            case -1:
                throw new CanException("device not found");
        }

        if (errcode < 0){
            throw new CanException("unknow error");
        }
    }



    public void open(int devType, int devIndex) throws CanException{
        int ret = CanLibrary.INSTANCE.VCI_OpenDevice(devType, devIndex, 0);
        error(ret);
    }


    public void close(int devType, int devIndex) throws CanException{
        int ret = CanLibrary.INSTANCE.VCI_CloseDevice(devType, devIndex);
        error(ret);
    }


    public void init(int devType, int devIndex, int canIndex) throws CanException {
        CanInitConfig.ByReference config = new CanInitConfig.ByReference();
        config.accCode = 0x80000000;
        config.accMask = 0xffffffff;
        config.filter =  1;
        config.timing0 = 0x00;
        config.timing1 = 0x14;
        config.mode = 0;
        config.reserved = 0;
        int ret = CanLibrary.INSTANCE.VCI_InitCAN(devType, devIndex, canIndex, config);
        error(ret);
    }


    public void start(int devType, int devIndex, int canIndex) throws CanException{
        int ret = CanLibrary.INSTANCE.VCI_StartCAN(devType, devIndex, canIndex);
        error(ret);
    }


    public void reset(int devType, int devIndex, int canIndex) throws CanException{
        int ret = CanLibrary.INSTANCE.VCI_ResetCAN(devType, devIndex, canIndex);
        error(ret);
    }


    public void transmit(int devType, int devIndex, int canIndex, CanObject [] canObject, int length) throws CanException{

        byte [] canByteObject = CanByteObject.getByteArray(canObject);

        int ret = CanLibrary.INSTANCE.VCI_Transmit(devType, devIndex, canIndex, canByteObject, length );

        System.out.println("send byte = "+Arrays.toString(canByteObject));
        if (ret >=1){
            System.out.println("transmit success for "+ret);
        }
        error(ret);
    }


    public CanObject [] receive(int devType, int devIndex, int canIndex, int length) throws CanException{
        System.out.println("receive length = "+length);


//        CanObject.ByReference canObject = new CanObject.ByReference();
        byte [] canByteObject = new byte[24 * length];


        int ret = CanLibrary.INSTANCE.VCI_Receive(devType, devIndex, canIndex, canByteObject, length, 0);
        System.out.println("ret = "+ret);


        System.out.println("recv byte = "+Arrays.toString(canByteObject));


        CanObject [] canObjects = CanByteObject.getObject(canByteObject, (int)length);
//        System.out.println("ret = "+ret +" id = " + canObject.ID);
//        System.out.println(canObject.toString());
//        CanObject [] objects = (CanObject[]) canObject.toArray(ret);

//        for (int i=0;i<objects.length; ++i){
//            System.out.println(objects[i].toString());
//        }

        error(ret);

//        System.out.println(canObject.toString());

        return canObjects;//;;canObject;
    }


    public int receiveNumber(int devType, int devIndex, int canIndex) throws CanException{
        int ret = CanLibrary.INSTANCE.VCI_GetReceiveNum(devType, devIndex, canIndex);
        error(ret);
        return ret;
    }

}
