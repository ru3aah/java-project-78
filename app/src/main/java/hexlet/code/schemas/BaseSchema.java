package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema {

    /**
     * List of requirements enabled for the chosen schema.
     */
    private List<Predicate> requirements = new ArrayList<>();
    /**
     * True in case requirement to be checked.
     */
    private Boolean required = false;

    /**
     * adds the requirement to the List.
     * @param requirement to be added
     */
    protected final void addRequirement(final Predicate requirement) {
        requirements.add(requirement);
    }

    /**
     * Checks if obj is not null and suits requirements in the list.
     * List is generated according to Chosen Scheme.
     * @param obj Object
     * @return True if all requirements are fulfilled.
     * False in case obj is null or doesn't fit at least one requirement.
     */
    public final boolean isValid(final Object obj) {
        if (null == obj) {
            return !required;
        }
        for (Predicate requirement : requirements) {
            if (!requirement.test(obj)) {
                return false;
            }
        }
        return true;
    }

    protected final void setRequiredOn() {
        required = true;

    }
    protected final void reset() {
        requirements.clear();
    }
}
