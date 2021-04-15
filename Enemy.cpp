#include <iostream>
#include <SFML/Graphics.hpp>
#include "Enemy.h"
#include "ScoreSystem.h"

using namespace std;
using namespace sf;


Enemy::Enemy(const string& image,Font& font)
{
    enemyShape.setFillColor(Color::White);
    enemyShape.setPosition(resp_xPos,resp_yPos);
    enemyShape.setSize(Vector2f{enemyWidth,enemyHeight});
    enemyShape.setOrigin(0.0,enemyHeight);
    enemyTexture.loadFromFile(image);
    initHp(font);
}

void Enemy::updateTexture()
{
    enemyShape.setTexture(&enemyTexture);
}

void Enemy::draw(RenderTarget& targets,RenderStates states) const
{
    targets.draw(enemyShape,states);
}

void Enemy::movement()
{
    enemyShape.move(-enemySpeed,0.0);
    hpText.setPosition(getPosition().x+(enemyWidth/2-20),getPosition().y-(enemyHeight+15));
}

Vector2f Enemy::getPosition()
{
    return enemyShape.getPosition();
}

float Enemy::getHeight()
{
    return enemyHeight;
}

void Enemy::initHp(Font& font)
{
    hpText.setCharacterSize(20);
    hpText.setFillColor(Color::Red);
    font.loadFromFile("arial.ttf");
    hpText.setFont(font);
    hpText.setString(to_string(hp));
}

void Enemy::hpUpdate()
{
    hp -= (30 +(rand()% 20));
    hpText.setString(to_string(hp));
}

Text& Enemy::getText()
{
    return hpText;
}

Vector2f Enemy::getCurrentPosition()
{
    return Vector2f {enemyShape.getPosition().x,enemyShape.getPosition().y-(enemyHeight/2)};
}



