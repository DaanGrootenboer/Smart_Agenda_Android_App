package nl.secondchance.smartagenda.Models;

/**
 * Created by daangrootenboer on 20-04-16.
 */
public class Reservation {
    private String mRoom;
    private String mBdate;
    private String mEdate;
    private String mBtime;
    private String mEtime;
    private String mScenario;

    public Reservation (String room, String bdate, String edate, String btime, String etime, String scenario) {
        this.mRoom = room;
        this.mBdate = bdate;
        this.mEdate = edate;
        this.mBtime = btime;
        this.mEtime = etime;
        this.mScenario = scenario;
    }

    public String getRoom() {
        return mRoom;
    }

    public void setRoom(String room) {
        mRoom = room;
    }

    public String getBdate() {
        return mBdate;
    }

    public void setBdate(String bdate) {
        mBdate = bdate;
    }

    public String getEdate() {
        return mEdate;
    }

    public void setEdate(String edate) {
        mEdate = edate;
    }

    public String getBtime() {
        return mBtime;
    }

    public void setBtime(String btime) {
        mBtime = btime;
    }

    public String getEtime() {
        return mEtime;
    }

    public void setEtime(String etime) {
        mEtime = etime;
    }

    public String getScenario() {
        return mScenario;
    }

    public void setScenario(String scenario) {
        mScenario = scenario;
    }

}
