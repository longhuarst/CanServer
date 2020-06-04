package com.lsxs.canserver.jna;

import com.lsxs.canserver.entity.CanRawData;
import com.lsxs.canserver.rabbitmq.CanRabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CanScheduledTask {

    @Autowired
    private Can can;

    @Autowired
    private CanRabbitService canRabbitService;


    @Scheduled(initialDelay = 1000, fixedDelay = 20)
    public void scheduledCanReceive(){
        try {
            int len = can.receiveNumber(4, 0, 0);
            if (len > 0){
                System.out.println("can 0 receive num = "+len);
                CanObject []canObject = can.receive(4, 0, 0, len);
                for (int i=0;i<canObject.length;++i){
                    System.out.println(canObject[i].toString());

                    CanRawData canRawData = new CanRawData();
                    canRawData.setBusid(canObject[i].ID);
                    canRawData.setExtern(canObject[i].ExternFlag == 1);
                    canRawData.setRemote(canObject[i].RemoteFlag == 1);
                    canRawData.setTimestamp(canObject[i].TimeStamp);
                    canRawData.setDlc(Integer.valueOf(canObject[i].DataLen));
                    canRawData.setData0(canObject[i].Data[0]);
                    canRawData.setData1(canObject[i].Data[1]);
                    canRawData.setData2(canObject[i].Data[2]);
                    canRawData.setData3(canObject[i].Data[3]);
                    canRawData.setData4(canObject[i].Data[4]);
                    canRawData.setData5(canObject[i].Data[5]);
                    canRawData.setData6(canObject[i].Data[6]);
                    canRawData.setData7(canObject[i].Data[7]);

                    canRabbitService.add(canRawData);

                }



                System.out.println(canObject.length);


            }
        }catch (CanException canException){

        }


        try {
            int len = can.receiveNumber(4, 0, 1);
            if (len > 0){
                System.out.println("can 1 receive num = "+len);
                CanObject []canObject = can.receive(4, 0, 1, len);
                for (int i=0;i<canObject.length;++i){
                    System.out.println(canObject[i].toString());

                    CanRawData canRawData = new CanRawData();
                    canRawData.setBusid(canObject[i].ID);
                    canRawData.setExtern(canObject[i].ExternFlag == 1);
                    canRawData.setRemote(canObject[i].RemoteFlag == 1);
                    canRawData.setTimestamp(canObject[i].TimeStamp);
                    canRawData.setDlc(Integer.valueOf(canObject[i].DataLen));
                    canRawData.setData0(canObject[i].Data[0]);
                    canRawData.setData1(canObject[i].Data[1]);
                    canRawData.setData2(canObject[i].Data[2]);
                    canRawData.setData3(canObject[i].Data[3]);
                    canRawData.setData4(canObject[i].Data[4]);
                    canRawData.setData5(canObject[i].Data[5]);
                    canRawData.setData6(canObject[i].Data[6]);
                    canRawData.setData7(canObject[i].Data[7]);

                    canRabbitService.add(canRawData);
                }

                System.out.println(canObject.length);
            }
        }catch (CanException canException){

        }
    }

}
