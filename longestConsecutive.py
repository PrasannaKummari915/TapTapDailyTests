def longestConsecutive(nums):
    num_set = set(nums)   # store all numbers for O(1) lookup
    longest = 0

    for num in num_set:
        # only start counting if it's the beginning of a sequence
        if num - 1 not in num_set:
            length = 1
            while num + length in num_set:
                length += 1
            longest = max(longest, length)

    return longest


# Dynamic input
nums = list(map(int, input("Enter numbers separated by space: ").split()))
print("Longest consecutive sequence length:", longestConsecutive(nums))