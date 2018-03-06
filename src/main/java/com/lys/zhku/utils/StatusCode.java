package com.lys.zhku.utils;

public interface StatusCode {

	//mapper
	int ERROR = -1;
	int EXIST = 0;
	int SUCCESS = 1;
	int NOT_FOUND = 2;
	
	//model
	int INCOMPLETE_MODEL_DATA = 101;
	
	//web
	int MISSING_REQUEST_PARAM = 201;
}
