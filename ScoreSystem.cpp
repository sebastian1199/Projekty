#include <iostream>
#include <SFML/Graphics.hpp>
#include "ScoreSystem.h"

using namespace std;
using namespace sf;

Text ScoreSystem::scoreInit(Font& font, int points)
{
    text.setFont(font);
    text.setCharacterSize(30);
    text.setFillColor(Color::Black);
    text.setString("Score : " + to_string(points));
    text.setPosition(textPosition);
    return text;
}

void ScoreSystem::scoreUpdate(Text& text,int additionalPoints)
{
    points+=additionalPoints;
    text.setString("Score : " + to_string(points));
    text=this->text;
}

void ScoreSystem::update()
{
    static int Points;
    static int levelRange;
    if(points>Points) levelRange++;
    Points=points;
    if(levelRange%2==0) level++;
    cout<<"Level: "<<level<<endl;
}
