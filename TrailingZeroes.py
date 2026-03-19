def has_trailing_zero(nums):
    # Check all pairs (or more) of elements
    n = len(nums)
    for i in range(n):
        for j in range(i + 1, n):
            if (nums[i] | nums[j]) % 2 == 0:  # OR result has trailing zero if it's even
                return True
    return False

# Dynamic input: space-separated integers
nums = list(map(int, input("Enter numbers: ").split()))

print(has_trailing_zero(nums))