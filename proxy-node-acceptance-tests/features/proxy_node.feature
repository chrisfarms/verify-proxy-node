Feature: proxy-node feature

    Scenario: Proxy node happy path - LOA LOW
        Given the proxy node is sent a LOA 'Low' request
        And they progress through verify
        And they login to stub idp
        Then they should arrive at the success page

    Scenario: Proxy node happy path - LOA Substantial
        Given the proxy node is sent a LOA 'Substantial' request
        And they progress through verify
        And they login to stub idp
        Then they should arrive at the success page

    Scenario: Proxy node happy path - LOA High
        Given the proxy node is sent a LOA 'High' request
        Then the user should be presented with an error page

    Scenario: Stub connector Generates Authn Failure
        Given the stub connector supplies a bad authn request
        Then the user should be presented with an error page

    Scenario: Show error page if page doesnt exist
        Given the user accesses a invalid page
        Then the user should be presented with an error page

    Scenario: Show error page if route is not accessible
        Given the user accesses the gateway response url directly
        Then the user should be presented with an error page
