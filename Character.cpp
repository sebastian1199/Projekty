#include <iostream>
#include <SFML/Graphics.hpp>
#include "Character.h"

using namespace std;
using namespace sf;


Character::Character(float pos_x,float pos_y)
{
    character.setFillColor(Color::White);
    character.setOrigin(0.0,characterHeight);
    character.setPosition(pos_x,pos_y);
    character.setSize(Vector2f{characterWidth,characterHeight});
    characterTexture.loadFromFile("character.png");
    character.setTexture(&characterTexture);
    initHp();
}

void Character::draw(RenderTarget &targets, RenderStates states) const
{
    targets.draw(character,states);
}

void Character::movement(float gravitySpeed,float groundHeight)
{
    if(Keyboard::isKeyPressed(Keyboard::Right)) character.move(characterSpeed,0.0);
    else if(Keyboard::isKeyPressed(Keyboard::Left)) character.move(-characterSpeed,0.0);
    else if(Keyboard::isKeyPressed(Keyboard::Up) && canJump){
        canJump=false;
        jumps=true;
    }

    if(!canJump) {
        if(character.getPosition().y>=(groundHeight-jumpHeight) && jumps)
        character.move(0.0, -gravitySpeed);
        else{
            jumps=false;
            character.move(0.0, gravitySpeed);
        }
    }

    if(character.getPosition().y>=groundHeight) canJump=true;
    hpText.setPosition(getTopPosition().x-(characterWidth/2+20),getTopPosition().y-5);
}

Vector2f Character::getCurrentPosition()
{
    return Vector2f{character.getPosition().x+characterWidth,character.getPosition().y-(characterHeight/2)};
}

Vector2f Character::getTopPosition()
{
    return Vector2f {character.getPosition().x+characterWidth,character.getPosition().y-characterHeight};
}

float Character::getHeight()
{
    return characterHeight;
}

void Character::initHp()
{
    hpText.setCharacterSize(20);
    hpText.setFillColor(Color::Blue);
    font.loadFromFile("arial.ttf");
    hpText.setFont(font);
    hpText.setString(to_string(hp));
}

void Character::hpUpdate()
{
    hp -= (5 +(rand()% 10));
    hpText.setString(to_string(hp));
}

Text& Character::getText()
{
    return hpText;
}
