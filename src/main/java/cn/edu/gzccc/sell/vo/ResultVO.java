package cn.edu.gzccc.sell.vo;

import lombok.Data;

/**
 * http请求放回的最外层对象
 */
@Data
public class ResultVO<T>{
    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 具体内容 */
    private T data;
}
