$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("./FeatureFiles/Login.feature");
formatter.feature({
  "line": 1,
  "name": "Login",
  "description": "",
  "id": "login",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3829264465,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "to test the login with valid credentials",
  "description": "",
  "id": "login;to-test-the-login-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@Smoke"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user open the browser",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user clicks on Sign_In link",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user enter username \"automationwithpankaj@gmail.com\"",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "user enter password as \"test@1234\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "user clicks on sign in",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "user should be logged in successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user logout from the application",
  "keyword": "And "
});
formatter.match({
  "location": "StepDef.user_open_the_browser()"
});
formatter.result({
  "duration": 9482480894,
  "status": "passed"
});
formatter.match({
  "location": "StepDef.user_clicks_on_Sign_In_link()"
});
formatter.result({
  "duration": 2295600029,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "automationwithpankaj@gmail.com",
      "offset": 21
    }
  ],
  "location": "StepDef.user_enter_username(String)"
});
formatter.result({
  "duration": 331998117,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test@1234",
      "offset": 24
    }
  ],
  "location": "StepDef.user_enter_password_as(String)"
});
formatter.result({
  "duration": 200956874,
  "status": "passed"
});
formatter.match({
  "location": "StepDef.user_clicks_on_sign_in()"
});
formatter.result({
  "duration": 1786261138,
  "status": "passed"
});
formatter.match({
  "location": "StepDef.user_should_be_logged_in_successfully()"
});
formatter.result({
  "duration": 96921161,
  "status": "passed"
});
formatter.match({
  "location": "StepDef.user_logout_from_the_application()"
});
formatter.result({
  "duration": 2358087226,
  "status": "passed"
});
formatter.after({
  "duration": 214092088,
  "status": "passed"
});
});