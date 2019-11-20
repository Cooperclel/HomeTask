package person.saveAndReadFile;

import person.Person;

import java.util.List;

public class SaveInfoPersonWithValidation extends SaveInfoPerson{

    @Override
    public void saveInfoPerson(List<Person> listPerson, String fileName){
        validate(listPerson);
        super.saveInfoPerson(listPerson, fileName);
    }

    public void validate(List<Person> listPerson){
        for(Person person : listPerson){
            if(person.getName() == null){
                throw new IllegalArgumentException("Пустое значение пользователя");
            }
        }
    }
}
