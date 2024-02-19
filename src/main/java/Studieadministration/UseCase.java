package Studieadministration;

public class UseCase {

    public Studerende soegStamOplysninger(int stdnr) {
        Studerende s;
        DbSql db = new DbSql();
        s = db.soegAlleOplysOmStuderende(stdnr);
        return s;
    }
}

