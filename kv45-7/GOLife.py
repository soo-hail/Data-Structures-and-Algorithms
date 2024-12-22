import pygame
import random

# Initialize Pygame
pygame.init()

# Constants
BLACK = (0, 0, 0)
WHITE = (255, 255, 255)
YELLOW = (255, 255, 0)
CELL_SIZE = 20
WIDTH, HEIGHT = 800, 800
GRID_WIDTH = WIDTH // CELL_SIZE
GRID_HEIGHT = HEIGHT // CELL_SIZE
FPS = 60

# Initialize screen and clock
screen = pygame.display.set_mode((WIDTH, HEIGHT))
clock = pygame.time.Clock()

def draw_grid(positions):
    """Draws the grid with active cells."""
    for position in positions:
        col, row = position
        top_left = (col * CELL_SIZE, row * CELL_SIZE)
        pygame.draw.rect(screen, WHITE, (*top_left, CELL_SIZE, CELL_SIZE))

def gen_pos(n):
    """Generates a set of random positions."""
    return set((random.randrange(0, GRID_HEIGHT), random.randrange(0, GRID_WIDTH)) for _ in range(n))

def get_neigh(pos):
    """Gets the neighbors of a given position."""
    neighbors = []
    for col in range(pos[0] - 1, pos[0] + 2):
        for row in range(pos[1] - 1, pos[1] + 2):
            if (0 <= col < GRID_HEIGHT) and (0 <= row < GRID_WIDTH) and (col != pos[0] or row != pos[1]):
                neighbors.append((col, row))
    return neighbors

def update_grid(positions):
    """Updates the grid based on the current positions."""
    all_neighbors = set()
    new_positions = set()
    
    for pos in positions:
        neighbors = get_neigh(pos)
        all_neighbors.update(neighbors)
        active_neighbors = list(filter(lambda p: p in positions, neighbors))
        
        if len(active_neighbors) in [2, 3]:  # Survives
            new_positions.add(pos)
    
    for pos in all_neighbors:
        active_neighbors = list(filter(lambda p: p in positions, get_neigh(pos)))
        
        if len(active_neighbors) == 3:  # New cell
            new_positions.add(pos)

    return new_positions

def main():
    running = True
    playing = False
    count = 0
    positions = set()

    # Main game loop
    while running:
        clock.tick(FPS)
        pygame.display.set_caption('Playing' if playing else 'Paused')

        if playing:
            count += 1
            
        if count >= 30:
            positions = update_grid(positions)
            count = 0

        # Handle events
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                running = False
                
            elif event.type == pygame.MOUSEBUTTONDOWN:
                x, y = pygame.mouse.get_pos()
                col, row = x // CELL_SIZE, y // CELL_SIZE
                pos = (col, row)
                
                if pos in positions:
                    positions.remove(pos)
                else:
                    positions.add(pos)
                
            elif event.type == pygame.KEYDOWN:
                if event.key == pygame.K_SPACE:
                    playing = not playing
                elif event.key == pygame.K_c:
                    positions = set()
                elif event.key == pygame.K_g:
                    positions = gen_pos(random.randrange(4, 10) * GRID_WIDTH)
        
        screen.fill(BLACK)
        draw_grid(positions)
        pygame.display.update()
        
    pygame.quit()

if __name__ == '__main__':
    main()
