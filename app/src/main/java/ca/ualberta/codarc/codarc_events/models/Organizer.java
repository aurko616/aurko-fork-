/*
 * Simplified organizer model capturing device-scoped identity and ban status for
 * administrative controls.
 * Outstanding issues: Extend with profile metadata once organizer directory is added.
 */
package ca.ualberta.codarc.codarc_events.models;

/**
 * Organizer model - minimal, just deviceId and banned flag.
 * No profile info needed.
 */
public class Organizer {
    
    private String deviceId;
    private boolean banned;
    
    // Firestore needs empty constructor
    /**
     * Constructs an organizer instance required by Firestore deserialization.
     */
    public Organizer() {
        this.banned = false;
    }

    /**
     * Creates an organizer associated with the provided device id.
     *
     * @param deviceId unique identifier for the organizer device
     */
    public Organizer(String deviceId) {
        this.deviceId = deviceId;
        this.banned = false;
    }

    /**
     * @return device id that uniquely identifies the organizer.
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Sets the device identifier for this organizer.
     *
     * @param deviceId device id to associate with the organizer
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * @return true if the organizer is banned from managing events.
     */
    public boolean isBanned() {
        return banned;
    }

    /**
     * Updates the ban status of the organizer.
     *
     * @param banned true to prevent the organizer from creating events
     */
    public void setBanned(boolean banned) {
        this.banned = banned;
    }
}

