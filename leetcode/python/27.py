class Solution(object):
    def removeElement(self, nums, val):
        k,l = 0,len(nums)
        rx = l-1 

        for i in reversed(range(0,l)):
            if nums[i] != val:
                k+=1
            else:
                nums[i],nums[rx] = nums[rx],nums[i]
                rx-=1
        
        return k
