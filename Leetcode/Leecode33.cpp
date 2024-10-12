#include<iostream>
#include<vector>
using namespace std;

int main(){
    vector<int> vec = {3, 4, 5, 6, 7, 0, 1, 2};
    int target = 0;

    int start = 0, end = vec.size() - 1;
    
    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (vec[mid] == target) {
            cout << mid << endl;
            return 0;
        }
        
        // CHECK IF LEFT-HALF IS SORTED.
        if (vec[start] <= vec[mid]) {
            if (target >= vec[start] && target < vec[mid]) {
                // SEARCH IN LEFT-HALF
                end = mid - 1;  
            } else {
                // SEARCH IN RIGHT-HALF
                start = mid + 1;  
            }
        }
        // ELSE, RIGHT-HALF MUST BE SORTED.
        else {
            if (target > vec[mid] && target <= vec[end]) {
                // SEARCH IN RIGHT-HALF
                start = mid + 1; 
            } else {
                // SEARCH IN LEFT-HALF
                end = mid - 1;  
            }
        }
    }
    
    cout << "Target not found" << endl;
    return 0;
}
