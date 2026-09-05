cmake_minimum_required(VERSION 3.22)

project(aether)

set(CMAKE_CXX_STANDARD 20)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

include(FetchContent)

FetchContent_Declare(
    preloader_android
    GIT_REPOSITORY https://github.com/LiteLDev/preloader-android.git
    GIT_TAG 0.2.2
)

FetchContent_MakeAvailable(preloader_android)

add_library(aether SHARED
    src/main.cpp
    src/AetherMod.cpp
)

target_link_libraries(aether PRIVATE preloader)

target_include_directories(aether PRIVATE
    ${preloader_android_SOURCE_DIR}/include
)

set_target_properties(aether PROPERTIES
    OUTPUT_NAME "aether"
)
