print('Welcome to golf, you have four clubs and super saiyan.')
print('The goal is to get the distance to zero.')
print('Club 1 has a range of 30-120')
print('Club 2 has a range of 20-60')
print('Club 3 has a range of 10-20')
print('Club 4 has a range of 1-5')
print('Goku (5) has a range of over 9000!')
import random
times = 0
total = 100
print('Shot: ',total)
ans = input("Enter which club you want to use (1,2,3,4,5)")
while True:
    c1 = random.randint(30,120)
    c2 = random.randint(20,60)
    c3 = random.randint(10,20)
    c4 = random.randint(1,5)
    c5 = random.randint(9001,9002)
    if ans =='1':
        total = abs(total - c1)
        print(times,'Shot: ',c1,'     Distance: ',total,)
        ans = input("Enter which club you want to use (1,2,3,4,5)")
        times = times + 1
        if total == 0:
            print('You win! It took you',times,'shots')
            break
    elif ans =='2':
        total = abs(total - c2)
        print(times,'Shot: ',c2,'     Distance: ',total,)
        ans = input("Enter which club you want to use (1,2,3,4,5)")
        times = times + 1
        if total == 0:
            print('You win! It took you',times,'shots')
            break
    elif ans =='3':
        total = abs(total - c3)
        print(times,'Shot: ',c3,'     Distance: ',total,)
        ans = input("Enter which club you want to use (1,2,3,4,5)")
        times = times + 1
        if total == 0:
            print('You win! It took you',times,'shots')
            break
    elif ans =='5':
        total = abs(total - c5)
        print(times,'Shot: ',c5,'     Distance: ',total,)
        ans = input("Enter which club you want to use (1,2,3,4,5)")
        times = times + 1
        if total == 0:
            print('You win! It took you',times,'shots')
            break
    elif ans =='4':
        total = abs(total - c4)
        print(times,'Shot: ',c4,'     Distance: ',total,)
        ans = input("Enter which club you want to use (1,2,3,4)")
        times = times + 1
        if total == 0:
            print('You win! It took you',times,'shots')
            break

   
