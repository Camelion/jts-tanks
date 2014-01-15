package ru.jts.server.tests.crypt;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Before;
import org.junit.Test;
import ru.jts.common.util.ArrayUtils;
import ru.jts.server.network.crypt.CryptEngine;

import java.security.Security;

/**
 * @author: Camelion
 * @date: 12.11.13/19:56
 */
public class CryptEngineTest {
    private byte[] in = new byte[]{
            (byte) 0x2c, (byte) 0xb2, (byte) 0x6c, (byte) 0x0d, (byte) 0x7e, (byte) 0x5e, (byte) 0x6a, (byte) 0x2f, (byte) 0x0a, (byte) 0x0c, (byte) 0x8e, (byte) 0xc4, (byte) 0xb5, (byte) 0xcc, (byte) 0x29, (byte) 0x9d, (byte) 0x09, (byte) 0x6a, (byte) 0x84, (byte) 0xd3, (byte) 0xaa, (byte) 0xfa, (byte) 0x89, (byte) 0x80, (byte) 0x36, (byte) 0x84, (byte) 0x83, (byte) 0xd0, (byte) 0x6e, (byte) 0xcf, (byte) 0xbf, (byte) 0x28, (byte) 0x74, (byte) 0xf0, (byte) 0xda, (byte) 0xd1, (byte) 0x8e, (byte) 0x66, (byte) 0x2b, (byte) 0x7f, (byte) 0xfe, (byte) 0x72, (byte) 0x20, (byte) 0x8f, (byte) 0x6f, (byte) 0x6a, (byte) 0x65, (byte) 0x20, (byte) 0xe2, (byte) 0x0c, (byte) 0xf8, (byte) 0x8a, (byte) 0xe4, (byte) 0x1a, (byte) 0x47, (byte) 0x10, (byte) 0x02, (byte) 0x80, (byte) 0x8c, (byte) 0xd5, (byte) 0x96, (byte) 0xf0, (byte) 0x35, (byte) 0x2d, (byte) 0x10, (byte) 0xed, (byte) 0xec, (byte) 0x8f, (byte) 0x3e, (byte) 0x6e, (byte) 0x75, (byte) 0x47, (byte) 0xaf, (byte) 0xd3, (byte) 0x6c, (byte) 0x23, (byte) 0xcd, (byte) 0x8a, (byte) 0x32, (byte) 0x4e, (byte) 0x10, (byte) 0xb4, (byte) 0xa7, (byte) 0xd2, (byte) 0x15, (byte) 0x40, (byte) 0xa8, (byte) 0x05, (byte) 0xb4, (byte) 0x46, (byte) 0xe6, (byte) 0xf8, (byte) 0x48, (byte) 0x29, (byte) 0x70, (byte) 0x52, (byte) 0x77, (byte) 0x44, (byte) 0x9f, (byte) 0xc6, (byte) 0x1e, (byte) 0x50, (byte) 0x71, (byte) 0x4e, (byte) 0x7e, (byte) 0x19, (byte) 0xaf, (byte) 0x70, (byte) 0x9e, (byte) 0xfa, (byte) 0xe5, (byte) 0x2a, (byte) 0xdc, (byte) 0xa5, (byte) 0xfd, (byte) 0xde, (byte) 0xef, (byte) 0x28, (byte) 0x24, (byte) 0xf8
    };
    private byte[] out = {
            (byte) 0x58, (byte) 0x04, (byte) 0x0E, (byte) 0xFE, (byte) 0x92, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x07, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0xF5, (byte) 0x5C, (byte) 0xCD, (byte) 0x22, (byte) 0xCF, (byte) 0xA6, (byte) 0x5C, (byte) 0xEF, (byte) 0xBE, (byte) 0xAD, (byte) 0xDE, (byte) 0x08
    };

    private byte[] key = new byte[]{
            (byte) 0xF3, (byte) 0x9D, (byte) 0x62, (byte) 0x8C, (byte) 0x83, (byte) 0x3A, (byte) 0xC7, (byte) 0xD1, (byte) 0xBE, (byte) 0x2E, (byte) 0xC9, (byte) 0xEA, (byte) 0x3A, (byte) 0x8B, (byte) 0xD9, (byte) 0x41
    };

    @Before
    public void before() {
        Security.addProvider(new BouncyCastleProvider());
    }

    @Test
    public void testXorBlowFish() {
        byte[] result = CryptEngine.getInstance().decrypt(in, key);

        System.out.println(new String(result));
        System.out.println(ArrayUtils.bytesToHexString(result));
    }
}