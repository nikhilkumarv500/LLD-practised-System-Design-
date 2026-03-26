package Rules;

import Enum.RuleType;

public class RuleFactory {
    static RuleFactory selfObj;

    public static RuleFactory getInsatance() {
        if(selfObj==null) selfObj = new RuleFactory();
        return selfObj;
    }

    public IRules generateRuleFactory(RuleType type) {
        if(type == RuleType.STANDARD) {
            return new StandardRules();
        }

        return null;
    }
}
