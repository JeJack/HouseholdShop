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

import org.adam.householdshop.enums.MessageProjection;
import org.adam.householdshop.enums.Projection;
import org.adam.householdshop.modules.finder.Repository;

@Stateless
public class MessageRepository implements Repository {

	@Resource(mappedName = "householdshop")
	private DataSource datasource;
	
	@Override
	public Map<String, Map<String, Object>> findAll(Projection projection) {
		String query = "select " + projection.toString() + " from ((message_finder m join user_finder u on m.from = u.id) join offer_finder o on m.offer_id = o.id)";
		
		if (projection.equals(MessageProjection.CUSTOMER)) {
			query = "select " + projection.toString() + " from ((message_finder m join user_finder u on m.to = u.id) join offer_finder o on m.offer_id = o.id)";
		}
		
		/** try-with-resource Java 7 */
		try (Connection con = datasource.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {

			try (ResultSet rs = ps.executeQuery();) {
				Map<String, Map<String, Object>> resultMap = new HashMap<String, Map<String, Object>>();
				String messageId = "";
				while (rs.next()) {
					Map<String, Object> tmpMap = new HashMap<String, Object>();
					for (String field : projection.getFields()) {
						if (field.equals("m.id"))
							messageId = rs.getString(field);
						else
							tmpMap.put(field, rs.getObject(field));
					}
					resultMap.put(messageId, tmpMap);
				}
				return resultMap;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, Object> findOne(UUID id, Projection projection) {
		// TODO Auto-generated method stub
		return null;
	}

}
