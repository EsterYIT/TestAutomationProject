package sanity;

import extentions.UIVerifications;
import extentions.WaitTimeUnit;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

import static workflows.ElectronFlows.getNumberOfTasks;

@Listeners(utilities.Listeners.class)
public class TodoElectron extends CommonOps {

    @Test(description = "Test01 - Add And Verify New Task")
    @Description("This test adds a new task and verifies it in the list tasks")
    public void test01_addAndVerifyNewTasks()
    {
        ElectronFlows.addNewTask("Learn Java");
        WaitTimeUnit.twoSecondWait();
        UIVerifications.verifyNumber(getNumberOfTasks(),1);
    }

    @Test(description = "Test02 - Drag Last Task To First Line")
    @Description("This test verifies that last task will be at the top of the tasks list")
    public void test02_lastTaskAtTheTopOfList()
    {
        ElectronFlows.dragAndDrop();
        String actual = todoMain.getList_tasks().get(0).getText().split("\n")[1];
        UIVerifications.verifyTextInText(actual,"C++");
    }

    @Test(description = "Test03 - Mark Task In 'V' And Verify That Task Is Not In Todo Tasks List")
    @Description("This test verifies that completed tasks is not shown in 'Todo' tasks list")
    public void test03_markTaskIsCompleted()
    {
        ElectronFlows.addNewTask("Java");
        ElectronFlows.taskComplete();
        UIVerifications.visibilityOfElement(todoMain.getTxt_noTasks());
    }

    @Test(description = "Test04 - Shows Tasks By Color")
    @Description("This test verifies that shown tasks by chosen color")
    public void test04_tasksByColor()
    {
        ElectronFlows.taskByColor();
        int remainingTasks = Integer.parseInt(drawerMainTodo.getTxt_remainingTasks().getText().split("")[0]);
        UIVerifications.verifyNumber(getNumberOfTasks(),remainingTasks);
    }

}
