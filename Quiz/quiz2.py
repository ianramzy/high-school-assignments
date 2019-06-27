att = 0
ans1 = ''
ans2 = ''
ans3 = ''
while ans1 != '19':
    ans1 = input('What is 9+10?')
    if ans1 == '19':
        print('Correct!')
    else:
        print('Wrong')
        att = att + 1
while ans2 != 'kcvi':
    ans2 = input('What is the best school?')
    if ans2 == 'kcvi':
        print('Correct!')
    else:
        print('Wrong')
        att = att + 1
print('It took you',att,'times')
