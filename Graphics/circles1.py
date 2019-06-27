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
    for i in range(0,170,20):
    
        pygame.draw.circle(screen, red, [20+i,20],20,1)
        pygame.draw.circle(screen, red, [20+i,180],20,1)
    pygame.display.update()
