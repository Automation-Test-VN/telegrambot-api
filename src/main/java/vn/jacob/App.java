package vn.jacob;

import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final String TOKEN = "7191381589:AAFfo6yMxtI4O1o-ozbTb7a_8Dq5LBbLey8";
        final String GROUP_ID = "-1002396520150";

        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {

            BotCommands botCommands = new BotCommands(TOKEN, GROUP_ID);
            botsApplication.registerBot(TOKEN, botCommands);

            botCommands.send("Jacob is living.");

            Thread.currentThread().join();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
