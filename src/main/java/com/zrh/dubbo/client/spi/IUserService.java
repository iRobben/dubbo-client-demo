package com.zrh.dubbo.client.spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author zhangrenhua
 * @date 2019/9/27
 */
@SPI("default")
public interface IUserService {

    String sayName();
}
