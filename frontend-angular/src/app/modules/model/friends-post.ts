import { User } from "./user";

export class FriendsPost{
    postId: number = 0;
    userId!: User;
    content: string = "";
    likeNum: number = 0;
    isLiked!: Boolean;
    timeOfCreation!: Date;
    
    public constructor(obj?: any) {
        if (obj) {
            this.postId = obj.postId;
            this.userId = obj.userId;
            this.content = obj.content;
            this.likeNum = obj.likeNum;
            this.isLiked = obj.isLiked;
            this.timeOfCreation = obj.timeOfCreation;
        }
    }
}