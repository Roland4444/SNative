#include "HelloLibrary.hpp"
#include <iostream>
#include <dlfcn.h>

typedef void (*PFN_SAY_NAME)(const char*);

int main(void) {
    void* handle = dlopen("./libHelloLibrary.so", RTLD_LAZY);
    if (!handle) {    
        std::cout << "Could not open the library" << std::endl;
        return 1;
    }

    PFN_SAY_NAME hello = reinterpret_cast<PFN_SAY_NAME>(dlsym(handle, 
"SayHello"));
    if (!hello) {
        std::cout << "Could not find symbol SayHello" << std::endl;
        dlclose(handle);
        return 1;
    }

    hello("Edoren");
    dlclose(handle);

    return 0;
}

