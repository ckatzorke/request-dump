# request-dump

Small utility (REST controller) to be added to your sprig app, that prints out information about the received request.
Useful for debug use, when you want to make sure which headers have been modified during the way to the server.


## Example

Request to /requestdump
```json
{
  "requestHeaders": {
    "accept-language": [
      "en-US,en;q=0.8,de-DE;q=0.6,de;q=0.4"
    ],
    "cookie": [
      "stuff"
    ],
    "host": [
      "localhost:8080"
    ],
    "upgrade-insecure-requests": [
      "1"
    ],
    "connection": [
      "keep-alive"
    ],
    "cache-control": [
      "max-age=0"
    ],
    "accept-encoding": [
      "gzip, deflate, sdch, br"
    ],
    "user-agent": [
      "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36"
    ],
    "accept": [
      "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8"
    ]
  },
  "requestParameters": {
    "test": [
      "1"
    ]
  },
  "method": "GET"
}
```

Request to /requestdump?test=1
```json
{
  "requestHeaders": {
    "accept-language": [
      "en-US,en;q=0.8,de-DE;q=0.6,de;q=0.4"
    ],
    "cookie": [
      "stuff"
    ],
    "host": [
      "localhost:8080"
    ],
    "upgrade-insecure-requests": [
      "1"
    ],
    "connection": [
      "keep-alive"
    ],
    "cache-control": [
      "max-age=0"
    ],
    "accept-encoding": [
      "gzip, deflate, sdch, br"
    ],
    "user-agent": [
      "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36"
    ],
    "accept": [
      "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8"
    ]
  },
  "requestParameters": {
    "test": [
      "1"
    ]
  },
  "method": "GET"
}