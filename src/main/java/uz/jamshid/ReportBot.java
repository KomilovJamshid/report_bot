package uz.jamshid;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class ReportBot extends TelegramLongPollingBot {
    private String username = "report_test_blabla_bot";
    private String token = "5227121580:AAFC5c0BNKUfnpPD7-5JwIWUdYHCP7nFTUA";

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message.hasText()) {
                String text = message.getText();
                if (text.equals("/start")) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("Welcome to OSON report bot!");
                    sendMessage.setParseMode(ParseMode.MARKDOWN);
                    sendMessage.setChatId(String.valueOf(message.getChatId()));

                    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                    replyKeyboardMarkup.setResizeKeyboard(true);
                    replyKeyboardMarkup.setOneTimeKeyboard(true);

                    List<KeyboardRow> keyboardRowList = new ArrayList<>();
                    KeyboardRow keyboardRow = new KeyboardRow();

                    KeyboardButton keyboardButton1 = new KeyboardButton();
                    keyboardButton1.setText("Agent balance");

                    KeyboardButton keyboardButton2 = new KeyboardButton();
                    keyboardButton2.setText("Merchant balance");

                    keyboardRow.add(keyboardButton1);
                    keyboardRow.add(keyboardButton2);

                    keyboardRowList.add(keyboardRow);

                    replyKeyboardMarkup.setKeyboard(keyboardRowList);

                    sendMessage.setReplyMarkup(replyKeyboardMarkup);


                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals("Agent balance")) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setParseMode(ParseMode.MARKDOWN);
                    sendMessage.setChatId(String.valueOf(message.getChatId()));

                    ArrayList<Integer> balanceList = new ArrayList<>();
                    for (int i = 1000; i < 1020; i++) {
                        balanceList.add(i);
                    }

                    String balance = "";
                    for (int i = 1; i < 21; i++) {
                        balance += i + " agent's balance is $" + balanceList.get(i - 1) + "\n";
                    }

                    sendMessage.setText(balance);

                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals("Merchant balance")) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setParseMode(ParseMode.MARKDOWN);
                    sendMessage.setChatId(String.valueOf(message.getChatId()));

                    ArrayList<Integer> balanceList = new ArrayList<>();
                    for (int i = 1000; i < 1020; i++) {
                        balanceList.add(i);
                    }

                    StringBuilder balance = new StringBuilder();
                    for (int i = 1; i < 21; i++) {
                        balance.append(i).append(" merchant's balance is $").append(balanceList.get(i - 1)).append("\n");
                    }

                    sendMessage.setText(balance.toString());

                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}