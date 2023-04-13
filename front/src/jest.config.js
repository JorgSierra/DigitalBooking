module.exports = {
transform: {
    "^.+\\.jsx?$": "babel-jest"
  },
  moduleNameMapper: {
    
    axios: "<rootDir>/src/__mocks__/axios.js"
  },
  testPathIgnorePatterns: [
    "<rootDir>/node_modules/",
    "<rootDir>/build/",
    "<rootDir>/src/index.jsx"
  ],
  moduleFileExtensions: [
    "js",
    "jsx"
  ],
  globals: {
    "NODE_ENV": "test"
  },
  setupFilesAfterEnv: [
    "<rootDir>/src/setupTests.js"
  ],
  collectCoverage: true,
  coverageReporters: [
    "text",
    "html"
  ],
  coverageDirectory: "<rootDir>/coverage",
  coveragePathIgnorePatterns: [
    "<rootDir>/node_modules/",
    "<rootDir>/build/",
    "<rootDir>/src/index.jsx"
  ],
  coverageThreshold: {
    "global": {
      "branches": 80,
      "functions": 80,
      "lines": 80,
      "statements": 80
    }
  },
  transformIgnorePatterns: [
    "node_modules/(?!(react|react-dom|@testing-library|@babel/runtime))"
  ],
  resolver: "jest-resolver-webpack",
  roots: [
    "<rootDir>/src/__test__"
  ],
  testEnvironment: "jsdom"
};
