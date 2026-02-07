import { Outlet, Link, useLocation } from "react-router";
import { useEffect, useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';

const Layout: React.FC<{ children?: React.ReactNode }> = ({ children }) => {
    const location = useLocation();
    const [isScrolled, setIsScrolled] = useState(false);

    useEffect(() => {
        const handleScroll = () => {
            setIsScrolled(window.scrollY > 50);
        };

        window.addEventListener('scroll', handleScroll);
        return () => window.removeEventListener('scroll', handleScroll);
    }, []);

    const isActive = (path: string) => location.pathname === path;

    return (
        <>
            <header className={`container-fluid py-4 ${isScrolled ? 'scrolled' : ''}`}>
                <div className="container">
                    <div className="d-flex flex-wrap align-items-center justify-content-between text-center text-md-start">
                        <Link to="/" className="logo mb-3 mb-md-0 text-decoration-none">
                            Portfolio
                        </Link>

                        <nav className="nav justify-content-center">
                            <Link className={`nav-link ${isActive('/') ? 'active' : ''}`} to="/">Home</Link>
                            <Link className={`nav-link ${isActive('/about') ? 'active' : ''}`} to="/about">About</Link>
                            <Link className={`nav-link ${isActive('/portfolio') ? 'active' : ''}`} to="/portfolio">Portfolio</Link>
                            <Link className={`nav-link ${isActive('/contact') ? 'active' : ''}`} to="/contact">Contact</Link>
                        </nav>
                    </div>
                </div>
            </header>

            <main>
                {children || <Outlet />}
            </main>

            <footer className="container-fluid py-4 mt-5 border-top border-secondary">
                <div className="container text-center">
                    <p className="mb-0 text-white">
                        © 2024 June Lienon Salamanca. All rights reserved.
                    </p>
                    <div className="mt-2">
                        <small className="text-white">
                            Built with React, TypeScript & ❤️
                        </small>
                    </div>
                </div>
            </footer>
        </>
    );
};

export default Layout;