package ru.job4j.finder.opt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Class OptionName
 *
 * @author Rodion V.
 * @version 1.0
 * @since 1.0
 */

public class OptionName extends Option implements OptActions<Rule> {
    private final String option;
    private final Map<String, Rule> map;

    public OptionName(String option) {
        super(option, "n");
        this.option = option;
        map = new HashMap<>();
        map.put("f", new RuleNameAsFullName());
        map.put("m", new RuleNameByMask());
        map.put("r", new RuleNameByRegex());
    }

    private String getInputString() {
        return super.option;
    }

    @Override
    public Rule apply() {
        try {
            return Arrays.stream(option.split("-"))
                    .map(String::trim)
                    .filter(x -> x.length() > 0)
                    .filter(x -> map.containsKey(x.substring(0, 1)))
                    .map(x -> map.get(x.substring(0, 1)))
                    .findFirst()
                    .orElse(new RuleNameAsFullName());
        } catch (PatternSyntaxException pse) {
            System.out.println("Pattern syntax error.");
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
        return null;
    }

    private class RuleNameAsFullName implements Rule, ValidateOption {

        public boolean check(String fileName) {
            validate(getInputString());
            return fileName.equals(getInputString());
        }

        @Override
        public void validate(String str) {
            if (getInputString() == "") {
                throw new RuntimeException("String can't be empty.");
            }
        }
    }

    private class RuleNameByMask implements Rule, ValidateOption {

        @Override
        public boolean check(String fileName) {
            String mask = getInputString()
                    .replace((CharSequence) ".", (CharSequence) "[.]")
                    .replace((CharSequence) "*", (CharSequence) ".*")
                    .replace((CharSequence) "?", (CharSequence) ".");
            validate(getInputString());
            return fileName.matches(mask);
        }

        @Override
        public void validate(String str) {
            if (getInputString() == "") {
                throw new RuntimeException("String can't be empty.");
            }
            Pattern pattern = Pattern.compile(str);
        }
    }

    private class RuleNameByRegex implements Rule {
        @Override
        public boolean check(String fileName) {
            return fileName.matches(getInputString());
        }
    }

}
