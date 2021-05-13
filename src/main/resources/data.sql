INSERT INTO user (id, first_name, last_name, email, password) VALUES
  (1, 'John', 'Doe', 'john@company.org', '1234'),
  (2, 'Jane', 'Poe', 'jane@company.org', '1234');

INSERT INTO role (id, name) VALUES
  (1, 'ROLE_USER'),
  (2, 'ROLE_ADMIN');

INSERT INTO donation (donation_id, donation_type, can_recur) VALUES
  (1, 'General Donation Fund', 1),
  (2, 'Run For the Sun 2021', 1),
  (3, 'Mission Trip Sponsorship', 0),
  (4, 'Memorial Gift', 1);

INSERT INTO transaction (transaction_id, amount, date, recurring, donation_id, id) VALUES
  (1, 100.00, '2021/05/10', 1, 2, 1),
  (2, 10.00, '2021/05/10', 0, 3, 1),
  (3, 53.00, '2021/05/12', 0, 4, 2);