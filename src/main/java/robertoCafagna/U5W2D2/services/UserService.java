package robertoCafagna.U5W2D2.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import robertoCafagna.U5W2D2.entities.User;
import robertoCafagna.U5W2D2.exception.NotFoundException;
import robertoCafagna.U5W2D2.payloads.UserPayload;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserService {
    private List<User> userDB = new ArrayList<>();

    public List<User> findAll() {
        return this.userDB;
    }

    public User save(UserPayload body) {
        User newUser = new User(body.getNome(), body.getCognome(), body.getEmail(), body.getDataDiNascita());
        this.userDB.add(newUser);
        log.info("L'utente:" + newUser.getId() + "è stato salvato");
        return newUser;
    }

    public User findById(long userId) {
        User found = null;

        for (User user : this.userDB) {
            if (user.getId() == userId) found = user;
        }
        if (found == null) throw new NotFoundException("risorsa non trovata");

        return found;
    }


    public User findByIdAndUpdate(long userId, UserPayload body) {
        User found = findById(userId);
        found.setNome(body.getNome());
        found.setCognome(body.getCognome());
        found.setEmail(body.getEmail());
        found.setDataDiNascita(body.getDataDiNascita());

        return found;
    }


    public void findAndDelete(long userId) {
        User found = findById(userId);
        this.userDB.remove(found);
    }
}
