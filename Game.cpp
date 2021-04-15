#include <iostream>
#include <SFML/Graphics.hpp>
#include "Character.h"
#include "Background.h"
#include <vector>
#include "CharacterBall.h"
#include "Animation.h"
#include "ScoreSystem.h"

using namespace std;
using namespace sf;


bool isEnemyShooted(CharacterBall& characterBall,Enemy& enemy)
{
    if(characterBall.getPosition().x>=enemy.getPosition().x && characterBall.getPosition().y<=enemy.getPosition().y &&
            characterBall.getPosition().y>=enemy.getPosition().y-enemy.getHeight()) return true;
    else return false;
}

bool isCharacterShooted(EnemyBall& enemyBall,Character& character)
{
    if(enemyBall.getPosition().x<=character.getCurrentPosition().x && enemyBall.getPosition().y<=
    character.getTopPosition().y+character.getHeight() && enemyBall.getPosition().y>=character.getTopPosition().y)
        return true;
    else return false;
}


Text title(Font& font)
{
    Text text;
    text.setFont(font);
    text.setCharacterSize(40);
    text.setFillColor(Color::Blue);
    text.setPosition(550,30);
    text.setString("Welcome to the game");
    return text;
}


int main() {

    RenderWindow window(VideoMode(1500,800),"Game");
    window.setFramerateLimit(60);
    Character character(50.0,650.0);
    Background background;
    float gravitySpeed=4.0,groundHeight=650.0;
    vector<CharacterBall> characterBalls;
    vector<EnemyBall> enemyBalls;
    Clock characterBallClock,titleClock,enemyClock;
    vector<Clock> enemyBallClocks;
    float titleTime = 5000.0,characterBallPause = 400.0,enemyPause = 6000.0,enemyBallPause = 3000.0;
    vector<Enemy> enemies;
    bool isEnemyDestroyed=false,titleDisplayed = false;
    Font font;
    font.loadFromFile("arial.ttf");
    Text title_text,text,characterHpText;
    vector<Text> enemiesHp;
    Animation characterAnimation;
    vector<Animation> enemiesAnimations;
    int count=0;
    unsigned short int dragonsMissed=0;
    vector<string> files = {"dragon.png","dragon2.png","dragon3.png"};
    characterAnimation.setPartOfTexture(character);
    ScoreSystem scoreSystem;
    text = scoreSystem.scoreInit(font,0);
    vector<Text> enemiesHpTexts;


    while(window.isOpen()){

        Event event{};

        while(window.pollEvent(event)){
            if(event.type == Event::Closed) window.close();
        }

        window.clear(Color::Black);

        window.draw(background);
        character.movement(gravitySpeed,groundHeight);
        characterAnimation.update(character);
        window.draw(character);

        if(titleClock.getElapsedTime().asMilliseconds()>titleTime) titleDisplayed=true;
        if(!titleDisplayed){
            title_text = title(font);
            window.draw(title_text);
        }

           if(enemyClock.getElapsedTime().asMilliseconds()>enemyPause )
           {
              enemies.emplace_back(files[count++],font);
                if(count==files.size()) count=0;

               enemiesAnimations.emplace_back();
               enemiesAnimations.back().setPartOfTexture(enemies.back());
               enemyClock.restart();
               enemiesHpTexts.emplace_back();
               enemyBallClocks.emplace_back();
            }


        for(int i=0;i<enemies.size();i++){
        enemies[i].updateTexture();
        enemies[i].movement();
        enemiesAnimations[i].update(enemies[i]);
        window.draw(enemies[i]);

            if(enemyBallClocks[i].getElapsedTime().asMilliseconds()>enemyBallPause){
                enemyBalls.emplace_back(enemies[i].getCurrentPosition());
                enemyBallClocks[i].restart();
            }
        }

        for(auto& enemyBall: enemyBalls) {
            enemyBall.movement();
            window.draw(enemyBall);
        }

        for(int enemyBall=0;enemyBall<enemyBalls.size();enemyBall++){
            if(enemyBalls[enemyBall].getPosition().x<=0){
                enemyBalls.erase(enemyBalls.begin()+enemyBall);
            }
        }

        if(Keyboard::isKeyPressed(Keyboard::Space)){
            if(characterBallClock.getElapsedTime().asMilliseconds()>characterBallPause)
            {
                characterBalls.emplace_back(character.getCurrentPosition());
                characterBallClock.restart();
            }
        }

        for(auto& characterBall:characterBalls)
        {
            characterBall.movement();
            window.draw(characterBall);
        }

        for(int characterBall=0;characterBall<characterBalls.size();characterBall++){
            if(characterBalls[characterBall].getPosition().x>=1500){
                characterBalls.erase(characterBalls.begin()+characterBall);
            }
        }

        for(int i=0;i<enemies.size();i++){
            if(enemies[i].getPosition().x<=0)
            {
                enemies.erase(enemies.begin()+i);
                enemiesAnimations.erase(enemiesAnimations.begin()+i);
                enemiesHpTexts.erase(enemiesHpTexts.begin()+i);
                enemyBallClocks.erase(enemyBallClocks.begin()+i);

                if(++dragonsMissed>2){
                    cout<<"too many missed dragons"<<endl;
                    return 0;
                }
            }
        }

        for(int i=0;i<enemies.size();i++)
        {
            for(int o=0;o<characterBalls.size();o++){
                if(isEnemyShooted(characterBalls[o],enemies[i]))
                {
                    characterBalls.erase(characterBalls.begin()+o);
                    enemies[i].hpUpdate();
                    enemiesHpTexts[i]=enemies[i].getText();
                    string hp=enemiesHpTexts[i].getString();

                    if(stoi(hp)<=0){
                        enemies.erase(enemies.begin()+i);
                        enemiesAnimations.erase(enemiesAnimations.begin()+i);
                        isEnemyDestroyed=true;
                        scoreSystem.scoreUpdate(text,1);

                        scoreSystem.update();

                        enemiesHpTexts.erase(enemiesHpTexts.begin()+i);
                        enemyBallClocks.erase(enemyBallClocks.begin()+i);
                        break;
                    }
                }
            }
            if(isEnemyDestroyed) {
                isEnemyDestroyed=false;
                break;
            }
        }


            for(int o=0;o<enemyBalls.size();o++){
                if(isCharacterShooted(enemyBalls[o],character))
                {
                    enemyBalls.erase(enemyBalls.begin()+o);
                    character.hpUpdate();
                    characterHpText=character.getText();
                    string characterHp = characterHpText.getString();
                    if(stoi(characterHp)<=0){
                        cout<<"character destroyed"<<endl;
                        return 0;
                    }
                }
            }

            characterHpText=character.getText();
            window.draw(characterHpText);

        for(int i=0;i<enemies.size();i++){
          enemiesHpTexts[i]=enemies[i].getText();
         window.draw(enemiesHpTexts[i]);
        }

        window.draw(text);
        window.display();
    }
}
