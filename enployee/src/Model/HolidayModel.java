package Model;



import java.util.List;

import DAO.GenericDAOI;

public class HolidayModel {
    private GenericDAOI<Holiday> dao;

    public HolidayModel(GenericDAOI<Holiday> dao) {
        this.dao = dao;
    }
    

    public void addHoliday(Holiday holiday) {
        dao.add(holiday);
    }

    public void updateHoliday(Holiday holiday) {
        dao.update(holiday, 0);
    }

    public void deleteHoliday(int id) {
        dao.delete(id);
    }

   
    public Holiday getHolidayById(int id) {
        return dao.getById(id);
    }
}