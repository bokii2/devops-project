CREATE TABLE IF NOT EXISTS player (
    id bigint PRIMARY KEY,
    name VARCHAR(255),
    bio TEXT,
    points_per_game DOUBLE PRECISION,
    position VARCHAR(255),
    team_id BIGINT,
    votes INTEGER DEFAULT 0,
    FOREIGN KEY (team_id) REFERENCES team(id)
);