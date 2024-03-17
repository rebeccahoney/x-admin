package com.lantu;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {

        //这里的x_user是数据库的名字
        FastAutoGenerator.create(new DataSourceConfig.Builder("jdbc:mysql://localhost:3306/x_user?allowPublicKeyRetrieval=true","root","Wcxwan582453").dbQuery(new MySqlQuery()))
                .globalConfig(builder -> {
                    builder.author("rebecca")
                            .outputDir("/Users/wangchenxi/IdeaProjects/x-admin/src/main/java");
                })
               
                .packageConfig(builder ->
                    builder.parent("com.lantu")
                            .moduleName("sys")
                            .pathInfo(Collections.singletonMap(OutputFile.xml,"/Users/wangchenxi/IdeaProjects/x-admin/src/main/resources/mapper/sys")))

                .strategyConfig(builder -> {
                    builder.addInclude("x_user,x_role,x_read,x_book") //db table name
                            .addTablePrefix("x_");
                })

                .execute();
    }
}
