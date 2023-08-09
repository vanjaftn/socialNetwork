export class RegisterUser{
    email: String = "";
    password: String = "";
    // confirmPassword: string = "";
    firstname: String = "";
    lastname: String = "";
    
    public constructor(obj?: any) {
        if (obj) {
            this.email = obj.email;
            this.password = obj.password;
            this.firstname = obj.firstname;
            this.lastname = obj.lastname;
        }
    }
}