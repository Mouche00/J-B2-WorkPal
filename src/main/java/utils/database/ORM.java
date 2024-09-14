package utils.database;

import utils.Reflection;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ORM {

    public static <T> void save(T entity) throws SQLException, IllegalAccessException {
        Class<?> clazz = entity.getClass();
        List<Field> fields = Reflection.getAllDeclaredFields(clazz);
        int i = -1;
        for (Field field : fields) {
            i++;
            field.setAccessible(true);
            if(field.getName().toLowerCase().equals("id")){
                break;
            }
        }
        fields.remove(i);

        String tableName = clazz.getSimpleName().toLowerCase() + "s";

        StringBuilder sql = new StringBuilder("INSERT INTO ").append(tableName).append(" (");
        StringBuilder values = new StringBuilder(" VALUES (");

        for (Field field : fields) {
            field.setAccessible(true);
            sql.append(field.getName()).append(", ");
            if(field.getName().toLowerCase().contains("id")){
                values.append("?::uuid, ");
            } else {
                values.append("?, ");
            }
        }

        sql.setLength(sql.length() - 2);
        values.setLength(values.length() - 2);
        sql.append(")").append(values).append(")");

        try (Connection conn = JdbcConnection.getConnection().get();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

            int index = 1;
            for (Field field : fields) {
                pstmt.setObject(index++, field.get(entity));
            }
            pstmt.executeUpdate();
        }
    }

    public static <T> T find(Class<T> clazz, int id) throws SQLException, InstantiationException, IllegalAccessException {
        String tableName = clazz.getSimpleName().toLowerCase()  + "s";
        String sql = "SELECT * FROM " + tableName + " WHERE id = ?::uuid";

        try (Connection conn = JdbcConnection.getConnection().get();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    T entity = clazz.newInstance();
                    List<Field> fields = Reflection.getAllDeclaredFields(clazz);
                    for (Field field : fields) {
                        field.setAccessible(true);
                        field.set(entity, rs.getObject(field.getName()));
                    }
                    return entity;
                }
            }
        }
        return null;
    }

    public static <T> List<T> findAll(Class<T> clazz) throws SQLException, InstantiationException, IllegalAccessException {
        List<T> result = new ArrayList<>();
        String tableName = clazz.getSimpleName().toLowerCase() + "s";
        String sql = "SELECT * FROM " + tableName;

        try (Connection conn = JdbcConnection.getConnection().get();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                T entity = clazz.newInstance();
                List<Field> fields = Reflection.getAllDeclaredFields(clazz);
                for (Field field : fields) {
                    field.setAccessible(true);
                    field.set(entity, rs.getObject(field.getName()));
                }
                result.add(entity);
            }
        }
        return result;
    }

    public static <T> void update(T entity) throws SQLException, IllegalAccessException {
        Class<?> clazz = entity.getClass();
        List<Field> fields = Reflection.getAllDeclaredFields(clazz);
        String tableName = clazz.getSimpleName().toLowerCase() + "s";
        StringBuilder sql = new StringBuilder("UPDATE ").append(tableName).append(" SET ");

        for (Field field : fields) {
            field.setAccessible(true);
            sql.append(field.getName()).append(" = ?, ");
        }

        sql.setLength(sql.length() - 2); // Remove last comma and space
        sql.append(" WHERE id = ?::uuid");

        try (Connection conn = JdbcConnection.getConnection().get();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {

            int index = 1;
            for (Field field : fields) {
                if (!field.getName().equals("id")) {
                    pstmt.setObject(index++, field.get(entity));
                }
            }
            Field idField = clazz.getDeclaredField("id");
            idField.setAccessible(true);
            pstmt.setObject(index, idField.get(entity));

            pstmt.executeUpdate();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static <T> void delete(Class<T> clazz, int id) throws SQLException {
        String tableName = clazz.getSimpleName().toLowerCase() + "s";
        String sql = "DELETE FROM " + tableName + " WHERE id = ?::uuid";

        try (Connection conn = JdbcConnection.getConnection().get();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}