import sys, pygame
pygame.init()
pygame.key.set_repeat(10)

size = width, height = 1050,600
xspeed = 13
yspeed = 13

x = 100.0
y = 50.0

black = [0, 255, 0]
white = [238, 0, 0]
font = pygame.font.SysFont("algerian",30)
font2 = pygame.font.SysFont("algerian",100)

screen = pygame.display.set_mode(size)

pygame.mixer.music.load('music.wav')
pygame.mixer.music.play(-1)
            
paddleone = pygame.image.load("darock.png")
paddletwo = pygame.image.load("big.png")
ball = pygame.image.load("cenah.png")
backround = pygame.image.load("cenascene.jpg")

backrect = pygame.Rect(1,1,1,1) 
ballrect = ball.get_rect()
ballrect.left = width/2
paddle1 = pygame.Rect(10,10,100,220)
paddle2 = pygame.Rect(970,10,100,220)
score1 = 0
score2 = 0

while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
        keys=pygame.key.get_pressed()
        if keys[pygame.K_w]:
            paddle1.top=paddle1.top-8
        if keys[pygame.K_s]:
            paddle1.top=paddle1.top+8
        if keys[pygame.K_UP]:
            paddle2.top=paddle2.top-8
        if keys[pygame.K_DOWN]:
            paddle2.top=paddle2.top+8

    x = x + xspeed
    y = y + yspeed
    ballrect.left = x
    ballrect.top = y

    if ballrect.left < 0:
        x=width/2+100
        score1 = score1 + 1
    if ballrect.right > width:
        x=width/2+100
        score2 = score2 + 1
    if ballrect.top < 0 or ballrect.bottom > height:
        yspeed = yspeed * -1
    if ballrect.colliderect(paddle1):
        xspeed = xspeed * -1
    if ballrect.colliderect(paddle2):
        xspeed = xspeed * -1
    if paddle1.top < 0:
        paddle1.top = 0
    if paddle1.bottom > 600:
        paddle1.bottom = 600
    if paddle2.top < 0:
        paddle2.top = 0
    if paddle2.bottom > 600:
        paddle2.bottom = 600

    screen.blit(backround, backrect)
    screen.blit(ball, ballrect)
    screen.blit(paddleone, paddle1)
    screen.blit(paddletwo, paddle2)
    renderedText = font.render("Score: "+str(score1),1,white)
    screen.blit(renderedText, (width/50+50,10))
    renderedText = font.render("Score2: "+str(score2),1,white)
    screen.blit(renderedText, (width/20+800,10))
    renderedText = font2.render('CENAPONG',1,white)
    screen.blit(renderedText, (width/20+220,-10))
    pygame.display.flip()
    pygame.time.wait(10)
    
    


