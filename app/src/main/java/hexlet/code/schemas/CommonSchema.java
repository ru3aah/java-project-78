package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CommonSchema {
    private List<Predicate> requirements = new ArrayList<>();
    private Boolean checkRequirement = false;

    protected final void addRequirement(final Predicate requirement) {
        requirements.add(requirement);
    }

    public final boolean isValid(final Object obj) {
        if (null == obj) {
            return !checkRequirement;
        }
        for (Predicate requirement : requirements) {
            if (!requirement.test(obj)) {
                return false;
            }
        }
        return true;
    }

    protected final void setRequiredOn() {
        checkRequirement = true;

    }
    protected final void reset() {
        requirements.clear();
    }
}
