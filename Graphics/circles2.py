import pygame , sys
pygame.init()

# Set window size and create window:
size = 200, 200
screen = pygame.display.set_mode(size)

# Define colours:
black = [0, 0, 0]
red = [200, 0, 0]
green = [0, 200, 0]

# Main loop
while True:
    # Check for window close:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
            
    #Draw patterns:
    screen.fill(black)
    for i in range(20,200,5):
    
        pygame.draw.circle(screen, red, [i,i],i,1)

    pygame.display.update()
