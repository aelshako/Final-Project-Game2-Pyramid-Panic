# csc413-SecondGame

## Student Name : Ahmad El Shakoushy

## IDE Used: IntelliJ IDEA
## Version of Java: 10.0.2

**Note on Documentation: Please note that the documentation for this game is included within the repo, and the documentation 
  goes into great detail in explaining both parts of my Final Project(both the Tank Game and the Pyramid Panic game)**

 **How to import the game:**
 
   1. Go to the "Project Structure" menu within IntelliJ and select the following:
   
      - Set the Github repo("csc413-secondgame-aelshako") as the content root
      - Set "src" folder as a source folder
      - Set the "src/resources" folder as a resource folder 
     
 **How to run the game:**
 1. The easiest way to run the game is to simply copy the jar file("csc413-secondgame-aelshako.jar") found in the /jar folder.
 2. Execute the jar file by either:
 
    - double clicking file.
    -  by using the command line(something similar to Windows PowerShell). Please note
    that you will need to have Java installed in order to run the game. 
    
 **Controls:**
    
   ---- Player controls ----
   - W: Move Forwards
   - A: Move left
   - S: Move Backwards
   - D: Move right
   - ENTER: Activate scarab(if available)
    
 **How to play the game:**
    
   - The purpose of Pyramid Panic is for the player to go on a spooky adventure to collect as much gold(increasing their score).
   - Creatures will try to hunt the player: scorpions, beetles, and mummies. 
     - Scorpions only move horizontally, and beetles only move vertically but both of these creatures are reactive, so they
       will double their speed when they can sense a player in front of them.(These creatures senses allow them to sense you even
       if a wall is separating you, so long as you are within a minimum distance.
     - Mummies go towards the player if the player is within a certain radius.
     - Mummies run away from the player when a scarab is active(the player can hold up to 3 scarabs at a time, and scarabs last for a total of 7 seconds)
   - Movable walls can be used to the player's advantage to block scorpions or beetles. Use movable walls strategically as they lock into place onto pushed against other walls.
   - The player emerges as victorious when they collect the sword and manage to make their way back to the entrance before their score ticks down to zero.
     - The player's score will rapidly decrease as soon as they pick up the sword: if it reaches zero, they lose regardless of the number of lives remaining.
   - Lives only play a role in the outcome of the game before the sword is picked up    
