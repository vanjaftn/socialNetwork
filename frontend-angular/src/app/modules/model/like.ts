export class Like{
    likeId: number = 0;
    postId: number = 0;
    userId: number = 0;
    
    public constructor(obj?: any) {
        if (obj) {
            this.likeId = obj.likeId;
            this.postId = obj.postId;
            this.userId = obj.userId;
        }
    }
}