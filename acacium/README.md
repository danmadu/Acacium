Run the application: 
1. Open the application in Intellij.
2. Start the application
3. Using Postman, post the csv file in the body as a form-data. The key for the csv file should be 'file'. Call this endpoint: http://localhost:8080/upload-shift-csvfile
4. Using Postman, get the csv file in a JSON format by calling this endpoint: http://localhost:8080/get-shifts