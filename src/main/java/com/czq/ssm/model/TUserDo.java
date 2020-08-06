package com.czq.ssm.model;

import lombok.Data;

import java.io.Serializable;


@Data
public class TUserDo implements Serializable {
    private static final long serialVersionUID = 1L;
    private int uid;
    private String uName;
    private int uAge;
    private String uSex;
}


