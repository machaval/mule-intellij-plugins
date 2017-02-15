{
  d: in1 filter ((value) -> value.firstName == 'Hello World'),
  a: in1 filter $.firstName == 'Hello World',
  b: in1 filter $.firstName == 'John' and $.lastName != 'Doe' or $.age > 30,
  c: ([31 , 30 , 20 ] filter $ > 30)[0],
  e: in1 filter
     ((value) ->
        value.firstName == 'John' and value.lastName != 'Doe' or value.age > 30),
  f: in1 filter ((customer) ->
      (customer.salary >
          (in0.customers filter ((customer2) -> customer2.firstName == 'Emiliano') map ((customer2) -> customer2.salary)))[0]),
  g: ([31 , 30 , 20 ] filter ((value) -> value > 30))[0]
}