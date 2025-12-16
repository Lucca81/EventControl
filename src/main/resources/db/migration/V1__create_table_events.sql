CREATE TABLE events
(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    date_start TIMESTAMP NOT NULL,
    date_end TIMESTAMP NOT NULL,
    identifier VARCHAR(255) NOT NULL UNIQUE,
    event_local VARCHAR(155) NOT NULL,
    organizer VARCHAR(155) NOT NULL,
    capacity INTEGER NOT NULL,
    type VARCHAR(100) NOT NULL
)