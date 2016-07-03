{
  a: in0.salary reduce ((acc, val) -> acc + val),
  b: in0.salary reduce $$ + $,
  c: in0.employees filter $.salary < 5000 map { lastName: $.lastName, startDate: $.startDate, salary: $.salary } reduce ((acc, val) -> acc + val),
  d: in0.salary reduce ((acc = 1, val) -> acc + val)
}