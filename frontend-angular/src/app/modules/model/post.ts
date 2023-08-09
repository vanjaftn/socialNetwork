export class Post{
    postId: number = 0;
    userId: number = 0;
    content: String = "";
    timeOfCreation!: Date;
    
    public constructor(obj?: any) {
        if (obj) {
            this.postId = obj.postId;
            this.userId = obj.userId;
            this.content = obj.content;
            this.timeOfCreation = obj.timeOfCreation;
        }
    }
}