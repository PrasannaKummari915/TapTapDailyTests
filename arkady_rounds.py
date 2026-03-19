def arkady_rounds(n, m, difficulties):
    freq = [0] * (n + 1)   # frequency of each difficulty
    result = []
    distinct = 0           # count of distinct difficulties currently in pool

    for diff in difficulties:
        freq[diff] += 1
        if freq[diff] == 1:   # new distinct difficulty added
            distinct += 1

        if distinct == n:     # all difficulties present → round held
            result.append("1")
            # remove one copy of each difficulty
            for i in range(1, n + 1):
                freq[i] -= 1
                if freq[i] == 0:
                    distinct -= 1
        else:
            result.append("0")

    return "".join(result)


# Dynamic input
n, m = map(int, input().split())
difficulties = list(map(int, input().split()))

print(arkady_rounds(n, m, difficulties))