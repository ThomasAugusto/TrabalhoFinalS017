package org.s017.apigateway.routing;

import org.s017.apigateway.entities.UserRequestDTO;
import org.s017.apigateway.entities.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "account-service",
url = "http://localhost:3003/")
public interface ClientService {

    @RequestMapping(value = "/v1/user", method = RequestMethod.POST)
    public ResponseEntity<String> saveUser(@RequestBody UserDTO data);

    @RequestMapping(value = "/v1/user/login", method = RequestMethod.POST)
    public ResponseEntity<String> loginUser(@RequestBody UserRequestDTO data);
}
