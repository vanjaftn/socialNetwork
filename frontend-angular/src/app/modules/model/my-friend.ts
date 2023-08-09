import { Post } from "./post";
import { User } from "./user";

export class MyFriend{
    userId: number = 0;
    email: String = "";
    firstName: String = "";
    lastName: String = "";
    photoURL: String = "";
    posts!: Array<Post>;
    friends!: Array<User>
    isMyFriend!: Boolean;
    hasAccepted!: Boolean;
    
    public constructor(obj?: any) {
        if (obj) {
            this.userId = obj.userId;
            this.email = obj.email;
            this.photoURL = obj.photoURL;
            this.firstName = obj.firstName;
            this.lastName = obj.lastName;
            this.posts = obj.posts;
            this.friends = obj.friends;
            this.isMyFriend = obj.isMyFriend;

        }
    }
}