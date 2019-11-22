package org.anonymous.core;

import org.anonymous.domain.Configuration;
import org.anonymous.utils.XMLConfigBuilder;
import org.dom4j.DocumentException;

import java.io.InputStream;

/**
 * @author child
 * 2019/4/9 21:45
 * 构造者模式
 * 封装好的 Configuration 对象: driver + url + username + password + Mapper 对象
 * 创建 SqlSessionFactory 对象, 传递 Configuration 对象
 */
public class SqlSessionFactoryBuilder {

    /**
     * @param is  数据库核心配置文件 对应的 输入流
     * @return  返回 SqlSessionFactory 对象: 用来生产 SqlSession (sql)
     * @throws DocumentException
     */
    public SqlSessionFactory build(InputStream is) throws DocumentException {
        //解析配置文件封装 configuration 对象 : 工具类 -- org.anonymous.utils.XMLConfigBuilder
        Configuration configuration = XMLConfigBuilder.builderConfiguration(is);
        //创建 sqlSessionFactory 对象且传递 configuration 对象
        return new SqlSessionFactory(configuration);
    }
    /*//解析配置文件,封装 configuration  -- 将该方法 封装 工具类 -- org.anonymous.utils.XMLConfigBuilder
    private Configuration parseXML(InputStream is) throws DocumentException {
        Configuration configuration = new Configuration();
        //解析并封装
        SAXReader saxReader = new SAXReader();
//        InputStream is = getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        Document document = saxReader.read(is);
        Element root = document.getRootElement();
        List<Element> list = root.selectNodes("//property");
        for (Element e : list) {
            String name = e.attributeValue("name");
            String value = e.attributeValue("value");
            if ("driver".equals(name)) {
                configuration.setDriver(name);
            }
            if ("password".equals(name)) {
                configuration.setPassword(name);
            }
            if ("url".equals(name)) {
                configuration.setUrl(name);
            }
            if ("username".equals(name)) {
                configuration.setUsername(name);
            }
        }
        return configuration;
    }*/
}


