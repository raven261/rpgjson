package game;

/*
 * Created by ravenalb on 31-5-2017.
 */
public class World {

    private int[][] world = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}
    };

    //private game.Character pc = new game.Character();

    public static void main(String[] args) {
        // new game.World().printRoom();
        //new game.World().test();
    }

    Integer getRoomCoords(int x, int y) {
        return world[x][y];
    }

    Integer returnWorldLength(){
        return world.length;
    }

    void moveNorth(){

        try {
            Integer oldX = Character.returnPcLocationX();
            Integer newX = oldX - 1;
            if(newX >= 0){
                Character.setLocationX(newX);
            }else{
                System.out.println("You cannot go that way.");
            }

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("MoveNorth: " + e.getMessage());
        }
    }

    void moveEast(){
        Integer oldY = Character.returnPcLocationY();
        Integer newY = oldY + 1;
        if(newY >= 0 && newY < world[Character.returnPcLocationX()].length){
            Character.setLocationY(newY);
        }else{
            System.out.println("East, You cannot go that way");
        }

    }

//    void moveSouth(){
//        Integer oldX= pc.getPlayerLocationX();
//        Integer newX = oldX + 1;
//        if(newX < world.length) {
//            pc.updateLocationValue(0, newX);
//        }else{
//            System.out.println("south: newX < world.length error");
//        }
//    }
//
//    void moveWest(){
//        try {
//            Integer oldY = pc.getPlayerLocationY();
//            Integer newY = oldY - 1;
//            if (newY >= 0 && newY < world[newY].length) {
//                pc.updateLocationValue(1, newY);
//            } else {
//                System.out.println("You cannot go that way");
//            }
//        }catch(ArrayIndexOutOfBoundsException e){
//            System.out.println("MoveNorth: " + e.getMessage());
//        }
//    }

}
