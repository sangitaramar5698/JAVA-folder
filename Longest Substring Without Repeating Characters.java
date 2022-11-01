class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int pos=0,count=0;
       
      if(s.length()>1){      
        for(int i=0;i<s.length();i++){          //i=0
              char[] check= new char[s.length()];
              pos=0;
              
            for(int j=i;j<s.length();j++){       //j=0 //j=1
                count=0;    
                if(pos==0){                     //pos=0
                        check[pos]=s.charAt(j); //c[0]=a
                        pos++;                  //pos= 1
                }else{                              
                    
                    for(int len=0;len<pos;len++){       //len=0, len 1<pos 1
                        if(check[len]==s.charAt(j)){       //c[0]==s[1] a==u
                            count++;
                            // max = (count>0)? (pos>max) ? pos:max
                            break;
                        }
                    }

                    if(count==0){
                        check[pos]=s.charAt(j);  //c[1]=s[1], au
                        pos++;  
                         max = (pos>max)?pos:max;
                                            //pos =2
                    }
                    
                }
                if(count >0){
                    max = (pos>max)?pos:max;
                    break;

                }
                
            }
           
           
           
            
        }
        return max;
      }else{
          return s.length();
      }
        
    }
}
