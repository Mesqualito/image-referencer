package com.eigenbaumarkt.cp2db.repositories;

import com.eigenbaumarkt.cp2db.domain.Image;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ImageMongoRepositoryTest {
    @Autowired
    private ImageMongoRepository imageMongoRepository;
    @Before
    public void setUp() throws Exception {
        Image img1= new Image("Rillenkugellager", Instant.now());
        Image img2= new Image("Nadelhülse", Instant.now());
        // save image, verify has ID value after save
        assertNull(img1.getId());
        assertNull(img2.getId()); // null before save
        this.imageMongoRepository.save(img1);
        this.imageMongoRepository.save(img2);
        assertNotNull(img1.getId());
        assertNotNull(img2.getId());
    }

    @Test
    public void testFetchData(){
        /* Test data retrieval */
        Image imgA = imageMongoRepository.findByDescription("Rillenkugellager");
        assertNotNull(imgA);
        assertNotNull(imgA.getSavedAt());
        /* Get all images, list should only have two */
        Iterable<Image> images = imageMongoRepository.findAll();
        int count = 0;
        for(Image img : images){
            count++;
        }
        assertEquals(count, 2);
    }
    @Test
    public void testDataUpdate(){
        /* Test update */
        Image imgB = imageMongoRepository.findByDescription("Nadelhülse");
        imgB.setSavedAt(Instant.now());
        imageMongoRepository.save(imgB);
        Image imgC= imageMongoRepository.findByDescription("Rillenkugellager");
        assertNotNull(imgC);
    }
    @After
    public void tearDown() throws Exception {
        this.imageMongoRepository.deleteAll();
    }
}
