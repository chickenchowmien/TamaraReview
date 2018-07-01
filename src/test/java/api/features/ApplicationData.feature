Feature: Applicants data cvs report

  Background: User is on Applicants report page

    Scenario: Validate UI data against CSV report
      Given csv report is generated
      Then data in UI and csv report should match