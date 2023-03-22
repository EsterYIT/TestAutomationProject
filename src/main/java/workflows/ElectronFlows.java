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

    @Step("Business Flow: RGB Header Colors")
    public static boolean RGBColors(String R, String G, String B)
    {
        boolean equals = false;
        UIActions.click(todoMain.getEditor_headerBg());
        UIActions.click(todoMain.getAllHeaderColors().get(6));
        String bgColor = todoMain.getBg_header().getAttribute("style").split(("\\("))[1];
        String red = bgColor.split(",")[0];
        String green = bgColor.split(",")[1];
        String blue = bgColor.split(",")[2].split(("\\)"))[0];

        if(R.equals(red.trim()) && G.equals(green.trim()) && B.equals(blue.trim()))
            equals = true;

        return equals;
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
