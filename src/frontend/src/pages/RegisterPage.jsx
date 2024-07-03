import React from 'react';
import RegisterForm from '../components/RegisterForm';
import { Container } from 'react-bootstrap';

const RegisterPage = () => {
    return (
        <Container className="mt-5">
            <h1>Register Page</h1>
            <RegisterForm />
        </Container>
    );
};

export default RegisterPage;
