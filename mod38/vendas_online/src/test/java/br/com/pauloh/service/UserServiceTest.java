package br.com.pauloh.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Test;

import br.com.pauloh.model.User;

public class UserServiceTest {

    IUserService userService;

    public UserServiceTest() {
        userService = new UserService();
    }

    @After
    public void after() {
        List<User> users = userService.searchAll();
        users.forEach(user -> {
            userService.delete(user.getId());
        });
    }

    public User createUser() {
        User user = new User();
        user.setName("Test");
        user.setEmail("test@test");
        user.setPassword("test123");
        user.setPhone("123456789");

        return user;
    }

    @Test
    public void testCreate() {
        User user = createUser();
        user.setCpf(1L);

        userService.create(user);
        
        assertNotNull(user.getId());
    }

    @Test
    public void testDelete() {
        User user = createUser();
        user.setCpf(2L);

        userService.delete(user.getId());

        assertNotNull(user.getId());
    }

    @Test
    public void testRead() {
        User user = createUser();
        user.setCpf(3L);

        userService.create(user);

        User read = userService.read(user.getId());

        assertNotNull(read);
    }

    @Test
    public void testUpdate() {
        User user = createUser();
        user.setCpf(4L);

        userService.create(user);

        user.setName("Teste2");
        userService.update(user);

        assertEquals("Teste2", user.getName());
    }

    @Test
    public void testReadEmail() {
        User user = createUser();
        user.setCpf(5L);

        userService.create(user);

        User read = userService.readEmail(user.getEmail());

        assertNotNull(read);
    }
}
