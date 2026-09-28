# Calculator Operations with Select

Start with the basic dropdown lesson, then use this exercise to practice choosing calculator operations from a native `select` menu. It also uses keyboard Actions and explicit waits; revisit it after those lessons if these techniques are new to you.

`BasicCalculatorTest` enters five fixed pairs with keyboard Actions, selects all five operations with `Select`, waits for each answer, and checks it against the expected value. Fixed inputs make a failure reproducible and easier to debug. The calculator is a public demo, so its availability and behavior can change.

The main learning goal is selecting an operation and checking its result, so this exercise belongs in the Select chapter. [Task instructions](Task.md) list the operations to practice.
