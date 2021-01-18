package com.mms.thinking.in.spring.ioc.overview.dependency.injection;

import com.mms.thinking.in.spring.ioc.overview.annotaion.Super;
import com.mms.thinking.in.spring.ioc.overview.domain.User;
import com.mms.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.List;
import java.util.Map;

/**
 * 依赖注入
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        //启动spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
      //  UserRepository userRepositories = (UserRepository)beanFactory.getBean("userRepository");
      //  System.out.println(userRepositories.getUsers());


        ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        // 依赖来源一：自定义 Bean
        UserRepository userRepository = applicationContext.getBean("userRepository",UserRepository.class);

        System.out.println(userRepository.getUsers());

        // 依赖来源二：依赖注入（內建依赖）
        System.out.println( userRepository.getBeanFactory() == applicationContext);

        ObjectFactory userFactory = userRepository.getObjectFactory();

        //System.out.println(userFactory.getObject() == applicationContext);

        // 依赖查找（错误）
       // System.out.println(beanFactory.getBean(BeanFactory.class));

        // 依赖来源三：容器內建 Bean
        Environment environment = applicationContext.getBean(Environment.class);
      //  System.out.println("获取 Environment 类型的 Bean：" + environment);

    }


}
