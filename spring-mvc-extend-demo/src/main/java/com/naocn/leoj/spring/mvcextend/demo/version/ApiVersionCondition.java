package com.naocn.leoj.spring.mvcextend.demo.version;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Rest 接口版本号控制
 * <pre>
 *     1、版本定义在url中，采用/v1/..的形式
 *     2、版本号通过{@Link ApiVersion}进行定义
 *     3、如果请求中不指定api版本号，自动适配最新版本（TODO 通过参数进行控制）
 *     4、如果请求的api版本不存在，自动适配底版本中最新版本
 * </pre>
 */
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {
    private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile("v(\\d+)/");
    private int version;

    public ApiVersionCondition(int version) {
        this.version = version;
    }

    public int getVersion() {
        return version;
    }

    @Override
    public ApiVersionCondition combine(ApiVersionCondition apiVersionCondition) {
        return new ApiVersionCondition(apiVersionCondition.getVersion());
    }

    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest httpServletRequest) {
        Matcher m = VERSION_PREFIX_PATTERN.matcher(httpServletRequest.getPathInfo());
        if (m.find()) {
            Integer version = Integer.parseInt(m.group(1));
            if (version >= this.version) {
                return this;
            }
        }
        return null;
    }

    @Override
    public int compareTo(ApiVersionCondition apiVersionCondition, HttpServletRequest httpServletRequest) {
        return apiVersionCondition.getVersion() - version;
    }
}
