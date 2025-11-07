/*
 * Model representing notifications sent to entrants, including transient UI state flags
 * while awaiting user actions.
 * Outstanding issues: Evaluate pruning strategy for historical notifications to limit
 * offline storage.
 */
package ca.ualberta.codarc.codarc_events.models;

import java.io.Serializable;

/**
 * Represents a single notification sent to an entrant.
 *
 * <p>The entry mirrors the structure stored under
 * {@code entrants/<deviceId>/notifications} in Firestore and carries
 * a couple of transient flags used by the UI layer (such as the
 * {@code processing} flag).</p>
 */
public class NotificationEntry implements Serializable {

    private String id;
    private String eventId;
    private String eventName;
    private String message;
    private String category;
    private long createdAt;
    private boolean read;
    private String response;
    private long respondedAt;

    // Transient state used by RecyclerView rows while an action is pending.
    private transient boolean processing;

    /**
     * @return unique identifier of this notification document.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the Firestore identifier for this notification.
     *
     * @param id notification document id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return identifier of the event related to this notification.
     */
    public String getEventId() {
        return eventId;
    }

    /**
     * Assigns the associated event identifier.
     *
     * @param eventId Firestore id of the event
     */
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    /**
     * @return display name of the associated event.
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * Sets the display name of the related event.
     *
     * @param eventName event name shown to users
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * @return body text presented to the entrant.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Updates the message body presented in the notification.
     *
     * @param message textual content sent to the entrant
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return category key describing the notification type.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category value used for filtering notifications.
     *
     * @param category category label assigned to the entry
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return epoch milliseconds timestamp when the notification was created.
     */
    public long getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the creation timestamp for this notification.
     *
     * @param createdAt epoch milliseconds when the notification was generated
     */
    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return true when the entrant has marked the notification as read.
     */
    public boolean isRead() {
        return read;
    }

    /**
     * Updates the read status of the notification.
     *
     * @param read true when the notification has been acknowledged
     */
    public void setRead(boolean read) {
        this.read = read;
    }

    /**
     * @return textual response supplied by the entrant, if any.
     */
    public String getResponse() {
        return response;
    }

    /**
     * Records an entrant response message.
     *
     * @param response response content supplied by the entrant
     */
    public void setResponse(String response) {
        this.response = response;
    }

    /**
     * @return timestamp when the entrant responded to the notification.
     */
    public long getRespondedAt() {
        return respondedAt;
    }

    /**
     * Sets when the entrant responded to the notification.
     *
     * @param respondedAt epoch milliseconds of the response time
     */
    public void setRespondedAt(long respondedAt) {
        this.respondedAt = respondedAt;
    }

    /**
     * @return true if the notification is awaiting completion of an in-flight action.
     */
    public boolean isProcessing() {
        return processing;
    }

    /**
     * Updates whether the notification is currently being processed by the UI.
     *
     * @param processing true while an action is pending completion
     */
    public void setProcessing(boolean processing) {
        this.processing = processing;
    }
}