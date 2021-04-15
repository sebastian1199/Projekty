#include <SFML/Graphics.hpp>
#include "Bullet.h"

using namespace sf;
using namespace std;


Bullet::Bullet(Vector2f position)
{
    bullet.setFillColor(Color::Red);
    bullet.setRadius(bullet_radius);
    bullet.setOrigin(bullet_radius,bullet_radius);
    bullet.setPosition(position.x,position.y-bullet_radius);
}

void Bullet::movement()
{
    bullet.move(0,-bullet_speed);
}

void Bullet::draw(RenderTarget& target,RenderStates states) const
{
    target.draw(bullet,states);
}

float Bullet::top_edge()
{
    return bullet.getPosition().y-bullet_radius;
}

float Bullet::left_edge()
{
    return bullet.getPosition().x-bullet_radius;
}

float Bullet::right_edge()
{
    return bullet.getPosition().x+bullet_radius;
}



