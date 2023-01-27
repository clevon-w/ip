package storage;

import java.util.ArrayList;

import exception.InvalidArgumentException;

/**
 * Represents the to do list
 * @author clevon-w
 */
public class TaskList {
    /**
     * Represents the to do list
     */
    private ArrayList<Task> taskList;

    /**
     * Creates an empty ArrayList of Strings as an empty to do list
     */
    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    /**
     * Adds a task into the to do list
     * @param newToDo The new task to be added
     */
    public void createToDo(Task newToDo) {
        this.taskList.add(newToDo);
    }

    /**
     * Custom String representation of the to do list
     * @return Custom string representation
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Here are the tasks in your list:\n");
        if (taskList.size() == 0) {
            return "There are currently no tasks in your to do list,\n\t create one now!";
        }
        for (int i = 0; i < taskList.size(); i++) {
            res.append(String.format("\t %d.%s\n", i + 1, taskList.get(i).toString()));
        }
        return res.toString().trim();
    }

    /**
     * Function to mark a task in the to do list
     * @param i The index of the task to mark
     * @return Returns the marked task for printing
     */
    public Task mark(Integer i) throws InvalidArgumentException {
        try {
            Task curr = this.taskList.get(i - 1);
            curr.markAsDone();
            return curr;
        } catch (IndexOutOfBoundsException err) {
            throw new InvalidArgumentException("Make sure you enter an index of a task that exists in the list!");
        }
    }

    /**
     * Function to unmark a task in the to do list
     * @param i The index of the task to unmark
     * @return Returns the unmarked task for printing
     */
    public Task unmark(Integer i) throws InvalidArgumentException{
        try {
            Task curr = this.taskList.get(i - 1);
            curr.unmarkAsDone();
            return curr;
        } catch (IndexOutOfBoundsException err) {
            throw new InvalidArgumentException("Make sure you enter an index of a task that exists in the list!");
        }
    }

    /**
     * Determine the number of tasks in the to do list
     * @return Count of the tasks
     */
    public int count() {
        return taskList.size();
    }

    /**
     * Function to delete a task in the to do list
     * @param i The index of the task to delete
     * @return Returns the deleted task for printing
     */
    public Task delete(Integer i) throws InvalidArgumentException {
        try {
            Task curr = this.taskList.get(i - 1);
            this.taskList.remove(curr);
            return curr;
        } catch (IndexOutOfBoundsException err) {
            throw new InvalidArgumentException("Make sure you enter an index of a task that exists in the list!");
        }
    }

    public ArrayList<String> getDataList() {
        ArrayList<String> res = new ArrayList<>();
        this.taskList.forEach(task -> {
            res.add(task.toData());
        });
        return res;
    }
}
