#include "darts.h"
#include <cmath>
namespace darts {
    int score (double x, double y) {
        double distanceFromCenter = sqrt(x * x + y * y);
        if (distanceFromCenter <= 1) {
            return 10;
        } else if (distanceFromCenter <= 5) {
            return 5;
        } else if (distanceFromCenter <= 10) {
            return 1;
        } else {
            return 0;
        }
    }
} // namespace darts