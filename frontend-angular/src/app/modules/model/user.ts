import { Post } from "./post";

export class User{
    userId: number = 0;
    email: String = "";
    firstName: String = "";
    lastName: String = "";
    photoURL: String = "";
    posts!: Array<Post>;
    
    public constructor(obj?: any) {
        if (obj) {
            this.userId = obj.userId;
            this.email = obj.email;
            this.photoURL = obj.photoURL;
            this.firstName = obj.firstName;
            this.lastName = obj.lastName;
            this.posts = obj.posts;
        }
    }
}