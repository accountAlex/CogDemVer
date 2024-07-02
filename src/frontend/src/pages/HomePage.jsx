import React from 'react';
import authService from '../api/auth';

const HomePage = () => {
    const currentUser = authService.getCurrentUser();

    return (
        <div>
            {currentUser ? (
                <h1>Welcome, {currentUser.username}!</h1>
            ) : (
                <h1>Welcome to our website!</h1>
            )}
        </div>
    );
};

export default HomePage;
