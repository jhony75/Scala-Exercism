#include "raindrops.h"
#include <string>

namespace raindrops {

    std::string convert(int x) {
      std::string name;
      if (x % 3 == 0) {
        name += "Pling";
      }
      if (x % 5 == 0) {
        name += "Plang";
      }
      if (x % 7 == 0) {
        name += "Plong";
      }
      if (name.empty()) {
        name = std::to_string(x);
      }
      return name;
    }

}  // namespace raindrops
