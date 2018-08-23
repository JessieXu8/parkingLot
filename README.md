
1. create user successfully:
    given: user information
    when: post api/users
    then: return the status code is 2XX
2. create user failed:
    given: user information
    when: post api/users
    then: return the status code is 4XX
3. create user successfully:
    given: user information
    when: call addUser function in UserService
    then: return true
4. create user failed:
    given: user information
    when:  call addUser function in UserService
    then:  return false
    
