#include <SFML/Graphics.hpp>
#include "EnemyBall.h"

using namespace std;
using namespace sf;


EnemyBall::EnemyBall(Vector2f position)
{
    ball.setFillColor(Color::Red);
    ball.setPosition(position);
    ball.setRadius(ballRadius);
}

void EnemyBall::draw(RenderTarget&targets,RenderStates states) const
{
    targets.draw(ball,states);
}

void EnemyBall::movement()
{
    ball.move(-ballSpeed,0.0);
}

Vector2f EnemyBall::getPosition()
{
    return ball.getPosition();
}

