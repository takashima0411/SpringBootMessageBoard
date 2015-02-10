package sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.entity.*;
import sample.repository.BoardRepository;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    MessageService messageService;

    public Board save(String title){
        Board b = new Board();
        b.setTitle(title);
        return boardRepository.save(b);
    }

    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    public Board find(long id){
        return boardRepository.findOne(id);
    }

    public Board write(long boardId,String message){
        Board b = this.find(boardId);
        Message m = new Message();
        m.setBody(message);
        m.setBoard(b);
        messageService.save(m);
        return b;
    }

}
