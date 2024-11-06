import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import src.main.java.com.User;
import src.main.java.com.Event;
import src.main.java.com.Invite;


class inviteTest {
    private Invite inv;

    @BeforeEach
    void setUp() {
        Invite invite = new Invitation(2574, "MGE754");
    }

    @Test
    void testConstructor() {
        assertEquals(2574, invite.getEventId());
        assertEquals("MGE754", invite.getInvitedUserID());
    }
}
