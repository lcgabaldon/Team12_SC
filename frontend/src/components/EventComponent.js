// src/components/EventComponent.js
import React from 'react';

const EventComponent = ({ event }) => {
    // Parse the date using JavaScript's Date object
    const eventDate = new Date(event.dateTime);

    // Format the date for display
    const formattedDate = isNaN(eventDate) ? "Invalid Date" : eventDate.toLocaleString();

    return (
        <div>
            <h2>{event.name}</h2>
            <p>{event.description}</p>
            <p>Location: {event.location}</p>
            <p>Date: {formattedDate}</p>
            <p>Max Attendees: {event.maxAttendees}</p>
        </div>
    );
};

export default EventComponent;
