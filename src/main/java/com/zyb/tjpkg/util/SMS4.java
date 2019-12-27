package com.zyb.tjpkg.util;

import org.apache.commons.codec.binary.Base64;

import java.util.Arrays;

public class SMS4 {

    private static final int ENCRYPT = 1;
    private static final int DECRYPT = 0;
    public static final int ROUND = 32;
    private static final int BLOCK = 16;

//    private byte[] Sbox = { (byte) 0xd6, (byte) 0x90, (byte) 0xe9, (byte) 0xfe,
//            (byte) 0xcc, (byte) 0xe1, 0x3d, (byte) 0xb7, 0x16, (byte) 0xb6,
//            0x14, (byte) 0xc2, 0x28, (byte) 0xfb, 0x2c, 0x05, 0x2b, 0x67,
//            (byte) 0x9a, 0x76, 0x2a, (byte) 0xbe, 0x04, (byte) 0xc3,
//            (byte) 0xaa, 0x44, 0x13, 0x26, 0x49, (byte) 0x86, 0x06,
//            (byte) 0x99, (byte) 0x9c, 0x42, 0x50, (byte) 0xf4, (byte) 0x91,
//            (byte) 0xef, (byte) 0x98, 0x7a, 0x33, 0x54, 0x0b, 0x43,
//            (byte) 0xed, (byte) 0xcf, (byte) 0xac, 0x62, (byte) 0xe4,
//            (byte) 0xb3, 0x1c, (byte) 0xa9, (byte) 0xc9, 0x08, (byte) 0xe8,
//            (byte) 0x95, (byte) 0x80, (byte) 0xdf, (byte) 0x94, (byte) 0xfa,
//            0x75, (byte) 0x8f, 0x3f, (byte) 0xa6, 0x47, 0x07, (byte) 0xa7,
//            (byte) 0xfc, (byte) 0xf3, 0x73, 0x17, (byte) 0xba, (byte) 0x83,
//            0x59, 0x3c, 0x19, (byte) 0xe6, (byte) 0x85, 0x4f, (byte) 0xa8,
//            0x68, 0x6b, (byte) 0x81, (byte) 0xb2, 0x71, 0x64, (byte) 0xda,
//            (byte) 0x8b, (byte) 0xf8, (byte) 0xeb, 0x0f, 0x4b, 0x70, 0x56,
//            (byte) 0x9d, 0x35, 0x1e, 0x24, 0x0e, 0x5e, 0x63, 0x58, (byte) 0xd1,
//            (byte) 0xa2, 0x25, 0x22, 0x7c, 0x3b, 0x01, 0x21, 0x78, (byte) 0x87,
//            (byte) 0xd4, 0x00, 0x46, 0x57, (byte) 0x9f, (byte) 0xd3, 0x27,
//            0x52, 0x4c, 0x36, 0x02, (byte) 0xe7, (byte) 0xa0, (byte) 0xc4,
//            (byte) 0xc8, (byte) 0x9e, (byte) 0xea, (byte) 0xbf, (byte) 0x8a,
//            (byte) 0xd2, 0x40, (byte) 0xc7, 0x38, (byte) 0xb5, (byte) 0xa3,
//            (byte) 0xf7, (byte) 0xf2, (byte) 0xce, (byte) 0xf9, 0x61, 0x15,
//            (byte) 0xa1, (byte) 0xe0, (byte) 0xae, 0x5d, (byte) 0xa4,
//            (byte) 0x9b, 0x34, 0x1a, 0x55, (byte) 0xad, (byte) 0x93, 0x32,
//            0x30, (byte) 0xf5, (byte) 0x8c, (byte) 0xb1, (byte) 0xe3, 0x1d,
//            (byte) 0xf6, (byte) 0xe2, 0x2e, (byte) 0x82, 0x66, (byte) 0xca,
//            0x60, (byte) 0xc0, 0x29, 0x23, (byte) 0xab, 0x0d, 0x53, 0x4e, 0x6f,
//            (byte) 0xd5, (byte) 0xdb, 0x37, 0x45, (byte) 0xde, (byte) 0xfd,
//            (byte) 0x8e, 0x2f, 0x03, (byte) 0xff, 0x6a, 0x72, 0x6d, 0x6c, 0x5b,
//            0x51, (byte) 0x8d, 0x1b, (byte) 0xaf, (byte) 0x92, (byte) 0xbb,
//            (byte) 0xdd, (byte) 0xbc, 0x7f, 0x11, (byte) 0xd9, 0x5c, 0x41,
//            0x1f, 0x10, 0x5a, (byte) 0xd8, 0x0a, (byte) 0xc1, 0x31,
//            (byte) 0x88, (byte) 0xa5, (byte) 0xcd, 0x7b, (byte) 0xbd, 0x2d,
//            0x74, (byte) 0xd0, 0x12, (byte) 0xb8, (byte) 0xe5, (byte) 0xb4,
//            (byte) 0xb0, (byte) 0x89, 0x69, (byte) 0x97, 0x4a, 0x0c,
//            (byte) 0x96, 0x77, 0x7e, 0x65, (byte) 0xb9, (byte) 0xf1, 0x09,
//            (byte) 0xc5, 0x6e, (byte) 0xc6, (byte) 0x84, 0x18, (byte) 0xf0,
//            0x7d, (byte) 0xec, 0x3a, (byte) 0xdc, 0x4d, 0x20, 0x79,
//            (byte) 0xee, 0x5f, 0x3e, (byte) 0xd7, (byte) 0xcb, 0x39, 0x48 };

    private byte[] Sbox = {(byte) 0x63, (byte) 0x7C, (byte) 0x77, (byte) 0x7B,
            (byte) 0xF2, (byte) 0x6B, (byte) 0x6F, (byte) 0xC5,
            (byte) 0x30, (byte) 0x01, (byte) 0x67, (byte) 0x2B,
            (byte) 0xFE, (byte) 0xD7, (byte) 0xAB, (byte) 0x76,
            (byte) 0xCA, (byte) 0x82, (byte) 0xC9, (byte) 0x7D,
            (byte) 0xFA, (byte) 0x59, (byte) 0x47, (byte) 0xF0,
            (byte) 0xAD, (byte) 0xD4, (byte) 0xA2, (byte) 0xAF,
            (byte) 0x9C, (byte) 0xA4, (byte) 0x72, (byte) 0xC0,
            (byte) 0xB7, (byte) 0xFD, (byte) 0x93, (byte) 0x26,
            (byte) 0x36, (byte) 0x3F, (byte) 0xF7, (byte) 0xCC,
            (byte) 0x34, (byte) 0xA5, (byte) 0xE5, (byte) 0xF1,
            (byte) 0x71, (byte) 0xD8, (byte) 0x31, (byte) 0x15,
            (byte) 0x04, (byte) 0xC7, (byte) 0x23, (byte) 0xC3,
            (byte) 0x18, (byte) 0x96, (byte) 0x05, (byte) 0x9A,
            (byte) 0x07, (byte) 0x12, (byte) 0x80, (byte) 0xE2,
            (byte) 0xEB, (byte) 0x27, (byte) 0xB2, (byte) 0x75,
            (byte) 0x09, (byte) 0x83, (byte) 0x2C, (byte) 0x1A,
            (byte) 0x1B, (byte) 0x6E, (byte) 0x5A, (byte) 0xA0,
            (byte) 0x52, (byte) 0x3B, (byte) 0xD6, (byte) 0xB3,
            (byte) 0x29, (byte) 0xE3, (byte) 0x2F, (byte) 0x84,
            (byte) 0x53, (byte) 0xD1, (byte) 0x00, (byte) 0xED,
            (byte) 0x20, (byte) 0xFC, (byte) 0xB1, (byte) 0x5B,
            (byte) 0x6A, (byte) 0xCB, (byte) 0xBE, (byte) 0x39,
            (byte) 0x4A, (byte) 0x4C, (byte) 0x58, (byte) 0xCF,
            (byte) 0xD0, (byte) 0xEF, (byte) 0xAA, (byte) 0xFB,
            (byte) 0x43, (byte) 0x4D, (byte) 0x33, (byte) 0x85,
            (byte) 0x45, (byte) 0xF9, (byte) 0x02, (byte) 0x7F,
            (byte) 0x50, (byte) 0x3C, (byte) 0x9F, (byte) 0xA8,
            (byte) 0x51, (byte) 0xA3, (byte) 0x40, (byte) 0x8F,
            (byte) 0x92, (byte) 0x9D, (byte) 0x38, (byte) 0xF5,
            (byte) 0xBC, (byte) 0xB6, (byte) 0xDA, (byte) 0x21,
            (byte) 0x10, (byte) 0xFF, (byte) 0xF3, (byte) 0xD2,
            (byte) 0xCD, (byte) 0x0C, (byte) 0x13, (byte) 0xEC,
            (byte) 0x5F, (byte) 0x97, (byte) 0x44, (byte) 0x17,
            (byte) 0xC4, (byte) 0xA7, (byte) 0x7E, (byte) 0x3D,
            (byte) 0x64, (byte) 0x5D, (byte) 0x19, (byte) 0x73,
            (byte) 0x60, (byte) 0x81, (byte) 0x4F, (byte) 0xDC,
            (byte) 0x22, (byte) 0x2A, (byte) 0x90, (byte) 0x88,
            (byte) 0x46, (byte) 0xEE, (byte) 0xB8, (byte) 0x14,
            (byte) 0xDE, (byte) 0x5E, (byte) 0x0B, (byte) 0xDB,
            (byte) 0xE0, (byte) 0x32, (byte) 0x3A, (byte) 0x0A,
            (byte) 0x49, (byte) 0x06, (byte) 0x24, (byte) 0x5C,
            (byte) 0xC2, (byte) 0xD3, (byte) 0xAC, (byte) 0x62,
            (byte) 0x91, (byte) 0x95, (byte) 0xE4, (byte) 0x79,
            (byte) 0xE7, (byte) 0xC8, (byte) 0x37, (byte) 0x6D,
            (byte) 0x8D, (byte) 0xD5, (byte) 0x4E, (byte) 0xA9,
            (byte) 0x6C, (byte) 0x56, (byte) 0xF4, (byte) 0xEA,
            (byte) 0x65, (byte) 0x7A, (byte) 0xAE, (byte) 0x08,
            (byte) 0xBA, (byte) 0x78, (byte) 0x25, (byte) 0x2E,
            (byte) 0x1C, (byte) 0xA6, (byte) 0xB4, (byte) 0xC6,
            (byte) 0xE8, (byte) 0xDD, (byte) 0x74, (byte) 0x1F,
            (byte) 0x4B, (byte) 0xBD, (byte) 0x8B, (byte) 0x8A,
            (byte) 0x70, (byte) 0x3E, (byte) 0xB5, (byte) 0x66,
            (byte) 0x48, (byte) 0x03, (byte) 0xF6, (byte) 0x0E,
            (byte) 0x61, (byte) 0x35, (byte) 0x57, (byte) 0xB9,
            (byte) 0x86, (byte) 0xC1, (byte) 0x1D, (byte) 0x9E,
            (byte) 0xE1, (byte) 0xF8, (byte) 0x98, (byte) 0x11,
            (byte) 0x69, (byte) 0xD9, (byte) 0x8E, (byte) 0x94,
            (byte) 0x9B, (byte) 0x1E, (byte) 0x87, (byte) 0xE9,
            (byte) 0xCE, (byte) 0x55, (byte) 0x28, (byte) 0xDF,
            (byte) 0x8C, (byte) 0xA1, (byte) 0x89, (byte) 0x0D,
            (byte) 0xBF, (byte) 0xE6, (byte) 0x42, (byte) 0x68,
            (byte) 0x41, (byte) 0x99, (byte) 0x2D, (byte) 0x0F,
            (byte) 0xB0, (byte) 0x54, (byte) 0xBB, (byte) 0x16};

    private int[] CK = {0x00070e15, 0x1c232a31, 0x383f464d, 0x545b6269,
            0x70777e85, 0x8c939aa1, 0xa8afb6bd, 0xc4cbd2d9, 0xe0e7eef5,
            0xfc030a11, 0x181f262d, 0x343b4249, 0x50575e65, 0x6c737a81,
            0x888f969d, 0xa4abb2b9, 0xc0c7ced5, 0xdce3eaf1, 0xf8ff060d,
            0x141b2229, 0x30373e45, 0x4c535a61, 0x686f767d, 0x848b9299,
            0xa0a7aeb5, 0xbcc3cad1, 0xd8dfe6ed, 0xf4fb0209, 0x10171e25,
            0x2c333a41, 0x484f565d, 0x646b7279};

    private byte[] fillDataArray = {0, 1, 2, 3, 4, 5, 6, 7, 8};

    private int Rotl(int x, int y) {
        return x << y | x >>> (32 - y);
    }

    private int ByteSub(int A) {
        return (Sbox[A >>> 24 & 0xFF] & 0xFF) << 24
                | (Sbox[A >>> 16 & 0xFF] & 0xFF) << 16
                | (Sbox[A >>> 8 & 0xFF] & 0xFF) << 8 | (Sbox[A & 0xFF] & 0xFF);
    }

    private int L1(int B) {
        return B ^ Rotl(B, 2) ^ Rotl(B, 10) ^ Rotl(B, 18) ^ Rotl(B, 24);
        // return B^(B<<2|B>>>30)^(B<<10|B>>>22)^(B<<18|B>>>14)^(B<<24|B>>>8);
    }

    private int L2(int B) {
        return B ^ Rotl(B, 13) ^ Rotl(B, 23);
        // return B^(B<<13|B>>>19)^(B<<23|B>>>9);
    }

    void SMS4Crypt(byte[] Input, byte[] Output, int[] rk) {
        int r, mid, x0, x1, x2, x3;
        int[] x = new int[4];
        int[] tmp = new int[4];
        for (int i = 0; i < 4; i++) {
            tmp[0] = Input[0 + 4 * i] & 0xff;
            tmp[1] = Input[1 + 4 * i] & 0xff;
            tmp[2] = Input[2 + 4 * i] & 0xff;
            tmp[3] = Input[3 + 4 * i] & 0xff;
            x[i] = tmp[0] << 24 | tmp[1] << 16 | tmp[2] << 8 | tmp[3];
            // x[i]=(Input[0+4*i]<<24|Input[1+4*i]<<16|Input[2+4*i]<<8|Input[3+4*i]);
        }
        for (r = 0; r < 32; r += 4) {
            mid = x[1] ^ x[2] ^ x[3] ^ rk[r + 0];
            mid = ByteSub(mid);
            x[0] = x[0] ^ L1(mid); // x4

            mid = x[2] ^ x[3] ^ x[0] ^ rk[r + 1];
            mid = ByteSub(mid);
            x[1] = x[1] ^ L1(mid); // x5

            mid = x[3] ^ x[0] ^ x[1] ^ rk[r + 2];
            mid = ByteSub(mid);
            x[2] = x[2] ^ L1(mid); // x6

            mid = x[0] ^ x[1] ^ x[2] ^ rk[r + 3];
            mid = ByteSub(mid);
            x[3] = x[3] ^ L1(mid); // x7
        }

        // Reverse
        for (int j = 0; j < 16; j += 4) {
            Output[j] = (byte) (x[3 - j / 4] >>> 24 & 0xFF);
            Output[j + 1] = (byte) (x[3 - j / 4] >>> 16 & 0xFF);
            Output[j + 2] = (byte) (x[3 - j / 4] >>> 8 & 0xFF);
            Output[j + 3] = (byte) (x[3 - j / 4] & 0xFF);
        }
    }

    private void SMS4KeyExt(byte[] Key, int[] rk, int CryptFlag) {
        int r, mid;
        int[] x = new int[4];
        int[] tmp = new int[4];
        for (int i = 0; i < 4; i++) {
            tmp[0] = Key[0 + 4 * i] & 0xFF;
            tmp[1] = Key[1 + 4 * i] & 0xff;
            tmp[2] = Key[2 + 4 * i] & 0xff;
            tmp[3] = Key[3 + 4 * i] & 0xff;
            x[i] = tmp[0] << 24 | tmp[1] << 16 | tmp[2] << 8 | tmp[3];
            // x[i]=Key[0+4*i]<<24|Key[1+4*i]<<16|Key[2+4*i]<<8|Key[3+4*i];
        }
        x[0] ^= 0xa3b1bac6;
        x[1] ^= 0x56aa3350;
        x[2] ^= 0x677d9197;
        x[3] ^= 0xb27022dc;
        for (r = 0; r < 32; r += 4) {
            mid = x[1] ^ x[2] ^ x[3] ^ CK[r + 0];
            mid = ByteSub(mid);
            rk[r + 0] = x[0] ^= L2(mid); // rk0=K4

            mid = x[2] ^ x[3] ^ x[0] ^ CK[r + 1];
            mid = ByteSub(mid);
            rk[r + 1] = x[1] ^= L2(mid); // rk1=K5

            mid = x[3] ^ x[0] ^ x[1] ^ CK[r + 2];
            mid = ByteSub(mid);
            rk[r + 2] = x[2] ^= L2(mid); // rk2=K6

            mid = x[0] ^ x[1] ^ x[2] ^ CK[r + 3];
            mid = ByteSub(mid);
            rk[r + 3] = x[3] ^= L2(mid); // rk3=K7
        }

        // 解密时轮密钥使用顺序：rk31,rk30,...,rk0
        if (CryptFlag == DECRYPT) {
            for (r = 0; r < 16; r++) {
                mid = rk[r];
                rk[r] = rk[31 - r];
                rk[31 - r] = mid;
            }
        }
    }

    public int sms4(byte[] in, int inLen, byte[] key, byte[] out, int CryptFlag) {
        int point = 0;
        int[] round_key = new int[ROUND];
        // int[] round_key={0};
        SMS4KeyExt(key, round_key, CryptFlag);
        byte[] input = new byte[16];
        byte[] output = new byte[16];

        while (inLen >= BLOCK) {
            input = Arrays.copyOfRange(in, point, point + 16);
            // output=Arrays.copyOfRange(out, point, point+16);
            SMS4Crypt(input, output, round_key);
            System.arraycopy(output, 0, out, point, BLOCK);
            inLen -= BLOCK;
            point += BLOCK;
        }

        return 0;
    }

    public static byte[] encodeSMS4(String plaintext, byte[] key) throws Exception {
        if (plaintext == null || plaintext.equals("")) {
            return null;
        }

        //获取原始数据的byte，如果不是16的整数倍，需要进行补位，补位规则，缺几个，补几个几，例如缺3个，补3个3
        byte[] original = plaintext.getBytes("UTF-8");
        int originalLength = original.length;

        //计算需要补位的位数及数字
        int i = originalLength % 16;
        int fillDataLength = 16 - i;

        //补位之后的数组的长度
        int tempByteLength = originalLength + fillDataLength;

        //把原始数据拷贝到补位之后的数组中
        byte[] temp = Arrays.copyOf(original, tempByteLength);

        //获取到补位的数字
        byte fillData = (byte) (16 - i);

        //设置后面需要补位的值
        for (i = originalLength; i < tempByteLength; i++) {
            temp[i] = fillData;
        }

        return SMS4.encodeSMS4(temp, key);
    }

    /**
     * 不限明文长度的SMS4加密
     *
     * @param plaintext
     * @param key
     * @return
     */
    public static byte[] encodeSMS4(byte[] plaintext, byte[] key) {
        byte[] ciphertext = new byte[plaintext.length];

        int k = 0;
        int plainLen = plaintext.length;
        while (k + 16 <= plainLen) {
            byte[] cellPlain = new byte[16];
            for (int i = 0; i < 16; i++) {
                cellPlain[i] = plaintext[k + i];
            }
            byte[] cellCipher = encode16(cellPlain, key);
            for (int i = 0; i < cellCipher.length; i++) {
                ciphertext[k + i] = cellCipher[i];
            }

            k += 16;
        }

        return ciphertext;
    }

    /**
     * 不限明文长度的SMS4解密
     *
     * @param ciphertext
     * @param key
     * @return
     */
    public static byte[] decodeSMS4(byte[] ciphertext, byte[] key) {
        byte[] plaintext = new byte[ciphertext.length];

        int k = 0;
        int cipherLen = ciphertext.length;
        while (k + 16 <= cipherLen) {
            byte[] cellCipher = new byte[16];
            for (int i = 0; i < 16; i++) {
                cellCipher[i] = ciphertext[k + i];
            }
            byte[] cellPlain = decode16(cellCipher, key);
            for (int i = 0; i < cellPlain.length; i++) {
                plaintext[k + i] = cellPlain[i];
            }

            k += 16;
        }

        byte[] result = Arrays.copyOf(plaintext, plaintext.length - plaintext[plaintext.length - 1]);

        return result;
    }


    /**
     * 只加密16位明文
     *
     * @param plaintext
     * @param key
     * @return
     */
    private static byte[] encode16(byte[] plaintext, byte[] key) {
        byte[] cipher = new byte[16];
        SMS4 sm4 = new SMS4();
        sm4.sms4(plaintext, 16, key, cipher, ENCRYPT);

        return cipher;
    }

    /**
     * 只解密16位密文
     *
     * @param ciphertext
     * @param key
     * @return
     */
    private static byte[] decode16(byte[] ciphertext, byte[] key) {
        byte[] plain = new byte[16];
        SMS4 sm4 = new SMS4();
        sm4.sms4(ciphertext, 16, key, plain, DECRYPT);

        return plain;
    }

    /**
     * sm4加密
     *
     * @param taxCode 税号
     * @param data    待加密的数据
     * @return
     */
    public static String encodeSMS4toString(String taxCode, String data) {

        try {

            byte[] key = getKey(taxCode);

            if (null == key) {
                return null;
            }

            //对数据进行加密
            byte[] enOut = SMS4.encodeSMS4(data, key);

            //把加密之后的结果转换为base64串
            return Base64.encodeBase64String(enOut);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * sm4解密方法
     *
     * @param taxCode 税号
     * @param data    待解密的base64编码的字符串
     * @return 解密之后的字符串
     */
    public static String decodeSMS4toString(String taxCode, String data) {

        try {

            if (null == data) {
                return null;
            }

            byte[] key = getKey(taxCode);

            if (null == key) {
                return null;
            }

            //对数据进行解密，首先base64解码，然后解密
            byte[] plaintext = decodeSMS4(Base64.decodeBase64(data), key);
            /*StringBuilder str = new StringBuilder();
            System.out.println("---------------------------------");
            for (int a = 0; a < plaintext.length; a++) {
                str.append(plaintext[a]).append(",");
            }
            System.out.println(str)*/;
            //获取utf-8编码格式的数据
            String deOutStr = new String(plaintext, "UTF-8");

            //返回解密之后结果的串
            return deOutStr;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static byte[] getKey(String taxCode) {
        if (null == taxCode || taxCode.length() < 15) {
            return null;
        }
        try {

            //sm4加密需要的key是16位，之前的老税号可能是15位
            byte[] tempKey = taxCode.getBytes("UTF-8");
            byte fillData = 0;
            if (tempKey.length < 16) {
                byte[] key = Arrays.copyOf(tempKey, 16);
                for (int i = tempKey.length; i < 16; i++) {
                    key[i] = fillData;
                }

                return key;
            } else {
                byte[] key = Arrays.copyOf(tempKey, 16);
                return key;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) throws Exception {
        // 密钥
        String sh = "91110108MA001K7YXU";
        byte[] key = getKey(sh);
        StringBuilder str = new StringBuilder();
        for (int a = 0; a < key.length; a++) {
            str.append(key[a]).append(",");
        }
        System.out.println(str);
        String encParamData = "4g1tsk58dzUYDaB2gXPZ0inoigYGA34gsNKcnFSjfKdrq02DM+3RNy5BAyyXWhlgrxqiRJElHjMHE2GGazN9B7nQsHO3aPT3DqwPktXwFW+8UISZlRsWb5pQdSDP3mOmqIlTs/Mq5qQ/1GflLK0hxW9rI6UHHyxC1G3EqFAL1JPsTMMWkxB0jFbRI/8xDBBRvEs6dGCB0PGr1jCqlP1Swr8VVKiAHwRgNazADhPEM+H3CNq+mqpM0eQ+xHQq5PLMfNAhUxPVf5tTrMoBYqiNEGSIDrjD+RrjQHdde4gmJDEQDyMVJqhnVrDSk0Lb9PlR";

        String deOutStr = SMS4.decodeSMS4toString(sh, encParamData);
        System.out.println(deOutStr);
//        byte[] bt= FileUtil.read("E:\\TEST\\test-files\\result1");
//        String baseStr = new String(bt);
//        System.out.println("end");


    }
}
