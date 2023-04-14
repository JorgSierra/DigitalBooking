# Front-end

Deploying <code>Vite+React</code> app to github pages:

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
