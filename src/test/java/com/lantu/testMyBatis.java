package com.lantu;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;

import java.util.Collections;

public class testMyBatis {
    public static void main(String[] args) {
        FastAutoGenerator.create(new DataSourceConfig.Builder("jdbc:mysql://localhost:3306/x_user?allowPublicKeyRetrieval=true","root","Wcxwan582453").dbQuery(new MySqlQuery()))
                .packageConfig(builder -> builder.parent("com.lantu")
                                
                        )

                .execute();
    }
}
