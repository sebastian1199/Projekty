#include <iostream>
#include <SFML/Graphics.hpp>
#include "CharacterBall.h"

using namespace std;
using namespace sf;


CharacterBall::CharacterBall(Vector2f position)
{
    ball.setFillColor(Color::Blue);
    ball.setOrigin(ballRadius*2,0.0);
    ball.setPosition(position);
    ball.setRadius(ballRadius);
//
//    arrowTexture.loadFromFile("arrow.png");
//    arrow.setTexture(&arrowTexture);
}


void CharacterBall::draw(RenderTarget&targets,RenderStates states) const
{
  targets.draw(ball,states);
}



void CharacterBall::movement()
{
  ball.move(ballSpeed,0.0);

}

Vector2f CharacterBall::getPosition()
{
    return ball.getPosition();
}