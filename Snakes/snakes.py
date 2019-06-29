import pygame, sys, random
# pygame 1.9.4

pygame.init()
size = width, height = 1320, 720
screen = pygame.display.set_mode(size)
# pygame.mixer.pre_init()

# white = [0, 0, 0]
white = [255, 255, 255]
orange = [255, 140, 0]
red = [255, 0, 0]
gray = [35, 35, 35]
# white = [0, 0, 255]
font = pygame.font.SysFont("BankGothic", 45)
font2 = pygame.font.SysFont("BankGothic", 80)
font3 = pygame.font.SysFont("BankGothic", 222)
font4 = pygame.font.SysFont("BankGothic", 15)
font5 = pygame.font.SysFont("BankGothic", 95)
font6 = pygame.font.SysFont("BankGothic", 65)
# snakeyum = pygame.mixer.Sound('snakeyum.wav')
# alarm = pygame.mixer.Sound('alarm.wav')
# ticktick = pygame.mixer.Sound('ticktock.wav')
backround = pygame.image.load("snakeback.jpg")
timebon = pygame.image.load("clock.png")


# pygame.mixer.music.load('tronmusic.wav')


def gamep1():
    isticking = False
    # pygame.mixer.music.play(-1)

    # starting speed is going to the right:
    speed = [0, 30]

    # head is where the new snake segment will be created:
    head = [90, 90]
    # snake is a list of Rectangles, representing segments of the snake:
    snake = [pygame.Rect(head, [30, 30])]
    # starting length is 5:
    length = 5

    # set random position for food:
    food = [30 * random.randint(0, width / 30 - 1), 30 * random.randint(0, height / 30 - 1)]
    food2 = [30 * random.randint(0, width / 30 - 1), 30 * random.randint(0, height / 30 - 1)]
    eleven = 11
    counter = eleven
    wt = 0
    score = 0
    backrect = pygame.Rect(0, 0, 0, 0)

    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            elif event.type == pygame.KEYDOWN:
                if event.key == pygame.K_UP:
                    if speed[1] != 30:
                        speed = [0, -30]
                elif event.key == pygame.K_DOWN:
                    if speed[1] != -30:
                        speed = [0, 30]
                if event.key == pygame.K_LEFT:
                    if speed[0] != 30:
                        speed = [-30, 0]
                elif event.key == pygame.K_RIGHT:
                    if speed[0] != -30:
                        speed = [30, 0]

        # move the head:
        head[0] = head[0] + speed[0]
        head[1] = head[1] + speed[1]

        # check for collision with self: 
        for segment in snake:
            if segment == pygame.Rect(head, [30, 30]):
                losequit(score)

        # check for collision with walls:
        if head[0] >= width or head[0] < 0 or head[1] >= height or head[1] < 0:
            losequit(score)

        # check for collision with food:
        if head == food:
            length = length + 1
            food = [30 * random.randint(0, width / 30 - 1), 30 * random.randint(0, height / 30 - 1)]
            wt = wt - 3
            eleven = eleven - .5
            counter = eleven
            score = score + 1
            # snakeyum.play()

        # check for collision with time bonus:
        if head == food2:
            food2 = [30 * random.randint(0, width / 30 - 1), 30 * random.randint(0, height / 30 - 1)]
            eleven = eleven + 1
            counter = eleven
            # snakeyum.play()

        # add new segment to snake at head:
        snake.append(pygame.Rect(head, [30, 30]))

        # remove tail segments if necessary:
        while len(snake) > length:
            snake.pop(0)

        # draw your game elements here:
        screen.blit(backround, backrect)

        # draw all the snake segments:
        for segment in snake:
            pygame.draw.rect(screen, red, segment, 0)
        ##    timer
        counter = counter - 0.1
        ##    render title
        renderedText = font5.render("SNAKE TRIALS", 1, white)
        screen.blit(renderedText, (300, 10))
        ##    render timer
        renderedText = font.render("Time Remaining: " + str(int(counter)), 1, white)
        screen.blit(renderedText, (5, height - 155))
        ##    render score
        renderedText = font.render("Score: " + str(int(score)), 1, white)
        screen.blit(renderedText, (5, height - 195))

        if counter <= 4:
            if not isticking:
                # ticktick.play(0)
                isticking = True

        # running out of time:
        if counter <= 0:
            losequit(score)

        # draw the food:
        pygame.draw.rect(screen, orange, pygame.Rect(food, [30, 30]), 0)
        screen.blit(timebon, food2)
        pygame.display.flip()
        pygame.time.wait(wt)


def gamep2():
    isticking = False
    # backround = pygame.image.load("snakeback.jpg")
    # pygame.mixer.music.load('tronmusic.wav')
    # pygame.mixer.music.play(-1)

    # starting speed is going to the right:
    speed = [0, 30]
    speed2 = [30, 0]

    # head is where the new snake segment will be created:
    head = [90, 90]
    head2 = [270, 270]
    # snake is a list of Rectangles, representing segments of the snake:
    snake = [pygame.Rect(head, [30, 30])]
    snake2 = [pygame.Rect(head2, [30, 30])]
    # starting length is 5:
    length = 5
    length2 = 5
    # set random position for food:
    food = [30 * random.randint(0, width / 30 - 1), 30 * random.randint(0, height / 30 - 1)]
    food2 = [30 * random.randint(0, width / 30 - 1), 30 * random.randint(0, height / 30 - 1)]

    eleven = 11
    counter = eleven
    wt = 100
    score = 0

    backrect = pygame.Rect(0, 0, 0, 0)

    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            elif event.type == pygame.KEYDOWN:
                if event.key == pygame.K_w:
                    if speed[1] != 30:
                        speed = [0, -30]
                elif event.key == pygame.K_s:
                    if speed[1] != -30:
                        speed = [0, 30]
                if event.key == pygame.K_a:
                    if speed[0] != 30:
                        speed = [-30, 0]
                elif event.key == pygame.K_d:
                    if speed[0] != -30:
                        speed = [30, 0]
                        # snake2 controls
                if event.key == pygame.K_UP:
                    if speed2[1] != 30:
                        speed2 = [0, -30]
                elif event.key == pygame.K_DOWN:
                    if speed2[1] != -30:
                        speed2 = [0, 30]
                if event.key == pygame.K_LEFT:
                    if speed2[0] != 30:
                        speed2 = [-30, 0]
                elif event.key == pygame.K_RIGHT:
                    if speed2[0] != -30:
                        speed2 = [30, 0]

        # move the head:
        head[0] = head[0] + speed[0]
        head[1] = head[1] + speed[1]

        head2[0] = head2[0] + speed2[0]
        head2[1] = head2[1] + speed2[1]

        # check for collision with self: 
        for segment in snake:
            if segment == pygame.Rect(head, [30, 30]):
                losequit(score)

        for segment in snake2:
            if segment == pygame.Rect(head2, [30, 30]):
                losequit(score)

        for segment in snake:
            if segment == pygame.Rect(head2, [30, 30]):
                losequit(score)

        for segment in snake2:
            if segment == pygame.Rect(head, [30, 30]):
                losequit(score)

        # check for collision with walls:
        if head[0] >= width or head[0] < 0 or head[1] >= height or head[1] < 0:
            losequit(score)

        if head2[0] >= width or head2[0] < 0 or head2[1] >= height or head2[1] < 0:
            losequit(score)

        # check for collision with food:
        if head == food:
            length = length + 1
            food = [30 * random.randint(0, width / 30 - 1), 30 * random.randint(0, height / 30 - 1)]
            wt = wt - 3
            eleven = eleven - .5
            counter = eleven
            score = score + 1
            # snakeyum.play()

        if head2 == food:
            length2 = length2 + 1
            food = [30 * random.randint(0, width / 30 - 1), 30 * random.randint(0, height / 30 - 1)]
            wt = wt - 3
            eleven = eleven - .5
            counter = eleven
            score = score + 1
            # snakeyum.play()

        # check for collision with time bonus:
        if head == food2:
            food2 = [30 * random.randint(0, width / 30 - 1), 30 * random.randint(0, height / 30 - 1)]
            eleven = eleven + .5
            counter = eleven
            # snakeyum.play()

        if head2 == food2:
            food2 = [30 * random.randint(0, width / 30 - 1), 30 * random.randint(0, height / 30 - 1)]
            eleven = eleven + .5
            counter = eleven
            # snakeyum.play()

        # add new segment to snake at head:
        snake.append(pygame.Rect(head, [30, 30]))
        snake2.append(pygame.Rect(head2, [30, 30]))

        # remove tail segments if necessary:
        while len(snake) > length:
            snake.pop(0)

        while len(snake2) > length:
            snake2.pop(0)

        # draw your game elements here:
        screen.blit(backround, backrect)

        # draw all the snake segments:
        for segment in snake:
            pygame.draw.rect(screen, white, segment, 0)

        for segment in snake2:
            pygame.draw.rect(screen, red, segment, 0)

        ## timer
        counter = counter - 0.1

        if counter <= 4:
            if not isticking:
                # ticktick.play(0)
                isticking = True

        ##    render title
        renderedText = font5.render("P2 SNAKE TRIALS ", 1, white)
        screen.blit(renderedText, (233, 5))
        ##    render timer
        renderedText = font.render("Time Remaining: " + str(int(counter)), 1, white)
        screen.blit(renderedText, (5, height - 55))
        ##    render score
        renderedText = font.render("Score: " + str(int(score)), 1, white)
        screen.blit(renderedText, (5, height - 95))

        # running out of time:
        if counter <= 0:
            losequit(score)
        # draw the food:
        pygame.draw.rect(screen, orange, pygame.Rect(food, [30, 30]), 0)
        screen.blit(timebon, food2)

        pygame.display.flip()
        pygame.time.wait(wt)


def startscreen():
    backround = pygame.image.load("snakeback.jpg")
    backrect = pygame.Rect(0, 0, 0, 0)
    screen.blit(backround, backrect)
    renderedText = font5.render('Welcome to Snake Trials', 1, white)
    screen.blit(renderedText, (11, 1))
    renderedText = font6.render("Press Space to Start", 1, white)
    screen.blit(renderedText, (11, height - 195))
    renderedText = font6.render("Press '2' for Two Player Co-Op", 1, white)
    screen.blit(renderedText, (11, height - 95))
    pygame.display.flip()

    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            elif event.type == pygame.KEYDOWN:
                if event.key == pygame.K_SPACE:
                    gamep1()
                if event.key == pygame.K_2:
                    gamep2()


def prestart():
    time = 0
    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            elif event.type == pygame.KEYDOWN:
                if event.key == pygame.K_SPACE:
                    startscreen()
        if time == 10:
            white = [0, 0, 0]
            renderedText = font4.render(
                'Traceback most recent call last:File C:Users Wood Word is2o snakes snakes.py, line 307, in <module>',
                0, white)
            screen.blit(renderedText, (0, 0))
            renderedText = font4.render('Press space to initiate the new world order and virus.exe', 0, white)
            screen.blit(renderedText, (0, 15))

        if time == 20:
            white = [255, 255, 255]
            renderedText = font4.render(
                'Traceback most recent call last:File C:Users Wood Word is2o snakes snakes.py, line 307, in <module>',
                0, white)
            screen.blit(renderedText, (0, 0))
            renderedText = font4.render('Press space to initiate the new world order and virus.exe', 0, white)
            screen.blit(renderedText, (0, 15))
            time = 0
        time = time + 1
        pygame.display.flip()
        pygame.time.wait(100)


def losequit(score):
    # pygame.mixer.music.load('tronmusic.wav')
    # pygame.mixer.music.stop
    # alarm.play()
    fixme = 69420
    backround = pygame.image.load("snakeback.jpg")
    backrect = pygame.Rect(0, 0, 0, 0)
    screen.blit(backround, backrect)
    renderedText = font3.render('You Lose!', 1, white)
    screen.blit(renderedText, (85, 100))
    renderedText = font.render("You scored: " + str(int(score)), 1, white)
    screen.blit(renderedText, (4, height - 95))
    renderedText = font.render("Press Space to Play Single Player Again", 1, white)
    screen.blit(renderedText, (4, height - 195))
    renderedText = font.render("Press '2' to Play Two Player", 1, white)
    screen.blit(renderedText, (4, height - 155))
    pygame.display.flip()
    while True:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                pygame.quit()
                sys.exit()
            elif event.type == pygame.KEYDOWN:
                if event.key == pygame.K_SPACE:
                    gamep1()
                if event.key == pygame.K_2:
                    gamep2()


prestart()
