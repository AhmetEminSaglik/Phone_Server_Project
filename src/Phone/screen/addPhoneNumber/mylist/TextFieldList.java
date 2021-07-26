//package phone.screen.addPhoneNumber.mylist;
//
//import javafx.scene.control.TextField;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TextFieldList {
//
//    private List<TextField> list = new ArrayList<>();
//    int index = 0;
//
//    public List<TextField> getTextFieldList() {
//        return list;
//    }
//
//    public void setTextFieldList(List<TextField> textFieldList) {
//        this.list = textFieldList;
//    }
//
//    public int getTxtFieldListIndex() {
//        return index;
//    }
//
//    public void setTxtFieldListIndex(int index) {
//        this.index = index;
//    }
//
//    public TextField selectNextIndex() {
//        if (index < list.size() - 1) {
//            index++;
//        }
//        return list.get(index);
//    }
//
//    public TextField selectPreviousIndex() {
//        if (index > 0) {
//            index--;
//        }
//        return list.get(index);
//    }
//    public void add(TextField textField){
//        list.add(textField);
//
//    }
//    public TextField selectOnIndex(){
//        return list.get(index);
//
//    }
//    public List getList(){
//        return  list;
//    }
//    public TextField get(int index){
//        return list.get(index);
//    }
//    public int size(){
//        return list.size();
//    }
//}
