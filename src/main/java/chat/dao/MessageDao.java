package chat.dao;

import chat.model.MessageModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MessageDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void create(MessageModel message) {
        entityManager.persist(message);
    }


    public void update(MessageModel message) {
        entityManager.merge(message);
    }


    public MessageModel getMessageById(long id) {
        return entityManager.find(MessageModel.class, id);
    }

    public List<MessageModel> findAll() {
        return entityManager.createQuery("from " + MessageModel.class.getSimpleName()).getResultList();
    }

    public void delete(long id) {
        MessageModel message = getMessageById(id);
        if (message != null) {
            entityManager.remove(message);
        }
    }
}
