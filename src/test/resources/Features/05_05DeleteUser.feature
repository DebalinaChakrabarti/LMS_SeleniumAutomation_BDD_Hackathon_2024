#Feature: Delete User
#
#Background: Logged on the LMS portal
#
  #@tag1
  #Scenario: Validate row level delete icon
    #Given The delete icon on row level in data table is enabled
    #When Admin click the delete icon
    #Then Alert appears with yes and No option
#
  #@tag2
  #Scenario: Validate accept alert
    #Given Admin clicks the delete icon
    #When You click yes option
    #Then User deleted alert pops and user is no more available in data table
#
  #@tag3
  #Scenario: Validate reject alert
    #Given Admin clicks the delete icon
    #When you click No option
    #Then User is still listed in data table
