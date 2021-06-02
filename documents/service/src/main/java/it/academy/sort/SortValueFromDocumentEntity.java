package it.academy.sort;

import org.springframework.stereotype.Component;

@Component
public class SortValueFromDocumentEntity {

    public String getSortValue(String sortValue){

        switch (sortValue){
            case "name": return "documentName.documentName";
            case "period": return "periodOfExecution.periodOfExecution";
            case "date": return "createDate";
            case "who create": return "personWhoConcludedContract.personWhoConcludedContract";
            default: return "personWithWhomTheContractWasSigned.personWithWhomTheContractWasSigned";
        }
    }
}
