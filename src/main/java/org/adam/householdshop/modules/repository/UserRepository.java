package org.adam.householdshop.modules.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import org.adam.householdshop.enums.Projection;
import org.adam.householdshop.modules.finder.Repository;

/* TODO można wyekstrahować interfejs Repository */

@Stateless
public class UserRepository implements Repository {

	@Resource(mappedName = "householdshop")
	private DataSource datasource;

	@Override
	public Map<String, Object> findOne(UUID id, Projection projection) {
		String query = "select " + projection.toString() + " from user_finder where id = " + id;

		/** try-with-resource Java 7 */
		try (Connection con = datasource.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {

			try (ResultSet rs = ps.executeQuery();) {
				Map<String, Object> resultMap = new HashMap<String, Object>();
				String userId = "";
				while (rs.next()) {
					for (String field : projection.getFields()) {
						if (field.equals("id"))
							userId = rs.getString(field);
						else
							resultMap.put(field, rs.getObject(field));
					}
					return resultMap;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Map<String, Map<String, Object>> findAll(Projection projection) {
		String query = "select " + projection.toString() + " from user_finder";

		/** try-with-resource Java 7 */
		try (Connection con = datasource.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {

			try (ResultSet rs = ps.executeQuery();) {
				Map<String, Map<String, Object>> resultMap = new HashMap<String, Map<String, Object>>();
				String userId = "";
				while (rs.next()) {
					Map<String, Object> tmpMap = new HashMap<String, Object>();
					for (String field : projection.getFields()) {
						if (field.equals("id"))
							userId = rs.getString(field);
						else
							tmpMap.put(field, rs.getObject(field));
					}
					resultMap.put(userId, tmpMap);
				}
				return resultMap;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
