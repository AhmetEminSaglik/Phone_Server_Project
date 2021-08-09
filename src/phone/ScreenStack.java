package phone;

import phone.screen.basescreen.BaseScreen;

import java.util.Stack;

public class ScreenStack {

    private Stack<BaseScreen> screenStack = new Stack();

    public void addCurrentScreenToStack(BaseScreen baseScreen) {
        screenStack.add(baseScreen);
    }

    public void clearScreenStack() {

        if (!isScreenStackEmpty()) {
            for (int i = screenStack.size() - 1; i >= 0; i--) {
                screenStack.remove(i);
            }
        }
    }



    public BaseScreen peekLastScreenFromScreenStack() {
        if (!isScreenStackEmpty()) {
            return screenStack.peek();
        }
        return null;
    }

    public BaseScreen popLastScreenFromScreenStack() {
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
    }

    public void setScreenStack(Stack<BaseScreen> screenStack) {
        this.screenStack = screenStack;
    }
}
