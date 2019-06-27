import pygame , sys
pygame.init()

# Set window size and create window:
size = 200, 200
screen = pygame.display.set_mode(size)

# Define colours:
black = [0, 0, 0]
red = [255, 0, 0]
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
    for i in range(0,201,5):
        pygame.draw.line(screen,red,[100,0],[i,100])
        pygame.draw.line(screen,green,[100,200],[i,100])
        
        
        
    pygame.display.update()
