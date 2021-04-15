#include "Ball.h"

using namespace std;
using namespace sf;

Ball::Ball(float pos_x,float pos_y)
{
    circle.setRadius(ball_radius);
    circle.setFillColor(Color::Blue);
    circle.setPosition(pos_x,pos_y);
    circle.setOrigin(ball_radius,ball_radius);
}

void Ball::draw(RenderTarget& target,RenderStates states) const
{
    target.draw(circle,states);
}

void Ball::movement()
{
    if(circle.getPosition().x-ball_radius<=0 )
        circle.move(-(circle.getPosition().x-ball_radius),0.0);
         if(circle.getPosition().x+ball_radius>=800)
        circle.move(-(circle.getPosition().x+ball_radius-800),0.0);

     if(Keyboard::isKeyPressed(Keyboard::Right)) circle.move(ball_shift,0);
    else if(Keyboard::isKeyPressed(Keyboard::Left)) circle.move(-ball_shift,0);
}

Vector2f Ball::getCurrentPosition()
{
    Vector2f position=circle.getPosition();
    position.y-=circle.getRadius();
    return position;
}


