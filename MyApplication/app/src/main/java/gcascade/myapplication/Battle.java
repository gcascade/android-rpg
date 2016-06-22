package gcascade.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Battle extends AppCompatActivity implements View.OnClickListener {

    private static final int MAX = 6;
    private BattleController battleController;
    private Hero hero1;
    private Hero hero2;
    private Hero hero3;
    private Foe foe1;
    private Foe foe2;
    private Foe foe3;
    private Button attack;
    private Button skills;
    private Button pass;
    private Button items;
    private Button battleEnd;
    private TextView hero1hp;
    private TextView hero1name;
    private TextView hero2hp;
    private TextView hero2name;
    private TextView hero3hp;
    private TextView hero3name;
    private TextView battleMessage;
    private TextView battleMessageEnemy;
    private TextView turnText;
    private TextView foe1name;
    private TextView foe2name;
    private TextView foe3name;
    private ProgressBar foe1hp;
    private ProgressBar foe2hp;
    private ProgressBar foe3hp;
    boolean attackPressed=false;
    boolean skillsPressed=false;
    boolean itemsPressed=false;
    boolean passPressed=false;
    int turn;
    int characterTurn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        setup();
        hero1 = new Hero();
        hero2 = null;
        hero3 = null;
        foe1 = new Foe();
        foe2 = null;
        foe3 = null;
        hero1.setAtk(10);
        hero1.setName("Luke");
        hero1.setDef(3);
        hero1.setHp(10);
        hero1.setSp(100);
        foe1.setHp(30);
        foe1.setSp(50);
        foe1.setDef(5);
        foe1.setAtk(5);
        foe1.setName("Slime");
        turn = 1;
        characterTurn=1; //Hero1's turn at the beginning
        hero1hp.setText(String.valueOf(hero1.getHp())+" HP");
        hero1name.setText(hero1.getName());
        foe1name.setText(foe1.getName());
        foe1hp.setProgress(foe1.getHp());
        foe1hp.setMax(foe1.getHp());
        if(hero2 == null) {
            hero2name.setVisibility(View.GONE);
            hero2hp.setVisibility(View.GONE);
        }
        else {
            hero2name.setText(hero2.getName());
            hero2hp.setText(String.valueOf(hero2.getHp())+" HP");
        }
        if(hero3 == null) {
            hero3hp.setVisibility(View.GONE);
            hero3name.setVisibility(View.GONE);
        }
        else {
            hero3name.setText(hero3.getName());
            hero3hp.setText(String.valueOf(hero3.getHp())+" HP");
        }
        if(foe2 == null) {
            foe2name.setVisibility(View.GONE);
            foe2hp.setVisibility(View.GONE);
        }
        else {
            foe2name.setText(hero2.getName());
            foe2hp.setMax(foe2.getHp());
            foe2hp.setProgress(foe2.getHp());
        }
        if(foe3 == null) {
            foe3hp.setVisibility(View.GONE);
            foe3name.setVisibility(View.GONE);
        }
        else {
            foe3name.setText(hero3.getName());
            foe3hp.setMax(foe3.getHp());
            foe3hp.setProgress(foe3.getHp());
        }
        turnText.setText("Turn "+turn);
        battleMessage.setText(hero1.getName()+"'s turn. Choose an action");
        battleMessageEnemy.setText("An enemy appears.");
        battleEnd.setVisibility(View.INVISIBLE);
        battleEnd.setClickable(false);
        battleController = new BattleController(hero1,hero2,hero3,foe1,foe2,foe3);
        attack.setOnClickListener(this);
        pass.setOnClickListener(this);
        battleEnd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.buttonAtk:
                attackPressed=!attackPressed;
                if(passPressed) {
                    pass.setBackgroundResource(R.drawable.btn_white_glossy);
                    passPressed=false;
                }
                if(attackPressed) {
                    attack.setBackgroundResource(R.drawable.btn_green_glossy);
                }
                else {
                    attack.setBackgroundResource(R.drawable.btn_white_glossy);
                    ArrayList<Character> targets = new ArrayList<Character>();
                    targets.add(foe1);
                    battleController.attack(hero1,targets);
                    if(checkBattleEnd()) {
                        attack.setClickable(false);
                        skills.setClickable(false);
                        items.setClickable(false);
                        pass.setClickable(false);
                        battleEnd.setText("Victory !");
                        battleEnd.setVisibility(View.VISIBLE);
                        battleEnd.setClickable(true);
                    }
                    else {
                        nextChar();
                        handleTurn();
                    }
                }
                break;
            case R.id.buttonPass:
                passPressed=!passPressed;
                if(attackPressed) {
                    attack.setBackgroundResource(R.drawable.btn_white_glossy);
                    attackPressed=false;
                }
                if(passPressed) {
                    pass.setBackgroundResource(R.drawable.btn_green_glossy);
                }
                else {
                    pass.setBackgroundResource(R.drawable.btn_white_glossy);
                    battleMessage.setText(getCharacter(characterTurn).getName()+" passed his turn.");
                    nextChar();
                    handleTurn();
                }
                break;
            case R.id.battleEndButton:
                Intent intent = new Intent(Battle.this, MainActivity.class);
                startActivity(intent);
            default:
        }
        updateScreen();
    }

    private void updateScreen() {
        hero1hp = (TextView)findViewById(R.id.hero1hp);
        hero2hp = (TextView)findViewById(R.id.hero2hp);
        hero3hp = (TextView)findViewById(R.id.hero3hp);
        hero1name = (TextView)findViewById(R.id.hero1);
        hero2name = (TextView)findViewById(R.id.hero2);
        hero3name = (TextView)findViewById(R.id.hero3);
        foe1hp = (ProgressBar) findViewById(R.id.enemy1hp);
        foe2hp = (ProgressBar) findViewById(R.id.enemy2hp);
        foe3hp = (ProgressBar) findViewById(R.id.enemy3hp);
        foe1name = (TextView)findViewById(R.id.enemy1);
        foe2name = (TextView)findViewById(R.id.enemy2);
        foe3name = (TextView)findViewById(R.id.enemy3);
        hero1hp.setText(String.valueOf(hero1.getHp())+" HP");
        hero1name.setText(hero1.getName());
        foe1name.setText(foe1.getName());
        foe1hp.setProgress(foe1.getHp());
        if(hero2 == null) {
            hero2name.setVisibility(View.GONE);
            hero2hp.setVisibility(View.GONE);
        }
        else {
            hero2name.setText(hero2.getName());
            hero2hp.setText(String.valueOf(hero2.getHp())+" HP");
        }
        if(hero3 == null) {
            hero3hp.setVisibility(View.GONE);
            hero3name.setVisibility(View.GONE);
        }
        else {
            hero3name.setText(hero3.getName());
            hero3hp.setText(String.valueOf(hero3.getHp())+" HP");
        }
        if(foe2 == null) {
            foe2name.setVisibility(View.GONE);
            foe2hp.setVisibility(View.GONE);
        }
        else {
            foe2name.setText(hero2.getName());
        }
        if(foe3 == null) {
            foe3hp.setVisibility(View.GONE);
            foe3name.setVisibility(View.GONE);
        }
        else {
            foe3name.setText(hero3.getName());
        }
        turnText.setText("Turn "+turn);
    }

    private void handleTurn() {
        //Hero1's turn
        if(characterTurn == 1) {
            battleMessage.setText(hero1.getName()+"'s turn. Choose an action");
        }
        //Hero2's turn
        if(characterTurn == 2) {
            battleMessage.setText(hero2.getName()+"'s turn. Choose an action");
        }
        //Hero3's turn
        if(characterTurn == 3) {
            battleMessage.setText(hero3.getName()+"'s turn. Choose an action");
        }
        //Foe 1's turn
        if(characterTurn == 4) {
            enemyAttack(foe1);
            if(checkBattleEnd()) {
                attack.setClickable(false);
                skills.setClickable(false);
                items.setClickable(false);
                pass.setClickable(false);
                battleEnd.setText("Defeat.");
                battleEnd.setVisibility(View.VISIBLE);
                battleEnd.setClickable(true);
            }
            else {
                nextChar();
                handleTurn();
            }
        }
        //Foe 2's turn
        if (characterTurn == 5) {
            enemyAttack(foe2);
            nextChar();
            handleTurn();
        }
        //Foe 3's turn
        if (characterTurn == 6) {
            enemyAttack(foe3);
            nextChar();
            handleTurn();
        }
    }

    private void nextChar() {
        switch(characterTurn) {
            case 1:
                if(hero2==null || hero2.getHp() == 0) {
                    if (hero3==null || hero3.getHp() == 0) {
                        if(foe1.getHp() == 0) {
                            if(foe2==null || foe2.getHp() == 0) {
                                characterTurn = 6;
                            }
                            else {
                                characterTurn = 5;
                            }
                        }
                        else {
                            characterTurn = 4;
                        }
                    }
                    else {
                        characterTurn = 3;
                    }
                }
                else {
                    characterTurn = 2;
                }
                break;
            case 2:
                if(hero3==null || hero3.getHp() == 0) {
                    if (foe1.getHp() == 0) {
                        if(foe2==null || foe2.getHp() == 0) {
                            characterTurn = 6;
                        }
                        else {
                            characterTurn = 5;
                        }
                    }
                    else {
                        characterTurn = 4;
                    }
                }
                else {
                    characterTurn = 3;
                }
                break;
            case 3:
                if (foe1.getHp() == 0) {
                    if(foe2==null || foe2.getHp() == 0) {
                        characterTurn = 6;
                    }
                    else {
                        characterTurn = 5;
                    }
                }
                else {
                    characterTurn = 4;
                }
                break;
            case 4:
                if(foe2==null || foe2.getHp() == 0) {
                    if (foe3==null || foe3.getHp() == 0){
                        if(hero1.getHp() == 0) {
                            if(hero2==null || hero2.getHp()==0) {
                                characterTurn = 3;
                                turn++;
                            }
                            else {
                                characterTurn = 2;
                                turn++;
                            }
                        }
                        else {
                            characterTurn = 1;
                            turn++;
                        }
                    }
                    else {
                        characterTurn = 6;
                    }
                }
                else {
                    characterTurn = 5;
                }
                break;
            case 5:
                if (foe3==null || foe3.getHp() == 0){
                    if(hero1.getHp() == 0) {
                        if(hero2==null || hero2.getHp()==0) {
                            characterTurn = 3;
                            turn++;
                        }
                        else {
                            characterTurn = 2;
                            turn++;
                        }
                    }
                    else {
                        characterTurn = 1;
                        turn++;
                    }
                }
                else {
                    characterTurn = 6;
                }
                break;
            case 6:
                turn++;
                if(hero1.getHp() == 0) {
                    if(hero2==null || hero2.getHp()==0) {
                        characterTurn = 3;
                    }
                    else {
                        characterTurn = 2;
                    }
                }
                else {
                    characterTurn = 1;
                }
                break;
        }
    }

    private void enemyAttack(Foe foe) {
        Random random = new Random();
        boolean targetAcquired=false;
        int targetNb=0;
        //choose target randomly and simulate attack once the target is confirmed.
        while(targetAcquired==false) {
            targetNb=random.nextInt(3);
            if(targetNb==0) {
                if(hero1.getHp()!=0) {
                    targetAcquired=true;
                    ArrayList<Character>  attacked = new ArrayList<Character>();
                    attacked.add(hero1);
                    battleController.attack(foe,attacked);
                    battleMessageEnemy.setText(foe.getName()+" attacked "+hero1.getName());
                }
            }
            else if (targetNb==1) {
                if(hero2 !=null) {
                    if(hero2.getHp() !=0) {
                        targetAcquired=true;
                        ArrayList<Character>  attacked = new ArrayList<Character>();
                        attacked.add(hero2);
                        battleController.attack(foe,attacked);
                        battleMessageEnemy.setText(foe.getName()+" attacked "+hero2.getName());
                    }
                }
            }
            else {
                if(hero3 !=null) {
                    if(hero3.getHp() != 0) {
                        targetAcquired=true;
                        ArrayList<Character>  attacked = new ArrayList<Character>();
                        attacked.add(hero2);
                        battleController.attack(foe,attacked);
                        battleMessageEnemy.setText(foe.getName()+" attacked "+hero3.getName());
                    }
                }
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private boolean checkBattleEnd() {
        boolean result;
        boolean enemy1dead=false;
        boolean enemy2dead=false;
        boolean enemy3dead=false;
        boolean hero1dead=false;
        boolean hero2dead=false;
        boolean hero3dead=false;
        if(foe1.getHp() <= 0)
            enemy1dead=true;
        if(foe2 == null || foe2.getHp() <=0)
            enemy2dead=true;
        if(foe3 == null || foe3.getHp() <= 0)
            enemy3dead=true;
        if(hero1.getHp() <=0)
            hero1dead=true;
        if(hero2 == null || hero2.getHp() <=0)
            hero2dead=true;
        if(hero3 == null || hero3.getHp() <=0)
            hero3dead=true;
        result=((enemy1dead && enemy2dead && enemy3dead) || (hero1dead && hero2dead && hero3dead));
        return result;
    }

    private Character getCharacter(int characterTurn) {
        if(characterTurn < 1 || characterTurn > 6)
            throw new IllegalArgumentException();
        switch(characterTurn) {
            case 1:
                return hero1;
            case 2:
                return hero2;
            case 3:
                return hero3;
            case 4:
                return foe1;
            case 5:
                return foe2;
            case 6:
                return foe3;
            default:
                return hero1;
        }
    }

    private void setup() {
        attack = (Button)findViewById(R.id.buttonAtk);
        skills = (Button)findViewById(R.id.buttonSkills);
        pass = (Button)findViewById(R.id.buttonPass);
        items = (Button)findViewById(R.id.buttonItem);
        battleEnd = (Button)findViewById(R.id.battleEndButton);
        hero1hp = (TextView)findViewById(R.id.hero1hp);
        hero2hp = (TextView)findViewById(R.id.hero2hp);
        hero3hp = (TextView)findViewById(R.id.hero3hp);
        hero1name = (TextView)findViewById(R.id.hero1);
        hero2name = (TextView)findViewById(R.id.hero2);
        hero3name = (TextView)findViewById(R.id.hero3);
        foe1hp = (ProgressBar) findViewById(R.id.enemy1hp);
        foe2hp = (ProgressBar) findViewById(R.id.enemy2hp);
        foe3hp = (ProgressBar) findViewById(R.id.enemy3hp);
        foe1name = (TextView)findViewById(R.id.enemy1);
        foe2name = (TextView)findViewById(R.id.enemy2);
        foe3name = (TextView)findViewById(R.id.enemy3);
        turnText = (TextView)findViewById(R.id.turn);
        battleMessage = (TextView)findViewById(R.id.battleMessage);
        battleMessageEnemy = (TextView)findViewById(R.id.battleMessageEnemy);
    }
}
