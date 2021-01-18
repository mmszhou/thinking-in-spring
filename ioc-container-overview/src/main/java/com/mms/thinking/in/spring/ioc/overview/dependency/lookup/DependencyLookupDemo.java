package com.mms.thinking.in.spring.ioc.overview.dependency.lookup;

import com.mms.thinking.in.spring.ioc.overview.annotaion.Super;
import com.mms.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
        // lookupByName(beanFactory);
        // lookupByNameInLazy(beanFactory);
         lookupByType(beanFactory);

        // lookupCollectionByType(beanFactory);

        //lookupByAnnotaion(beanFactory);

    }


    /**
     * 根据名称查找
     *
     * @param beanFactory
     */
    private static void lookupByName(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("名称查找:" + user);
    }

    /**
     * 根据名称查找(延迟查找)
     *
     * @param beanFactory
     */
    private static void lookupByNameInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找 :" + user);
    }

    /**
     * 根据类型查找
     *
     * @param beanFactory
     */
    private static void lookupByType(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean(User.class);
        System.out.println("类型查找:" + user);
    }

    /**
     * 根据类型查找 集合bean对象
     *
     * @param beanFactory
     */
    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("类型查找bean集合对象:" + users);

        }
    }

    /**
     * 查找标注 @Super 所有的 User 集合对象
     * @param beanFactory
     */
    private static void lookupByAnnotaion(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String,User>  users = (Map)listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("按注解:" + users);

        }


    }
}
