package nl.secondchance.smartagenda.Models;

/**
 * Created by daangrootenboer on 20-04-16.
 */
public class Reservation {
    private String mRoom;
    private String mDate;
    private String mBtime;
    private String mEtime;
    private String mScenario;

    public String getRoom() {
        return mRoom;
    }

    public void setRoom(String room) {
        mRoom = room;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
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
