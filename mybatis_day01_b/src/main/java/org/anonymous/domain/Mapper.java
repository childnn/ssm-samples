package org.anonymous.domain;

/**
 * @author child
 * 2019/4/9 21:40
 * sql 配置文件对象
 *  1. sql 语句
 *  2. 返回类型的全限定名
 */
public class Mapper {
    private String querySql;
    private String resultType;

    public String getQuerySql() {
        return querySql;
    }

    public void setQuerySql(String querySql) {
        this.querySql = querySql;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    @Override
    public String toString() {
        return "Mapper{" +
                "querySql='" + querySql + '\'' +
                ", resultType='" + resultType + '\'' +
                '}';
    }
}
