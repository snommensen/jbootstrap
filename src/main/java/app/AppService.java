package app;

import java.util.Objects;

public class AppService implements IAppService {

    @Override
    public String greet(String name) {
        Objects.requireNonNull(name, "Given name is null!");
        return "Hello, " + name + "! :-)";
    }
}
