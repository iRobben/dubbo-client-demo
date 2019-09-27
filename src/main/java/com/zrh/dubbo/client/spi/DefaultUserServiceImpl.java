package com.zrh.dubbo.client.spi;

/**
 * <p>
 *
 * </p>
 *
 * @author zhangrenhua
 * @date 2019/9/27
 */
public class DefaultUserServiceImpl implements IUserService{
    @Override
    public String sayName() {
        return "zhangrenhua";
    }
}
