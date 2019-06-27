def test(que, ans):
    tries=0
    response=''
    while response != ans:
        response=input(que)
        if response.lower() == ans:
            print('Correct!')
        else:
            print('Wrong.')
        tries = tries + 1
        if tries>=5:
            print("Sorry, you only get 5 tries per question.")
            break
    print("That question took you",tries,"trie(s).")
    return tries


test("What is Ontario's capital?", "toronto")
test("What is 10 + 3?",  "13")
test('What is the best school?', 'kcvi')
