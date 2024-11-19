import React, { useState, useEffect } from 'react';
import api from '../api';

function Event() {
    const [name, setName] = useState("");
    const [description, setDescription] = useState("");
    const [location, setLocation] = useState("");
    const [dateTime, setDateTime] = useState("");
    const [maxAttendees, setMaxAttendees] = useState(10);
    const [events, setEvents] = useState([]);

    // Fetch events on component load
    useEffect(() => {
        fetchEvents();
    }, []);

    // Function to fetch events from the backend
    const fetchEvents = async () => {
        try {
            const response = await api.get('/events');
            setEvents(response.data);
        } catch (error) {
            console.error("Error fetching events:", error);
        }
    };

    // Function to create a new event
    const createEvent = async (e) => {
        e.preventDefault();
        try {
            const response = await api.post('/events/create', {
                name,
                description,
                location,
                dateTime,
                maxAttendees
            });
            // Add the new event to the list of events in the state
            setEvents([...events, response.data]);
            // Clear the form fields
            setName("");
            setDescription("");
            setLocation("");
            setDateTime("");
            setMaxAttendees(10);
        } catch (error) {
            console.error("Error creating event:", error);
        }
    };

    return (
        <div>
            <h1>Wedding Event Planner - Events</h1>
            <form onSubmit={createEvent} style={{ marginBottom: '20px' }}>
                <div>
                    <label>Event Name:</label>
                    <input
                        type="text"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Description:</label>
                    <input
                        type="text"
                        value={description}
                        onChange={(e) => setDescription(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Location:</label>
                    <input
                        type="text"
                        value={location}
                        onChange={(e) => setLocation(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Date & Time:</label>
                    <input
                        type="datetime-local"
                        value={dateTime}
                        onChange={(e) => setDateTime(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Max Attendees:</label>
                    <input
                        type="number"
                        value={maxAttendees}
                        onChange={(e) => setMaxAttendees(parseInt(e.target.value))}
                        min="1"
                        required
                    />
                </div>
                <button type="submit">Create Event!</button>
            </form>

            <h2>Available Events</h2>
            {events.length === 0 ? (
                <p>No events available.</p>
            ) : (
                <ul>
                    {events.map(event => (
                        <li key={event.id}>
                            <h3>{event.name}</h3>
                            <p>{event.description}</p>
                            <p>{event.location}</p>
                            <p>{new Date(event.dateTime).toLocaleString()}</p>
                            <p>Max Attendees: {event.maxAttendees}</p>
                        </li>
                    ))}
                </ul>
            )}
        </div>
    );
}

export default Event;
