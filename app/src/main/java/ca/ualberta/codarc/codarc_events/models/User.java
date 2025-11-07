/*
 * Core user model capturing device identity and role state flags persisted in Firestore.
 * Outstanding issues: Align with potential account linking to decouple from device ids.
 */
package ca.ualberta.codarc.codarc_events.models;

import com.google.firebase.firestore.PropertyName;

/**
 * User model - base identity with role flags.
 * All flags start as false, get set when user does actions.
 * Banned status is in Entrants/Organizers, not here.
 */
public class User {
    
    private String deviceId;
    private boolean isEntrant;
    private boolean isOrganizer;
    private boolean isAdmin;
    
    /**
     * Firestore requires an empty constructor for automatic deserialization.
     */
    public User() {
        this.isEntrant = false;
        this.isOrganizer = false;
        this.isAdmin = false;
    }

    /**
     * Creates a user associated with the provided device id.
     *
     * @param deviceId identifier used as the Firestore document key
     */
    public User(String deviceId) {
        this.deviceId = deviceId;
        this.isEntrant = false;
        this.isOrganizer = false;
        this.isAdmin = false;
    }

    /**
     * @return device id acting as the persistent user identifier.
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Sets the device identifier representing this user.
     *
     * @param deviceId identifier to associate with the user
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * @return true if the user has created entrant profile data.
     */
    @PropertyName("isEntrant")
    public boolean isEntrant() {
        return isEntrant;
    }

    /**
     * Updates whether the user participates as an entrant.
     *
     * @param entrant true when the user should be treated as an entrant
     */
    @PropertyName("isEntrant")
    public void setEntrant(boolean entrant) {
        isEntrant = entrant;
    }

    /**
     * @return true if the user manages events as an organizer.
     */
    @PropertyName("isOrganizer")
    public boolean isOrganizer() {
        return isOrganizer;
    }

    /**
     * Assigns or revokes organizer privileges.
     *
     * @param organizer true when the user should be treated as an organizer
     */
    @PropertyName("isOrganizer")
    public void setOrganizer(boolean organizer) {
        isOrganizer = organizer;
    }

    /**
     * @return true if the user has administrative permissions.
     */
    @PropertyName("isAdmin")
    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * Toggles admin privileges for the user.
     *
     * @param admin true to mark the user as an admin
     */
    @PropertyName("isAdmin")
    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}

