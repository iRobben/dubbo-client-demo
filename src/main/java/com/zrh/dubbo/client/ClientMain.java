package com.zrh.dubbo.client;

import com.zrh.dubbo.client.spi.IUserService;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ServiceLoader;

/**
 * <p>
 *
 * </p>
 *
 * @author zhangrenhua
 * @date 2019/9/26
 */
public class ClientMain {
    public static void main(String[] args) {
       // Main.main(args);
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        applicationContext.start();
        //DemoService demoService = applicationContext.getBean(DemoService.class);
        while (true) {
            byte[] b = new byte[1024];
            int size = 0;
            try {
                size = System.in.read(b);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //System.out.println(demoService.sayHello("zrh"));
            //dubbo SPI
            ExtensionLoader<IUserService> extensionLoader = ExtensionLoader.getExtensionLoader(IUserService.class);
            if ("common".equals(new String(b, 0, size).trim())) {
                System.out.println(extensionLoader.getExtension("common").sayName());
            }else {
               System.out.println(extensionLoader.getDefaultExtension().sayName());
            }



            //java SPI
          /*  if ("send".equals(new String(b, 0, size).trim())) {
                ServiceLoader<IUserService> serviceLoader = ServiceLoader.load(IUserService.class);
                System.out.println("Java SPI");
                serviceLoader.forEach(p-> System.out.println(p.sayName()));
            }
*/

        }
    }
}
