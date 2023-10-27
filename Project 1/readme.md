# Ledger CLI App

## Description

The Ledger CLI App is a user-friendly command-line interface application designed for keeping track of financial transactions. It allows users to add deposits, make payments, view their ledger, and run custom or predefined reports. The application offers a seamless experience by refreshing each screen to maintain a clean and organized view.

## Features

- **Home Screen**: User is presented with the following options:
  - **Add Deposit**: Input deposit details and save them to a CSV file.
  - **Make Payment**: Input debit details and save them to a CSV file.
  - **Ledger**: View the ledger with the newest entries shown first.
  - **Exit**: Close the application.

- **Ledger Screen**:
  - **Display All Entries**: View all the transactions.
  - **Display Deposits**: Filter and view only deposit entries.
  - **Display Payments**: Filter and view only payment entries.
  - **Reports**: Access a new screen for running custom or predefined reports. Options include:
    - **Month To Date**
    - **Previous Month**
    - **Year To Date**
    - **Previous Year**
    - **Search by Vendor**: Input a vendor name and view all related entries.
    - **Back**: Return to the previous screen.
  - **Home**: Return to the home screen.

## Technical Details

- The application interfaces with a CSV file to persistently store and retrieve transaction data.
- The CLI refreshes with each navigation ensuring a clean and clutter-free user experience.
- Date and time comparisons are made using an interface, ensuring accurate and efficient operations.
