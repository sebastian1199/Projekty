#include <SFML/Graphics.hpp>
#include "Animation.h"
#include "Enemy.h"
#include "Character.h"

using namespace std;
using namespace sf;


void Animation::setPartOfTexture(Enemy &enemy)
{
    textureSize = enemy.enemyTexture.getSize();
    textureSize.x/=3;
    enemy.rect=IntRect(0,0,textureSize.x,textureSize.y);
    enemy.enemyShape.setTextureRect(enemy.rect);
}

void Animation::setPartOfTexture(Character &character)
{
    textureSize = character.characterTexture.getSize();
    textureSize.x/=4;
    character.rect=IntRect(0,0,textureSize.x,textureSize.y);
    character.character.setTextureRect(character.rect);
}

void Animation::update(Enemy& enemy)
{
    if(Clock.getElapsedTime().asMilliseconds()>enemySwitchTime)
    {
        if(enemy.rect.left==textureSize.x*2)
        {
            enemy.rect.left-=textureSize.x;
            fromRight=true;
        }
        else if(fromRight) {
            enemy.rect.left-=textureSize.x;
            fromRight=false;
        }
        else enemy.rect.left+=textureSize.x;

        enemy.enemyShape.setTextureRect(enemy.rect);
        Clock.restart();
    }
}

void Animation::update(Character& character)
{
    if(Clock.getElapsedTime().asMilliseconds()>characterSwitchTime)
    {
        if(character.rect.left==0.0 ){
            character.rect.left+=textureSize.x;
        }
        else if(character.rect.left==textureSize.x*3){
            character.rect.left-=textureSize.x;
            fromRight=true;
        }
        else if(fromRight) {
            character.rect.left-=textureSize.x;
            if(character.rect.left==0.0)
            fromRight=false;
        }
        else character.rect.left+=textureSize.x;

        character.character.setTextureRect(character.rect);
        Clock.restart();
    }
}