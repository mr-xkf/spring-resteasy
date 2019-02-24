/**
 * FileName: BusniessException
 * Author:   13235
 * Date:     2019/1/13 16:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.example.demo.exception;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author 13235
 * @create 2019/1/13
 * @since 1.0.0
 */
public class BusniessException extends Exception implements CommonError {

    private CommonError commonError;

    public BusniessException(CommonError commonError) {
        this.commonError = commonError;
    }

    @Override
    public Integer getErrorCode() {
        return commonError.getErrorCode();
    }

    @Override
    public String getErrorMsg() {
        return commonError.getErrorMsg();
    }

    @Override
    public CommonError setMsg(String message) {
        return commonError.setMsg(message);
    }
}
