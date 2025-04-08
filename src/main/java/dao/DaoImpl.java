package dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class DaoImpl implements IDao {
    public DaoImpl() {
    }

    @Override
    public double getData() {
        System.out.println("Version base de donnee");
        double temp=23;
        return temp;
    }
}
