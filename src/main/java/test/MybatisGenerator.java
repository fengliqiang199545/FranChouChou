package test;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MybatisGenerator {



    public static void main(String[] args) {

        try {
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;

            //制定mybatis 的配置文件
            File configFile = new File("src/main/resources/mybatis/MBG.xml");

            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration configuration = cp.parseConfiguration(configFile);

            DefaultShellCallback callback = new DefaultShellCallback(overwrite);

            MyBatisGenerator mybatisGenerator = new MyBatisGenerator(configuration,callback,warnings);

            mybatisGenerator.generate(null);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
