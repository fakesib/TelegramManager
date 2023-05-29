package com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results;

import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.inputmessage.InputMessageContent.InputMessageContentType;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultCaptioned;
import com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResultTitled;
import com.tecknobit.telegrammanager.botapi.records.basetypes.keyboard.inline.InlineKeyboardMarkup;
import com.tecknobit.telegrammanager.botapi.records.basetypes.message.MessageEntity;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramType;
import com.tecknobit.telegrammanager.botapi.records.structures.TelegramTypeStructure;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.tecknobit.telegrammanager.botapi.records.basetypes.inline.results.parents.InlineQueryResult.InlineQueryResultType.voice;

/**
 * The {@code InlineQueryResultCachedVoice} class is useful to format a {@code Telegram}'s inline query result cached voice
 *
 * @param <T> the input content message
 * @author N7ghtm4r3 - Tecknobit
 * @apiNote see the official documentation at: <a href="https://core.telegram.org/bots/api#inlinequeryresultcachedvoice">
 * InlineQueryResultCachedVoice</a>
 * @see TelegramTypeStructure
 * @see TelegramType
 * @see InlineQueryResult
 * @see InlineQueryResultTitled
 * @see InlineQueryResultCaptioned
 */
public class InlineQueryResultCachedVoice<T extends InputMessageContentType> extends InlineQueryResultCaptioned<T> {

    /**
     * {@code voiceFileId} a valid file identifier for the voice message
     */
    private final String voiceFileId;

    /**
     * Constructor to init a {@link InlineQueryResultCachedVoice} object
     *
     * @param id:                  unique identifier for this result, 1-64 Bytes
     * @param inputMessageContent: content of the message to be sent
     * @param replyMarkup:         inline keyboard attached to the message
     * @param title:               title of the result
     * @param caption:             caption of the result to be sent
     * @param captionEntities:     list of special entities that appear in the caption, which can be specified instead of
     *                             {@link #parseMode}
     * @param parseMode:           mode for parsing entities in the result caption
     * @param voiceFileId:         a valid file identifier for the voice message
     */
    public InlineQueryResultCachedVoice(String id, T inputMessageContent, InlineKeyboardMarkup replyMarkup,
                                        String title, String caption, ArrayList<MessageEntity> captionEntities,
                                        String parseMode, String voiceFileId) {
        super(voice, id, inputMessageContent, replyMarkup, title, caption, captionEntities, parseMode);
        this.voiceFileId = voiceFileId;
    }

    /**
     * Constructor to init a {@link InlineQueryResultCachedVoice} object
     *
     * @param jInlineQueryResultCachedVoice: inline query result cached voice details as {@link JSONObject}
     */
    public InlineQueryResultCachedVoice(JSONObject jInlineQueryResultCachedVoice) {
        super(jInlineQueryResultCachedVoice);
        voiceFileId = hTelegram.getString("voice_file_id");
    }

    /**
     * Method to get {@link #voiceFileId} instance <br>
     * No-any params required
     *
     * @return {@link #voiceFileId} instance as {@link String}
     */
    public String getVoiceFileId() {
        return voiceFileId;
    }

    /**
     * Method to get an instance of this Telegram's type
     *
     * @param jItem: item details as {@link JSONObject}
     * @return instance as {@link InlineQueryResultCachedVideo<T>}
     */
    public static <T extends InputMessageContentType> InlineQueryResultCachedVideo<T> getInstance(JSONObject jItem) {
        if (jItem == null)
            return null;
        else
            return new InlineQueryResultCachedVideo<>(jItem);
    }

}
