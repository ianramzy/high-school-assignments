time=3
batt=100
read=0
nap=0

north=0
south=1
east=2
west=3

# The Place class has 3 variables: a description, a list of exits and a list of things.
# The description and list of things are passed as parameters when a new Place is created;
# the list of exits is set to None,None,None,None.  (An exit can only be set after the place
# it links to has been declared.)
# Place also has one function, describe(), which prints the description.
class Place:
    def __init__(self,description,things):
        self.description = description
        self.exits=[None,None,None,None]
        self.things=things
    def describe(self):
        print()
        print(self.description)


#Define all places first:
desk = Place("You are at you desk at Boring Co.",[])
lounge = Place("You are in the employee lounge.",["chair","newspaper"])
boss = Place("You are in the bosses office.\nHe stares menacingly.",[])

#Then define the exits:
desk.exits=[lounge,None,None,None]
boss.exits=[None,lounge,None,None]
lounge.exits=[boss,desk,None,None]

# The goto function will change the currentplace if the exit in the
# specified direction is not None.
def goto(direction):
    global currentplace
    if currentplace.exits[direction]==None:
        print("You cannot go there.")
    else:
        currentplace = currentplace.exits[direction]    

# Where you start:
currentplace = desk
# Things you start with:
inventory = ["phone"]
# Introductory comments:
print("You have a really bad headache and there is still 3 hours left in the day.\nSurvive the day and don't get fired")

gameOn=True
while gameOn:
    if time==0:
        print('You survived the day!\nBe sure to arrive on time tomorrow!')
        break
    currentplace.describe()
    if len(currentplace.things)>0:
        print("You see:",end="")
        for item in currentplace.things:
            print(item,"  ",end="")
        print()
    
        
    command = input('What do you want to do?').lower()
    if command=="":
        continue
    parsed = command.split() # This is a list of the words in command
    if command in ["n","north","go north"]:
        goto(north)
    elif command in ["s","south","go south"]:
        goto(south)
    elif command in ["e","east","go east"]:
        goto(east)
    elif command in ["w","west","go west"]:
        goto(west)
    elif command in ["q","quit", "exit"]:
        gameOn=False
    elif command in ["i","inventory", "inv"]:
        if len(inventory)>0:
            print("You have:",end="")
            for item in inventory:
                print(item,"  ",end="")
            print()
    elif parsed[0] in ["get", "take"]:
        del parsed[0] # remove the first word ("get" or "take")
        for item in parsed: # allow getting multiple items
            if item in currentplace.things:
                inventory.append(item)
                currentplace.things.remove(item)
    elif parsed[0] in ["put", "drop"]:
        del parsed[0] # remove the first word ("put" or "drop")
        for item in parsed: # allow dropping multiple items
            if item in inventory:
                currentplace.things.append(item)
                inventory.remove(item)
    elif parsed[0] in ["use"]:
        if parsed[1] not in inventory:
            print("You do not have ",parsed[1])
        elif parsed[1]=="newspaper":
            if currentplace==boss:
                print("You can't read the newspaper infront of the boss\nYou're fired!")
                break
            if read==1:
                print('You have already read all of the news')
            else:
                print("You've wasted half an hour")
                time=time-.5
                print(time,'hours remain')
                read=1
        elif parsed[1]=="chair":
            if currentplace==boss:
                print("The chair is in the lounge")
                continue
            if currentplace==desk:
                print("The chair is in the lounge")
                continue
            if nap==1:
                print('You already took a nap')
            else:
                print("You've wasted half an hour")
                time=time-.5
                print(time,'hours remain')
                nap=1
        elif parsed[1]=="phone":
            if currentplace==boss:
                print("You can't use your phone infront of the boss\nYou're fired!")
                break
            if batt==0:
                print('Your phone is out of battery')
            else:
                time=time-1
                print("You've wasted an hour")
                batt=batt-50
                print('Battery Charge:',batt,'%')
                print(time,'hours remain')
        else:
            print("I don't know how to use that.")
    else:
        print("Sorry, I don't understand.")

print("\nThanks for playing!\n")
