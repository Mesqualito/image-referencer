package com.eigenbaumarkt.cp2db.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    void saveImageFile(String targetId, MultipartFile image);
}
