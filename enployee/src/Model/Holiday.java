package Model;

import java.util.Date;

import javax.swing.table.DefaultTableModel;

public class Holiday {
    private int id;
    private String employee;
    private Date startDate;
    private Date endDate;
    private HolidayType type;
    private String reason;

    public Holiday(int id, String employee, Date startDate, Date endDate, HolidayType type, String reason) {
        this.id = id;
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
        this.reason = reason;
    }

    public Holiday(int int1, java.sql.Date date, java.sql.Date date2, String reason2, int employeeId) {
		// TODO Auto-generated constructor stub
	}

	// Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public HolidayType getType() {
        return type;
    }

    public void setType(HolidayType type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

   
    
    public enum HolidayType {
    	CONGE_PAYEE,
    	CONGE_NON_PAYEE,
    	CONGE_MALADIE;

		 public DefaultTableModel getModel() {
			// TODO Auto-generated method stub
			return null;
		}
    }



	public void deleteHoliday(int id2) {
		// TODO Auto-generated method stub
		
	}

	public Object getAllHolidays() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteHoliday(Holiday holiday) {
		// TODO Auto-generated method stub
		
	}

	public void updateHoliday(Holiday holiday) {
		// TODO Auto-generated method stub
		
	}
}