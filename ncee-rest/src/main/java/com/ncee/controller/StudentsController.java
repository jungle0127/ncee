package com.ncee.controller;

import com.ncee.dto.RestResponse;
import com.ncee.dto.User;
import com.ncee.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import javax.validation.Valid;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ps
 */
@RestController
@RequestMapping("/users")
public class StudentsController {
    private UserService userService;
    private ConcurrentLinkedDeque<DeferredResult<RestResponse<Boolean>>> deferredResults = new ConcurrentLinkedDeque<>();
    @Autowired
    public StudentsController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/user")
    public DeferredResult<RestResponse<Boolean>> addUser(@Valid @RequestBody  User user, BindingResult bindingResult){
        final DeferredResult<RestResponse<Boolean>> deferredResult = new DeferredResult<>();
        deferredResults.add(deferredResult);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                Boolean result = userService.addUser(user);
                deferredResult.setResult(new RestResponse<>(result));
            }
        });
        deferredResult.onCompletion(new Runnable() {
            @Override
            public void run() {
                deferredResults.remove(deferredResult);
            }
        });
        deferredResult.onTimeout(new Runnable() {
            @Override
            public void run() {
                deferredResult.setErrorResult("Time out");
                deferredResult.setResult(new RestResponse<>(false));
            }
        });
        return deferredResult;
    }
}
