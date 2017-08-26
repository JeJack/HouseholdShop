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
	public Map<String, Object> findOne(UUID id, Projection projection) {
		String query = "select " + Projection.get(projection) + " from offer_finder where id = " + id;
		return execute(query);
	}

	private Map<String, Object> execute(String query) {
		/** try-with-resource Java 7 */
		
		try (Connection con = datasource.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {

			try (ResultSet rs = ps.executeQuery();) {
				Map<String, Map<String, Object>> resultMap = new HashMap<String, Map<String, Object>>();
				while( rs.next()) {
				    Map<String, Object> tmpMap = new HashMap<String, Object>();
				    tmpMap.put( "floor", rs.get( "floor" );
				    tmpMap.put( "number_of_rooms", rs.get( "number_of_rooms" );
				    tmpMap.put( "balcony", rs.get( "balcony" );
				    tmpMap.put( "area", rs.get( "area" );
				    tmpMap.put( "city", rs.get( "city" );
				    tmpMap.put( "street", rs.get( "street" );
				    tmpMap.put( "postal_code", rs.get( "postal_code" );
				    tmpMap.put( "house_number", rs.get( "house_numbery" );
				    resultMap.put( rs.getString( "id" ), tmpMap );
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
