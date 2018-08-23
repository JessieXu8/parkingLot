
1. create user successfully:
    given: user information
    when: post api/users
    then: return the status code is 204
2. create user failed:
    given: user information
    when: post api/users
    then: return the status code is 400
