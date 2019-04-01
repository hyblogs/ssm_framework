package com.ssm.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 运行发向生成实体类
 */
public class GeneratorMain {
	/**
	 * 运行反向生成实体
	 * @param args
	 * @throws Exception
	 */
    public static void main(String[] args) {
        List<String> warnings = new ArrayList<String>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config;
		try {
			//在配置文件generatorConfig.xml中配置要进行反向生成的数据库表
			config = cp.parseConfiguration(GeneratorMain.class.getResourceAsStream("/generator/generatorConfig.xml"));
			BlogsShellCallBack callback = new BlogsShellCallBack();
			//model 先删除
			File directory = callback.getDirectory(config.getContext("Mysql").getJavaModelGeneratorConfiguration().
			getTargetProject(),config.getContext("Mysql").getJavaModelGeneratorConfiguration().getTargetPackage());
			File[] files = directory.listFiles();
			assert files != null;
			for (File file : files) {
			   file.delete();
		   	}
	       	MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		   	myBatisGenerator.generate(null);
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
}
