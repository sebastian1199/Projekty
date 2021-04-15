#ifndef UNTITLED_BULLET_H
#define UNTITLED_BULLET_H

#include <iostream>
#include <SFML/Graphics.hpp>

using namespace sf;
using namespace std;

class Bullet : public Drawable
{
    CircleShape bullet;
    float bullet_radius = 6.0;
    float bullet_speed= 15.0;
    void draw(RenderTarget& target,RenderStates states) const override;

public:
    Bullet(Vector2f position);
    void movement();
    float top_edge();
    float left_edge();
    float right_edge();
};


















#endif //UNTITLED_BULLET_H
