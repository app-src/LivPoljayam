// Import the http module
const http = require('http');

// Create the server
const server = http.createServer((req, res) => {

  // Set response HTTP header with HTTP status and Content type
  res.writeHead(200, {'Content-Type': 'text/plain'}); 
  
  // Send response body
  res.end('Hello World!');  
});

// Listen on port 3000
server.listen(3000, 'localhost', () => {
  console.log('Node.js web server running on port 3000');
});