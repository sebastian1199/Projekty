#ifndef UNTITLED1_ENEMYBALL_H
#define UNTITLED1_ENEMYBALL_H

#include <iostream>
#include <SFML/Graphics.hpp>
#include "ScoreSystem.h"

using namespace std;
using namespace sf;

class EnemyBall : public Drawable
{
    CircleShape ball;
    float ballRadius=7.5;
    float ballSpeed=7.0;
    void draw(RenderTarget&targets,RenderStates states) const override;

public:
    EnemyBall(Vector2f position);
    void movement();
    Vector2f getPosition();
};
















#endif //UNTITLED1_ENEMYBALL_H
