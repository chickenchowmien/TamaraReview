
Feature: Verify amount of names returned from Server (1-500 range)

@n
  Scenario Outline: User sends valid amount request to server
    When the user sends the request to a server for <num> name
    Then The the server should return expected number of names

    Examples: 
      | number |
      |   1 |
      | 499 |
      | 500 |

@p
  Scenario Outline: User sends invalid amount request to server
    When The user sends the invalid request to the server for <num> the invalid amount of names
    Then the server should return expected exception

    Examples: 
      | number |
      |   0 |
      |  -1 |
      | 501 |
