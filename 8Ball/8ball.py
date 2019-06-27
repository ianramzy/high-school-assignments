import random
def magic8ball():
    x = random.randint(1,9)
    q = input('Enter a yes or no question?')
    if x == 1:
        print('Its to early for this.')
    if x == 2:
        print('Why are you asking me.')
    if x == 3:
        print('Proabably in some universe.')
    if x == 4:
        print('The cake is a lie.')
    if x == 5:
        print('Absolutely not.')
    if x == 6:
        print('For sure.')
    if x == 7:
        print('42')
    if x == 8:
        print('Try again.')
    if x == 9:
        print('Unsure.')
while True:
    magic8ball()
