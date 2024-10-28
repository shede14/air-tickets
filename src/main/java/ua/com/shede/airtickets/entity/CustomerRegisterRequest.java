package ua.com.shede.airtickets.entity;

public record CustomerRegisterRequest(
        String name,
        String email,
        String phone,
        String address,
        String password
) {
}
