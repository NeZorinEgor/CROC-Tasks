package SoundPlayer;

import Contracts.PlaySound;
import Songs.*;

public class UNIVERSALPlayer extends SoundPlayerAbsolute implements PlaySound {
    public UNIVERSALPlayer(){
        this.suportMediaType = "UNIVERSAL";
    }
    @Override
    public void playSong(Song song){
            System.out.println(song.getGroupName() + " - " + song.getSongTitle() + " on: " + getSuportMediaType());
        }
    }

