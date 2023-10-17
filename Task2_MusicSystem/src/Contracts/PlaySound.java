package Contracts;

import Songs.Song;

//Интерфейс. Полезно, когда нас интересует поведение некоторой сущности, но совсем не интересуют детали реализации
public interface PlaySound {
    void playSong(Song song);
}
