package arstansubanov.booking.services;

import arstansubanov.booking.model.MovieSession;
import arstansubanov.booking.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SessionService {

    private final SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<MovieSession> findAll(){
        LocalTime time = LocalTime.now();
        return sessionRepository.findAllFutureMovieSessions(new Date(), LocalTime.now());
    }

    public MovieSession findSessionById(int id){
        Optional<MovieSession> session = sessionRepository.findById(id);
        return session.orElse(null);
    }

    @Transactional
    public void save(MovieSession movieSession){
        movieSession.setCreatedAt(new Date());
        sessionRepository.save(movieSession);
    }

    @Transactional
    public void update(int id, MovieSession movieSession){
        movieSession.setId(id);
        sessionRepository.save(movieSession);
    }

    @Transactional
    public void delete(int id){
        sessionRepository.deleteById(id);
    }

}
