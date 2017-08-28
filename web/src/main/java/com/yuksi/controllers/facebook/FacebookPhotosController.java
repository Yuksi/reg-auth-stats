package com.yuksi.controllers.facebook;

/**
 * Created by Yuksi on 28.08.2017.
 */
import javax.inject.Inject;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FacebookPhotosController {

    private final Facebook facebook;

    @Inject
    public FacebookPhotosController(Facebook facebook) {
        this.facebook = facebook;
    }

    @RequestMapping(value="/facebook/albums", method=RequestMethod.GET)
    public String showAlbums(Model model) {
        model.addAttribute("albums", facebook.mediaOperations().getAlbums());
        return "facebook/albums";
    }

    @RequestMapping(value="/facebook/album/{albumId}", method=RequestMethod.GET)
    public String showAlbum(@PathVariable("albumId") String albumId, Model model) {
        model.addAttribute("album", facebook.mediaOperations().getAlbum(albumId));
        model.addAttribute("photos", facebook.mediaOperations().getPhotos(albumId));
        return "facebook/album";
    }

}