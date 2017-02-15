{
  a: in1 groupBy $.firstName,
  b: in1 groupBy ((value) -> value.firstName),
  c: in1 map $.firstName filter $.lastName == "Emiliano" groupBy $.salary
}