class Solution(object):
    def removeDuplicates(self, nums):
        nums[:] = sorted(set(nums))

        return len(nums)