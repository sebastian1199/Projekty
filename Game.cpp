#include <iostream>
#include <SFML/Graphics.hpp>
#include <vector>
#include "Ball.h"
#include "Bullet.h"
#include "Block.h"

using namespace std;
using namespace sf;

float time_step = 1000.0;
int score=0;

bool isCollision(Bullet& bullet,Block& block)
{
    if(bullet.top_edge()<block.bottom_edge() && bullet.left_edge()>block.left_edge()
    && bullet.right_edge()<block.right_edge()) {
        return true;
    }
    return false;
}

bool isGameOver(Block& block)
{
    if(block.bottom_edge()>600) return true;
    return false;
}

void level_update()
{
    static int level=1;
    if(score>0 && score%10==0)
    {
        time_step-=50.0;
        cout<<"Next level: "<<to_string(++level)<<"!"<<endl;
    }
}


int main() {

    RenderWindow window(VideoMode(800, 600), "Shooter Game");
    window.setFramerateLimit(100);
    Ball ball(400, 550);
    vector<Bullet> bullets;
    vector<Block> blocks;
    Clock clock;
    Event event{};
    bool destroyed = false;
    cout<<"Level: 1\n";


    while (window.isOpen()) {
        if(clock.getElapsedTime().asMilliseconds()>time_step)
        {
            clock.restart();
            blocks.emplace_back(rand()%700,0);
        }

        while (window.pollEvent(event)) {
            if (event.type == Event::Closed)
                window.close();
        }

        window.clear(Color::Black);

        ball.movement();
        window.draw(ball);

        if (Keyboard::isKeyPressed(Keyboard::Space)) {
            bullets.emplace_back(ball.getCurrentPosition());
        }

        for (auto &bullet : bullets) {
            bullet.movement();
            window.draw(bullet);
        }

        for (auto &block : blocks) {
            block.movement();
            window.draw(block);
        }


        for(int i=0;i<bullets.size();i++)
        {
            for(int o=0;o<blocks.size();o++) {
                if (isCollision(bullets[i], blocks[o])) {
                    bullets.clear();
                    destroyed=true;
                    score++;
                    level_update();
                    auto iterator = blocks.begin();
                    blocks.erase(iterator + o);
                    break;
                }
            }
            if(destroyed){
                destroyed=false;
                break;
            }
        }

            for(auto& block:blocks)
            {
                if(isGameOver(block))
                {
                    cout<<"Game Over!\nScore: "<<score<<endl;
                    return 0;
                }
            }

            window.display();
        }
      }
