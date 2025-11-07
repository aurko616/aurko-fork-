/*
 * Model encapsulating entrant profile details collected during waitlist enrollment and
 * used when managing draws.
 * Outstanding issues: Normalize contact information validation between controllers and
 * this data object.
 */
package ca.ualberta.codarc.codarc_events.models;

import com.google.firebase.firestore.PropertyName;

/**
 * Entrant model - profile info for users who join waitlists.
 * Created when user joins first waitlist and provides info.
 */
public class Entrant {

    private String deviceId;
    private String name;
    private long createdAtUtc;
    private String email;
    private String phone;
    private boolean isRegistered;
    private boolean banned;

    // Firestore needs empty constructor
    /**
     * Constructs an entrant without preset values for Firestore deserialization.
     */
    public Entrant() { }

    /**
     * Creates an entrant with the provided identity and creation metadata.
     *
     * @param deviceId unique identifier tied to the entrant's device
     * @param name entrant display name
     * @param createdAtUtc epoch milliseconds when the entrant profile was created
     */
    public Entrant(String deviceId, String name, long createdAtUtc) {
        this.deviceId = deviceId;
        this.name = name;
        this.createdAtUtc = createdAtUtc;
        this.email = "";
        this.phone = "";
        this.isRegistered = false;
        this.banned = false;
    }

    /**
     * @return device id associated with the entrant.
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * Sets the device identifier associated with the entrant.
     *
     * @param deviceId device id to persist for this entrant
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * @return entrant's display name.
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the entrant's display name.
     *
     * @param name new display name value
     */
    public void setName(String name) {
        this.name = name;
    }

    // kept for test compatibility
    /**
     * @return timestamp (ms) when the entrant was created.
     */
    public long getCreatedAt() {
        return createdAtUtc;
    }

    /**
     * Sets the creation timestamp for compatibility with older tests.
     *
     * @param createdAtUtc epoch milliseconds of profile creation
     */
    public void setCreatedAt(long createdAtUtc) {
        this.createdAtUtc = createdAtUtc;
    }

    // Firestore field name is createdAtUtc
    /**
     * @return creation timestamp mapped to the createdAtUtc Firestore field.
     */
    @PropertyName("createdAtUtc")
    public long getCreatedAtUtc() {
        return createdAtUtc;
    }

    /**
     * Updates the creation timestamp stored in Firestore.
     *
     * @param createdAtUtc epoch milliseconds representing creation time
     */
    @PropertyName("createdAtUtc")
    public void setCreatedAtUtc(long createdAtUtc) {
        this.createdAtUtc = createdAtUtc;
    }

    /**
     * @return entrant email contact.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the entrant email contact information.
     *
     * @param email email address for updates
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return entrant phone contact information.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the entrant phone contact information.
     *
     * @param phone phone number to reach the entrant
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Firestore uses snake_case
    /**
     * @return true when the entrant has been fully registered.
     */
    @PropertyName("is_registered")
    public boolean getIsRegistered() {
        return isRegistered;
    }

    /**
     * Marks whether the entrant has a confirmed registration.
     *
     * @param isRegistered true when the entrant has been accepted
     */
    @PropertyName("is_registered")
    public void setIsRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }

    /**
     * @return true if the entrant is banned from participation.
     */
    @PropertyName("banned")
    public boolean isBanned() {
        return banned;
    }

    /**
     * Updates the banned status for this entrant.
     *
     * @param banned true to prevent participation
     */
    @PropertyName("banned")
    public void setBanned(boolean banned) {
        this.banned = banned;
    }
}