print("welcome to the temperature convertoe: ")

temp_f = float(input('what is the given temperature in degrees Fahrenheit: '))

temp_c = (5/9)*(temp_f - 32)
temp_k = temp_c + 273.15

temp_f = round(temp_f, 4)
temp_c = round(temp_c, 4)
temp_k = round(temp_k , 4)
print("\n Degrees fahreneheit: \t"+ str(temp_f))
print("\n Degrees Celsius: \t"+ str(temp_c))
print("\n Degrees Kelvin: \t"+ str(temp_k))