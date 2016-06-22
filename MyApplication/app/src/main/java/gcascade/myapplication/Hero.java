package gcascade.myapplication;

/**
 * Created by Geoffroy on 17/05/2016.
 */
public class Hero extends Character {
    Item head;
    Item rightHand;
    Item leftHand;
    Item body;
    Item boots;
    public Hero() {
        super();
        head=new Helm();
        head.setEmpty();
        rightHand=new Weapon();
        rightHand.setEmpty();
        leftHand=new Weapon();
        leftHand.setEmpty();
        body=new Armor();
        body.setEmpty();
        boots=new Boots();
        boots.setEmpty();
    }

    public Item getHead() {
        return head;
    }

    public void setHead(Item head) {
        this.head = head;
    }

    public Item getRightHand() {
        return rightHand;
    }

    public void setRightHand(Item rightHand) {
        this.rightHand = rightHand;
    }

    public Item getLeftHand() {
        return leftHand;
    }

    public void setLeftHand(Item leftHand) {
        this.leftHand = leftHand;
    }

    public Item getBody() {
        return body;
    }

    public void setBody(Item body) {
        this.body = body;
    }

    public Item getBoots() {
        return boots;
    }

    public void setBoots(Item boots) {
        this.boots = boots;
    }
}
