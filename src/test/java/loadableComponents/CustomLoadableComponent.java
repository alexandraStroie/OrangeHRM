package loadableComponents;

public abstract class CustomLoadableComponent<T extends CustomLoadableComponent<T>> {
    protected abstract void load();

    protected abstract void isLoaded() throws Error;

    protected abstract boolean isAtPage();

    public T get() {
        try {
            if (!isAtPage()) {
                load();
            }
            isLoaded();
            return (T) this;
        } catch (Error e) {
            System.out.println("Component not loaded, attempting to load: " + e.getMessage());
            load();
            isLoaded(); // Retry isLoaded check after loading
            return (T) this;
        }
    }
}

