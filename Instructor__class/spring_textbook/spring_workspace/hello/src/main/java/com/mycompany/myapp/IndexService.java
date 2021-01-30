package com.mycompany.myapp;

import org.springframework.stereotype.Service;

@Service
public class IndexService implements IIndexService {

	@Override
	public String message() {
		
		return "Hello Spring";
	}


}
