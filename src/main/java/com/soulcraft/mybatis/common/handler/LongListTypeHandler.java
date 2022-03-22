package com.soulcraft.mybatis.common.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.util.StringUtils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 将数据库字符串映射成List<Long>
 *
 * @author Scott
 * @since 2022年03月17日
 */
public class LongListTypeHandler extends BaseTypeHandler<List<Long>> {
    private static final String DELIM = ",";

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i,
                                    List<Long> parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setLong(i, parameter.get(i));
    }

    @Override
    public List<Long> getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        String value = rs.getString(columnName);
        return stringToList(value);
    }

    private List<Long> stringToList(String value) {
        String[] strings = StringUtils.tokenizeToStringArray(value, DELIM);
        List<Long> result = new ArrayList<>();
        for (String string : strings) {
            result.add(Long.valueOf(string));
        }
        return result;
    }

    @Override
    public List<Long> getNullableResult(ResultSet rs, int columnIndex)
            throws SQLException {
        String value = rs.getString(columnIndex);
        return stringToList(value);
    }

    @Override
    public List<Long> getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        String value = cs.getString(columnIndex);
        return stringToList(value);
    }

}
