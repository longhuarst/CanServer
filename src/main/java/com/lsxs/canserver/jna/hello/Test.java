package com.lsxs.canserver.jna.hello;

import com.lsxs.canserver.jna.CanLibrary;
import com.lsxs.canserver.jna.CanLibraryUrl;
import com.sun.jna.Library;
import com.sun.jna.Native;

public interface Test extends Library {
    Test INSTANCE = (Test) Native.loadLibrary("D:\\lhc\\ideaTools\\dllc\\cmake-build-debug\\libdllc.dll",Test.class);

    void hello();

    void testx(byte [] obj, int size);

    void get(byte [] obj, int size);

}
