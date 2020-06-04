package com.lsxs.canserver.controller;


import com.lsxs.canserver.jna.Can;
import com.lsxs.canserver.jna.CanException;
import com.lsxs.canserver.jna.CanObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/can")
public class CanController {

    @Autowired
    private Can can;



    @RequestMapping("/open")
    public String open(){
        try {
            can.open(4, 0);
        }catch (CanException canException){
            return new String(canException.getMessage());
        }
        return "打开成功";
    }


    @RequestMapping("/close")
    public String close(){
        return "";
    }


    @RequestMapping("/init")
    public String init(int canx){
        if (canx >= 0 && canx <= 1){
            try {
                can.init(4, 0, canx);
                return "初始化成功";
            }catch (CanException canException){
                return canException.getMessage();
            }
        }
        return "can index not found";
    }


    @RequestMapping("/start")
    public String start(int canx){
        if (canx >= 0 && canx <= 1){
            try {
                can.start(4, 0, canx);
                return "开始成功";
            }catch (CanException canException){
                return canException.getMessage();
            }
        }
        return "can index not found";
    }


    @RequestMapping("/transmit")
    public String transmit(int canx, int id, byte[] data){
        if (canx >= 0 && canx <= 1){
            try {
                int dlc = data.length;
                if (dlc >= 8) {dlc = 8;}
                CanObject canObject = new CanObject();
                canObject.ID = id;
                canObject.RemoteFlag = 0;
                canObject.ExternFlag = 0;
                canObject.DataLen = (byte)dlc;
                canObject.Reserved = new byte[3];
                if (data.length <= 8) {
                    canObject.Data = data;
                } else {
                    canObject.Data = new byte[8];
                    for (int i=0;i<8;++i){
                        canObject.Data[i] = data[i];
                    }
                }

                System.out.println(canObject);

                CanObject [] sendArray = new CanObject[1];
                sendArray[0] = canObject;
                can.transmit(4, 0, canx,sendArray ,1);

                return "发送成功";
            }catch (CanException canException){
                return canException.getMessage();
            }
        }
        return "can index not found";
    }



    @RequestMapping("/transmit2")
    public String transmit2(int canx, int id, byte[] data, int length){
        if (canx >= 0 && canx <= 1){
            try {
                int dlc = data.length;
                if (dlc >= 8) {dlc = 8;}



                CanObject []canObject = new CanObject[length];


                System.out.println("canobject length = "+ canObject.length);


                for (int i=0;i<canObject.length; ++i){
                    canObject[i] = new CanObject();
                }
                for (int i=0;i<length; ++i){
                    data[0] = (byte)i;
                    canObject[i].ID = id+i;
                    canObject[i].RemoteFlag = 0;
                    canObject[i].ExternFlag = 0;
                    canObject[i].DataLen = (byte)dlc;
                    canObject[i].Reserved = new byte[3];


                    canObject[i].Data = new byte[8];
                    for (int j=0;j<dlc;++j){
                        canObject[i].Data[j] = data[j];
                    }
                }

//
                for (int i =0 ;i<canObject.length; ++i){

                    CanObject [] sendArray = new CanObject[1];
                    sendArray[0] = canObject[i];
//                    System.out.println("transmit = "+canObject[i].toString());
                    can.transmit(4, 0, canx,sendArray ,1);
                }

                return "发送成功";
            }catch (CanException canException){
                return canException.getMessage();
            }
        }
        return "can index not found";
    }

    @RequestMapping("/receive")
    public String receive(int canx){
        if (canx >= 0 && canx <= 1){
            try{
                CanObject [] canObject = can.receive(4, 0, canx, 1);
                String res = "";
                for (int i=0;i<canObject.length; ++i){
                    System.out.println(canObject.toString());
                    res += "接收成功 : id = "+canObject[i].ID+"  |  dlc = "+canObject[i].DataLen + "  |  data = [ ";
                    for (int j=0;j<canObject[i].DataLen; ++j){
                        res += canObject[i].Data[j];
                        if (i != canObject[i].DataLen - 1){
                            res += " , ";
                        }
                    }
                    res += " ] \r\n";


                }

                return res;
            }catch (CanException canException){
                return canException.getMessage();
            }
        }
        return "can index not found";
    }


    @RequestMapping("/test")
    public String test(){
        System.out.println(open());
        System.out.println(init(0));
        System.out.println(init(1));

        System.out.println(start(0));
        System.out.println(start(1));
        byte a[] ={1, 2, 3, 4, 5};
        System.out.println(transmit(0, 1235, a));

        System.out.println(receive(1));

        return "null";

    }
}
