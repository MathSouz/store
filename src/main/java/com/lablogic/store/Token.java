package com.lablogic.store;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class Token
{
    private static Algorithm algorithm;

    public static void init(String secret)
    {
        algorithm = Algorithm.HMAC256(secret);
    }

    public static Algorithm getAlgorithm() {
        return algorithm;
    }

    public static String createToken(long userId)
    {
        return JWT.create().withIssuer(String.valueOf(userId)).sign(algorithm);
    }

    public static boolean verifyToken(String token)
    {
        try {
            JWT.require(algorithm).acceptExpiresAt(86400).withIssuer("auth0").build().verify(token);
            return true;
        }
        catch(Exception e) {
            return false;
        }

    }

    public static boolean verifyTokenAsHeader(String token)
    {
        return verifyToken(token.split("\\s+")[1]);
    }
}
