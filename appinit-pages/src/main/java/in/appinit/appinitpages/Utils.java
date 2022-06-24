package in.appinit.appinitpages;


import in.appinit.appinitpages.model.FilterCondition;
import in.appinit.appinitpages.model.variable.Variable;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static Map<String, FilterCondition> getAvailableFilters() {
        Map<String, FilterCondition> filters = new HashMap<>();
        filters.put("eq", new FilterCondition("eq", "Simple", "="));
        filters.put("neq", new FilterCondition("neq", "Simple", "NOT="));
        filters.put("gt", new FilterCondition("gt", "Simple", ">"));
        filters.put("lt", new FilterCondition("lt", "Simple", "<"));
        filters.put("gte", new FilterCondition("gte", "Simple", ">="));
        filters.put("lte", new FilterCondition("lte", "Simple", "=<"));
        filters.put("startsWith", new FilterCondition("startsWith", "Simple", "Starting with"));
        filters.put("contains", new FilterCondition("contains", "Simple", "Containing"));
        filters.put("endsWith", new FilterCondition("endsWith", "Simple", "Ending with"));
        filters.put("in", new FilterCondition("in", "List", "IN"));
        filters.put("nin", new FilterCondition("nin", "List", "NOT IN"));
        filters.put("all", new FilterCondition("all", "Simple", "ALL"));
        filters.put("and", new FilterCondition("and", "Filters", "AND"));
        filters.put("or", new FilterCondition("or", "Filters", "OR"));
        filters.put("nor", new FilterCondition("nor", "Filters", "NOR"));

        return filters;
    }

    public static Map<String, Variable> getAppVariables() {
        Map<String, Variable> variables = new HashMap<>();
      /*  variables.put("username", new Variable("username", "Username", "This variable provides username of the logged in user", "${username}"));
        variables.put("email", new Variable("email", "E-mail", "This variable provides e-mail of the logged in user", "${email}"));
        variables.put("name", new Variable("name", "Name", "This variable provides name of the logged in user", "${name}"));
        variables.put("date", new Variable("date", "Date", "Provides current date at the runtime.", "${date}"));*/
        return variables;
    }
}
