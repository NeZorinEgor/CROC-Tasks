package SoundPlayer;

import Songs.*;

public class UNIVERSALPlayer extends SoundPlayerAbsolute{
    public UNIVERSALPlayer(){
        this.suportMediaType = "UNIVERSAL";
    }
    @Override
    public void playSong(Song song){
            System.out.println(song.getGroupName() + " - " + song.getSongTitle() + " on: " + getSuportMediaType());
        }
    }
