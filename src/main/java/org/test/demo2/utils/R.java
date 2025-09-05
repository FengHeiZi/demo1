package org.test.demo2.utils;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class R<T>{
    private Integer code;
    private String msg;
    private T data;
    private R(){

    }
    public static R ok(){
        R r = new R();
        r.setCode(200);
        r.setMsg("请求成功");
        return r;
    }

    public static R error(){
        R r = new R();
        r.setCode(500);
        r.setMsg("请求失败");
        return r;
    }
    public R message(String msg){
        this.setMsg(msg);
        return this;
    }
    //单独封装data数据
    public R data(T value){
        this.data = value;
        return this;
    }

}
