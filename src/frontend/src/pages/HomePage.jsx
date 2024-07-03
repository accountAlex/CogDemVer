import React from 'react';
import { Container } from 'react-bootstrap';
import authService from '../api/auth';

const HomePage = () => {
    const currentUser = authService.getCurrentUser();

    return (
        <Container className="mt-5">
            {currentUser ? (
                <h1>Welcome, {currentUser.username}!</h1>
            ) : (
                <h1>Добро пожаловать блять, знали бы вы как мы нахуй стараемся над Когнитивом, так что только попробуйте ливнуть</h1>


            )}
        </Container>
    );
};

export default HomePage;
