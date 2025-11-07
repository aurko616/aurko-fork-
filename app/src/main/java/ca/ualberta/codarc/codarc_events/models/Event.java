/*
 * Domain model representing an event along with metadata such as registration windows and
 * capacity constraints as stored in Firestore.
 * Outstanding issues: Align date strings with a shared temporal abstraction to prevent
 * formatting inconsistencies.
 */
package ca.ualberta.codarc.codarc_events.models;

import java.io.Serializable;

/**
 * Plain data holder for events.
 * Mirrors what we store in Firestore.
 */
public class Event implements Serializable {

    private String id;
    private String name;
    private String description;
    private String eventDateTime;
    private String registrationOpen;
    private String registrationClose;
    private boolean open;
    private String organizerId;
    private String qrCode;
    private Integer maxCapacity;
    private String location;

    /**
     * Creates an empty event instance for use by Firestore deserializers.
     */
    public Event() { }

    /**
     * Creates a populated event with the provided identifiers and scheduling metadata.
     *
     * @param id unique event identifier
     * @param name display name shown to entrants
     * @param description marketing copy describing the event experience
     * @param eventDateTime formatted string describing when the event occurs
     * @param registrationOpen formatted string indicating when registration opens
     * @param registrationClose formatted string indicating when registration closes
     * @param open flag indicating if the event currently accepts registrations
     * @param organizerId device id of the organizer who owns the event
     * @param qrCode optional QR code payload assigned to the event
     */
    public Event(String id, String name, String description,
                 String eventDateTime, String registrationOpen,
                 String registrationClose, boolean open, String organizerId, String qrCode) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.eventDateTime = eventDateTime;
        this.registrationOpen = registrationOpen;
        this.registrationClose = registrationClose;
        this.open = open;
        this.organizerId = organizerId;
        this.qrCode = qrCode;
    }


    // Getters
    /**
     * @return unique Firestore identifier for the event.
     */
    public String getId() { return id; }

    /**
     * @return event name displayed across the UI.
     */
    public String getName() { return name; }

    /**
     * @return rich description offering entrants context.
     */
    public String getDescription() { return description; }

    /**
     * @return formatted date and time string for the event occurrence.
     */
    public String getEventDateTime() { return eventDateTime; }

    /**
     * @return date string describing when registration opens.
     */
    public String getRegistrationOpen() { return registrationOpen; }

    /**
     * @return date string describing when registration closes.
     */
    public String getRegistrationClose() { return registrationClose; }

    /**
     * @return true if the event is open for new entrants.
     */
    public boolean isOpen() { return open; }

    /**
     * @return organizer device id that owns this event.
     */
    public String getOrganizerId() { return organizerId; }

    /**
     * @return QR code payload associated with the event or null if unset.
     */
    public String getQrCode() { return qrCode; }

    /**
     * @return maximum number of entrants allowed or null if unlimited.
     */
    public Integer getMaxCapacity() { return maxCapacity; }

    /**
     * @return human-readable location string for the event.
     */
    public String getLocation() { return location; }

    // Setters
    /**
     * Sets the Firestore id assigned to this event.
     *
     * @param id identifier value to persist
     */
    public void setId(String id) { this.id = id; }

    /**
     * Updates the event name displayed to users.
     *
     * @param name descriptive title of the event
     */
    public void setName(String name) { this.name = name; }

    /**
     * Updates the long-form description for marketing purposes.
     *
     * @param description textual description of the event
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * Sets the human-readable date and time string for the event.
     *
     * @param eventDateTime formatted date-time string
     */
    public void setEventDateTime(String eventDateTime) { this.eventDateTime = eventDateTime; }

    /**
     * Sets when registration opens for this event.
     *
     * @param registrationOpen formatted opening date string
     */
    public void setRegistrationOpen(String registrationOpen) { this.registrationOpen = registrationOpen; }

    /**
     * Sets when registration closes for this event.
     *
     * @param registrationClose formatted closing date string
     */
    public void setRegistrationClose(String registrationClose) { this.registrationClose = registrationClose; }

    /**
     * Toggles whether the event currently accepts registrations.
     *
     * @param open true to accept entrants, false to pause registration
     */
    public void setOpen(boolean open) { this.open = open; }

    /**
     * Associates the event with the organizer who manages it.
     *
     * @param organizerId organizer device identifier
     */
    public void setOrganizerId(String organizerId) { this.organizerId = organizerId; }

    /**
     * Stores the QR code payload used for entrant check-in.
     *
     * @param qrCode encoded QR representation
     */
    public void setQrCode(String qrCode) { this.qrCode = qrCode; }

    /**
     * Sets the maximum number of entrants that may attend the event.
     *
     * @param maxCapacity optional capacity limit
     */
    public void setMaxCapacity(Integer maxCapacity) { this.maxCapacity = maxCapacity; }

    /**
     * Sets the physical or virtual location of the event.
     *
     * @param location location string displayed to entrants
     */
    public void setLocation(String location) { this.location = location; }
}

