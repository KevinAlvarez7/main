package duke.ui;

import duke.models.locker.Locker;

import java.util.List;
import java.util.Scanner;

public class Ui {
    private Scanner sc = new Scanner(System.in);

    public String readCommand() {
        return sc.nextLine();
    }

    /**
     * This function responsible for printing a line.
     */
    public void printDash() {
        String str = "";
        for (int i = 0; i < 120; i++) {
            str += "_";
        }
        printSpaces(str);
    }

    private void printSpaces(String printStr) {
        System.out.println("    " + printStr);
    }

    /**
     * This function prints the hello message every time Duke is initiated.
     */
    public void showWelcome() {
        String logo = "SpongeBob";
        printSpaces(" Hello from " + logo);
        printDash();
        printSpaces(" Hello! I am SpongeBob. I am here to manage lockers for you!");
        printSpaces(" What can I do for you?");
        printSpaces(" If you need any assistance, please type 'help' to access to User Manual.");
        printDash();
    }

    /**
     * This function prints the tasks stored in the list.
     * @param printData stores the list of tasks to be printed.
     */
    public void printList(List<Locker> printData) {
        printSpaces(" Here are the lockers in your list:");
        showList(printData);
    }

    /**
     * This function tells the user that Duke has marked the task as done.
     * @param printStr stores the task that has been marked as done.
     */
    public void printMarkAsDone(String printStr) {
        printSpaces(" Nice! I have marked this task as done:");
        printSpaces(" " + printStr);
        printDash();
    }

    /**
     * This function tells the user that Duke has added the task to the list.
     * @param listOfTasks used for printing the number of tasks in the list.
     * @param taskA stores the task that is to be added to the list.
     */
    public void printAddTask(List<Locker> listOfTasks, String taskA) {
        printSpaces(" Got it. I have added this task:");
        printSpaces("  " + taskA);
        showNumTasks(listOfTasks);
    }

    /**
     * This function tells the user that SpongeBob has added the locker into the list.
     * @param listOfLockers used for printing the number of lockers in the list
     * @param lockerA stores the locker that is added to the list
     */
    public void printAddLocker(List<Locker> listOfLockers, String lockerA) {
        printSpaces(" Got it. I have added this locker: ");
        printSpaces(" " + lockerA);
        printSpaces(" Now, Spongebob is managing " + listOfLockers.size() + " lockers");
        printDash();
    }

    /**
     * This function tells the user that SpongeBob has added a batch of lockers to the list.
     * @param num  stores the number of lockers that are added
     */
    public void printBatch(int num) {
        printSpaces(" Got it. I have added " + num + " lockers");
        printDash();
    }

    /**
     * This function is used to notify the user that SpongeBob has successfully assigned
     * the locker for the user.
     * @param locker stores the string to show the locker that has been assigned
     */
    public void printSuccessfulAllocation(String locker) {
        printSpaces(" I have successfully assigned a new locker to the student. "
                + "Here are the details:");
        printSpaces(" " + locker);
        printDash();
    }

    /**
     * prints the message for successful editing of lockers.
     * @param editedLocker stores the data of the edited locker
     */
    public void showSuccessfullyEdited(String editedLocker) {
        printSpaces(" I have successfully edited the locker properties.");
        printSpaces(" " + editedLocker);
        printDash();
    }

    public void showNoAvailableLockers() {
        printSpaces(" There are no available lockers at the moment. ");
        printSpaces(" Unfortunately I will have to terminate the subscription of the student");
    }

    /**
     * This function tells the user that Duke has snoozed/postponed/rescheduled the task.
     * @param taskA stores the task that is to be added to the list.
     * @param type stores whether that task is an event or a deadline
     * @param command stores whether user command is snooze or postpone or reschedule
     */
    public void printSnoozeTask(String taskA, String type, String command) {
        switch (type) {
        case "E":
            printSpaces(" I have successfully " + command + "d" + " the data and time of this event:");
            printSpaces("  " + taskA);
            printDash();
            break;
        case "D":
            printSpaces(" I have successfully " + command + "d" + " the data and time of this deadline:");
            printSpaces("  " + taskA);
            printDash();
            break;
        default:
            printSpaces(" Invalid command");
        }

    }

    private void showNumTasks(List<Locker> listOfTasks) {
        printSpaces(" Now you have " + listOfTasks.size()
                + ((listOfTasks.size() == 1) ? " locker in the list." : " lockers in "
                + "the list"));
        printDash();
    }

    private void showList(List<Locker> listOfTasks) {
        System.out.println();
        for (int i = 0; i < listOfTasks.size(); i++) {
            printSpaces(" " + listOfTasks.get(i).toString());
        }
        printDash();
    }

    /**
     * This function prints the exit message every time Duke is closed.
     */
    public void exitDuke() {
        printSpaces(" Bye! Hope to see you again.");
        printDash();
    }

    /**
     * This function prints the error message.
     * @param errorMessage stores the error message.
     */
    public void showError(String errorMessage) {
        printSpaces(errorMessage);
        printDash();
    }

    /**
     *  This function is used to notify the user that there were no available lockers in his list
     *  of preferences.
     */
    public void showNoLockersFoundInPreferences() {
        printSpaces(" Unable to find any free lockers in the preferences stated.");
        printSpaces(" Looking for free lockers in the entire system ...");
        printDash();
    }

    /**
     * This function tells the user that SpongeBob has deleted the lockers from the list.
     * @param lockerList used for showing the number of lockers left in the list.
     * @param lockerA stores the locker that is deleted.
     */
    public void deleteMessage(List<Locker> lockerList, String lockerA) {
        printSpaces(" Noted. I have removed this locker:");
        printSpaces("  " + lockerA);
        showNumTasks(lockerList);
    }

    /**
     * This function tells the user that SpongeBob has edited the locker from the list.
     * @param lockerA stores the locker that is edited
     */
    public void editMessage(String lockerA) {
        printSpaces("Noted. I have edited the locker to:");
        printSpaces(" " + lockerA);
        printDash();
    }

    /**
     * This function tells the user that SpongeBob has exported the CSV file.
     */
    public void exportMessage() {
        printSpaces("Noted. I have exported the details to a new CSV file");
        printDash();
    }

    /**
     * This function prints the tasks that match a given keyword.
     * @param taskList stores the tasks that match a given keyword.
     */
    public void keywordPrint(List<Locker> taskList) {
        printSpaces(" Here are the matching tasks in your list:");
        showList(taskList);
    }

    public void getRemindersList(List<Locker> taskList) {
        printSpaces(" Here are your deadlines:");
        showList(taskList);
    }


    /**
     * This function prints the message when there is an error in loading data from the file.
     * @param message stores the error message.
     */
    public void showLoadingError(String message) {
        printDash();
        printSpaces(message);
        printDash();
    }

    public void printFoundLockers(List<Locker> foundLockers) {
        if (foundLockers.size() != 0){
            printSpaces(" Here are lockers that match your search parameters ");
            showList(foundLockers);
        }
        else {
            printSpaces(" There are NO lockers that match your search parameters ");
        }


    /**
     * This function prints the syntax for addlocker command.
     */
    public void showAddSyntax() {
        printSpaces("To add a locker into the system:");
        printSpaces("  addlocker s/__ a/__ z/__");
        System.out.println();
    }

    /**
     * This function prints the syntax for addbatch command.
     */
    public void showAddBatchSyntax() {
        printSpaces("To add a batch of lockers into the system:");
        printSpaces("  addbatch s/__ u/__ a/__ z/__");
        System.out.println();
    }

    /**
     * This function prints the syntax for deletelocker command.
     */
    public void showDeleteSyntax() {
        printSpaces("To delete a locker from the system:");
        printSpaces("  deletelocker XXXX");
        System.out.println();
    }

    /**
     * This function prints the syntax for editlocker command.
     */
    public void showEditSyntax() {
        printSpaces("To edit the information of a locker:");
        printSpaces("  editlocker XXXX s/__ a/__ z/__ c/__");
        printSpaces("(Note: You can choose to change one or more tokens of the locker");
        System.out.println();
    }

    /**
     * This function prints the syntax for assign command.
     */
    public void showAssignSyntax() {
        printSpaces("To assign a locker for rental to a student:");
        printSpaces("  assign n/__ i/__ e/__ m/__ f/__ t/__ p/__");
        System.out.println();
    }

    /**
     * This function prints the syntax for list and bye command.
     */
    public void showOtherSyntax() {
        printSpaces("To show the list of lockers:");
        printSpaces("  list");
        System.out.println();
        printSpaces("To exit SpongeBob:");
        printSpaces("  bye");
        System.out.println();
    }

    /**
     * This function prints the legends for help manual.
     */
    public void showSyntaxLegends() {
        printSpaces("-LEGENDS-");
        printSpaces("XXXX - serial number of selected locker");
        printSpaces("s - serial number (addlocker) OR starting serial number (addbatch)");
        printSpaces("u - size");
        printSpaces("a - area");
        printSpaces("z - zone");
        printSpaces("c - condition/tags");
        printSpaces("n - name");
        printSpaces("i - id(matric number)");
        printSpaces("e - email");
        printSpaces("m - major of study");
        printSpaces("f - rental start date");
        printSpaces("t - rental end date");
        printSpaces("p - preferences");
        System.out.println();
    }

    /**
     * This function prints the notes in help manual.
     */
    public void showSyntaxNote() {
        printSpaces("(Note: All the tokens can be assigned in any order.)");
    }

    /**
     * This function prints the help manual when requested by the user.
     */
    public void printHelp() {
        printSpaces("HELP MANUAL");
        System.out.println();
        showAddSyntax();
        showAddBatchSyntax();
        showDeleteSyntax();
        showEditSyntax();
        showAssignSyntax();
        showOtherSyntax();
        showSyntaxLegends();
        showSyntaxNote();
        printDash();

    }
}