package com.joya.image.service;

import java.util.List;

import com.joya.image.domain.Images;

public interface ImageService {
	
	public void create(Images image);
	public  List<Images> listAll();
	public  Images search(String filename);
}
