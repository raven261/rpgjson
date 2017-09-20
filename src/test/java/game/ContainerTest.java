package game;

import org.junit.Test;

import static org.junit.Assert.*;

/*
 * Created by ravenalb on 1-9-2017.
 */
public class ContainerTest {

    Container testContainer = new Container("testId", "testContainer", "Test description", false, false, "none");
    @Test
    public void returnContainerId() throws Exception {
        String expected = "testId";
        assertEquals("Container id is returned",expected, testContainer.returnContainerId());
    }

    @Test
    public void returnContainerName() throws Exception {
        String expected = "testContainer";
        assertEquals("Container name is returned",expected, testContainer.returnContainerName());
    }

    @Test
    public void returnContainerDescription() throws Exception {
        String expected = "Test description";
        assertEquals("Container description is returned",expected, testContainer.returnContainerDescription());
    }

    @Test
    public void returnContainerLocked() throws Exception {
        Boolean expected = false;
        assertEquals("Container locked is returned",expected, testContainer.returnContainerIsLocked());
    }

    @Test
    public void returnContainerClosed() throws Exception {
        Boolean expected = false;
        assertEquals("Container closed is returned",expected, testContainer.returnContainerIsClosed());
    }

    @Test
    public void returnContainerLockDifficulty() throws Exception {
        String expected = "none";
        assertEquals("Container lockDifficulty is returned",expected, testContainer.returnContainerLockDifficulty());
    }

}