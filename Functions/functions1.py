def celtofer(temp):
    bork = temp*9/5 + 32
    return bork
def fertocel(temp):
    bork = (temp - 32)*5/9
    return bork
temp = float(input('Temperature to be converted?'))
ans = input('Celsius to Farenheit? (y/n)')
if ans == 'y':
    print(celtofer(temp))
elif ans == 'n':
    print(fertocel(temp))
