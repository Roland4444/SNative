#include "HelloLibrary.hpp"
#include <iostream>

void SayHello(const char* name, const char * ender) {
    std::cout << "Hello " << name << " have a nice day!" << std::endl;
    std::cout << ender;
}
