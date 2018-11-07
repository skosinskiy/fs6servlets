CREATE TABLE users (
  id INTEGER,
  name VARCHAR(100)
);

CREATE TABLE operations (
  id INTEGER,
  name VARCHAR(20)
);

CREATE TABLE history (
  id INTEGER,
  x INTEGER,
  y INTEGER,
  op INTEGER,
  usr INTEGER
);

select x,op,y,usr FROM history;

SELECT x,operations.name,y,"=",
  case
    when op = 1 THEN x+y,
    when op = 2 THEN x-y,
    when op = 3 THEN x/y,
  end result
    ,users.name
  FROM history
  JOIN users (users.id = history.usr)
  JOIN operations (operations.id = history.op)
    GROUP BY usr.name
    ORDER BY COUNt(history.usr)



