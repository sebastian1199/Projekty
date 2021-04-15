#ifndef UNTITLED1_ANIMATION_H
#define UNTITLED1_ANIMATION_H

#include <iostream>
#include <SFML/Graphics.hpp>


using namespace std;
using namespace sf;

class Enemy;
class Character;

class Animation
{
    float characterSwitchTime=600.0;
    float enemySwitchTime=500.0;
    Vector2u textureSize;
    Clock Clock;
    bool fromRight=false;;

public:

    void update(Enemy& enemy);
    void update(Character& character);
    void setPartOfTexture(Enemy& enemy);
    void setPartOfTexture(Character& character);


};



















#endif //UNTITLED1_ANIMATION_H
