package com.example.simpleclothesapp;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.util.ArrayList;

public class SimpleClothesController {
    private final String basePath = "src/main/resources/Clothes/";
    private final String[] categories = {"hat", "top", "bottom", "shoes", "bracelet", "sunglasses"};
    private final ArrayList<Image>[] images = new ArrayList[categories.length];
    private final int[] currentIndex = new int[categories.length];

    @FXML private ImageView hatImageView;
    @FXML private ImageView topImageView;
    @FXML private ImageView bottomImageView;
    @FXML private ImageView shoesImageView;
    @FXML private ImageView braceletImageView;
    @FXML private ImageView sunglassesImageView;

    @FXML
    public void initialize() {
        for (int i = 0; i < categories.length; i++) {
            images[i] = loadImages(categories[i]);
            currentIndex[i] = 0;
        }
        updateImageViews();
    }

    private ArrayList<Image> loadImages(String category) {
        ArrayList<Image> imageList = new ArrayList<>();
        File dir = new File(basePath + category);
        if (dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                if (file.isFile() && (file.getName().endsWith(".jpg") || file.getName().endsWith(".png"))) {
                    System.out.println("Loading image: " + file.toURI().toString());
                    imageList.add(new Image(file.toURI().toString()));
                }
            }
        }
        return imageList;
    }

    private void updateImageViews() {
        if (!images[0].isEmpty()) hatImageView.setImage(images[0].get(currentIndex[0]));
        if (!images[1].isEmpty()) topImageView.setImage(images[1].get(currentIndex[1]));
        if (!images[2].isEmpty()) bottomImageView.setImage(images[2].get(currentIndex[2]));
        if (!images[3].isEmpty()) shoesImageView.setImage(images[3].get(currentIndex[3]));
        if (!images[4].isEmpty()) braceletImageView.setImage(images[4].get(currentIndex[4]));
        if (!images[5].isEmpty()) sunglassesImageView.setImage(images[5].get(currentIndex[5]));
    }

    @FXML
    protected void onNextHatClick() {
        currentIndex[0] = (currentIndex[0] + 1) % images[0].size();
        hatImageView.setImage(images[0].get(currentIndex[0]));
    }

    @FXML
    protected void onNextTopClick() {
        currentIndex[1] = (currentIndex[1] + 1) % images[1].size();
        topImageView.setImage(images[1].get(currentIndex[1]));
    }

    @FXML
    protected void onNextBottomClick() {
        currentIndex[2] = (currentIndex[2] + 1) % images[2].size();
        bottomImageView.setImage(images[2].get(currentIndex[2]));
    }

    @FXML
    protected void onNextShoesClick() {
        currentIndex[3] = (currentIndex[3] + 1) % images[3].size();
        shoesImageView.setImage(images[3].get(currentIndex[3]));
    }

    @FXML
    protected void onNextBraceletClick() {
        currentIndex[4] = (currentIndex[4] + 1) % images[4].size();
        braceletImageView.setImage(images[4].get(currentIndex[4]));
    }

    @FXML
    protected void onNextSunglassesClick() {
        currentIndex[5] = (currentIndex[5] + 1) % images[5].size();
        sunglassesImageView.setImage(images[5].get(currentIndex[5]));
    }
}
