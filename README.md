# Course project vs. this repository

There are some differences between the project developed during the course and this repository

## Front-end

In the original project, the static content was hosted by an AWS S3 bucket. This repo deploys the <code>Vite+React</code> app to GitHub pages (unlimited FREE) using the following strategy:

1. Install the <code>gh-pages</code> package:

    ```bash
    npm install gh-pages --save-dev
    ```
    
2. In the <code>package.json</code> file add before <code>"build": "vite build"</code>:

    ```json
    "predeploy": "npm run build",
    "deploy": "gh-pages -d dist",
    ```

3. In the <code>vite.config.js</code> file add before <code>plugins: [react()],</code>:

    ```js
    base: "DigitalBooking",
    ```
    
4. Even if using yarn as package manager. In the terminal on the front folder run:

    ```bash
    npm run deploy
    ```
    
**To update app deployment:** run the <code>npm run deploy</code> command again.

## Back-end

1. New controller implementations.
2. When a ROLE_USER sent a request asking for other users' resources an exception **error** was sent as a response. Now, when a ROLE_USER sends a request is **modified** to get only its resources.
3. Exception handling of:
    - Repeated names on tipolitica
