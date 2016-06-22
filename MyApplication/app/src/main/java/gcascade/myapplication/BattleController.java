package gcascade.myapplication;

import java.util.List;
import java.util.Random;

/**
 * Created by Geoffroy on 23/05/2016.
 */
public class BattleController {
    Hero hero1;
    Hero hero2;
    Hero hero3;
    Foe foe1;
    Foe foe2;
    Foe foe3;
    private static final int CRIT_CHANCE = 5;
    private static final double CRIT_MULTIPLIER=1.3;
    public BattleController(){

    }

    public BattleController(Hero hero1, Hero hero2, Hero hero3, Foe foe1, Foe foe2, Foe foe3) {
        this.hero1=hero1;
        this.hero2=hero2;
        this.hero3=hero3;
        this.foe1=foe1;
        this.foe2=foe2;
        this.foe3=foe3;
    }

    /**
     * Normal attack
     * @param attacker
     * @param targets
     */
    public void attack(Character attacker, List<Character> targets) {
        Random random = new Random();
        int crit, mitigation, luck, damage, newHp;
        for(int i=0;i<targets.size();i++) {
            crit= random.nextInt(100);
            if (attacker.getAtk() > 10) {
                mitigation = random.nextInt(attacker.getAtk()/10);
            }
            else {
                mitigation = 0;
            }
            luck = random.nextInt(2);
            switch(luck) {
                case 0:
                    damage=attacker.getAtk() - targets.get(i).getDef();
                    break;
                case 1:
                    damage=attacker.getAtk() + mitigation-targets.get(i).getDef();
                    break;
                case 2:
                    damage=attacker.getAtk() - mitigation-targets.get(i).getDef();
                    break;
                default:
                    damage=attacker.getAtk() - targets.get(i).getDef();
            }
            /*if (crit < CRIT_CHANCE) {
                damage=damage*CRIT_MULTIPLIER;
            }*/
            /*Update hp*/
            if (damage > 0) {
                newHp = targets.get(i).getHp() - damage;
            }
            else {
                newHp = targets.get(i).getHp();
            }
            /*Set the HP to 0 if HP < 0*/
            if(newHp < 0) {
                newHp = 0;
            }
            targets.get(i).setHp(newHp);
        }
    }
}
