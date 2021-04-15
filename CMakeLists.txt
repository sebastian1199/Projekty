cmake_minimum_required(VERSION 3.17)
project(untitled1)

set(CMAKE_CXX_STANDARD 11)

add_executable(untitled1 Game.cpp Character.cpp Character.h Background.h Background.cpp CharacterBall.h CharacterBall.cpp Enemy.h Enemy.cpp Animation.h Animation.cpp ScoreSystem.h ScoreSystem.cpp EnemyBall.h Enemyball.cpp)

find_package(SFML 2.5.1 COMPONENTS system window graphics audio)

target_link_libraries(untitled1 sfml-system sfml-window sfml-graphics sfml-audio -static)
