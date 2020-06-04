package com.lsxs.canserver.jna.hello;

import com.lsxs.canserver.jna.CanInitConfig;
import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class TestObject extends Structure {

    public static class ByReference extends TestObject implements Structure.ByReference{

    }

    public static class ByValue extends TestObject implements Structure.ByValue{

    }


    public byte a;
    public byte b;


    @Override
    protected List<String> getFieldOrder() {
        List<String> field = new ArrayList<>();
        field.add("a");
        field.add("b");

        return field;
    }
}
