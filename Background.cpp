#include <iostream>
#include <SFML/Graphics.hpp>
#include "Background.h"

using namespace std;
using namespace sf;


Background::Background()
{
    background.setPosition(0.0,0.0);
    background.setSize(Vector2f{backgroundWidth,backgroundHeight});
    backgroundTexture.loadFromFile("background.jpg");
    background.setTexture(&backgroundTexture);
}

void Background::draw(RenderTarget&targets,RenderStates states) const
{
    targets.draw(background,states);
}
