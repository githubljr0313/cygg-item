package io.cygg.item.util;

import io.cygg.item.model.po.SkuPO;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;

public class CreateTableSqlAutoGenerate {

    private static <T> void generateTableSqlByClazz(Class<T> clazz){
        StringJoiner sqlJoiner = new StringJoiner("");
        String tableName = javaCamelConvertMysql(clazz.getSimpleName());
        sqlJoiner.add("CREATE TABLE IF NOT EXISTS `").add(tableName).add("` (");
        Field[] declaredFields = clazz.getDeclaredFields();
        Class<? super T> superclass = clazz.getSuperclass();
        if(Objects.nonNull(superclass)){
            Field[] superclassDeclaredFields = superclass.getDeclaredFields();
            for (Field field : superclassDeclaredFields) {
                buildFieldSql(sqlJoiner, field);
            }
        }
        for (Field field : declaredFields) {
            buildFieldSql(sqlJoiner, field);
        }
        sqlJoiner.add("\n\tPRIMARY KEY (`id`)\n")
                .add(") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;");
//                .add("COMMENT='Components';");
        System.out.println(sqlJoiner);
    }

    public static void main(String[] args) {
        generateTableSqlByClazz(SkuPO.class);
//        System.out.println(javaCamelConvertMysql("SKUPO"));

    }

    /**
     * Java驼峰转换mysql下划线
     * @param candidate 待转换的字符串
     * @return 转换完的字符串
     */
    public static String javaCamelConvertMysql(String candidate){
        StringBuilder builder = new StringBuilder();
        char[] strArray = candidate.toCharArray();
        for (int i = 0; i < strArray.length; i++) {
            char c = strArray[i];
            if(c >= 65 && c <= 90){
                if(i != 0 && i != strArray.length - 1){
                    builder.append("_");
                }
                builder.append((char)(c + 32));
            }else{
                builder.append(c);
            }
        }
        return builder.toString();
    }

    /**
     * Java类型转换mysql类型
     * @param typeClazz
     * @param <T>
     * @return
     */
    public static <T> String javaTypeConvertMysqlType(Class<T> typeClazz){
        if(typeClazz.equals(Date.class)){
            return "datetime";
        }else if(typeClazz.equals(String.class)){
            return "varchar(256)";
        }else if(typeClazz.equals(Long.class)){
            return "bigint(10)";
        }else if(typeClazz.equals(Integer.class)){
            return "int(10)";
        }else if(typeClazz.getSuperclass().equals(Enum.class)){
            return "varchar(256)";
        }else{
            throw new IllegalArgumentException("暂不支持该类型");
        }
    }

    /**
     * 构造Java字段SQL
     * @param sqlJoiner
     * @param field
     */
    public static void buildFieldSql(StringJoiner sqlJoiner, Field field){
        String fieldName = field.getName();
        sqlJoiner.add("\n\t`").add(javaCamelConvertMysql(fieldName)).add("` ");
        sqlJoiner.add(javaTypeConvertMysqlType(field.getType()));
        if(fieldName.equals("id")){
            sqlJoiner.add(" unsigned NOT NULL AUTO_INCREMENT,");
        }else{
            sqlJoiner.add(" DEFAULT NULL,");
        }
    }

}
