package SoundMedia;

import SoundPlayer.SoundPlayerAbsolute;

/**
 * Каждый носитель звука имеет свой медиа тип,
 * Что бы он мог запуститься в нужном пригрывателе
 */
public class SoundMediaAbsolute extends SoundPlayerAbsolute {
    protected String mediaType;

    /**
     * Будем искать тип через строку, что бы не вытаскивать ссылку на сам класс
     */
    public String getMediaTyper(){
        return this.mediaType;
    }
}
