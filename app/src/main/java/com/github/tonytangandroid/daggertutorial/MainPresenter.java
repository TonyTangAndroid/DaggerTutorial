package com.github.tonytangandroid.daggertutorial;

import javax.inject.Inject;

public class MainPresenter {

    private final GetMessageUseCase getMessageUseCase;
    private MainView mainView;

    @Inject
    public MainPresenter(PremiumDataRepository premiumDataRepository,
                         GetMessageUseCase getMessageUseCase) {
        this.getMessageUseCase = getMessageUseCase;
    }

    public void init(MainView mainView) {
        this.mainView = mainView;
    }

    public void create() {
        mainView.showMessage(getMessageUseCase.retrieveMessage());
    }
}
