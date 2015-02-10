package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sample.entity.Message;
import sample.repository.MessageRepository;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> findAll() {
        return messageRepository.findAll(new Sort(Sort.Direction.ASC,"id"));
    }

    public Message save(Message message){
        return messageRepository.save(message);
    }

    public Message save(String message){
        Message m = new Message();
        m.setBody(message);
        return messageRepository.save(m);
    }
}
