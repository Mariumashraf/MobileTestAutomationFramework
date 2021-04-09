package com.qacart.screens;

import com.qacart.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class NewTaskScreen extends Base {
    @AndroidFindBy(xpath = "//*[@text='Add new Task']")
    private MobileElement addTaskBtn;

    @AndroidFindBy(xpath = "//*[@text='Enter a new Task']")
    private MobileElement taskNameTxt;

    @AndroidFindBy(xpath = "//*[@text='ABack']")
    private MobileElement backBtn;

  public void addNewTask(String taskName){
      addTaskBtn.click();
      taskNameTxt.sendKeys(taskName);
      addTaskBtn.click();
  }

  public void clickOnCancel(){
      addTaskBtn.click();
      backBtn.click();
  }

}
