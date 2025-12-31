package edu.raijin.notifications.scrum.domain.port.utility;

import edu.raijin.commons.util.annotation.Port;
import edu.raijin.notifications.identity.domain.model.User;
import edu.raijin.notifications.scrum.domain.model.Story;

@Port
public interface SendStoryUpdatePort {

    void sendStoryUpdate(Story story, User user, User actor);
}
