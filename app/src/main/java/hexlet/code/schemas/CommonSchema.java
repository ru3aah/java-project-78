package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CommonSchema {

    /**
     * List of requirements enabled for the choosen schema.
     */
    private List<Predicate> requirements = new ArrayList<>();
    /**
     * True in caase requirement to be checked.
     */
    private Boolean checkRequirement = false;

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
     * False in case obj is null or doesn't fit ot at least one requirement.
     */
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
