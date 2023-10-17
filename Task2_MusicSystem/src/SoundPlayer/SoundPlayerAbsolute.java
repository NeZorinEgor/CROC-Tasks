package SoundPlayer;

import Songs.*;

public class SoundPlayerAbsolute  {
    public String suportMediaType;

    public String getSuportMediaType(){
        return suportMediaType;
    }

    public void playSong(Song song){
        if ((song.getMediaType().mediaType).equals(suportMediaType)){
            System.out.println(song.getGroupName() + " - " + song.getSongTitle() + " on: " + getSuportMediaType());
        } else {
            System.out.println("Musical type ERROR! Check media_type");
        }
    }

}
