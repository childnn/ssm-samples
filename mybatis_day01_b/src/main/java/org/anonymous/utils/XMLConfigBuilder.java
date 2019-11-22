package org.anonymous.utils;

import org.anonymous.domain.Configuration;
import org.anonymous.domain.Mapper;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author child
 * 2019/4/9 21:58
 * 加载 数据库连接核心配置文件: SqlMapConfig.xml
 * 得到数据库连接的相关信息及 sql 执行信息 -- 封装 Configuration 对象
 *   数据库连接相关信息:
 *      驱动/url/数据库连接用户名/密码
 *   sql 执行信息:
 *      sql 语句 + resultType
 */
@SuppressWarnings("unchecked")
public abstract class XMLConfigBuilder {
    public static Configuration builderConfiguration(InputStream is) throws DocumentException {
        Configuration configuration = new Configuration();
        //解析并封装: Configuration
        SAXReader saxReader = new SAXReader();
//        InputStream is = getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        Document document = saxReader.read(is);
        Element root = document.getRootElement();
        List<Element> list = root.selectNodes("//property");

        for (Element e : list) {
            //解析 数据库连接核心配置文件(SqlMapConfig.xml): 将指定 name 属性的 value 值 赋值给
            //数据库连接核心配置文件对象(Configuration 对象): driver/url/username
            String name = e.attributeValue("name");
            String value = e.attributeValue("value");

            //同 name 则 设置 对应的 value
            if ("driver".equals(name)) {
                configuration.setDriver(value);
            }
            if ("url".equals(name)) {
                configuration.setUrl(value);
            }
            if ("username".equals(name)) {
                configuration.setUsername(value);
            }
            if ("password".equals(name)) {
                configuration.setPassword(value);
            }
        }
        // 对 sql 的 map 集合赋值
        Map<String, Mapper> mappers = new HashMap<>();
        // 解析 sql 语句的配置文件
        Element mappersElement = root.element("mappers");
        if (null != mappersElement) {
            List<Element> mapperElements = mappersElement.elements("mapper");
            for (Element mapperElement : mapperElements) {
                // UserMapper.xml 配置文件的相对路径
                String path = mapperElement.attributeValue("resource");
                // 将每一个 sql 配置文件中的 map 集合存入到大的 map 中
                mappers.putAll(loadXmlForMapper(path));
            }
        }
        // 给 configuration 对象的 mappers 属性赋值
        configuration.setMappers(mappers);
        return configuration;
    }

    // 封装 sql 映射配置文件对象: Map<String, Mapper>  -- Mapper: sql 语句 + resultType
    private static Map<String, Mapper> loadXmlForMapper(String path) throws DocumentException {
        //path 是 sql 配置文件的路径,将路径转化为字节流
        //类加载器加载配置文件的路径:相对于 src 的路径
        InputStream is = XMLConfigBuilder.class.getClassLoader().getResourceAsStream(path);
        //dom4j 解析
        //创建 SAXReader
        SAXReader reader = new SAXReader();
        //获取 Document 对象(xml文档)
        Document document = reader.read(is);
        // 获取根节点
        Element rootElement = document.getRootElement();
        //封装 Mapper 对象的 map
        Map<String, Mapper> map = new HashMap<String, Mapper>();

        String namespace = rootElement.attributeValue("namespace");
        List<Element> list = rootElement.elements("select");
        for (Element element : list) {
            /*
            * <mapper namespace="user"> -- 模块名: 唯一
            *   <select id="getUser" resultType="全限定名">
            *       select * from xxx //sql 语句
            *   </select>
            * </mapper>
            * */
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String sql = element.getText(); //文本即 定义的 sql 语句
            Mapper mapper = new Mapper();
            mapper.setQuerySql(sql);
            mapper.setResultType(resultType);

            //key : namespace.id -- value : Mapper 对象
            map.put(namespace + "." + id, mapper);
        }
        return map;
    }
}
