package com.lichking.leetcode.solution;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * team : CORE HR
 * Description:
 *
 * @author: wangrubo
 * @date: 2018/8/28
 * @time: 15:05
 * Copyright (C) 2018 Meituan
 * All rights reserved
 * on Date : 2018/8/28  Time : 15:05
 */
public class TinyUrl {

    /**
     * TinyURL是一种URL简化服务，
     * 比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl 时，
     * 它将返回一个简化的URL http://tinyurl.com/
     *
     * 要求：设计一个 TinyURL 的加密 encode 和解密 decode 的方法。
     * 你的加密和解密算法如何设计和运作是没有限制的，你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。
     */

    public class Codec {

        private Map<Integer,String> map = new HashMap<>();

        private String host = "http://tinyurl.com/";

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            int key = longUrl.hashCode();
            map.put(key,longUrl);
            return host + key;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            int key = Integer.parseInt(shortUrl.replace(host,""));
            return map.get(key);
        }

    }

}
