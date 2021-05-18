package com.quibbler.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.map.MapUtil;
import com.google.code.kaptcha.Producer;
import com.quibbler.global.Constans;
import com.quibbler.utils.RedisUtil;
import com.quibbler.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author paksu
 */
@RestController
public class AuthController {

    @Autowired
    Producer producer;

    @Autowired
    RedisUtil redisUtil;

    @GetMapping("/captcha")
    public Result captcha() throws IOException {
        // the key set in the redis to get code
        String key = UUID.randomUUID().toString();
        // captcha code save in redis
        String code = producer.createText();

        BufferedImage image = producer.createImage(code);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);

        BASE64Encoder encoder = new BASE64Encoder();
        String pre = "data:image/jpeg;base64";

        String base64Image = pre + encoder.encode(outputStream.toByteArray());

        //put the captcha in redis with the key
        redisUtil.hPut(Constans.CAPTCHA_KEY, key, code);
        redisUtil.expire(Constans.CAPTCHA_KEY, 120, TimeUnit.SECONDS);

        return Result.successWithData(MapUtil.builder()
                .put("key", key)
                .put("base64Image", base64Image)
                .build());
    }
}
