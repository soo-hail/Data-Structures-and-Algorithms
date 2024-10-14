#include <iostream>
#include <vector>

using namespace std;

void product2(const vector<int>& vec, vector<int>& ans, int size) {
    // SC = O(1), No additional arrays for prefix/suffix, directly modifying ans.

    // For Prefix
    ans[0] = 1;
    for (int i = 1; i < size; i++) {
        ans[i] = ans[i - 1] * vec[i - 1];
    }

    // For Suffix
    int suffix = 1;
    for (int i = size - 2; i >= 0; i--) {
        suffix = suffix * vec[i + 1];
        ans[i] = ans[i] * suffix;
    }
}

int main() {
    vector<int> vec = {1, 2, 3, 4}; 
    int n = vec.size();

    vector<int> ans(n);
    
    product2(vec, ans, n);

    for (int val : ans) {
        cout << val << " ";
    }

    return 0;
}
