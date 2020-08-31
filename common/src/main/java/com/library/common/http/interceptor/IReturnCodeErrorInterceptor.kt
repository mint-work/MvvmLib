package com.library.common.http.interceptor

/**
 * @author yangbw
 * @date 2020/8/31
 * module： 接口请求ReturnCode不正确的情况拦截处理
 * description：
 */
interface IReturnCodeErrorInterceptor {
    /**
     * 根据返回的returnCode，判断是否进行拦截
     *
     * @param returnCode
     * @return
     */
    fun intercept(returnCode: String?): Boolean

    /**
     * intercept(String returnCode)方法为true的时候调用该方法
     *
     * @param returnCode
     * @param msg
     */
    fun doWork(returnCode: String?, msg: String?)
}