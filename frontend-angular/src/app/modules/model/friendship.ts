export class Friendship{
    friendshipId: number = 0;
    targetUserId: number = 0;
    sourceUserId: number = 0;
    status: String = "";
    
    public constructor(obj?: any) {
        if (obj) {
            this.friendshipId = obj.friendshipId;
            this.targetUserId = obj.targetUserId;
            this.sourceUserId = obj.sourceUserId;
            this.status = obj.status;
        }
    }
}