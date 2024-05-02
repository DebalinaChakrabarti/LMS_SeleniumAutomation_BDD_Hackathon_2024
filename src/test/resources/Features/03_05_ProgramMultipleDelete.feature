Feature: Multiple Delete Program
 
 
 Scenario:  Validate Common Delete button enabled after clicking on any checkbox
  Given Admin is in the manage program page after clicking Program on the navigation bar in the Program module
  When Admin clicks any checkbox in the data table in the Program module
  Then Admin should see common delete option enabled under header Manage Program in the Program module
  
 Scenario:  Validate multiple program deletion by selecting Single checkbox
  Given Admin clicks common delete button after selecting the check box in the data table to reach on confirm deletion alert in the Program module
  When Admin clicks <YES> button on the alert in the Program module
  Then Admin should land on Manage Program page and can see the selected program is deleted from the data table in the Program module
  
  Given Admin clicks common delete after selecting the check box in the data table to reach on confirm deletion alert in the Program module
  When Admin clicks <NO> button on the alert in the Program module
  Then Admin should land on Manage Program page and can see the selected program is not deleted from the data table in the Program module
  
  
  Scenario:  Validate multiple program deletion by selecting multiple check boxes
  Given Admin clicks common delete button after selecting multiple check boxes in the data table to reach on confirm deletion alert in the Program module
  When Admin clicks <YES> button on alert in the Program module
  Then Admin should land on Manage Program page and can see the selected programs are deleted from the data table in the Program module 
  
  Given Admin clicks common delete after selecting multiple check boxes in the data table to reach on confirm deletion alert in the Program module
  When Admin clicks <NO> button on alert in the Program module
  Then Admin should land on Manage Program page and can see the selected programs are not deleted from the data table in the Program module