package com.yucheng.util;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yucheng.core.resp.Article;
import com.yucheng.core.resp.Music;
import com.yucheng.pojo.SNSUserInfo;
import com.yucheng.pojo.WeixinGroup;
import com.yucheng.pojo.WeixinMedia;
import com.yucheng.pojo.WeixinOauth2Token;
import com.yucheng.pojo.WeixinQRCode;
import com.yucheng.pojo.WeixinUserInfo;
import com.yucheng.pojo.WeixinUserList;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 * 锟竭硷拷锟接口癸拷锟斤拷锟斤拷
 * 
 * @author liufeng
 * @date 2013-11-9
 */
public class AdvancedUtil {
	private static Logger log = LoggerFactory.getLogger(AdvancedUtil.class);

	/**
	 * 锟斤拷装锟侥憋拷锟酵凤拷锟斤拷息
	 * 
	 * @param openId 锟斤拷息锟斤拷锟酵讹拷锟斤拷
	 * @param content 锟侥憋拷锟斤拷息锟斤拷锟斤拷
	 * @return
	 */
	public static String makeTextCustomMessage(String openId, String content) {
		// 锟斤拷锟斤拷息锟斤拷锟斤拷锟叫碉拷双锟斤拷锟脚斤拷锟斤拷转锟斤拷
		content = content.replace("\"", "\\\"");
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"text\",\"text\":{\"content\":\"%s\"}}";
		return String.format(jsonMsg, openId, content);
	}

	/**
	 * 锟斤拷装图片锟酵凤拷锟斤拷息
	 * 
	 * @param openId 锟斤拷息锟斤拷锟酵讹拷锟斤拷
	 * @param mediaId 媒锟斤拷锟侥硷拷id
	 * @return
	 */
	public static String makeImageCustomMessage(String openId, String mediaId) {
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"image\",\"image\":{\"media_id\":\"%s\"}}";
		return String.format(jsonMsg, openId, mediaId);
	}

	/**
	 * 锟斤拷装锟斤拷锟斤拷锟酵凤拷锟斤拷息
	 * 
	 * @param openId 锟斤拷息锟斤拷锟酵讹拷锟斤拷
	 * @param mediaId 媒锟斤拷锟侥硷拷id
	 * @return
	 */
	public static String makeVoiceCustomMessage(String openId, String mediaId) {
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"voice\",\"voice\":{\"media_id\":\"%s\"}}";
		return String.format(jsonMsg, openId, mediaId);
	}

	/**
	 * 锟斤拷装锟斤拷频锟酵凤拷锟斤拷息
	 * 
	 * @param openId 锟斤拷息锟斤拷锟酵讹拷锟斤拷
	 * @param mediaId 媒锟斤拷锟侥硷拷id
	 * @param thumbMediaId 锟斤拷频锟斤拷息锟斤拷锟斤拷图锟斤拷媒锟斤拷id
	 * @return
	 */
	public static String makeVideoCustomMessage(String openId, String mediaId, String thumbMediaId) {
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"video\",\"video\":{\"media_id\":\"%s\",\"thumb_media_id\":\"%s\"}}";
		return String.format(jsonMsg, openId, mediaId, thumbMediaId);
	}

	/**
	 * 锟斤拷装锟斤拷锟街客凤拷锟斤拷息
	 * 
	 * @param openId 锟斤拷息锟斤拷锟酵讹拷锟斤拷
	 * @param music 锟斤拷锟街讹拷锟斤拷
	 * @return
	 */
	public static String makeMusicCustomMessage(String openId, Music music) {
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"music\",\"music\":%s}";
		jsonMsg = String.format(jsonMsg, openId, JSONObject.fromObject(music).toString());
		// 锟斤拷jsonMsg锟叫碉拷thumbmediaid锟芥换为thumb_media_id
		jsonMsg = jsonMsg.replace("thumbmediaid", "thumb_media_id");
		return jsonMsg;
	}

	/**
	 * 锟斤拷装图锟侥客凤拷锟斤拷息
	 * 
	 * @param openId 锟斤拷息锟斤拷锟酵讹拷锟斤拷
	 * @param articleList 图锟斤拷锟斤拷息锟叫憋拷
	 * @return
	 */
	public static String makeNewsCustomMessage(String openId, List<Article> articleList) {
		String jsonMsg = "{\"touser\":\"%s\",\"msgtype\":\"news\",\"news\":{\"articles\":%s}}";
		jsonMsg = String.format(jsonMsg, openId, JSONArray.fromObject(articleList).toString().replaceAll("\"", "\\\""));
		// 锟斤拷jsonMsg锟叫碉拷picUrl锟芥换为picurl
		jsonMsg = jsonMsg.replace("picUrl", "picurl");
		return jsonMsg;
	}

	/**
	 * 锟斤拷锟酵客凤拷锟斤拷息
	 * 
	 * @param accessToken 锟接口凤拷锟斤拷凭证
	 * @param jsonMsg json锟斤拷式锟侥客凤拷锟斤拷息锟斤拷锟斤拷锟斤拷touser锟斤拷msgtype锟斤拷锟斤拷息锟斤拷锟捷ｏ拷
	 * @return true | false
	 */
	public static boolean sendCustomMessage(String accessToken, String jsonMsg) {
		log.info("锟斤拷息锟斤拷锟捷ｏ拷{}", jsonMsg);
		boolean result = false;
		// 拼锟斤拷锟斤拷锟斤拷锟街�
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		// 锟斤拷锟酵客凤拷锟斤拷息
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "POST", jsonMsg);

		if (null != jsonObject) {
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (0 == errorCode) {
				result = true;
				log.info("锟酵凤拷锟斤拷息锟斤拷锟酵成癸拷 errcode:{} errmsg:{}", errorCode, errorMsg);
			} else {
				log.error("锟酵凤拷锟斤拷息锟斤拷锟斤拷失锟斤拷 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}

		return result;
	}

	/**
	 * 锟斤拷取锟斤拷页锟斤拷权凭证
	 * 
	 * @param appId 锟斤拷锟斤拷锟剿号碉拷唯一锟斤拷识
	 * @param appSecret 锟斤拷锟斤拷锟剿号碉拷锟斤拷钥
	 * @param code
	 * @return WeixinAouth2Token
	 */
	public static WeixinOauth2Token getOauth2AccessToken(String appId, String appSecret, String code) {
		WeixinOauth2Token wat = null;
		// 拼锟斤拷锟斤拷锟斤拷锟街�
		String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
		requestUrl = requestUrl.replace("APPID", appId);
		requestUrl = requestUrl.replace("SECRET", appSecret);
		requestUrl = requestUrl.replace("CODE", code);
		// 锟斤拷取锟斤拷页锟斤拷权凭证
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
		if (null != jsonObject) {
			try {
				wat = new WeixinOauth2Token();
				wat.setAccessToken(jsonObject.getString("access_token"));
				wat.setExpiresIn(jsonObject.getInt("expires_in"));
				wat.setRefreshToken(jsonObject.getString("refresh_token"));
				wat.setOpenId(jsonObject.getString("openid"));
				wat.setScope(jsonObject.getString("scope"));
			} catch (Exception e) {
				wat = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("锟斤拷取锟斤拷页锟斤拷权凭证失锟斤拷 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return wat;
	}

	/**
	 * 刷锟斤拷锟斤拷页锟斤拷权凭证
	 * 
	 * @param appId 锟斤拷锟斤拷锟剿号碉拷唯一锟斤拷识
	 * @param refreshToken
	 * @return WeixinAouth2Token
	 */
	public static WeixinOauth2Token refreshOauth2AccessToken(String appId, String refreshToken) {
		WeixinOauth2Token wat = null;
		// 拼锟斤拷锟斤拷锟斤拷锟街�
		String requestUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";
		requestUrl = requestUrl.replace("APPID", appId);
		requestUrl = requestUrl.replace("REFRESH_TOKEN", refreshToken);
		// 刷锟斤拷锟斤拷页锟斤拷权凭证
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
		if (null != jsonObject) {
			try {
				wat = new WeixinOauth2Token();
				wat.setAccessToken(jsonObject.getString("access_token"));
				wat.setExpiresIn(jsonObject.getInt("expires_in"));
				wat.setRefreshToken(jsonObject.getString("refresh_token"));
				wat.setOpenId(jsonObject.getString("openid"));
				wat.setScope(jsonObject.getString("scope"));
			} catch (Exception e) {
				wat = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("刷锟斤拷锟斤拷页锟斤拷权凭证失锟斤拷 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return wat;
	}

	/**
	 * 通锟斤拷锟斤拷页锟斤拷权锟斤拷取锟矫伙拷锟斤拷息
	 * 
	 * @param accessToken 锟斤拷页锟斤拷权锟接口碉拷锟斤拷凭证
	 * @param openId 锟矫伙拷锟斤拷识
	 * @return SNSUserInfo
	 */
	@SuppressWarnings( { "deprecation", "unchecked" })
	public static SNSUserInfo getSNSUserInfo(String accessToken, String openId) {
		SNSUserInfo snsUserInfo = null;
		// 拼锟斤拷锟斤拷锟斤拷锟街�
		String requestUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		// 通锟斤拷锟斤拷页锟斤拷权锟斤拷取锟矫伙拷锟斤拷息
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			try {
				snsUserInfo = new SNSUserInfo();
				// 锟矫伙拷锟侥憋拷识
				snsUserInfo.setOpenId(jsonObject.getString("openid"));
				// 锟角筹拷
				snsUserInfo.setNickname(jsonObject.getString("nickname"));
				// 锟皆憋拷1锟斤拷锟斤拷锟皆ｏ拷2锟斤拷女锟皆ｏ拷0锟斤拷未知锟斤拷
				snsUserInfo.setSex(jsonObject.getInt("sex"));
				// 锟矫伙拷锟斤拷锟节癸拷锟斤拷
				snsUserInfo.setCountry(jsonObject.getString("country"));
				// 锟矫伙拷锟斤拷锟斤拷省锟斤拷
				snsUserInfo.setProvince(jsonObject.getString("province"));
				// 锟矫伙拷锟斤拷锟节筹拷锟斤拷
				snsUserInfo.setCity(jsonObject.getString("city"));
				// 锟矫伙拷头锟斤拷
				snsUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
				// 锟矫伙拷锟斤拷权锟斤拷息
				snsUserInfo.setPrivilegeList(JSONArray.toList(jsonObject.getJSONArray("privilege"), List.class));
			} catch (Exception e) {
				snsUserInfo = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("锟斤拷取锟矫伙拷锟斤拷息失锟斤拷 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return snsUserInfo;
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷时锟斤拷锟轿讹拷维锟斤拷
	 * 
	 * @param accessToken 锟接口凤拷锟斤拷凭证
	 * @param expireSeconds 锟斤拷维锟斤拷锟斤拷效时锟戒，锟斤拷位为锟诫，锟斤拷蟛怀锟斤拷锟�1800
	 * @param sceneId 锟斤拷锟斤拷ID
	 * @return WeixinQRCode
	 */
	public static WeixinQRCode createTemporaryQRCode(String accessToken, int expireSeconds, int sceneId) {
		WeixinQRCode weixinQRCode = null;
		// 拼锟斤拷锟斤拷锟斤拷锟街�
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		// 锟斤拷要锟结交锟斤拷json锟斤拷锟斤拷
		String jsonMsg = "{\"expire_seconds\": %d, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": %d}}}";
		// 锟斤拷锟斤拷锟斤拷时锟斤拷锟轿讹拷维锟斤拷
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "POST", String.format(jsonMsg, expireSeconds, sceneId));

		if (null != jsonObject) {
			try {
				weixinQRCode = new WeixinQRCode();
				weixinQRCode.setTicket(jsonObject.getString("ticket"));
				weixinQRCode.setExpireSeconds(jsonObject.getInt("expire_seconds"));
				log.info("锟斤拷锟斤拷锟斤拷时锟斤拷锟轿讹拷维锟斤拷晒锟� ticket:{} expire_seconds:{}", weixinQRCode.getTicket(), weixinQRCode.getExpireSeconds());
			} catch (Exception e) {
				weixinQRCode = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("锟斤拷锟斤拷锟斤拷时锟斤拷锟轿讹拷维锟斤拷失锟斤拷 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return weixinQRCode;
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷锟矫达拷锟轿讹拷维锟斤拷
	 * 
	 * @param accessToken 锟接口凤拷锟斤拷凭证
	 * @param sceneId 锟斤拷锟斤拷ID
	 * @return ticket
	 */
	public static String createPermanentQRCode(String accessToken, int sceneId) {
		String ticket = null;
		// 拼锟斤拷锟斤拷锟斤拷锟街�
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=ACCESS_TOKEN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		// 锟斤拷要锟结交锟斤拷json锟斤拷锟斤拷
		String jsonMsg = "{\"action_name\": \"QR_LIMIT_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": %d}}}";
		// 锟斤拷锟斤拷锟斤拷锟矫达拷锟轿讹拷维锟斤拷
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "POST", String.format(jsonMsg, sceneId));

		if (null != jsonObject) {
			try {
				ticket = jsonObject.getString("ticket");
				log.info("锟斤拷锟斤拷锟斤拷锟矫达拷锟轿讹拷维锟斤拷晒锟� ticket:{}", ticket);
			} catch (Exception e) {
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("锟斤拷锟斤拷锟斤拷锟矫达拷锟轿讹拷维锟斤拷失锟斤拷 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return ticket;
	}

	/**
	 * 锟斤拷锟斤拷ticket锟斤拷取锟斤拷维锟斤拷
	 * 
	 * @param ticket 锟斤拷维锟斤拷ticket
	 * @param savePath 锟斤拷锟斤拷路锟斤拷
	 */
	public static String getQRCode(String ticket, String savePath) {
		String filePath = null;
		// 拼锟斤拷锟斤拷锟斤拷锟街�
		String requestUrl = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
		requestUrl = requestUrl.replace("TICKET", CommonUtil.urlEncodeUTF8(ticket));
		try {
			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setRequestMethod("GET");

			if (!savePath.endsWith("/")) {
				savePath += "/";
			}
			// 锟斤拷ticket锟斤拷为锟侥硷拷锟斤拷
			filePath = savePath + ticket + ".jpg";

			// 锟斤拷微锟脚凤拷锟斤拷锟斤拷锟斤拷锟截碉拷锟斤拷锟斤拷锟斤拷写锟斤拷锟侥硷拷
			BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
			FileOutputStream fos = new FileOutputStream(new File(filePath));
			byte[] buf = new byte[8096];
			int size = 0;
			while ((size = bis.read(buf)) != -1)
				fos.write(buf, 0, size);
			fos.close();
			bis.close();

			conn.disconnect();
			log.info("锟斤拷锟斤拷ticket锟斤拷取锟斤拷维锟斤拷晒锟斤拷锟絝ilePath=" + filePath);
		} catch (Exception e) {
			filePath = null;
			log.error("锟斤拷锟斤拷ticket锟斤拷取锟斤拷维锟斤拷失锟杰ｏ拷{}", e);
		}
		return filePath;
	}

	/**
	 * 获取用户信息
	 * 
	 * @param accessToken 密钥
	 * @param openId 用户openid
	 * @return WeixinUserInfo
	 */
	public static WeixinUserInfo getUserInfo(String accessToken, String openId) {
		WeixinUserInfo weixinUserInfo = null;
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
		  System.out.println(jsonObject.toString());
		if (null != jsonObject) {
			try {
				weixinUserInfo = new WeixinUserInfo();
				weixinUserInfo.setOpenId(jsonObject.getString("openid"));
				weixinUserInfo.setSubscribe(jsonObject.getInt("subscribe"));
				weixinUserInfo.setSubscribeTime(jsonObject.getString("subscribe_time"));
				weixinUserInfo.setNickname(jsonObject.getString("nickname"));
				weixinUserInfo.setSex(jsonObject.getInt("sex"));
				weixinUserInfo.setCountry(jsonObject.getString("country"));
				weixinUserInfo.setProvince(jsonObject.getString("province"));
				weixinUserInfo.setCity(jsonObject.getString("city"));
				weixinUserInfo.setLanguage(jsonObject.getString("language"));
				weixinUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
			} catch (Exception e) {
				if (0 == weixinUserInfo.getSubscribe()) {
					log.error("锟矫伙拷{}锟斤拷取锟斤拷锟斤拷注", weixinUserInfo.getOpenId());
				} else {
					int errorCode = jsonObject.getInt("errcode");
					String errorMsg = jsonObject.getString("errmsg");
					log.error("锟斤拷取锟矫伙拷锟斤拷息失锟斤拷 errcode:{} errmsg:{}", errorCode, errorMsg);
				}
			}
		}
		return weixinUserInfo;
	}

	/**
	 * 锟斤拷取锟斤拷注锟斤拷锟叫憋拷
	 * 
	 * @param accessToken 锟斤拷锟矫接匡拷凭证
	 * @param nextOpenId 锟斤拷一锟斤拷锟斤拷取锟斤拷openId锟斤拷锟斤拷锟斤拷默锟较达拷头锟斤拷始锟斤拷取
	 * @return WeixinUserList
	 */
	@SuppressWarnings( { "unchecked", "deprecation" })
	public static WeixinUserList getUserList(String accessToken, String nextOpenId) {
		WeixinUserList weixinUserList = null;

		if (null == nextOpenId)
			nextOpenId = "";

		// 拼锟斤拷锟斤拷锟斤拷锟街�
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("NEXT_OPENID", nextOpenId);
		// 锟斤拷取锟斤拷注锟斤拷锟叫憋拷
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
		// 锟斤拷锟斤拷锟斤拷锟缴癸拷
		if (null != jsonObject) {
			try {
				weixinUserList = new WeixinUserList();
				weixinUserList.setTotal(jsonObject.getInt("total"));
				weixinUserList.setCount(jsonObject.getInt("count"));
				weixinUserList.setNextOpenId(jsonObject.getString("next_openid"));
				JSONObject dataObject = (JSONObject) jsonObject.get("data");
				weixinUserList.setOpenIdList(JSONArray.toList(dataObject.getJSONArray("openid"), List.class));
			} catch (JSONException e) {
				weixinUserList = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("锟斤拷取锟斤拷注锟斤拷锟叫憋拷失锟斤拷 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return weixinUserList;
	}

	/**
	 * 锟斤拷询锟斤拷锟斤拷
	 * 
	 * @param accessToken 锟斤拷锟矫接匡拷凭证
	 */
	@SuppressWarnings( { "unchecked", "deprecation" })
	public static List<WeixinGroup> getGroups(String accessToken) {
		List<WeixinGroup> weixinGroupList = null;
		// 拼锟斤拷锟斤拷锟斤拷锟街�
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=ACCESS_TOKEN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		// 锟斤拷询锟斤拷锟斤拷
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);

		if (null != jsonObject) {
			try {
				weixinGroupList = JSONArray.toList(jsonObject.getJSONArray("groups"), WeixinGroup.class);
			} catch (JSONException e) {
				weixinGroupList = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("锟斤拷询锟斤拷锟斤拷失锟斤拷 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return weixinGroupList;
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷
	 * 
	 * @param accessToken 锟接口凤拷锟斤拷凭证
	 * @param groupName 锟斤拷锟斤拷锟斤拷锟斤拷
	 * @return
	 */
	public static WeixinGroup createGroup(String accessToken, String groupName) {
		WeixinGroup weixinGroup = null;
		// 拼锟斤拷锟斤拷锟斤拷锟街�
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=ACCESS_TOKEN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		// 锟斤拷要锟结交锟斤拷json锟斤拷锟斤拷
		String jsonData = "{\"group\" : {\"name\" : \"%s\"}}";
		// 锟斤拷锟斤拷锟斤拷锟斤拷
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "POST", String.format(jsonData, groupName));

		if (null != jsonObject) {
			try {
				weixinGroup = new WeixinGroup();
				weixinGroup.setId(jsonObject.getJSONObject("group").getInt("id"));
				weixinGroup.setName(jsonObject.getJSONObject("group").getString("name"));
			} catch (JSONException e) {
				weixinGroup = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				log.error("锟斤拷锟斤拷锟斤拷锟斤拷失锟斤拷 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return weixinGroup;
	}

	/**
	 * 锟睫改凤拷锟斤拷锟斤拷
	 * 
	 * @param accessToken 锟接口凤拷锟斤拷凭证
	 * @param groupId 锟斤拷锟斤拷id
	 * @param groupName 锟睫改猴拷姆锟斤拷锟斤拷锟�
	 * @return true | false
	 */
	public static boolean updateGroup(String accessToken, int groupId, String groupName) {
		boolean result = false;
		// 拼锟斤拷锟斤拷锟斤拷锟街�
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=ACCESS_TOKEN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		// 锟斤拷要锟结交锟斤拷json锟斤拷锟斤拷
		String jsonData = "{\"group\": {\"id\": %d, \"name\": \"%s\"}}";
		// 锟睫改凤拷锟斤拷锟斤拷
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "POST", String.format(jsonData, groupId, groupName));

		if (null != jsonObject) {
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (0 == errorCode) {
				result = true;
				log.info("锟睫改凤拷锟斤拷锟斤拷锟缴癸拷 errcode:{} errmsg:{}", errorCode, errorMsg);
			} else {
				log.error("锟睫改凤拷锟斤拷锟斤拷失锟斤拷 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return result;
	}

	/**
	 * 锟狡讹拷锟矫伙拷锟斤拷锟斤拷
	 * 
	 * @param accessToken 锟接口凤拷锟斤拷凭证
	 * @param openId 锟矫伙拷锟斤拷识
	 * @param groupId 锟斤拷锟斤拷id
	 * @return true | false
	 */
	public static boolean updateMemberGroup(String accessToken, String openId, int groupId) {
		boolean result = false;
		// 拼锟斤拷锟斤拷锟斤拷锟街�
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=ACCESS_TOKEN";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
		// 锟斤拷要锟结交锟斤拷json锟斤拷锟斤拷
		String jsonData = "{\"openid\":\"%s\",\"to_groupid\":%d}";
		// 锟狡讹拷锟矫伙拷锟斤拷锟斤拷
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "POST", String.format(jsonData, openId, groupId));

		if (null != jsonObject) {
			int errorCode = jsonObject.getInt("errcode");
			String errorMsg = jsonObject.getString("errmsg");
			if (0 == errorCode) {
				result = true;
				log.info("锟狡讹拷锟矫伙拷锟斤拷锟斤拷晒锟� errcode:{} errmsg:{}", errorCode, errorMsg);
			} else {
				log.error("锟狡讹拷锟矫伙拷锟斤拷锟斤拷失锟斤拷 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return result;
	}

	/**
	 * 锟较达拷媒锟斤拷锟侥硷拷
	 * 
	 * @param accessToken 锟接口凤拷锟斤拷凭证
	 * @param type 媒锟斤拷锟侥硷拷锟斤拷锟酵ｏ拷image锟斤拷voice锟斤拷video锟斤拷thumb锟斤拷
	 * @param mediaFileUrl 媒锟斤拷锟侥硷拷锟斤拷url
	 */
	public static WeixinMedia uploadMedia(String accessToken, String type, String mediaFileUrl) {
		WeixinMedia weixinMedia = null;
		// 拼装锟斤拷锟斤拷锟街�
		String uploadMediaUrl = "http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
		uploadMediaUrl = uploadMediaUrl.replace("ACCESS_TOKEN", accessToken).replace("TYPE", type);

		// 锟斤拷锟斤拷锟斤拷锟捷分革拷锟斤拷
		String boundary = "------------7da2e536604c8";
		try {
			URL uploadUrl = new URL(uploadMediaUrl);
			HttpURLConnection uploadConn = (HttpURLConnection) uploadUrl.openConnection();
			uploadConn.setDoOutput(true);
			uploadConn.setDoInput(true);
			uploadConn.setRequestMethod("POST");
			// 锟斤拷锟斤拷锟斤拷锟斤拷头Content-Type
			uploadConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
			// 锟斤拷取媒锟斤拷锟侥硷拷锟较达拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟轿拷欧锟斤拷锟斤拷锟叫达拷锟斤拷荩锟�
			OutputStream outputStream = uploadConn.getOutputStream();

			URL mediaUrl = new URL(mediaFileUrl);
			HttpURLConnection meidaConn = (HttpURLConnection) mediaUrl.openConnection();
			meidaConn.setDoOutput(true);
			meidaConn.setRequestMethod("GET");

			// 锟斤拷锟斤拷锟斤拷头锟叫伙拷取锟斤拷锟斤拷锟斤拷锟斤拷
			String contentType = meidaConn.getHeaderField("Content-Type");
			// 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟叫讹拷锟侥硷拷锟斤拷展锟斤拷
			String fileExt = CommonUtil.getFileExt(contentType);
			// 锟斤拷锟斤拷锟藉开始
			outputStream.write(("--" + boundary + "\r\n").getBytes());
			outputStream.write(String.format("Content-Disposition: form-data; name=\"media\"; filename=\"file1%s\"\r\n", fileExt).getBytes());
			outputStream.write(String.format("Content-Type: %s\r\n\r\n", contentType).getBytes());

			// 锟斤拷取媒锟斤拷锟侥硷拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷取锟侥硷拷锟斤拷
			BufferedInputStream bis = new BufferedInputStream(meidaConn.getInputStream());
			byte[] buf = new byte[8096];
			int size = 0;
			while ((size = bis.read(buf)) != -1) {
				// 锟斤拷媒锟斤拷锟侥硷拷写锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟轿拷欧锟斤拷锟斤拷锟叫达拷锟斤拷荩锟�
				outputStream.write(buf, 0, size);
			}
			// 锟斤拷锟斤拷锟斤拷锟斤拷锟�
			outputStream.write(("\r\n--" + boundary + "--\r\n").getBytes());
			outputStream.close();
			bis.close();
			meidaConn.disconnect();

			// 锟斤拷取媒锟斤拷锟侥硷拷锟较达拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷微锟脚凤拷锟斤拷锟斤拷锟斤拷锟斤拷锟捷ｏ拷
			InputStream inputStream = uploadConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			StringBuffer buffer = new StringBuffer();
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 锟酵凤拷锟斤拷源
			inputStream.close();
			inputStream = null;
			uploadConn.disconnect();

			// 使锟斤拷JSON-lib锟斤拷锟斤拷锟斤拷锟截斤拷锟�
			JSONObject jsonObject = JSONObject.fromObject(buffer.toString());
			weixinMedia = new WeixinMedia();
			weixinMedia.setType(jsonObject.getString("type"));
			// type锟斤拷锟斤拷thumb时锟侥凤拷锟截斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷筒锟揭伙拷锟�
			if ("thumb".equals(type))
				weixinMedia.setMediaId(jsonObject.getString("thumb_media_id"));
			else
				weixinMedia.setMediaId(jsonObject.getString("media_id"));
			weixinMedia.setCreatedAt(jsonObject.getInt("created_at"));
		} catch (Exception e) {
			weixinMedia = null;
			log.error("锟较达拷媒锟斤拷锟侥硷拷失锟杰ｏ拷{}", e);
		}
		return weixinMedia;
	}

	/**
	 * 锟斤拷锟斤拷媒锟斤拷锟侥硷拷
	 * 
	 * @param accessToken 锟接口凤拷锟斤拷凭证
	 * @param mediaId 媒锟斤拷锟侥硷拷锟斤拷识
	 * @param savePath 锟侥硷拷锟节凤拷锟斤拷锟斤拷锟较的存储路锟斤拷
	 * @return
	 */
	public static String getMedia(String accessToken, String mediaId, String savePath) {
		String filePath = null;
		// 拼锟斤拷锟斤拷锟斤拷锟街�
		String requestUrl = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("MEDIA_ID", mediaId);
		System.out.println(requestUrl);
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setRequestMethod("GET");

			if (!savePath.endsWith("/")) {
				savePath += "/";
			}
			// 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟酵伙拷取锟斤拷展锟斤拷
			String fileExt = CommonUtil.getFileExt(conn.getHeaderField("Content-Type"));
			// 锟斤拷mediaId锟斤拷为锟侥硷拷锟斤拷
			filePath = savePath + mediaId + fileExt;

			BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
			FileOutputStream fos = new FileOutputStream(new File(filePath));
			byte[] buf = new byte[8096];
			int size = 0;
			while ((size = bis.read(buf)) != -1)
				fos.write(buf, 0, size);
			fos.close();
			bis.close();

			conn.disconnect();
			log.info("锟斤拷锟斤拷媒锟斤拷锟侥硷拷锟缴癸拷锟斤拷filePath=" + filePath);
		} catch (Exception e) {
			filePath = null;
			log.error("锟斤拷锟斤拷媒锟斤拷锟侥硷拷失锟杰ｏ拷{}", e);
		}
		return filePath;
	}

	public static void main(String args[]) {
		String accessToken = CommonUtil.getToken("wxa2e858736eec406c", "a3861d0bcf8ecc7965f265f6bca72723").getAccessToken();

		
		//String jsonTextMsg = makeTextCustomMessage("oEdzejiHCDqafJbz4WNJtWTMbDcE", "锟斤拷锟斤拷榭�<a href=\"http://blog.csdn.net/lyq8479\">锟斤拷锟斤拷牟锟斤拷锟�</a>");
		
		//sendCustomMessage(accessToken, jsonTextMsg);

		
		//Article article1 = new Article();
		//article1.setTitle("微锟斤拷锟斤拷也锟杰讹拷锟斤拷锟斤拷");
		//article1.setDescription("");
		//article1.setPicUrl("http://www.egouji.com/xiaoq/game/doudizhu_big.png");
		//article1.setUrl("http://resource.duopao.com/duopao/games/small_games/weixingame/Doudizhu/doudizhu.htm");
		//Article article2 = new Article();
		//article2.setTitle("锟斤拷锟斤拷锟斤拷鹰\n80锟襟不得诧拷锟斤拷木锟斤拷锟斤拷锟较�");
		//article2.setDescription("");
		//article2.setPicUrl("http://www.egouji.com/xiaoq/game/aoqixiongying.png");
		//article2.setUrl("http://resource.duopao.com/duopao/games/small_games/weixingame/Plane/aoqixiongying.html");
		//List<Article> list = new ArrayList<Article>();
		//list.add(article1);
		//list.add(article2);
		//String jsonNewsMsg = makeNewsCustomMessage("oEdzejiHCDqafJbz4WNJtWTMbDcE", list);
		//sendCustomMessage(accessToken, jsonNewsMsg);

		
		WeixinQRCode weixinQRCode = createTemporaryQRCode(accessToken, 900, 111111);
		System.out.println(weixinQRCode.getTicket());
		System.out.println(weixinQRCode.getExpireSeconds());

		
		String ticket = "gQEg7zoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL2lIVVJ3VmJsTzFsQ0ZuQ0Y1bG5WAAIEW35+UgMEAAAAAA==";
		String savePath = "C:/download";
		getQRCode(ticket, savePath);

		
		

		/**
		 * 锟斤拷取锟斤拷注锟斤拷锟叫憋拷
		 */
		WeixinUserList weixinUserList = getUserList(accessToken, "");
		System.out.println("关注总数：" + weixinUserList.getTotal());
		System.out.println("关注count:" + weixinUserList.getCount());
		System.out.println("OpenID：" + weixinUserList.getOpenIdList().toString());
		System.out.println("next_openid:" + weixinUserList.getNextOpenId());
         String openId = "";
        List<String> list = weixinUserList.getOpenIdList();
         
		for(int i=0;i<list.size();i++){
			openId =  weixinUserList.getNextOpenId();
			WeixinUserInfo user = getUserInfo(accessToken, list.get(i));
			System.out.println("OpenID:" + user.getOpenId());
			System.out.println("是否关注：" + user.getSubscribe());
			System.out.println("关注时间：" + user.getSubscribeTime());
			System.out.println("昵称：" + user.getNickname());
			System.out.println("性别：" + user.getSex());
			System.out.println("国籍：" + user.getCountry());
			System.out.println("省份：" + user.getProvince());
			System.out.println("城市：" + user.getCity());
			System.out.println("语言：" + user.getLanguage());
			System.out.println("头像：" + user.getHeadImgUrl());
		}
		
		
		
		List<WeixinGroup> groupList = getGroups(accessToken);
		// 循锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟较�
		for (WeixinGroup group : groupList) {
			//System.out.println(String.format("ID锟斤拷%d 锟斤拷锟狡ｏ拷%s 锟矫伙拷锟斤拷锟斤拷%d", group.getId(), group.getName(), group.getCount()));
		}

		/**
		 * 锟斤拷锟斤拷锟斤拷锟斤拷
		 */
		//WeixinGroup group = createGroup(accessToken, "锟斤拷司员锟斤拷");
		//System.out.println(String.format("锟缴癸拷锟斤拷锟斤拷锟斤拷锟介：%s id锟斤拷%d", group.getName(), group.getId()));

		/**
		 * 锟睫改凤拷锟斤拷锟斤拷
		 */
		//updateGroup(accessToken, 100, "同锟斤拷");

		/**
		 * 锟狡讹拷锟矫伙拷锟斤拷锟斤拷
		 */
		//updateMemberGroup(accessToken, "oEdzejiHCDqafJbz4WNJtWTMbDcE", 100);

		/**
		 * 锟较达拷锟斤拷媒锟斤拷锟侥硷拷
		 */
		///WeixinMedia weixinMedia = uploadMedia(accessToken, "voice", "http://localhost:8080/weixinmpapi/test.mp3");
		//System.out.println(weixinMedia.getMediaId());
		//System.out.println(weixinMedia.getType());
		//System.out.println(weixinMedia.getCreatedAt());

		/**
		 * 锟斤拷锟截讹拷媒锟斤拷锟侥硷拷
		 */
		//getMedia(accessToken, "N7xWhOGYSLWUMPzVcGnxKFbhXeD_lLT5sXxyxDGEsCzWIB2CcUijSeQOYjWLMpcn", "G:/download");
	}
}

