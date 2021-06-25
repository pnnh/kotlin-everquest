#include <iostream>
#include "stdio.h"
#include "libnative_api.h"

int main(int argc, char** argv) {
  std::cout << "Hello, World!" << std::endl;
  libnative_ExportedSymbols* lib = libnative_symbols();

  lib->kotlin.root.xyz.sfx.utils.forIntegers(1, 2, 3, 4);
  lib->kotlin.root.xyz.sfx.utils.forFloats(1.0f, 2.0);

  const char* str = "Hello from Native!";
  const char* response = lib->kotlin.root.xyz.sfx.utils.strings(str);
  printf("in: %s\nout:%s\n", str, response);
  lib->DisposeString(response);

  libnative_kref_xyz_sfx_utils_Clazz newInstance = lib->kotlin.root.xyz.sfx.utils.Clazz.Clazz();
  long x = lib->kotlin.root.xyz.sfx.utils.Clazz.memberFunction(newInstance, 30);
  lib->DisposeStablePointer(newInstance.pinned);

  printf("DemoClazz returned %ld\n", x);

  return 0;
}
