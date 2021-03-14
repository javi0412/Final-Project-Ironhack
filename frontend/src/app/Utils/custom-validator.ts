import { AbstractControl, ValidationErrors } from "@angular/forms";

export class CustomValidator {
    static nameValidator(control:AbstractControl): ValidationErrors | null {
        const value = control.value;
        const regex = /\d/;
        if(regex.test(value)){
            return {invalidname:true}
        }   
        return null;
    }
    
    static amountValidator(control:AbstractControl): ValidationErrors | null {
        const value = control.value;
        if(value <=0 ){
            return {invalidAmount:true}
        }
        return null;
    }
}

