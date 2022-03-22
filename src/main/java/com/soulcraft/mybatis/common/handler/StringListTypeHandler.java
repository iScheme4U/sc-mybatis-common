package com.soulcraft.mybatis.common.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.util.StringUtils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * 将数据库字符串映射成List<String>
 *
 * @author Scott
 * @since 2022年03月17日
 */
public class StringListTypeHandler extends BaseTypeHandler<List<String>> {
    private static final String DELIM = ",";

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i,
                                    List<String> parameter, JdbcType jdbcType)
            throws SQLException {
        String value = StringUtils.collectionToDelimitedString(parameter, DELIM);
        ps.setString(i, value);
    }

    @Override
    public List<String> getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        String value = rs.getString(columnName);
        return Arrays.asList(StringUtils.tokenizeToStringArray(value, DELIM));
    }

    @Override
    public List<String> getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        String value = rs.getString(columnIndex);
        return Arrays.asList(StringUtils.tokenizeToStringArray(value, DELIM));
    }

    @Override
    public List<String> getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        String value = cs.getString(columnIndex);
        return Arrays.asList(StringUtils.tokenizeToStringArray(value, DELIM));
    }

}
