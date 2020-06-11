package com.eigenbaumarkt.cp2db.services.mongo;

import com.eigenbaumarkt.cp2db.services.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageService {

    @Override
    public void saveImageFile(String targetId, MultipartFile image) {

    }
}
