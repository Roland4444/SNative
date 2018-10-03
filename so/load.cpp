#include "summ.h"
#include <iostream>
#include <dlfcn.h>

typedef void (*PFN_SAY_NAME)(const char*);

int main(void) {
    void* handle = dlopen("libsumm.so", RTLD_LAZY);
    if (!handle) {    
        std::cout << "Could not open the library" << std::endl;
        return 1;
    }

    PFN_SAY_NAME summa = reinterpret_cast<PFN_SAY_NAME>(dlsym(handle, 
"summa"));
    if (!summa) {
        std::cout << "Could not find symbol SayHello" << std::endl;
        dlclose(handle);
        return 1;
    }

    summa(2,4);
    dlclose(handle);

    return 0;
}
