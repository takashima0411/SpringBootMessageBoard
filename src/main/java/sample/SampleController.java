package sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import sample.service.BoardService;
import sample.service.MessageService;

@Controller
@RequestMapping("/")
public class SampleController {

    @Autowired
    MessageService messageService;

    @Autowired
    BoardService boardService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("boards",boardService.findAll());
        return "hello";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(Model model, @RequestParam("title") String title) {
        boardService.save(title);
        model.addAttribute("boards",boardService.findAll());
        return "hello";

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String board(Model model,@PathVariable long id){
        model.addAttribute("board",boardService.find(id));
        return "board";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public String write(Model model,@PathVariable long id,@RequestParam("message") String message) {
        boardService.write(id,message);
        model.addAttribute("board", boardService.find(id));
        return "board";
    }

}