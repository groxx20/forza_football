package com.forzafootball.greendao_db;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MainGenerator {

    public static void main(String[] args) {

        createConfigSchema();
    }

    private static void createConfigSchema() {

        int schemaVersion = 4;
        String dataPackage = "com.forzafootball.assignment.dbdata.db";

        Schema configSchema = new Schema(schemaVersion, dataPackage);
        configSchema.setDefaultJavaPackageDao(dataPackage + ".dao");
        configSchema.enableKeepSectionsByDefault();

        addTables(configSchema);

        try {

            DaoGenerator daoGenerator = new DaoGenerator();
            daoGenerator.generateAll(configSchema, "../app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTables(Schema schema) {

        Entity team = schema.addEntity("TeamDB");
        team.addIdProperty().primaryKey().autoincrement();
        team.addStringProperty("name");
        team.addBooleanProperty("national");
        team.addStringProperty("country_name");

    }
}
