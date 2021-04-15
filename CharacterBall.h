#ifndef UNTITLED1_CHARACTERBALL_H
#define UNTITLED1_CHARACTERBALL_H

#include <iostream>
#include <SFML/Graphics.hpp>
#include "Character.h"
#include "Enemy.h"

using namespace std;
using namespace sf;

class CharacterBall : public Drawable
{
    CircleShape ball;
    float ballRadius=6.0;
    float ballSpeed=8.0;

    void draw(RenderTarget&targets,RenderStates states) const override;

public:
    CharacterBall(Vector2f position);
    void movement();
    Vector2f getPosition();

};





















#endif //UNTITLED1_CHARACTERBALL_H
