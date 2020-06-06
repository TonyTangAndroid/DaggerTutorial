package com.github.tonytangandroid.daggertutorial;

import javax.inject.Inject;

public class MainPresenter {

  private final GetMessageUseCase getMessageUseCase;
  private final MainView mainView;

  @Inject
  public MainPresenter(MainView mainView, GetMessageUseCase getMessageUseCase) {
    this.mainView = mainView;
    this.getMessageUseCase = getMessageUseCase;
  }

  public void create() {
    mainView.showMessage(getMessageUseCase.retrieveMessage());
  }
}
