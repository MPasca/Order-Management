package BLL.Validators;

import Model.Client;

import java.util.regex.Pattern;

public class TelephoneValidator implements Validator<Client>{
    private static final String TELEPHONE_PATTERN = "(\\+4)?07[0-9]{8}";

    @Override
    public void validate(Client c){
        Pattern pattern = Pattern.compile(TELEPHONE_PATTERN);
        if(!pattern.matcher(c.getTelephone()).matches()){
            throw new IllegalArgumentException("Not a valid telephone number!");
        }
    }
}
