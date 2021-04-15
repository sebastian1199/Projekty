cmake_minimum_required(VERSION 3.17)
project(shooter)

set(CMAKE_CXX_STANDARD 11)

add_executable(shooter Game.cpp Ball.h Ball.cpp Bullet.cpp Bullet.h Block.h Block.cpp)

find_package(SFML 2.5.1 COMPONENTS system window graphics audio)

target_link_libraries(shooter  sfml-system sfml-window sfml-graphics sfml-audio -static)
