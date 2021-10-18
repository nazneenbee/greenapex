package com.greenapex.Exception;

import org.springframework.http.ResponseEntity;

public class ResponseEntityBuilder {
	 public static ResponseEntity<Object> build(APIError apiError) {
         return new ResponseEntity<>(apiError, apiError.getStatus());
   }

}
