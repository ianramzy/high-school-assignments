num = 0
ans = input(str(num)+" Press enter or 'q' to quit...")
while True:
    if ans.lower() == 'q':
        break
    else:
        num = num + 1
        if num > 5:
            num = 0
        ans = input(str(num)+" Press enter or 'q' to quit...")

