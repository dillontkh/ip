import java.util.ArrayList;

public class DeleteCommand extends Command {
    private final ArrayList<String> argsList;

    public DeleteCommand(ArrayList<String> argsList) {
        this.argsList = argsList;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws NollidException {
        // This means that the user has not supplied any number with the command
        if (this.argsList.size() == 1) {
            throw new NollidException("Please enter the task you wish to delete!\n"
                    + "Usage: delete [task number]");
        } else {
            try {
                int taskIndex = Integer.parseInt(this.argsList.get(1));

                String message = "Alright, the following task has been removed:\n"
                        + "\t" + tasks.remove(taskIndex - 1).toString() + "\n";

                message += tasks.summary();

                ui.sendMessage(message);
                storage.update(tasks);
            } catch (NumberFormatException e) {
                throw new NollidException("Please enter a number for the delete command.\n"
                        + "Usage: delete [task number]");
            } catch (IndexOutOfBoundsException e) {
                throw new NollidException("Are you sure that's a valid task number? (Tip: use 'list' to check the "
                        + "number of your task!)\n" + "Usage: delete [task number]");
            }
        }
    }
}