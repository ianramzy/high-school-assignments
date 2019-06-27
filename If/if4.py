ans = int(input('Age?'))
if ans >= 18:
    print('You can vote')
elif ans <= 0:
    print('Invalid Input')
elif ans < 18:
    print('You cannot vote')

