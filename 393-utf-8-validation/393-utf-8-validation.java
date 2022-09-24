class Solution {
    public boolean validUtf8(int[] data) {
        int i=0;
      
        int nByte = 0;
        while(i<data.length)
        {
            int num = data[i];
            if(((num & 1<<7) == 1<<7) && nByte==0)
            {
                int k = 7;
                while(k>=0)
                {
                    if((num & 1<<k)==1<<k)
                    {
                        nByte++;
                    }
                    else
                        break;
                    k--;
                }
                if(nByte==1 || nByte>=5)
                    return false;
                nByte--;
                i++;
            }
            else if(nByte>0)
            {
                
                if(((num & 1<<7)!=1<<7 || (num & 1<<6)!=0))
                        return false;
                nByte--;
                i++;
            }
            else
                i++;
        }
        return nByte > 0 ? false : true;
    }
}