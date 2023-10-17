package SoundPlayer;

import Contracts.PlaySound;
import Songs.*;

/**
 * Универсальному плееру все равно, какой тип носителя ему предоставит, он исполнит его
 */
public class UNIVERSALPlayer extends SoundPlayerAbsolute implements PlaySound {
    public UNIVERSALPlayer(){
        this.suportMediaType = "UNIVERSAL";
    }
    /**
     * Переопределяем метод. Универсальному плееру все равно, какой тип играть
     */
    @Override
    public void playSong(Song song){
            System.out.println(song.getGroupName() + " - " + song.getSongTitle() + " on: " + getSuportMediaType());
        }
    }

