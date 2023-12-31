package SoundPlayer;

import Songs.*;
import Contracts.*;

/**
 * Класс проигрывателей, от которого будут наследоваться все отсвльные проигрыватели, определяющий у них поддерживаемый тип и метод проигрывания музыки
 */
public class SoundPlayerAbsolute implements PlaySound {
    public String suportMediaType;

    public String getSuportMediaType(){
        return suportMediaType;
    }

    /**
     * Метод для воспоизведения действия
     * Если тип проигрывателя совпадает с типом носителя звука, то все будет рабоать корректно
     * @param song
     */
    public void playSong(Song song) {
        if ((song.getMediaType()).equals(((suportMediaType)))){
            System.out.println(song.getGroupName() + " - " + song.getSongTitle() + " on: " + getSuportMediaType());
        } else {
            System.out.println("Musical type ERROR! Check MEDIA TYPE");
        }
    }

}
