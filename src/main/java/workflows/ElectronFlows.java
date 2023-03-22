package workflows;

import extentions.UIActions;
import extentions.WaitTimeUnit;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;

public class ElectronFlows extends CommonOps {

    @Step("Business Flow: Add New Task To The List")
    public static void addNewTask(String taskName)
    {
        UIActions.updateText(todoMain.getTxt_create(), taskName);
        UIActions.insertKey(todoMain.getTxt_create(), Keys.ENTER);
    }

    @Step("Business Flow: Count And Return Number Of Tasks In List")
    public static int getNumberOfTasks()
    {
        return todoMain.getList_tasks().size();
    }

    @Step("Business Flow: Empty Lists From Tasks")
    public static void emptyList()
    {
        for(int i = 0; i < getNumberOfTasks(); i++) {
            UIActions.mouseHover(todoMain.getBtn_deleteTask());
        }
    }

    @Step("Business Flow: Drag And Drop A Task")
    public static void dragAndDrop()
    {
        addNewTask("Java");
        addNewTask("C#");
        addNewTask("C++");

        WaitTimeUnit.Five00_MilliSecondWait();
        int last = getNumberOfTasks()-1;
        UIActions.dragAndDrop(todoMain.getList_dragAndDrop().get(last),todoMain.getList_dragAndDrop().get(0));
    }

    @Step("Business Flow: Mark Task Complete")
    public static void taskComplete()
    {
        UIActions.mouseHover(todoMain.getList_v().get(0));
        UIActions.click(drawerMainTodo.getOpenDrawer());
        UIActions.click(drawerMainTodo.getBtn_statusDrawer().get(1));
    }

    @Step("Business Flow: Shown Tasks By Color")
    public static void taskByColor()
    {
        addNewTask("JavaScript");
        UIActions.click(todoMain.getBtn_dropDownColors());
        UIActions.mouseHover(todoMain.getAllColors().get(1));
        addNewTask("Java");
        addNewTask("C#");
        UIActions.click(drawerMainTodo.getOpenDrawer());
        UIActions.mouseHover(drawerMainTodo.getAllColorsDrawer().get(1));
        WaitTimeUnit.Five00_MilliSecondWait();
        UIActions.click(drawerMainTodo.getCloseDrawer());
    }

}
