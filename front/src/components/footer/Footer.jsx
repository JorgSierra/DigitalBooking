import React, { lazy, Suspense } from "react";
import styles from './Footer.module.css'
//import { BsFacebook, BsTwitter, BsInstagram } from 'react-icons/bs'
//import { FaLinkedinIn } from 'react-icons/fa'

//const FaLinkedinIn = lazy(() => import('react-icons/fa/FaLinkedinIn'));
/*const BsFacebook = lazy(() => import('react-icons/bs/BsFacebook'));
const BsTwitter = lazy(() => import('react-icons/bs/BsTwitter'));
const BsInstagram = lazy(() => import('react-icons/bs/BsInstagram'));
const FaLinkedinIn = lazy(() => import('react-icons/fa').then(module => ({default: module.FaLinkedinIn})));
*/
const FaLinkedinIn = lazy(() => import('react-icons/fa').then(module => ({default: module.FaLinkedinIn})));
const BsFacebook = lazy(() => import('react-icons/bs').then(module => ({default: module.BsFacebook})));
const BsTwitter = lazy(() => import('react-icons/bs').then(module => ({default: module.BsTwitter})));
const BsInstagram = lazy(() => import('react-icons/bs').then(module => ({default: module.BsInstagram})));

const Footer = () => {
  return (
    <footer>
      <div data-testid="footer" className={styles.footerContainer}>
        <div className={styles.footerCopyrights} data-testid='footer-copyrights'>
          <p>©2023 Digital Booking</p>
        </div>

                
                    <div className={styles.footerSocialMedia} data-testid='footer-social-media'>
                        <FaLinkedinIn />
                        <BsFacebook />
                        <BsTwitter />
                        <BsInstagram />
                    </div>
               
            </div>
        </footer>
    );
};

export default Footer;
