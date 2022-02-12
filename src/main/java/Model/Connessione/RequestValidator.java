package Model.Connessione;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class RequestValidator {

    private final List<String> errors;
    private final HttpServletRequest request;
    private static final Pattern INT_PATTERN = Pattern.compile("^\\d+$");
    private static final Pattern DOUBLE_PATTERN = Pattern.compile("^(-)?(0|[1-9]\\d+)\\.\\d+$");

    public RequestValidator(HttpServletRequest request){
        this.errors = new ArrayList<>();
        this.request = request;
    }

    public boolean hasErrors(){
        return  !errors.isEmpty();
    }

    public List<String> getErrors(){
        return  errors;
    }

    private boolean gatherError(boolean condition,String message){
        if(condition){
            return true;
        }else {
            errors.add(message);
            return false;
        }
    }

    public boolean assertInts(String values,String msg){
        String[] params = request.getParameterValues(values);
        boolean allInt = Arrays.stream(params).allMatch(param -> INT_PATTERN.matcher(param).matches());
        return  gatherError(allInt,msg);
    }

    public boolean assertSize(String first,String second,String msg){
        String[] firstList = request.getParameterValues(first);
        String[] secondList = request.getParameterValues(second);
        return gatherError(firstList.length == secondList.length,msg);
    }
}
