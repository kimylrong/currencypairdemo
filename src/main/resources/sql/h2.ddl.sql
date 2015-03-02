create table trade(
  user_id bigint,
  currency_from varchar(16),
  currency_to varchar(16),
  amount_sell decimal(16,2),
  amount_buy decimal(16,2),
  rate decimal(8,8),
  time_placed timestamp,
  originating_country varchar(16)
);