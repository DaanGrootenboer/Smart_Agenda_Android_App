package nl.secondchance.smartagenda.Models;

public class Room {
    private String mName;
    private int mCurrentTemp;
    private int mAverageTemp;
    private int mCurrentSound;
    private int mAverageSound;
    private int mCurrentLight;
    private int mAverageLight;
    private boolean mIsAvailable;
    private boolean mHasScreen;

    public Room (String name, int currentTemp, int averageTemp, int currentSound,
                 int averageSound, int currentLight, int averageLight, boolean isAvailable, boolean hasScreen) {
        this.mName = name;
        this.mCurrentTemp = currentTemp;
        this.mAverageTemp = averageTemp;
        this.mCurrentSound = currentSound;
        this.mAverageSound = averageSound;
        this.mCurrentLight = currentLight;
        this.mAverageLight = averageLight;
        this.mIsAvailable = isAvailable;
        this.mHasScreen = hasScreen;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getCurrentTemp() {
        return mCurrentTemp;
    }

    public void setCurrentTemp(int currentTemp) {
        mCurrentTemp = currentTemp;
    }

    public int getAverageTemp() {
        return mAverageTemp;
    }

    public void setAverageTemp(int averageTemp) {
        mAverageTemp = averageTemp;
    }

    public int getCurrentSound() {
        return mCurrentSound;
    }

    public void setCurrentSound(int currentSound) {
        mCurrentSound = currentSound;
    }

    public int getAverageSound() {
        return mAverageSound;
    }

    public void setAverageSound(int averageSound) {
        mAverageSound = averageSound;
    }

    public int getCurrentLight() {
        return mCurrentLight;
    }

    public void setCurrentLight(int currentLight) {
        mCurrentLight = currentLight;
    }

    public int getAverageLight() {
        return mAverageLight;
    }

    public void setAverageLight(int averageLight) {
        mAverageLight = averageLight;
    }

    public boolean isAvailable() {
        return mIsAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        mIsAvailable = isAvailable;
    }

    public boolean isHasScreen() {
        return mHasScreen;
    }

    public void setHasScreen(boolean hasScreen) {
        mHasScreen = hasScreen;
    }
}
