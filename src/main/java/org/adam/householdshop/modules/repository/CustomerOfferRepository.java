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

import org.adam.householdshop.Projection;
import org.adam.householdshop.modules.finder.OfferRepository;

@Stateless
public class CustomerOfferRepository implements OfferRepository {

	/** Wstrzyknięcie zależności z JNDI" */
	@Resource(mappedName = "householdshop")
	private DataSource datasource;

	@Override
	public Map<String, Map<String, Object>> findAll(Projection projection) {
		String query = "select " + projection.toString() + " from offer_finder join adress";

		/** try-with-resource Java 7 */
		try (Connection con = datasource.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {

			try (ResultSet rs = ps.executeQuery();) {
				Map<String, Map<String, Object>> resultMap = new HashMap<String, Map<String, Object>>();
				String offerId = "";
				while (rs.next()) {
					Map<String, Object> tmpMap = new HashMap<String, Object>();
					for (String field : projection.getFields()) {
						if (field.equals("offer_id"))
							offerId = rs.getString(field);
						else
							tmpMap.put(field, rs.getObject(field));
					}
					resultMap.put(offerId, tmpMap);
				}
				return resultMap;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<String, Object> findOne(UUID id, Projection projection) {
		String query = "select " + projection.toString() + " from offer_finder join adress where offer_id = " + id;

		/** try-with-resource Java 7 */
		try (Connection con = datasource.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {

			try (ResultSet rs = ps.executeQuery();) {
				Map<String, Object> resultMap = new HashMap<String, Object>();
				String offerId = "";
				while (rs.next()) {
					for (String field : projection.getFields()) {
						if (field.equals("offer_id"))
							offerId = rs.getString(field);
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

}
