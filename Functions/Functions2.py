def quiz(question):
    while True:
        ans = input(question)
        if ans.lower() == 'yes':
            return ans
        if ans.lower() == 'no':
            return ans


q1='Do you like python? (yes/no)'
q2='Do you like Ian? (yes/no)'
        
answer = quiz(q1)
if answer == 'yes':
    print('Thats nice, thanks!')
else:
    print('Too bad. Try Java instead.')

answer = quiz(q2)
if answer == 'yes':
    print('Thats nice, thanks!')
else:
    print('Too bad. Try Jared instead.')
