package cn.edu.gzccc.sell.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求放回的最外层对象(给前端的用的)
 */
@Data
public class ResultVO<T> implements Serializable{


    private static final long serialVersionUID = -207100153550590214L;
    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 具体内容 */
    private T data;
}
