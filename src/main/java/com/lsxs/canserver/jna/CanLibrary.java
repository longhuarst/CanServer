package com.lsxs.canserver.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;

public interface CanLibrary extends Library {

//    CanLibrary instance = Native.loadLibrary(CanLibraryPath.getPath(), CanLibrary.class);
    CanLibrary INSTANCE = (CanLibrary) Native.loadLibrary(CanLibraryUrl.getUrl().toString(),CanLibrary.class);
    //,CanLibrary.class);

    int VCI_OpenDevice(int DevType,int DevIndex,int Reserved);

    int VCI_CloseDevice(int DevType,int DevIndex);

    int VCI_InitCAN(int DevType, int DevIndex, int CANIndex, CanInitConfig.ByReference pInitConfig);

    int VCI_StartCAN(int DevType,int DevIndex,int CANIndex);

    int VCI_ResetCAN(int DevType,int DevIndex,int CANIndex);


    int VCI_Transmit(int DeviceType,int DeviceInd,int CANInd,byte [] pSend,int Length);


    int VCI_Receive(int DevType, int DevIndex, int CANIndex, byte [] pReceive, int Len, int WaitTime);


    int VCI_GetReceiveNum(int DevType,int DevIndex,int CANIndex);


}
