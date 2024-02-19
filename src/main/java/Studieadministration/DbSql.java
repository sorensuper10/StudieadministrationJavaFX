package Studieadministration;

import java.sql.*;
import java.util.ArrayList;

public class DbSql {
    private Connection connection;
    private Statement stmt;
    private Statement stmt1;

    public DbSql() {
        connection = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:C://Databaser/Studieadministration.db";
            connection = DriverManager.getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /*public void opretStuderende(DbSql.Studerende s) {
        try {
            String sql = "insert into Studerende (Stdnr, fnavn, enavn, adresse, Postnr, telefon, Klasse)";
            sql += "values (" + String.valueOf(s.getStdnr()) + ",'" + s.getFnavn() + "','" + s.getEnavn();
            sql += "','" + s.getAdresse() + "','" + s.getPostnr() + "','" + s.getMobil() + "','";
            sql += s.getKlasse() + "')";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }*/

    public ArrayList opretStuderende(Studerende s) {
        try {
            String sql = "insert into Studerende (Stdnr, fnavn, enavn, adresse, Postnr, telefon, Klasse)";
            sql += "values (" + String.valueOf(s.getStdnr()) + ",'" + s.getFnavn() + "','" + s.getEnavn();
            sql += "','" + s.getAdresse() + "','" + s.getPostnr() + "','" + s.getMobil() + "','";
            sql += s.getKlasse() + "')";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void sletStuderende(int stdnr) {
        try {
            String sql = "delete from Studerende where stdnr = " + String.valueOf(stdnr);
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /*public void opretFag(DbSql.Fag f) {
        try {
            String sql = "insert into Fag (fagId, fagNavn)";
            sql += "values (" + String.valueOf(f.getFagnr()) + ",'" + f.getFagnavn() + "')";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }*/

    public ArrayList opretFag(Fag f) {
        try {
            String sql = "insert into Fag (fagId, fagNavn)";
            sql += "values (" + String.valueOf(f.getFagnr()) + ",'" + f.getFagnavn() + "')";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /*public void tilmeldStuderendeTilFag(DbSql.Studerende s, DbSql.Fag f) {
        try {
            String sql = "insert into Studerendefag (fagID, Karakter, StdNr)";
            sql += "values (" + String.valueOf(f.getFagnr() + ",");
            sql += String.valueOf(10) + "," + String.valueOf(s.getStdnr()) + "')";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }*/

    public ArrayList tilmeldStuderendeTilFag(Studerende s, Fag f) {
        try {
            String sql = "insert into Studerendefag (fagID, Karakter, StdNr)";
            sql += " values (" + String.valueOf(f.getFagnr() + ",");
            sql += String.valueOf(10) + "," + String.valueOf(s.getStdnr()) + ")";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /*public void frameldStuderendeFraFag(DbSql.Studerende s, DbSql.Fag f) {
        try {
            String sql = "delete from Studerendefag where fagID = " + String.valueOf(f.getFagnr()) + " And Stdnr = " + String.valueOf(s.getStdnr());
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }*/

    public ArrayList frameldStuderendeFraFag(Studerende s, Fag f) {
        try {
            String sql = "delete from Studerendefag where fagID = " + String.valueOf(f.getFagnr()) + " And Stdnr = " + String.valueOf(s.getStdnr());
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /*public void udskrivAlleStuderende() {
        try {
            String sql = "select * from DbSql.Studerende";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Connection to SQLite has been established.");
            while (rs.next()) {
                System.out.println(rs.getInt("Stdnr"));
                System.out.println(rs.getString("fnavn"));
                System.out.println(rs.getString("enavn"));
                System.out.println(rs.getString("Adresse"));
                System.out.println(rs.getString("Postnr"));
                System.out.println(rs.getString("Telefon"));
                System.out.println(rs.getString("Klasse"));
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }*/

    public ArrayList udskrivAlleStuderende() {
        ArrayList<Studerende> studliste = new ArrayList<>();
        try {
            String sql = "select * from DbSql.Studerende";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Studerende s = new Studerende();
                s.setStdnr(rs.getInt("stdnr"));
                s.setFnavn(rs.getString("fnavn"));
                s.setEnavn(rs.getString("enavn"));
                s.setAdresse(rs.getString("Adresse"));
                s.setPostnr(rs.getString("Postnr"));
                s.setMobil(rs.getString("Telefon"));
                String k = rs.getString("Klasse");
                s.setKlasse(k.charAt(0));
                studliste.add(s);
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studliste;
    }

    /*public void udskrivAlleFag() {
        try {
            String sql = "select * from DbSql.Fag";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Connection to SQLite has been established.");
            while (rs.next()) {
                System.out.println(rs.getInt("FagID"));
                System.out.println(rs.getString("fagNavn"));
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }*/

    public ArrayList udskrivAlleFag() {
        ArrayList<Fag> fagliste = new ArrayList<>();
        try {
            String sql = "select * from DbSql.Fag";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Fag f = new Fag();
                f.setFagnr(rs.getInt("fagID"));
                f.setFagnavn(rs.getString("fagNavn"));
                fagliste.add(f);
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return fagliste;
    }

    /*public void soegOplysOmStuderende(int stdnr) {
        try {
            String sql = "select * from DbSql.Studerende where stdnr =" + String.valueOf(stdnr);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Connection to SQLite has been established.");
            if (rs.next()) {
                System.out.println(rs.getInt("Stdnr"));
                System.out.println(rs.getString("fnavn"));
                System.out.println(rs.getString("enavn"));
                System.out.println(rs.getString("Adresse"));
                System.out.println(rs.getString("Postnr"));
                System.out.println(rs.getString("Telefon"));
                System.out.println(rs.getString("Klasse"));
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }*/

    public Studerende soegOplysOmStuderende(int stdnr) {
        Studerende s = new Studerende();
        s.setStdnr(stdnr);
        try {
            String sql = "select * from Studerende where stdnr =" + String.valueOf(stdnr);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                s.setStdnr(rs.getInt("Stdnr"));
                s.setFnavn(rs.getString("fnavn"));
                s.setEnavn(rs.getString("enavn"));
                s.setAdresse(rs.getString("Adresse"));
                s.setPostnr(rs.getString("Postnr"));
                s.setMobil(rs.getString("Telefon"));
                String k = rs.getString("Klasse");
                s.setKlasse(k.charAt(0));
                return s;
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Studerende soegAlleOplysOmStuderende(int stdnr) {
        Studerende s = new Studerende();
        s = soegOplysOmStuderende(stdnr);
        try {
            String sql = "select * from Studerendefag inner join fag on Studerendefag.fagID = fag.fagID where Studerendefag.stdnr =" + String.valueOf(stdnr);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Fag f = new Fag();
                f.setFagnavn(rs.getString("fagnavn"));
                s.tilmeldteFag.add(f);
            }
            return s;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    /*public void soegOplysOmFag(int fagnr) {
        try {
            String sql = "select * from DbSql.Fag where fagID =" + String.valueOf(fagnr);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Connection to SQLite has been established.");
            if (rs.next()) {
                System.out.println(rs.getInt("FagID"));
                System.out.println(rs.getString("fagNavn"));
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/

    public Fag soegOplysOmFag(int fagnr) {
        Fag f = new Fag();
        f.setFagnr(fagnr);
        try {
            String sql = "select * from DbSql.Fag where fagID =" + String.valueOf(fagnr);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                f.setFagnr(rs.getInt("fagID"));
                f.setFagnavn(rs.getString("fagNavn"));
                return f;
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public ArrayList<Studerende> alleoplysninger() {
        ArrayList<Studerende> tabel = new ArrayList<Studerende>();
        // String sql = "SELECT * from studerende left join studfag on studerende.stdnr=studfag.stdnr left join fag on studfag.fagnr=fag.fagnr order by stdnr";
        String sql = "select * from studerende";
        try {
            Statement stmt = connection.createStatement();
            Statement stmt1 = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Studerende s = new Studerende();
                int nr = rs.getInt("stdnr");
                s.setStdnr(nr);
                s.setFnavn(rs.getString("fnavn"));
                s.setEnavn(rs.getString("enavn"));
                s.setAdresse(rs.getString("adresse"));
                s.setPostnr(rs.getString("postnr"));
                s.setMobil(rs.getString("Telefonnr"));
                String k = rs.getString("Klasse");
                s.setKlasse(k.charAt(0));
                String sql1 = "SELECT * from StuderendeFag left join fag on StuderendeFag.fagId=fag.fagId where StuderendeFag.stdnr="+nr;
                ResultSet rs1 = stmt1.executeQuery(sql1);
                while (rs1.next()) {
                    Fag f = new Fag();
                    f.setFagnr(rs1.getInt("fagID"));
                    f.setFagnavn(rs1.getString("fagnavn"));
                    s.tilmeldteFag.add(f);
                }
                tabel.add(s);
            }
            stmt.close();
            stmt1.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tabel;
    }
}
