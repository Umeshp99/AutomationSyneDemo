Feature: DB to Excel Comparison feature

Scenario: Utility to Compare DB values with Excel Data

Given User Connects to the required DataBase
When User extracts data from the table "employee"
Then intitialize excel "TestExcel" and Sheet "Sheet1"
Then Convert the Excel in the required collection
Then Verify that column count is same in DB and Excel
Then Verify that row count is same in DB and Excel
Then Compares the DB values with Excel Data