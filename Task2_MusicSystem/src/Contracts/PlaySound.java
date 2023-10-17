package Contracts;

import Songs.Song;



/**Интерфейс
 * @deprecated Полезно, когда нас интересует поведение некоторой сущности, но совсем не интересуют детали реализации
 *
 */

public interface PlaySound { //SoundPlayer под капотом
    void playSong(Song song);
}
