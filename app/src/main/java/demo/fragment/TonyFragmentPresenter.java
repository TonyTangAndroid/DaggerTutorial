package demo.fragment;

import com.github.tonytangandroid.daggertutorial.GetMessageUseCase;

import javax.inject.Inject;

public class TonyFragmentPresenter {


    private TonyFragmentView tonyFragmentView;
    private final GetMessageUseCase getMessageUseCase;

    @Inject
    public TonyFragmentPresenter(GetMessageUseCase getMessageUseCase) {
        this.getMessageUseCase = getMessageUseCase;
    }

    public void setTonyFragmentView(TonyFragmentView tonyFragmentView) {
        this.tonyFragmentView = tonyFragmentView;
    }

    public void create() {
        tonyFragmentView.showFragmentMessage(getMessageUseCase.retrieveMessage());
    }
}
