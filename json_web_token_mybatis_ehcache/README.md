Json Web Token Demo with Filter to check if have the token for the /secure endpoint.
It also use the ehcache to cache the token.

1.check the index controller to make sure the application run normally
<image src="https://github.com/XLuffyStory/SpringBootStudy/blob/master/json_web_token_mybatis_ehcache/postman_screenshot/index_controller.JPG">

2.Check existing users,currently there is no user
<image src="https://github.com/XLuffyStory/SpringBootStudy/blob/master/json_web_token_mybatis_ehcache/postman_screenshot/check_users.JPG">

3.Register new user with username and password
<image src="https://github.com/XLuffyStory/SpringBootStudy/blob/master/json_web_token_mybatis_ehcache/postman_screenshot/register.JPG">

4.Login with correct username and password to get the token back and copy the token for later use.
<image src="https://github.com/XLuffyStory/SpringBootStudy/blob/master/json_web_token_mybatis_ehcache/postman_screenshot/login_to_getToken.JPG">

5.Go to the secure page without token, it will fail and have message about no authorisation information
<image src="https://github.com/XLuffyStory/SpringBootStudy/blob/master/json_web_token_mybatis_ehcache/postman_screenshot/secure_page.JPG">

6.Go to the secure pate with token, it will be successful at this time.
<image src="https://github.com/XLuffyStory/SpringBootStudy/blob/master/json_web_token_mybatis_ehcache/postman_screenshot/secure_page_with_token.JPG">

7.Register another user as username as tom and get the token after login with tom to get token.
Login with different user will have different token as token will have the username in it(setting in the token generation)
<image src="https://github.com/XLuffyStory/SpringBootStudy/blob/master/json_web_token_mybatis_ehcache/postman_screenshot/secure_token_with_token_for_another_user.JPG">
