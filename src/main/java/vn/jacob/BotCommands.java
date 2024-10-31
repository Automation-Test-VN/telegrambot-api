package vn.jacob;

import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

public class BotCommands implements LongPollingSingleThreadUpdateConsumer {
    protected String token;
    protected String groupId;
    protected TelegramClient telegramClient;
    public BotCommands(String token, String groupId) {
        this.token = token;
        this.groupId = groupId;
        this.telegramClient = new OkHttpTelegramClient(token);
    }

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            if (text.startsWith("/")) {
                send(text);
            }
        }
    }

    public void send(String msg) {
        SendMessage message = SendMessage
                .builder()
                .parseMode(ParseMode.MARKDOWN)
                .chatId(this.groupId)
                .text(msg)
                .build();

        try {
            this.telegramClient.execute(message);
        } catch (TelegramApiException e) {
            System.err.println("Telegram error: " + e.getMessage());
        }
    }
}
