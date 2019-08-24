package demo.fragment;

import com.github.tonytangandroid.daggertutorial.GetMessageUseCase;

import javax.inject.Inject;

public class TonyActivityPresenter {

    private final GetMessageUseCase getMessageUseCase;
    private final TonyActivityView mainView;

    @Inject
    public TonyActivityPresenter(TonyActivityView mainView,
                                 GetMessageUseCase getMessageUseCase) {
        this.mainView = mainView;
        this.getMessageUseCase = getMessageUseCase;
    }

    public void create() {
        mainView.showActivityMessage(getMessageUseCase.retrieveMessage());
    }
}
