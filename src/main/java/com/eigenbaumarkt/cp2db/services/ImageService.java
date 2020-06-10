package com.eigenbaumarkt.cp2db.services;

import com.eigenbaumarkt.cp2db.domain.Image;

import java.util.List;

public interface ImageService {

    Image getImage(String id);

    List<Image> listImages();
}
