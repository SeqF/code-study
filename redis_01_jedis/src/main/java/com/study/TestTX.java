package com.study;

import com.fasterxml.jackson.databind.util.JSONPObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTX {

    public static void main(String[] args) {
        Jedis jedis =new Jedis("120.79.33.152",6379);
        jedis.auth("Gundam00");
        System.out.println(jedis.ping());

        Transaction multi=jedis.multi();


        jedis.close();
    }
}
