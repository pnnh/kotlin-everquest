cmake_minimum_required(VERSION 3.19)
project(everquest)

set(CMAKE_CXX_STANDARD 14)

set( CMAKE_VERBOSE_MAKEFILE on )

include_directories(${PROJECT_SOURCE_DIR}/libraries)
link_directories(${PROJECT_SOURCE_DIR}/libraries)

add_executable(${PROJECT_NAME} src/main.cpp)

target_link_libraries(${PROJECT_NAME} native)