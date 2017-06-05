package chat.services;

import chat.model.MessageModel;
import chat.dao.MessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MessageService {
    @Autowired
    private MessageDao messageDao;

    public void create(MessageModel message) {
        messageDao.create(message);
    }

    public void update(MessageModel message) {
        messageDao.update(message);
    }


    public MessageModel getMessageById(long id) {
        return messageDao.getMessageById(id);
    }

    public List<MessageModel> findAll() {
        return messageDao.findAll();
    }

    public void delete(long id) {
        messageDao.delete(id);
    }
}
