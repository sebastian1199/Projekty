#ifndef UNTITLED_BALL_H
#define UNTITLED_BALL_H

#include <iostream>
#include <SFML/Graphics.hpp>

using namespace sf;
using namespace std;

class Ball : public Drawable
{
    CircleShape circle;
    float ball_radius = 15.0;
    float ball_shift = 10.0;
    void draw(RenderTarget& target,RenderStates states) const override;

public:
    Ball(float pos_x,float pos_y);
    void movement();
    Vector2f getCurrentPosition();
};
























#endif //UNTITLED_BALL_H
