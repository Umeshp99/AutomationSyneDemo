$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/feature/DBtoExcelComparison.feature");
formatter.feature({
  "line": 1,
  "name": "DB to Excel Comparison feature",
  "description": "",
  "id": "db-to-excel-comparison-feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1269141100,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Utility to Compare DB values with Excel Data",
  "description": "",
  "id": "db-to-excel-comparison-feature;utility-to-compare-db-values-with-excel-data",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "User Connects to the required DataBase",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User extracts data from the table \"employee\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "intitialize excel \"TestExcel\" and Sheet \"Sheet1\"",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Convert the Excel in the required collection",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Verify that column count is same in DB and Excel",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "Verify that row count is same in DB and Excel",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "Compares the DB values with Excel Data",
  "keyword": "Then "
});
formatter.match({
  "location": "DBtoExcelStepDefinition.user_Connects_to_the_required_DataBase()"
});
formatter.result({
  "duration": 1209108600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "employee",
      "offset": 35
    }
  ],
  "location": "DBtoExcelStepDefinition.user_extracts_data_from_the_table(String)"
});
formatter.result({
  "duration": 34613500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "TestExcel",
      "offset": 19
    },
    {
      "val": "Sheet1",
      "offset": 41
    }
  ],
  "location": "DBtoExcelStepDefinition.intitialize_excel_and_Sheet(String,String)"
});
formatter.result({
  "duration": 808558300,
  "status": "passed"
});
formatter.match({
  "location": "DBtoExcelStepDefinition.convert_the_Excel_in_the_required_collection()"
});
formatter.result({
  "duration": 12601400,
  "status": "passed"
});
formatter.match({
  "location": "DBtoExcelStepDefinition.verify_that_column_count_is_same_in_DB_and_Excel()"
});
formatter.result({
  "duration": 9638700,
  "status": "passed"
});
formatter.match({
  "location": "DBtoExcelStepDefinition.verify_that_row_count_is_same_in_DB_and_Excel()"
});
formatter.result({
  "duration": 156200,
  "status": "passed"
});
formatter.match({
  "location": "DBtoExcelStepDefinition.compares_the_DB_values_with_Excel_Data()"
});
formatter.result({
  "duration": 901400,
  "status": "passed"
});
});