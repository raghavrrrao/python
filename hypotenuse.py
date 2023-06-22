import math
print("welcome to the right triange=le solver app")

a = float(input("\nwhat is the first leg of the triangle: "))
b = float(input("what is the second leg of the trinagle: "))

c = math.sqrt(a**2 + b**2)
c = round(c , 3)
area = 0.5*a*b
area = round(area , 3)

print(f'\n for a triangle with legs of {a} and {b} the hypotenuse is {c}')
print(f'\n for a triangle with legs of {a} and {b} the area is {area}')