package vn.jacob;

import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

/**
 * Hello world!
 *
 */
public class MultipleBotApp
{
    public static void main( String[] args )
    {
        final String TOKEN_2 = "7577887143:AAFv14dDADR5fwUWyOHq5Plegtf9Xs8M8gU";
        final String TOKEN = "7191381589:AAFfo6yMxtI4O1o-ozbTb7a_8Dq5LBbLey8";

        final String GROUP_ID = "-1002396520150";

        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {

            BotCommands botCommands2 = new BotCommands(TOKEN_2, GROUP_ID);
            BotCommands botCommands = new BotCommands(TOKEN, GROUP_ID);

            botsApplication.registerBot(TOKEN, botCommands);
            botsApplication.registerBot(TOKEN_2, botCommands2);

            botCommands.send("Jacob is living.");
            botCommands2.send("Jacob 2 is living.");

            Thread.currentThread().join();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
