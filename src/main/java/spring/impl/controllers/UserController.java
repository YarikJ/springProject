package spring.impl.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.impl.dto.UserResponseDto;
import spring.impl.model.User;
import spring.impl.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        return convertToDto(userService.get(userId));
    }

    @GetMapping(value = "/inject")
    public String injectData() {
        userService.add(new User("Meredith", "mer@gmail.com", "111"));
        userService.add(new User("Sarah", "sarah@gmail.com", "111"));
        userService.add(new User("Baily", "bal@gmail.com", "111"));
        userService.add(new User("Amelia", "amely@gmail.com", "111"));
        return "Successfully injected users";
    }

    @GetMapping(value = "/")
    public List<UserResponseDto> getAll() {
        return userService.listUsers()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private UserResponseDto convertToDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());
        return userResponseDto;
    }
}
