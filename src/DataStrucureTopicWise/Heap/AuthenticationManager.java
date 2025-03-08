package DataStrucureTopicWise.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://leetcode.com/problems/design-authentication-manager
 * There is an authentication system that works with authentication tokens. For each session, the user will receive a new authentication token that will expire timeToLive seconds after the currentTime. If the token is renewed, the expiry time will be extended to expire timeToLive seconds after the (potentially different) currentTime.
Implement the AuthenticationManager class:
AuthenticationManager(int timeToLive) constructs the AuthenticationManager and sets the timeToLive.
generate(string tokenId, int currentTime) generates a new token with the given tokenId at the given currentTime in seconds.
renew(string tokenId, int currentTime) renews the unexpired token with the given tokenId at the given currentTime in seconds. If there are no unexpired tokens with the given tokenId, the request is ignored, and nothing happens.
countUnexpiredTokens(int currentTime) returns the number of unexpired tokens at the given currentTime.
Note that if a token expires at time t, and another action happens on time t (renew or countUnexpiredTokens), the expiration takes place before the other actions.
 * 
 * 
 * 
 * 
 * */
public class AuthenticationManager {	
	int timeToLive;
	
    class Pair{
        String tokenId;
        int expireTime;
        
        public Pair(String tokenId,int expireTime){
            this.tokenId=tokenId;
            this.expireTime=expireTime;
        }  
    }
    
    Queue<Pair> q = new PriorityQueue<>((Pair p1,Pair p2)->p1.expireTime-p2.expireTime);
    Map<String,Integer> map = new HashMap<>();    
    public AuthenticationManager(int timeToLive) {
        this.timeToLive=timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        if(!map.containsKey(tokenId)){
            q.offer(new Pair(tokenId,currentTime+timeToLive));
        }
        map.put(tokenId,currentTime+timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
         if(map.containsKey(tokenId) && map.get(tokenId)>currentTime){
              map.put(tokenId,currentTime+timeToLive);
         }    

    }
    
    public int countUnexpiredTokens(int currentTime) {
        while(!q.isEmpty() && q.peek().expireTime<=currentTime){
            Pair p = q.poll();
            if(map.get(p.tokenId)>p.expireTime){
                q.offer(new Pair(p.tokenId,map.get(p.tokenId)));
            }else{
                map.remove(p.tokenId);
            }
        }
        return q.size();
    }

	public static void main(String[] args) {
	}

}
