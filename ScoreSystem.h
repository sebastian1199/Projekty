#ifndef UNTITLED1_SCORESYSTEM_H
#define UNTITLED1_SCORESYSTEM_H

#include <iostream>
#include <SFML/Graphics.hpp>
#include "Enemy.h"
#include "EnemyBall.h"

using namespace std;
using namespace sf;

class EnemyBall;

class ScoreSystem
{
    int points = 0;
    Text text;
    Vector2f textPosition{0.0,0.0};
    unsigned short level = 1;

public:
    Text scoreInit(Font& font,int points);
    void scoreUpdate(Text& tekst,int additionalPoints);
    void update();
};

#endif //UNTITLED1_SCORESYSTEM_H
