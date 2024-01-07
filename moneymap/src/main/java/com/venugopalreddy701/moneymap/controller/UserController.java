package com.venugopalreddy701.moneymap.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.venugopalreddy701.moneymap.entity.LoginUser;
import com.venugopalreddy701.moneymap.entity.Transaction;
import com.venugopalreddy701.moneymap.entity.UpdateProfile;
import com.venugopalreddy701.moneymap.entity.User;
import com.venugopalreddy701.moneymap.service.TransactionService;
import com.venugopalreddy701.moneymap.service.UserService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@OpenAPIDefinition(info = @Info(title = "User Controller", description = "This controller consist of 9 operations: createUser, getUser, loginUser, createTransaction, getTransactions, updateTransaction, deleteTransaction, signout, updateProfile"))
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TransactionService transactionService;

    @Operation(summary = "Create User")
    @PostMapping("/createUser")
    public List<String> createUser(@RequestBody User user) {

        return userService.createUser(user);
    }

    @Operation(summary = "Login User")
    @PostMapping("/loginUser")
    public List<String> loginUser(@RequestBody LoginUser loginUser) {

        return userService.loginUser(loginUser);
    }

    @Operation(summary = "Create Transaction")
    @PostMapping("/createTransaction")
    public List<String> createTransaction(HttpServletRequest request, @RequestBody Transaction transaction) {

        return transactionService.createTransaction(transaction, request.getHeader("authorization"));
    }

    @Operation(summary = "Get Transactions")
    @GetMapping("/getTransactions")
    public Object getTransactions(HttpServletRequest request) {

        return transactionService.getTransactions(request.getHeader("authorization"));
    }

    @Operation(summary = "Update Transaction")
    @PutMapping("/updateTransaction")
    public List<String> updateTransaction(HttpServletRequest request, @RequestBody Transaction transaction) {

        return transactionService.updateTransaction(transaction, request.getHeader("authorization"));
    }

    @Operation(summary = "Delete Transaction")
    @DeleteMapping("/deleteTransaction")
    public List<String> deleteTransaction(HttpServletRequest request, @RequestParam Integer transaction_id) {

        return transactionService.deleteTransaction(transaction_id, request.getHeader("authorization"));
    }

    @Operation(summary = "Signout")
    @GetMapping("/signout")
    public List<String> signout(HttpServletRequest request) {

        return userService.signout(request.getHeader("authorization"));
    }

    @Operation(summary = "Update Profile")
    @PutMapping("/updateProfile")
    public List<String> updateProfile(HttpServletRequest request, @RequestBody UpdateProfile updateProfile) {

        return userService.updateProfile(request.getHeader("authorization"), updateProfile);
    }

    @Operation(summary = "Get User Info")
    @GetMapping("/getUser")
    public Map<String, String> getUser(HttpServletRequest request) {

        return userService.getUser(request.getHeader("authorization"));
    }
}
