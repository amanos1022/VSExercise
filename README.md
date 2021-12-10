# Vinoshipper Code Challenge

### Run Tests
`./gradlew clean test`

### Run Server Locally
```
./gradlew bootRun
```
Server will run at `http://localhost:8080/`


## Age Validator ("Bouncer")
The virtual bouncer will verify that all requests are "of age" (over 21). It compares the `bday` GET parameter with the current date to determine this.

### Example Request:
```
curl http://localhost:8080/bouncer?bday=1984-01-01
```
#### Response:
```
{
    "data": {
        "message": "You are good to go."
    },
    "status": "OK"
}
```

Make sure you're using ISO 8601 as your datetime format, or you will be yelled at. e.g.:

```
curl "http://localhost:8080/bouncer?bday=3084/01/01" 
```

#### Response
```
{
    "data": {
        "error_message": "Birthday isn't properly formatted"                                 
    },
    "status": "ERROR"
}
```

If any time travellers happen to use the system, they will be delt with appropriately:
### Example Request:
```
curl http://localhost:8080/bouncer?bday=3084-01-01
```

#### Response:
```
{
    "data": {
        "error_message": "No future people allowed"
    },
    "status": "ERROR"
}
```

## Business Hour Calculator (HoursDiff)
The business hour calculator is here to help you know how many hours of your life you will dedicate to coding for any given time span! Simply format your request as follows:

### Clarifications
1. If the start date is in the middle of the work day, the hour you're in will count toward the total.
2. If the end date is in the middle of the work day that hour will be counted toward the total.
3. This calculator does not take holidays into consideration.
```
curl "http://localhost:8080/hours-diff?start=2020-12-09T04:00:00&end=2020-12-25T20:00:00"
```
and you shall receive this informative response:
```
{
    "data": {
        "end": "2020-12-25T20:00:00",
        "hours": 104,
        "start": "2020-12-09T04:00:00"
    },
    "status": "OK"
}
```
Make sure you're using ISO 8601 as your datetime format, or you will be yelled at. e.g.:

```
curl "http://localhost:8080/hours-diff?start=Aug,42009T04:00:00&end=2020-12-25T20:00:00"
```

#### Response
```
{
    "data": {
        "error_message": "Start date time or end date time was not properly formatted please use ISO 8601 (e.g. yyyy-mm-ddTHH:MM:SS)"
    },
    "status": "ERROR"
}
```

# TODOs
There's a ton of things that could be improved on with more time. A couple things would be:
- More/better integration tests
- More extensive unit tests to hunt down edge cases
