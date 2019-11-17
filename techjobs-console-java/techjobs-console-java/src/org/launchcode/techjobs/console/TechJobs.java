package org.launchcode.techjobs.console;

import javax.naming.Name;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by LaunchCode
 */

//TechJobs booger = new TechJobs();


public class TechJobs {

    private static Scanner in = new Scanner(System.in);

    public static void main (String[] args) {

        // Initialize our field map with key/name pairs
        HashMap<String, String> columnChoices = new HashMap<>();
        columnChoices.put("core competency", "Skill");
        columnChoices.put("employer", "Employer");
        columnChoices.put("location", "Location");
        columnChoices.put("position type", "Position Type");
        columnChoices.put("all", "All");

        // Top-level menu options
        HashMap<String, String> actionChoices = new HashMap<>();
        actionChoices.put("search", "Search");
        actionChoices.put("list", "List");
//        System.out.println(columnChoices); // ****************************** THIS WAS MY ADDD IN IM LOOKING AT WHAT THESE HAVE
//        System.out.println(actionChoices); // ****************************** THIS WAS MY ADDD IN IM LOOKING AT WHAT THESE HAVE

        System.out.println("Welcome to LaunchCode's TechJobs App!");

        // Allow the user to search until they manually quit
        while (true) {

            String actionChoice = getUserSelection("View jobs by:", actionChoices);

            if (actionChoice.equals("list")) {

                String columnChoice = getUserSelection("List", columnChoices);

                if (columnChoice.equals("all")) {
                    printJobs(JobData.findAll());
                } else {
                    ArrayList<String> results = JobData.findAll(columnChoice);

                    System.out.println("\n*** All " + columnChoices.get(columnChoice) + " Values ***");

                    // Print list of skills, employers, etc
                    for (String item : results) {
                        System.out.println(item);
                    }
                }

            } else { // choice is "search"

                // How does the user want to search (e.g. by skill or employer)
                String searchField = getUserSelection("Search by:", columnChoices);

                // What is their search term?
                System.out.println("\nSearch term: ");
                String searchTerm = in.nextLine();

                if (searchField.equals("all")) {
//                    System.out.println("Search all fields not yet implemented.");
//                    System.out.println(JobData.findByValue(searchField, searchTerm));

                    printJobs(JobData.findByValue(searchField, searchTerm));        //**********************************************************
//                    printJobs(JobData.findByValue(searchTerm));

              } else {
                    printJobs(JobData.findByColumnAndValue(searchField, searchTerm));
                }
            }
        }
    }

    // ﻿Returns the key of the selected item from the choices Dictionary
    private static String getUserSelection(String menuHeader, HashMap<String, String> choices) {

        Integer choiceIdx;
        Boolean validChoice = false;
        String[] choiceKeys = new String[choices.size()];

        // Put the choices in an ordered structure so we can
        // associate an integer with each one
        Integer i = 0;
        for (String choiceKey : choices.keySet()) {
            choiceKeys[i] = choiceKey;
            i++;
        }

        do {

            System.out.println("\n" + menuHeader);

            // Print available choices
            for (Integer j = 0; j < choiceKeys.length; j++) {
                System.out.println("" + j + " - " + choices.get(choiceKeys[j]));
            }

            choiceIdx = in.nextInt();
            in.nextLine();

            // Validate user's input
            if (choiceIdx < 0 || choiceIdx >= choiceKeys.length) {
                System.out.println("Invalid choice. Try again.");
            } else {
                validChoice = true;
            }

        } while(!validChoice);

        return choiceKeys[choiceIdx];
    }

    // Print a list of jobs
    private static void printJobs(ArrayList<HashMap<String, String>> someJobs) {

            if (someJobs.isEmpty()) {
                System.out.println("No Match for your Search.");

            } else {
                for (HashMap<String, String> job : someJobs) {
                    System.out.println("***************");
                    Collection<String> keys = job.keySet();
                    for (String akey : keys) {
                        System.out.println(akey + ": " + job.get(akey));
                    }
                    System.out.println("***************");
                }

            }

//        ArrayList arrayListOfJobs;
//        arrayListOfJobs = JobData.findAll();
//        System.out.println(arrayListOfJobs.get(0));
////
//        String someString = String.valueOf(arrayListOfJobs);
////        System.out.println(someString);
//        Object theJob;*/

//        System.out.println(JobData.findAll()); // ****************************** THIS WAS MY ADDD IN IM LOOKING AT WHAT THESE HAVE
//        System.out.println(arrayListOfJobs.get(0));
//
//        Collection<String> theKeys = arrayListOfJobs.get(0);

//        theJob = arrayListOfJobs.get(0);
//        System.out.println(theJob + "********** &&&&&&&&& ");

//        System.out.println("********" + someString);
//        String goober = arrayListOfJobs.toString();
//        System.out.println(goober.indexOf("name"));
//        System.out.println(goober.contentEquals("name"));
//        System.out.println(arrayListOfJobs.contains(0));
//        System.out.println(arrayListOfJobs.get(0).getClass() + "***********************"); // ****************************** THIS WAS MY ADDD IN IM LOOKING AT WHAT THESE HAVE
//        System.out.println(arrayListOfJobs.get(0).getClass());
//        System.out.println(arrayListOfJobs.size() + "***********************");
////        System.out.println("*****");
//        System.out.println("*****");
//        System.out.println("printJobs is not implemented yet");
        //        System.out.println("printJobs is not implemented yet");
    }
}
