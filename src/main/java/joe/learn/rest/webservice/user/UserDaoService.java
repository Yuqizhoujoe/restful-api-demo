package joe.learn.rest.webservice.user;

import java.util.List;

public interface UserDaoService {

    public List<User> findAll();
    public User save(User user);
    public User findOne(int id);
    public User deleteById(int id);

}
