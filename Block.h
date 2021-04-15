#ifndef UNTITLED_BLOCK_H
#define UNTITLED_BLOCK_H

#include <iostream>
#include <SFML/Graphics.hpp>

using namespace sf;
using namespace std;

class Block : public Drawable
{
    RectangleShape rectangle;
    float width = 100.0;
    float height = 25.0;
    float speed = 4.0;
    void draw(RenderTarget& target,RenderStates states) const override;

public:
    Block(float pos_x,float pos_y);
    void movement();
    float bottom_edge();
    void destroy();
    float left_edge();
    float right_edge();
};


#endif //UNTITLED_BLOCK_H
