package game;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by ravenalb on 9-6-2017.
 */
class Container{

    /*
     * locked containers can only be opened with lockpicks
     */

    private String id;
    private String name;
    private String description;
    private boolean closed;
    private boolean locked;
    private String lockDifficulty;
    private List<String> containerContent = new ArrayList<String>();


    Container(String id, String name, String description, boolean closed, boolean locked, String lockDifficulty){
        setId(id);
        setName(name);
        setDescription(description);
        setIsClosed(closed);
        setIsLocked(locked);
        setLockDifficulty(lockDifficulty);
        setContent(containerContent);
    }


    private void setId(String id){
        this.id = id;
    }
    private void setName(String name){
        this.name = name;
    }

    private void setDescription(String description){
        this.description = description;
    }

    private void setContent(List<String> content){
        this.containerContent = content;
    }

    private void setIsLocked(boolean locked){
        this.locked = locked;
    }

    private void setLockDifficulty(String difficulty){
        this.lockDifficulty = difficulty;
    }

    private void setIsClosed(boolean closed){
        this.closed = closed;
    }

    String returnContainerId(){
        return this.id;
    }

    String returnContainerName(){
        return this.name;
    }

    String returnContainerDescription(){
        return this.description;
    }

    boolean returnContainerIsLocked(){
        return this.locked;
    }

    boolean returnContainerIsClosed(){
        return this.closed;
    }

    String returnContainerLockDifficulty(){
        return this.lockDifficulty;
    }

}
