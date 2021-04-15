#ifndef UNTITLED1_CHARACTER_H
#define UNTITLED1_CHARACTER_H

#include <iostream>
#include <SFML/Graphics.hpp>

using namespace std;
using namespace sf;

class Animation;

class Character : public Drawable
{
    RectangleShape character;
    Texture characterTexture;
    float characterWidth=100.0;
    float characterHeight=100.0;
    float characterSpeed = 8.0;
    float jumpHeight = 200.0;
    bool canJump = true;
    bool jumps=false;
    IntRect rect;
    friend class Animation;
    int hp=100;
    Text hpText;
    Font font;
    void draw(RenderTarget&targets,RenderStates states) const override;
    void initHp();

public:
    Character(float pos_x,float pos_y);
    void movement(float gravitySpeed,float groundHeight);
    Vector2f getCurrentPosition();
    Vector2f getTopPosition();
    float getHeight();
    void hpUpdate();
    Text& getText();
};



















#endif //UNTITLED1_CHARACTER_H
