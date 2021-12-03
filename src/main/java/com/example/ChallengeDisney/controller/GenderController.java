package com.example.ChallengeDisney.controller;

import com.example.ChallengeDisney.entity.Gender;
import com.example.ChallengeDisney.repository.GenderRepository;
import com.example.ChallengeDisney.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Enzo sosa
 */
@RestController
@RequestMapping("/gender")
public class GenderController {

    @Autowired
    private GenderService gs;

    @Autowired
    private GenderRepository gr;

    @GetMapping("/list")
    public String listGender(Model model, @RequestParam(required = false) String q) {
      
        if (q != null) {
            model.addAttribute("genero", gs.listAll(q));//si no encuentra el buscado
        } else {
            model.addAttribute("genero", gs.listAllGender());//entra en este y lista todo los generos
        }
        return "pruebaRutas";
    }

    @PostMapping("/save")
    public Gender agregarGenero(@RequestParam Gender g,
            @RequestParam(required = false) MultipartFile image) {
        return gs.createGender(g, image);
    }

    @GetMapping("/delete/{id}")
    public String eliminarGenero(@PathVariable String id, RedirectAttributes ra) {
        try {
            gs.deleteGender(id);
            ra.addFlashAttribute("success", "se ah eliminado correctamente");
        } catch (Exception e) {
            ra.addAttribute("error", e.getMessage());
        }
        return "redirect:/gender/list";
    }

}
