print('Welcome to dice rolling blackjack!')
print('Try to get as close to 21 as you can without going over.') 
import random
total = 0
print('Total',total)
ans = input("Press enter to roll again or 'q' to stand...")
while total < 21:
    x = random.randint(1,6)
    if ans.lower() =='q':
        print('You stood at',total)
        break
    else:
        total = total + x
        print('Roll:',x,'      Total:',total)
        ans = input( "Press enter to roll again or 'q' to stand...")
        if total > 21:
            print('You busted!')

