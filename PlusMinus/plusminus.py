print('Welcome to dice rolling blackjack!')
print('Try to get as close to 21 as you can without going over.') 
import random
total = 10
print('Total',total)
ans = input("Press enter to roll again")
while total < 21:
    x = random.randint(1,6)
    if x == 1:
        x = -1
    if x == 2:
        x = -2
    if x == 3:
        x = -3
    if x == 4:
        x = -4
    if x == 5:
        x = 5
    if x == 6:
        x = 6
    if ans.lower() =='qefgh':
        break
    else:
        total = total + x
        print('Roll:',x,'      Total:',total)
        ans = input( "Roll again?")
        if total > 21:
            print('You win!')
            break
        if total < 1:
            print('You lose!')
            break




