class Solution {
    public boolean validUtf8(int[] data) {
        int i=0;
        // if(data.length>=5)
        //     return false;
        int nByte = 0;
        while(i<data.length)
        {
            int num = data[i];
             System.out.println("nByte "+nByte);
            
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
                System.out.println(nByte);
                i++;
            }
            else if(nByte>0)
            {
                
                if(((num & 1<<7)!=1<<7 || (num & 1<<6)!=0)){
                    System.out.println(nByte);
                        System.out.println("Hi "+num);
                        return false;
                }
                nByte--;
                i++;
            }
            else if((num & 1<<7) == 0)
            {
                nByte = 0;
                i++;
            }
            else{
                System.out.println("Heyy");
                i++;
            }
           
            
        }
        System.out.println(nByte);
        return nByte > 0 ? false : true;
    }
}