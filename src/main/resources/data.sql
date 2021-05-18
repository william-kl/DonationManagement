INSERT INTO user (id, first_name, last_name, email, password, active) VALUES
  (1, 'John', 'Doe', 'john@company.org', '$2a$10$557zIih3GhHGEM9S9aft8eqLHKsqVnwLA73JavP6zDs1l2dgcQt86', 1),
  (2, 'Jane', 'Poe', 'jane@notcompany.com', '$2a$10$557zIih3GhHGEM9S9aft8eqLHKsqVnwLA73JavP6zDs1l2dgcQt86', 1),
  (3, 'Sam', 'Smith', 'sam@notcompany.com', '$2a$10$557zIih3GhHGEM9S9aft8eqLHKsqVnwLA73JavP6zDs1l2dgcQt86', 0),
  (4, 'Julia', 'Richardson', 'julia@company.org', '$2a$10$557zIih3GhHGEM9S9aft8eqLHKsqVnwLA73JavP6zDs1l2dgcQt86', 1);

INSERT INTO role (id, name) VALUES
  (1, 'USER'),
  (2, 'ADMIN');

INSERT INTO donation (donation_id, donation_type, can_recur, active) VALUES
  (1, 'General Donation Fund', 1, 1),
  (2, 'Run For the Sun 2021', 1, 1),
  (3, 'Mission Trip Sponsorship', 0, 1),
  (4, 'Memorial Gift', 1, 1),
  (5, 'Run For the Sun 2017', 1, 0);

INSERT INTO transaction (transaction_id, amount, date, recurring, donation_id, id) VALUES
  (1, 1000.00, '2017/07/03', 0, 5, 4),
  (2, 100.00, '2021/05/10', 1, 2, 1),
  (3, 10.00, '2021/05/10', 0, 3, 1),
  (4, 53.00, '2021/05/12', 0, 4, 2),
  (5, 500.00, '2021/05/13', 0, 2, 2),
  (6, 75.32, '2021/05/14', 0, 1, 3);