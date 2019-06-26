package sh.platform.template;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

import java.io.IOException;

import static java.util.stream.Collectors.toList;


@Controller
public class MusicController {

    @Autowired
    private MusicService musicService;

    @GetMapping("/")
    public String start(@RequestParam(name = "search", required = false) String search, Model model){

        model.addAttribute("musics", musicService.findAll(search));
        model.addAttribute("search", search);
        return "index";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("music", new Music());
        return "add-music";
    }

    @PostMapping("/add")
    public String addUser(@Valid Music music, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "add-music";
        }
        musicService.save(music);
        model.addAttribute("musics", musicService.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
        Music music = musicService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid music Id:" + id));
        model.addAttribute("music", music);
        return "add-music";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") String id, @Valid Music music, BindingResult result, Model model) {
        if (result.hasErrors()) {
            music.setId(id);
            return "add-music";
        }

        musicService.save(music);
        model.addAttribute("musics", musicService.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") String id, Model model){
        Music music = musicService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid music Id:" + id));
        musicService.delete(music);
        model.addAttribute("musics", musicService.findAll()
                .stream()
                .filter(m -> !m.getId().equals(id))
                .collect(toList()));
        return "index";
    }
}