CREATE TABLE users (
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    address VARCHAR(50) NOT NULL,
    number VARCHAR(10) NOT NULL
);

CREATE TABLE members (
    PRIMARY KEY (id)
) INHERITS (users);

CREATE TABLE managers (
    PRIMARY KEY (id)
) INHERITS (users);

CREATE TABLE admins (
    PRIMARY KEY (id)
) INHERITS (users);

CREATE TABLE workspaces (
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(50) NOT NULL,
    description VARCHAR(50) NOT NULL,
    size double precision NOT NULL,
    price double precision NOT NULL,
    managerId uuid NOT NULL,
    constraint fk_manager foreign key(managerId) references managers(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE reservations (
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    memberId uuid NOT NULL,
    workspaceId uuid NOT NULL,
    startDate DATE NOT NULL,
    endDate DATE NOT NULL,
    CONSTRAINT fk_member FOREIGN KEY (memberId) REFERENCES members(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_workspace FOREIGN KEY (workspaceId) REFERENCES workspaces(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE services (
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(50) NOT NULL,
    description VARCHAR(50) NOT NULL UNIQUE,
    price double precision NOT NULL
);

CREATE TABLE defaultservices (
    PRIMARY KEY(id),
    workspaceId uuid NOT NULL,
    CONSTRAINT fk_workspace FOREIGN KEY (workspaceId) REFERENCES workspaces(id) ON DELETE CASCADE ON UPDATE CASCADE
) INHERITS (services);

CREATE TABLE additionalservices (
    PRIMARY KEY(id)
) INHERITS (services);