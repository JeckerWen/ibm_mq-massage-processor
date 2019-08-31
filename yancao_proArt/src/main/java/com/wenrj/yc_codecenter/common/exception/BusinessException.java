package com.wenrj.yc_codecenter.common.exception;

/**
 * @Desc: 手动封装异常类
 * @Author: WenRj
 * @Date: 2019/8/31
 */

public class BusinessException extends RuntimeException{
    private Object object;

    public BusinessException(Object obj) {
        this.object = obj;
    }

    /**
     * @Desc:获取抛出的异常对象
     * @Author: WenRj
     * @param:
     * @return:
     * @Date: 2019/8/31
     * @update:2019/8/31
     */
    public Object getObject() {
        return this.object;
    }

    @Override
    public String toString() {
        return this.object.toString();
    }
}
