package phone;

import phone.screen.listviewscreen.listViewCard.CallHistoryCard;

import java.util.ArrayList;
import java.util.List;

public class History<T> {
    public Phone phone;
    List<T> list = new ArrayList<>();

    public History(Phone phone) {
        this.phone = phone;
    }

    protected void add(T t) {
        list.add(t);
    }

    public void updateHistory() {
    }

    public List getList() {
        return list;
    }

    public int size() {
        return list.size();
    }
}

