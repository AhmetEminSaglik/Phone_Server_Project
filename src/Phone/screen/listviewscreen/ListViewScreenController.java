package phone.screen.listviewscreen;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import phone.Phone;
import phone.key.ability.NumberKeyEvent;
import phone.screen.basescreen.BaseScreenController;
import phone.screen.listviewscreen.listViewCard.Card;

public abstract class ListViewScreenController extends BaseScreenController {
    @FXML
    private Label lblSelect;

    @FXML
    private Label lblBack;
    @FXML
    protected ListView<Card> menuListView;

    public ListViewScreenController(Phone phone) {
        super(phone);
        numberKeyEvent = new NumberKeyEvent(phone, menuListView);
    }


    public ListView<Card> getMenuListView() {
        return this.menuListView;
    }

    @Override
    public void updateScreen() {
//        getMenuListView().setMouseTransparent(true);
        preparePhoneScreenList();

        getMenuListView().setMouseTransparent(true);
        getMenuListView().getFocusModel().focus(0);
        getMenuListView().getSelectionModel().selectFirst();


    }
public abstract void setSwitchScreenParamaters();
    @Override
    public void addActionToOperatorKeys() {
        super.addActionToOperatorKeys();
//        System.out.println("GELEN SCREEN : " + menuListView.
//                getSelectionModel()
//                .getSelectedItem()
//                .getPhoneScreen()
//                .toString() );

        setSwitchScreenParamaters();
        numberKeyEvent.getListViewEvent().setEventToSelecPreviousOnListView(getWantedPhoneKey(phone, 0, 1), menuListView, this);
        numberKeyEvent.getListViewEvent().setEventToSelectNextOnListView(getWantedPhoneKey(phone, 1, 1), menuListView, this);
        getMenuListView().scrollTo(getMenuListView().getSelectionModel().getSelectedItem());

//      numberKeyEvent.setEventToGoUpOnListView(getWantedPhoneKey(phone, 0, 2), menuListView, this); // Bu tusunda yapabilecegi bir sey yok

//        numberKeyEvent.setEventToGoDownOnListView(getWantedPhoneKey(phone, 1, 1), menuListView, this);
    }

    //    public ListView<OptionScreenCard> getMenuListView() {
//
//        return  menuListView;
//    }
    public abstract void preparePhoneScreenList();

    public Label getLblSelect() {
        return lblSelect;
    }

    public void setLblSelect(Label lblSelect) {
        this.lblSelect = lblSelect;
    }

    public Label getLblBack() {
        return lblBack;
    }

    public void setLblBack(Label lblBack) {
        this.lblBack = lblBack;
    }

    public final void addItemtoMenuList(Card card) {
        getMenuListView().getItems().add(card);
//        System.out.println("Card : "+card);

    }
}
