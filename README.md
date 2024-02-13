# Interactive Ball Simulation

## Project Description
This interactive ball simulation allows users to engage with a dynamic environment where they can manipulate balls in a resizable graphical window. 

- **Dynamic Interaction**: Users can drag balls around the window, merging them into larger balls by overlapping.
- **Resizable Graphical Window**: A flexible window where balls bounce off edges, utilizing collision detection for realism.
- **Varied Visuals**: Balls of varying sizes and colors enhance the visual experience, bouncing within the window.
- **User Input**: Control the simulation with mouse clicks to add or remove balls, and keyboard inputs to adjust ball speed.
- **Physics** (Optional): Incorporate basic physics principles, including gravity and friction, to affect ball movement.

## Specifications

#### Add Balls
- **Input**: Mouse Clicks
  - **Action**: User clicks the mouse at a desired location within the graphical window.
- **Output**: Graphical Window
  - **Result**: A new ball appears at the location of the click.

#### Remove Balls
- **Input**: Keyboard Input ('R' Key)
  - **Action**: User presses the 'R' key.
- **Output**: Graphical Window
  - **Result**: All balls are removed from the display.

#### Merge Balls
- **Input**: Two Balls Information
  - **Action**: Two balls come into contact or a user clicks on an existing ball with another ball nearby.
- **Output**: Larger Ball Information
  - **Result**: The two balls merge to form a larger ball. The size and other properties of the new ball are determined by the characteristics of the two original balls.

#### Change Ball Trajectory
- **Input**: Mouse Drags (Optional)
  - **Action**: User clicks and drags a ball to change its trajectory.
- **Output**: Graphical Window
  - **Result**: The trajectory of the dragged ball is altered according to the drag direction and speed.

#### UI Control Enhancements (Optional)
- **Input**: User Interface Elements
  - **Action**: User interacts with UI elements like buttons, sliders, or menus.
- **Output**: Graphical Window and Ball Behavior
  - **Result**: Ball behavior and settings are modified according to the adjustments made with the UI elements.
