package chat.controller;

import chat.model.MessageModel;
import chat.requests.Message;
import chat.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

@Controller
public class ChatController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/chat")
    public String chat() {
        return "chat";
    }

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    @MessageMapping("/newMessage")
    @SendTo("/topic/newMessage")
    public Message save(MessageModel chatMessageModel) {
        MessageModel chatMessage = new MessageModel(chatMessageModel.getText(), chatMessageModel.getAuthor(), new Date());
        messageService.create(chatMessage);
        List<MessageModel> chatMessageModelList = messageService.findAll();
        return new Message(chatMessageModelList.toString());
    }

    @MessageMapping("/beginChat")
    @SendTo("/topic/beginChat")
    public Message beginChat(MessageModel chatMessageModel) {
        MessageModel chatMessage = new MessageModel();
        chatMessage.setText(String.format(Message.USER_LOGIN, chatMessageModel.getAuthor()));
        chatMessage.setCreateDate(new Date());
        chatMessage.setAuthor(chatMessageModel.getAuthor());
        messageService.create(chatMessage);
        List<MessageModel> chatMessageModelList = messageService.findAll();
        return new Message(chatMessageModelList.toString());
    }

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public HttpEntity list() {
        List<MessageModel> chatMessageModelList = messageService.findAll();
        return new ResponseEntity(chatMessageModelList, HttpStatus.OK);
    }
}
