package com.lsxs;

import com.lsxs.canserver.jna.CanLibrary;
import com.lsxs.canserver.jna.hello.Test;
import com.lsxs.canserver.jna.hello.TestObject;

public class CanTest {

    public static void main(String[] args) {


//        int ret = CanLibrary.INSTANCE.VCI_OpenDevice(4,0,0);
//
//        System.out.println(ret);


        Test.INSTANCE.hello();
//        TestObject.ByReference object = new TestObject.ByReference();
//        object.a = 1;
//        object.b = 2;
        byte [] a = {(byte)0xaa,(byte)0xbb,(byte)0xcc, (byte)0xdd,  (byte)0xaa,(byte)0xbb,(byte)0xcc, (byte)0xdd,};
        Test.INSTANCE.testx(a,2);


        byte [] b = {0,0,0,0};
        Test.INSTANCE.get(b, 2);

    }
}
