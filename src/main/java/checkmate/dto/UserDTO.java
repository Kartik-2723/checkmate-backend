package checkmate.dto;


import checkmate.entity.User;

public record UserDTO(
        Long id,
        String name,
        String email,
        User.Role role
) {}

