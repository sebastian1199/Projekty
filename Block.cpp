#include "Block.h"

using namespace sf;
using namespace std;

Block::Block(float pos_x, float pos_y)
{
    rectangle.setSize(Vector2f{width,height});
    rectangle.setPosition(pos_x,pos_y);
    rectangle.setFillColor(Color::Green);
}

void Block::draw(RenderTarget& target,RenderStates states) const
{
    target.draw(rectangle,states);
}

void Block::movement()
{
    rectangle.move(0,speed);
}

float Block::bottom_edge()
{
    return rectangle.getPosition().y+(height);
}

float Block::left_edge()
{
    return rectangle.getPosition().x;
}

float Block::right_edge()
{
    return rectangle.getPosition().x+width;
}


