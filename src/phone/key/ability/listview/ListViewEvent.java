package phone.key.ability.listview;

import javafx.scene.control.ListView;
import phone.Phone;
import phone.key.PhoneKey;
import phone.key.ability.KeyAbility;
import phone.key.ability.function.Function;
import phone.screen.basescreen.BaseScreen;
import phone.screen.basescreen.BaseScreenController;

public class ListViewEvent {
    Phone phone;
    ListView listView;

    public ListViewEvent(Phone phone, ListView listView) {
        this.phone = phone;
        this.listView = listView;
    }

    public void setEventToSelectNextOnListView(PhoneKey phoneKey, ListView listView, BaseScreenController baseScreenController) {
        phoneKey.setOnAction(
                (e) -> {
                    if (!isNull(listView) && !isLastIndex(listView)) {
                        listView.getSelectionModel().selectNext();
                        new Function(phone).updateAllChanges();
//                        new KeyAbility(phone).updateScreenController(baseScreenController);
                    }
                }
        );
    }


    public void setEventToSelecPreviousOnListView(PhoneKey phoneKey, ListView listView, BaseScreenController baseScreenController) {
        phoneKey.setOnAction(
                (e) -> {
                    if (!isNull(listView) && !isFirstIndex(listView)) {
                        listView.getSelectionModel().selectPrevious();
                        new Function(phone).updateAllChanges();
//                        new KeyAbility(phone).updateScreenController(baseScreenController);
                    }
                }
        );

    }


    boolean isNull(Object object) {
        if (object == null)
            return true;
        return false;

    }


    boolean isFirstIndex(ListView listView) {
        if (listView.getSelectionModel().getSelectedIndex() == 0)
            return true;
        return false;
    }

    boolean isLastIndex(ListView listView) {

        if (listView.getSelectionModel().getSelectedIndex() == listView.getItems().size() - 1)
            return true;
        return false;
    }


}
