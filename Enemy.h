#ifndef UNTITLED1_ENEMY_H
#define UNTITLED1_ENEMY_H

#include <iostream>
#include <SFML/Graphics.hpp>

using namespace std;
using namespace sf;

class Animation;

class Enemy : public Drawable
{
    RectangleShape enemyShape;
    Texture enemyTexture;
    float enemyWidth = 100.0;
    float enemyHeight = 100.0;
    float enemySpeed = 3.0;
    int hp=100;
    Text hpText;
    IntRect rect;
    friend class Animation;
    float resp_xPos = 1500.0;
    float resp_yPos = 450.0 + (rand() % 200);
    void draw(RenderTarget&targets,RenderStates states) const override;

public:

    Enemy(const string& image,Font& font);
    void movement();
    Vector2f getPosition();
    float getHeight();
    void hpUpdate();
    Text& getText();
    void initHp(Font&);
    void updateTexture();
    Vector2f getCurrentPosition();
};




#endif //UNTITLED1_ENEMY_H
