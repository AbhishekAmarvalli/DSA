/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    for (int cur = 0; cur < numsSize; cur++) {
        for (int x = cur + 1; x < numsSize; x++) {
            if (nums[x] == target - nums[cur]) {
                int* result = malloc(sizeof(int) * 2);
                result[0] = cur;
                result[1] = x;
                *returnSize = 2;
                return result;
            }
        }
    }
    *returnSize = 0;
    return malloc(sizeof(int) * 0);
}