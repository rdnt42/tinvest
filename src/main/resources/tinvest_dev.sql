BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "portfolio_item" (
	"id"	INTEGER NOT NULL,
	"portfolio_id"	INTEGER NOT NULL,
	"time_stamp"	date NOT NULL,
	"ticker"	TEXT NOT NULL,
	"name"	TEXT NOT NULL,
	"balance"	INTEGER,
	"yield_price"	REAL,
	"position_price"	REAL,
	"currency_type_id"	INTEGER NOT NULL,
	"slice_type_id"	INTEGER NOT NULL,
	FOREIGN KEY("slice_type_id") REFERENCES "slice_type",
	FOREIGN KEY("currency_type_id") REFERENCES "currency_type",
	PRIMARY KEY("id")
);
CREATE TABLE IF NOT EXISTS "portfolio" (
	"id"	integer NOT NULL PRIMARY KEY AUTOINCREMENT,
	"time_stamp"	date NOT NULL,
	"slice_type_id"	integer NOT NULL,
	FOREIGN KEY("slice_type_id") REFERENCES "slice_type"
);
CREATE TABLE IF NOT EXISTS "slice_type" (
	"id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	"name"	TEXT NOT NULL
);
CREATE TABLE IF NOT EXISTS "currency_type" (
	"id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	"name"	TEXT NOT NULL
);
INSERT INTO "slice_type" VALUES (1,'One minute portfolio');
INSERT INTO "slice_type" VALUES (2,'Five minutes portfolio');
INSERT INTO "slice_type" VALUES (3,'Half hour portfolio');
INSERT INTO "currency_type" VALUES (1,'RUB');
INSERT INTO "currency_type" VALUES (2,'USD');
COMMIT;
