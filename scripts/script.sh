echo 1. Get all screenings between 2019-10-31 and 2021-10-31
curl 'http://localhost:8080/screenings?from=2019-10-31T01:30:00.000-05:00&to=2021-10-31T01:30:00.000-05:00' | json_pp 

echo 2. Get  information about particular screening
curl 'http://localhost:8080/screenings/testId' | json_pp 

echo 3. Reserve seats 
curl -s -d @data.json -H "Content-Type: application/json; charset=UTF-8"  -X POST http://localhost:8080/reservations | json_pp 