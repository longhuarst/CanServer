package com.lsxs.canserver.jna;

public class CanByteObject {

    static byte[] getByteArray(CanObject[] objects) {
        byte[] res = new byte[24 * objects.length];

        for (int i = 0; i < objects.length; ++i) {

//            System.out.println(i);
            res[24 * i + 3] = (byte) (objects[i].ID >> 24 & 0xff);
            res[24 * i + 2] = (byte) (objects[i].ID >> 16 & 0xff);
            res[24 * i + 1] = (byte) (objects[i].ID >> 8 & 0xff);
            res[24 * i + 0] = (byte) (objects[i].ID >> 0 & 0xff);

            res[24 * i + 7] = (byte) (objects[i].TimeStamp >> 24 & 0xff);
            res[24 * i + 6] = (byte) (objects[i].TimeStamp >> 16 & 0xff);
            res[24 * i + 5] = (byte) (objects[i].TimeStamp >> 8 & 0xff);
            res[24 * i + 4] = (byte) (objects[i].TimeStamp >> 0 & 0xff);

            res[24 * i + 8] = (byte) objects[i].TimeFlag;
            res[24 * i + 9] = (byte) objects[i].SendType;
            res[24 * i + 10] = (byte) objects[i].RemoteFlag;
            res[24 * i + 11] = (byte) objects[i].ExternFlag;


            res[24 * i + 12] = (byte) objects[i].DataLen;

            if (objects[i].DataLen > 8) {
                objects[i].DataLen = 8;
            }
            switch (objects[i].DataLen) {
                case 8:
                    res[24 * i + 20] = (byte) objects[i].Data[7];
                case 7:
                    res[24 * i + 19] = (byte) objects[i].Data[6];
                case 6:
                    res[24 * i + 18] = (byte) objects[i].Data[5];
                case 5:
                    res[24 * i + 17] = (byte) objects[i].Data[4];
                case 4:
                    res[24 * i + 16] = (byte) objects[i].Data[3];
                case 3:
                    res[24 * i + 15] = (byte) objects[i].Data[2];
                case 2:
                    res[24 * i + 14] = (byte) objects[i].Data[1];
                case 1:
                    res[24 * i + 13] = (byte) objects[i].Data[0];
                case 0:
            }


            res[24 * i + 21] = (byte) objects[i].Reserved[0];
            res[24 * i + 22] = (byte) objects[i].Reserved[1];
            res[24 * i + 23] = (byte) objects[i].Reserved[2];
        }

        return res;
    }


    static CanObject[] getObject(byte[] data, int length) {

        CanObject[] canObject = new CanObject[length];

        for (int i = 0; i < length; ++i) {
            canObject[i] = new CanObject();


            canObject[i].ID = (data[i * 24 + 3] & 0x000000ff) << 24 | (data[i * 24 + 2] & 0x000000ff) << 16 | (data[i * 24 + 1] & 0x000000ff) << 8 | (data[i * 24 + 0] & 0x000000ff) << 0;
            canObject[i].TimeStamp = data[i * 24 + 7] << 24 | data[i * 24 + 6] << 16 | data[i * 24 + 5] << 8 | data[i * 24 + 4] << 0;

            canObject[i].TimeFlag = data[i * 24 + 8];
            canObject[i].SendType = data[i * 24 + 9];
            canObject[i].RemoteFlag = data[i * 24 + 10];
            canObject[i].ExternFlag = data[i * 24 + 11];

            canObject[i].DataLen = data[i * 24 + 12];

            canObject[i].Data[0] = data[i * 24 + 13];
            canObject[i].Data[1] = data[i * 24 + 14];
            canObject[i].Data[2] = data[i * 24 + 15];
            canObject[i].Data[3] = data[i * 24 + 16];
            canObject[i].Data[4] = data[i * 24 + 17];
            canObject[i].Data[5] = data[i * 24 + 18];
            canObject[i].Data[6] = data[i * 24 + 19];
            canObject[i].Data[7] = data[i * 24 + 20];

            canObject[i].Reserved[0] = data[i * 24 + 21];
            canObject[i].Reserved[1] = data[i * 24 + 22];
            canObject[i].Reserved[2] = data[i * 24 + 23];
        }

        return canObject;

    }
}
