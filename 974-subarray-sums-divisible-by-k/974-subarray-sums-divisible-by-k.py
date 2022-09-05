class Solution:
    def subarraysDivByK(self, A: List[int], K: int) -> int:
        res = 0
        d = [1] + [0] * K 
        acc = 0
        for a in A:
            acc = (acc + a) % K 
            if d[acc]:
                res += d[acc]
            d[acc] += 1            
        return res