package edu.raijin.notifications.identity.domain.port.utility;

import edu.raijin.commons.util.annotation.Port;
import edu.raijin.notifications.identity.domain.model.User;

@Port
public interface SendConfirmationPort {

    void sendConfirmation(User user);
}
