public class Tamagotchi {

  private int mHealth = 30;

  private String mName;
  private int mFoodLevel=10;
  private int mSleepLevel=10;
  private int mActivityLevel=10;

  public Tamagotchi(String inName){
    //what properties? (maybe if we want types of Tamagotchis)
    mName = inName;
  }

  //get properties:
  public String getName(){ return mName; }
  public int getFoodLevel(){ return mFoodLevel; }
  public int getSleepLevel(){ return mSleepLevel; }
  public int getActivityLevel(){ return mActivityLevel; }

  //check status
  public String checkStatus(){
    return getName() +"'s  food level: "+ getFoodLevel() +" sleep level: "+ getSleepLevel() +" activity level: "+ getActivityLevel();
  }


  //check aliveness of Tamagotchi
  public boolean isAlive(){
    if (mHealth<10){
      return false;
    }
    return true;
  }


  //feed Tamagotchi
  public void feedTama(){
    if (mFoodLevel<10){
      mFoodLevel++;
    }
  }

  //put it to sleep
  public void sleepTama(){
    if (mSleepLevel<10){
      mSleepLevel++;
    }
  }

  //play with Tamagotchi
  public void playTama(){
    if (mActivityLevel<10){
      mActivityLevel++;
    }
  }


  //time passes
  public void timePasses(int timePassed) {
    mFoodLevel-=timePassed;
    mSleepLevel-=timePassed;
    mActivityLevel-=timePassed;
    mHealth = mFoodLevel + mSleepLevel + mActivityLevel;
  }

}
