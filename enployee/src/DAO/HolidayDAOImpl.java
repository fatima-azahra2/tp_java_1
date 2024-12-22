package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Holiday;

public class HolidayDAOImpl implements GenericDAOI<Holiday> {
    private Connection conn;

    public HolidayDAOImpl() {
        this.conn = conn;
    }

    @Override
    public void add(Holiday holiday) {
        String query = "INSERT INTO Holiday(start_date, end_date, reason, employee_id) VALUES(?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDate(1, (Date) holiday.getStartDate());
            stmt.setDate(2, (Date) holiday.getEndDate());
            stmt.setString(3, holiday.getReason());
            stmt.setString(4, holiday.getEmployee());
            stmt.executeUpdate();
            System.out.println("Holiday added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding holiday!");
            e.printStackTrace();
        }
    }

    @Override
    public void update(Holiday holiday, int id) {
        String query = "UPDATE Holiday SET start_date = ?, end_date = ?, reason = ?, employee_id = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDate(1, (Date) holiday.getStartDate());
            stmt.setDate(2, (Date) holiday.getEndDate());
            stmt.setString(3, holiday.getReason());
            stmt.setString(4, holiday.getEmployee());
            stmt.setInt(5, id);
            stmt.executeUpdate();
            System.out.println("Holiday updated successfully!");
        } catch (SQLException e) {
            System.out.println("Error updating holiday!");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Holiday WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Holiday deleted successfully!");
        } catch (SQLException e) {
            System.out.println("Error deleting holiday!");
            e.printStackTrace();
        }
    }

    @Override
    public List<Holiday> findAll() {
        List<Holiday> holidays = new ArrayList<>();
        String query = "SELECT * FROM Holiday";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                holidays.add(new Holiday(
                    rs.getInt("id"),
                    rs.getDate("start_date"),
                    rs.getDate("end_date"),
                    rs.getString("reason"),
                    rs.getInt("employee_id")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving holidays!");
            e.printStackTrace();
        }
        return holidays;
    }

	@Override
	public Holiday getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}