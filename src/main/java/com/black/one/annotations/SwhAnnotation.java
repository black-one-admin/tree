package com.black.one.annotations;


import java.lang.annotation.*;


/**
 * swagger注解类swh
 * @date 2020/3/13 10:34
 * @author swh
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SwhAnnotation {

    /**
     * 操作内容
     * @return
     */
    String value() default "";
}
