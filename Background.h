#ifndef UNTITLED1_BACKGROUND_H
#define UNTITLED1_BACKGROUND_H

#include <iostream>
#include <SFML/Graphics.hpp>

using namespace std;
using namespace sf;

class Background : public Drawable
{
    RectangleShape background;
    Texture backgroundTexture;
    float backgroundWidth = 1500.0;
    float backgroundHeight = 800.0;
    void draw(RenderTarget&targets,RenderStates states) const override;

public:
    Background();
};




#endif //UNTITLED1_BACKGROUND_H
