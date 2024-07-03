import React, { useContext, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { AuthContext } from '../context/AuthContext';
import { Navbar, Nav, NavDropdown, Container, Form, Button, Dropdown } from 'react-bootstrap';
import { FaUserCircle } from 'react-icons/fa';

const NavBar = () => {
    const { user, logout, login } = useContext(AuthContext);
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();
    const [showDropdown, setShowDropdown] = useState(false);

    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            await login(username, password);
            navigate('/');
        } catch (err) {
            console.error(err);
        }
    };

    return (
        <Navbar bg="dark" variant="dark" expand="lg" fixed="top" className="justify-content-between">
            <Container fluid>
                <Navbar.Brand as={Link} to="/">Cognitive Нахуй</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="ml-auto">
                        {user ? (
                            <NavDropdown title={<FaUserCircle size={24} />} id="basic-nav-dropdown" alignRight>
                                <NavDropdown.Item as={Link} to="/profile">Profile</NavDropdown.Item>
                                <NavDropdown.Item onClick={logout}>Logout</NavDropdown.Item>
                            </NavDropdown>
                        ) : (
                            <>
                                <Dropdown
                                    show={showDropdown}
                                    onMouseEnter={() => setShowDropdown(true)}
                                    onMouseLeave={() => setShowDropdown(false)}
                                >
                                    <Dropdown.Toggle as="div" bsPrefix="custom-toggle">
                                        <Nav.Link as={Link} to="/login">Login</Nav.Link>
                                    </Dropdown.Toggle>
                                    <Dropdown.Menu>
                                        <Form onSubmit={handleLogin} className="p-3">
                                            <Form.Group controlId="formBasicEmail">
                                                <Form.Label>Username</Form.Label>
                                                <Form.Control
                                                    type="text"
                                                    value={username}
                                                    onChange={(e) => setUsername(e.target.value)}
                                                    required
                                                />
                                            </Form.Group>
                                            <Form.Group controlId="formBasicPassword">
                                                <Form.Label>Password</Form.Label>
                                                <Form.Control
                                                    type="password"
                                                    value={password}
                                                    onChange={(e) => setPassword(e.target.value)}
                                                    required
                                                />
                                            </Form.Group>
                                            <Button variant="primary" type="submit" className="mt-2" block>
                                                Login
                                            </Button>
                                        </Form>
                                    </Dropdown.Menu>
                                </Dropdown>
                                <Nav.Link as={Link} to="/register">Register</Nav.Link>
                            </>
                        )}
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
};

export default NavBar;
