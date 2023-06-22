import operator as op
name  = input("Hey, Whats is your name?")
print("Hello"+name)
print("I will count the number of times a particular letter occurs in a message!")

message = input("please enter a message : ")
letter = input("Which letter would you like me to count the occerances of? : ")
print(f"The letter {letter} has occurred {op.countOf(message, letter)} times")
