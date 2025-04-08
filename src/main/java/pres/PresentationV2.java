package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PresentationV2 {
    public static void main(String[] args) {
        try {
            Scanner scanner=new Scanner(new File("config.txt"));
            String daoClassename= scanner.nextLine();
            Class cDao = Class.forName(daoClassename);
            IDao dao=(IDao) cDao.getConstructor().newInstance();


            String metierClassname=scanner.nextLine();
            Class cMetier = Class.forName(metierClassname);
            IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);
            System.out.println("RES="+metier.calcul());

            Method setDao=cMetier.getDeclaredMethod("setDao",IDao.class);
            setDao.invoke(metier,dao);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
