package com.yanyun.utils.guava;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/12/15/19:51
 * @description
 */

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * Guava 限流器
 * @author linjunbo
 */
@Component
public class LimitInterceptor extends HandlerInterceptorAdapter {

    public enum LimitType {
        DROP,    //丢弃
        WAIT    //等待
    }

    /**
     * Guava 开源工具限流工具类
     * 限流器
     */
    private RateLimiter limiter;

    /**
     * 限流方式
     */
    private LimitType limitType = LimitType.DROP;

    public LimitInterceptor() {
        this.limiter = RateLimiter.create(1);
    }

    /**
     * @param tps       限流（每秒处理量）
     * @param limitType
     */
    public LimitInterceptor(int tps, LimitInterceptor.LimitType limitType) {
        this.limiter = RateLimiter.create(tps);
        this.limitType = limitType;
    }

    /**
     * @param permitsPerSecond 每秒新增的令牌数
     * @param limitType        限流类型
     */
    public LimitInterceptor(double permitsPerSecond, LimitInterceptor.LimitType limitType) {
        this.limiter = RateLimiter.create(permitsPerSecond, 1000, TimeUnit.MILLISECONDS);
        this.limitType = limitType;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (limitType.equals(LimitType.DROP)) {
            //尝试获取一个令牌,立即返回
            if (limiter.tryAcquire()) {
                return super.preHandle(request, response, handler);
            }
        }
        if (limitType.equals(LimitType.WAIT)) {
            //获取令牌 如果没有令牌则一直等待,返回等待的时间(单位为秒),没有被限流则直接返回0.0:
            double count = limiter.acquire();
            return super.preHandle(request, response, handler);
        }
        throw new APIException(500, "服务器达到请求达到上限，限流生效");//达到限流后，往页面提示的错误信息。
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    public RateLimiter getLimiter() {
        return limiter;
    }

    public void setLimiter(RateLimiter limiter) {
        this.limiter = limiter;
    }

    private class APIException extends Exception {
        public APIException(int i, String s) {
        }
    }
}
