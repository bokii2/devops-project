package mk.ukim.finki.wp.kol2023.g1.service.impl;

import mk.ukim.finki.wp.kol2023.g1.model.Team;
import mk.ukim.finki.wp.kol2023.g1.model.exceptions.InvalidTeamIdException;
import mk.ukim.finki.wp.kol2023.g1.repository.TeamRepository;
import mk.ukim.finki.wp.kol2023.g1.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team findById(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(InvalidTeamIdException::new);
        return team;
    }

    @Override
    public List<Team> listAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team create(String name) {
        Team team = new Team(name);
        teamRepository.save(team);
        return team;
    }
}
