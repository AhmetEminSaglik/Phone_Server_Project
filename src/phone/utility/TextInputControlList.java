package phone.utility;

import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;

import java.util.ArrayList;
import java.util.List;

public class TextInputControlList {
    private List<TextInputControl> list = new ArrayList();
    int index = 0;

    public TextInputControl selectNextIndex() {
        if (index < list.size() - 1) {
            index++;
        }
        return list.get(index);
    }

    public TextInputControl selectPreviousIndex() {
        if (index > 0) {
            index--;
        }
        return list.get(index);
    }

    public void add(TextInputControl textInputControl) {
        list.add(textInputControl);

    }

    public TextInputControl selectOnIndex() {
        return list.get(index);

    }

    public List<TextInputControl> getList() {
        return list;
    }

    public void setList(List<TextInputControl> list) {
        this.list = list;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public TextInputControl get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }
}
