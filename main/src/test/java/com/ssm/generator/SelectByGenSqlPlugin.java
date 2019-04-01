package com.ssm.generator;


import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

/**
 * Copyright: Copyright (c) 2018 HuangYong
 *
 * @ClassName: SelectByGenSqlPlugin
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: HY
 * @date: 2018-05-20 13:14
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-05-20   HY           v1.0.0             修改原因
 */
public class SelectByGenSqlPlugin extends PluginAdapter {

    /**
     * {@inheritDoc}
     */
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {

        String tableName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();//数据库表名

        List<IntrospectedColumn> columns = introspectedTable.getAllColumns();
        StringBuilder sql = new StringBuilder();
        sql.append("<!-- \r\n");
        sql.append("    WARNING - @mbg.generated  \r\n");
        sql.append("    -->  \r\n");

        sql.append("    SELECT \r\n");

        for(IntrospectedColumn column :columns){
            sql.append("        ");
            sql.append(column.getActualColumnName());
            sql.append(" AS ");
            sql.append(column.getJavaProperty());
            sql.append(" , \r\n");
        }
        sql.deleteCharAt(sql.length()-4);

        sql.append("    FROM \r\n");
        sql.append("        ");
        sql.append(tableName);

        XmlElement parentElement = document.getRootElement();

        // 产生分页语句前半部分
        XmlElement deleteLogicByIdsElement = new XmlElement("select");
        deleteLogicByIdsElement.addAttribute(new Attribute("id", "selectByGen"));



        deleteLogicByIdsElement.addElement(new TextElement(sql.toString()));

        parentElement.addElement(deleteLogicByIdsElement);

        return super.sqlMapDocumentGenerated(document, introspectedTable);
    }

}
