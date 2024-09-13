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
    manager_id uuid NOT NULL,
    constraint fk_manager foreign key(manager_id) references managers(id)
);

CREATE TABLE reservations (
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    member_id uuid NOT NULL,
    workspace_id uuid NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    CONSTRAINT fk_member FOREIGN KEY (member_id) REFERENCES members(id),
    CONSTRAINT fk_workspace FOREIGN KEY (workspace_id) REFERENCES workspaces(id)
);

CREATE TABLE services (
    id uuid PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(50) NOT NULL,
    description VARCHAR(50) NOT NULL UNIQUE,
    size double precision NOT NULL,
);

CREATE TABLE default_services (
    PRIMARY KEY(id),
    workspace_id uuid NOT NULL,
    CONSTRAINT fk_workspace FOREIGN KEY (workspace_id) REFERENCES workspaces(id)
) INHERITS (services);

CREATE TABLE additional_services (
    PRIMARY KEY(id),
    reservation_id uuid NOT NULL,
    CONSTRAINT fk_reservation FOREIGN KEY (reservation_id) REFERENCES reservations(id)
) INHERITS (services);