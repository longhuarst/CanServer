package com.lsxs.canserver.entity;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
//@Builder
@Entity
@Table(name = "CanRawData")
@EntityListeners(AuditingEntityListener.class)
public class CanRawData implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "busid")
    Integer busid;

    @Column(name = "dlc")
    Integer dlc;

    @Column(name = "data0")
    Byte data0;

    @Column(name = "data1")
    Byte data1;

    @Column(name = "data2")
    Byte data2;

    @Column(name = "data3")
    Byte data3;

    @Column(name = "data4")
    Byte data4;

    @Column(name = "data5")
    Byte data5;

    @Column(name = "data6")
    Byte data6;

    @Column(name = "data7")
    Byte data7;

    @Column(name = "timestamp")
    Integer timestamp;

    @Column(name = "extern")
    Boolean extern;

    @Column(name = "remote")
    Boolean remote;

    @CreatedDate
    Date date;
}
