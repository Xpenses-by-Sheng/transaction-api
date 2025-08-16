package com.xpenses.transaction.common;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class SnakeCasePhysicalNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        if (name == null)
            return null;

        String newName = convertCamelCaseToSnakeCase(name.getText());
        return Identifier.toIdentifier(newName);
    }

    public String convertCamelCaseToSnakeCase(String fieldName) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : fieldName.toCharArray()) {
            if (Character.isUpperCase(c))
                stringBuilder.append("_");
            stringBuilder.append(c);
        }
        return stringBuilder.toString().toLowerCase();
    }

}
