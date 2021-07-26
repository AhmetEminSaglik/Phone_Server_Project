package phone;

import phone.screen.basescreen.BaseScreen;

import java.util.Stack;

public class ScreenStack {

    private Stack<BaseScreen> screenStack = new Stack();

    public void addCurrentScreenToStack(BaseScreen baseScreen) {
        for (BaseScreen item : screenStack) {
            System.out.println(" Screen : " + item);
        }
        screenStack.add(baseScreen);
    }

    public void clearScreenStack() {

        if (!isScreenStackEmpty()) {
            for (int i = screenStack.size() - 1; i >= 0; i--) {
                System.out.println(" remove item : " + screenStack.get(i));
                screenStack.remove(i);
            }
            System.out.println(">>>>>>>>>>>>>>>> HALA silme funct. dayiz  kalan stackdeki deger: " + screenStack.size());
//            }
        }
    }

    public BaseScreen peekLastScreenFromScreenStack() {
        if (!isScreenStackEmpty()) {
            System.out.println(" kalan screen sayisi : " + (screenStack.size() - 1));
            return screenStack.peek();
        }
        return null;
    }

    public BaseScreen popLastScreenFromScreenStack() {
        System.out.println("+++  kalan screen sayisi : " + (screenStack.size() - 1));
        if (!isScreenStackEmpty()) {
            return screenStack.pop();
        }
        return null;
    }

    public int size() {
        return screenStack.size();
    }

    public Stack<BaseScreen> getScreenStack() {
        return screenStack;
    }

    public boolean isScreenStackEmpty() {
        return screenStack.size() > 0 ? false : true;
//        if (screenStack.size() > 0)
//            return false;
//        return true;
    }

    public void setScreenStack(Stack<BaseScreen> screenStack) {
        this.screenStack = screenStack;
    }
}
