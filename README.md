This project aims to help the company by enabling the employee to input his timesheet through format.

For the first interface, a REST call will be made that allow a user to query his timesheet as well as fill it by sending a POST request with a JSON payload.

There can be several types of input for an employee.

-Work log for a client (an employee can work at several clients)
-Legal holidays
-Sick days
-Vacations
-Others


The work logs should have increments of hours, as there can be half-day at work.

At terms, the REST API should be able to handle more than just JSON format, a csv or xml could be given.