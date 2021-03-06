package duke.task;

import duke.exception.DukeException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Represents a list of tasks.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Creates an instance of TaskList.
     */
    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Creates an instance of TaskList with existing tasks.
     *
     * @param tasks list of tasks
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Add a new task to the list.
     *
     * @param task new task to add
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Search and get a task by the given index.
     *
     * @param index given index of the task
     * @return the result task
     * @throws DukeException exception for error while the given index not exist
     */
    public Task getByIndex(int index) throws DukeException {
        try {
            return tasks.get(index - 1);
        } catch (IndexOutOfBoundsException ex) {
            throw new DukeException("OOPS!!! We don't have this number in list!!!");
        }
    }

    /**
     * Get the size of the list.
     *
     * @return integer size of the list
     */
    public int getSize() {
        return tasks.size();
    }

    /**
     * Get the list from the TaskList object.
     *
     * @return list of tasks
     */
    public ArrayList<Task> getList() {
        return tasks;
    }

    /**
     * Delete the list of tasks based on given indexes.
     *
     * @param indexes list indexes of the task
     * @return deleted TaskList
     * @throws DukeException exception for error while the given index not exist
     */
    public TaskList deleteTaskByIndexes(List<Integer> indexes) throws DukeException {
        TaskList deletedTasks = new TaskList();
        try {
            // This for loop is to ensure the sequence of returned deletedTasks.
            for (int index : indexes) {
                deletedTasks.addTask(tasks.get(index - 1));
            }

            // Sort the list in reverse order before deleting.
            indexes.sort(Collections.reverseOrder());
            for (int index : indexes) {
                tasks.remove(index - 1);
            }
        } catch (IndexOutOfBoundsException ex) {
            throw new DukeException("OOPS!!! We don't have some number in list!!!");
        }
        return deletedTasks;
    }

    /**
     * Find the task which contains the keyword.
     *
     * @param keyword keyword to search
     * @return a TaskList of result tasks
     */
    public TaskList getTaskListWithKeyword(String keyword) {
        TaskList result = new TaskList();
        for (Task task : tasks) {
            if (task.getDescription().contains(keyword)) {
                result.addTask(task);
            }
        }
        return result;
    }
}
