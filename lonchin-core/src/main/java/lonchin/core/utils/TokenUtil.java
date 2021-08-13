package lonchin.core.utils;

import lombok.AllArgsConstructor;

import java.util.concurrent.TimeUnit;


@AllArgsConstructor
public class TokenUtil {
	
    private final RedisUtil redisUtil;
	
	/**
	 * 获取token若已经存在就获取缓存中有的，若不存在就产生新的传回
	 * @param userName
	 * @return
	 */
    public String getToken(String userName){
        JedisConnectUtil jedisConnectUtil = new JedisConnectUtil();
    	Boolean result =  jedisConnectUtil.exists(userName);
    	if(result){
    		String token = JedisConnectUtil.getnx(userName);
    		return token;
    	} else{
    		String token = MD5Util.md5Password(System.currentTimeMillis() + "wall" + userName);
			redisUtil.setEx(userName, token, 3600*24, TimeUnit.SECONDS);
			redisUtil.setEx(token, userName, 3600*24, TimeUnit.SECONDS);
    		return token;
    	}
	}
    
	/**
	 * 校验token是否在缓存中存在 若存在则为真
	 * @param token
	 * @return
	 */
    public Boolean judgeToken(String token){
    	return redisUtil.hasKey(token);
    }
    
    /*public Boolean judgeRole(String token,String url){
        JedisConnectUtil jedisConnectUtil = new JedisConnectUtil();
    	Boolean result =  jedisConnectUtil.exists(token);
    	if(result){
    		String userName = JedisConnectUtil.getnx(token);
    		Set<String> permissions = tbUserDao.getPermissions(userName);
    		result = permissions.contains(url);
    	} else{
    		result = false;
    		throw new XmallException("你没有权限访问该接口或登录已失效");
    	}
    	return result;
    }*/
}
