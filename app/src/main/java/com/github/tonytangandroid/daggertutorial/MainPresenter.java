package com.github.tonytangandroid.daggertutorial;

import javax.inject.Inject;

public class MainPresenter {

  private final GetMessageUseCase getMessageUseCase;
  private final MainView mainView;
  private final MyUserRepoFactory myUserRepoFactory;

  @Inject
  public MainPresenter(
      MainView mainView, GetMessageUseCase getMessageUseCase, MyUserRepoFactory myUserRepoFactory) {
    this.mainView = mainView;
    this.getMessageUseCase = getMessageUseCase;
    this.myUserRepoFactory = myUserRepoFactory;
  }

  public void create() {
    MyUserRepo repo = myUserRepoFactory.create(new Config(getMessageUseCase.retrieveMessage()));
    mainView.showMessage(repo.getConfig().message);
  }
}
