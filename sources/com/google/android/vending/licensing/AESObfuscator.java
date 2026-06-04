package com.google.android.vending.licensing;

import com.google.android.vending.licensing.util.Base64;
import com.google.android.vending.licensing.util.Base64DecoderException;
import com.google.common.base.Ascii;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes4.dex */
public class AESObfuscator implements Obfuscator {
    private static final String CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final byte[] IV = {Ascii.DLE, 74, 71, -80, 32, 101, -47, 72, 117, -14, 0, -29, 70, 65, -12, 74};
    private static final String KEYGEN_ALGORITHM = "PBEWITHSHAAND256BITAES-CBC-BC";
    private static final String UTF8 = "UTF-8";
    private static final String header = "com.android.vending.licensing.AESObfuscator-1|";
    private Cipher mDecryptor;
    private Cipher mEncryptor;

    public AESObfuscator(byte[] bArr, String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance(KEYGEN_ALGORITHM).generateSecret(new PBEKeySpec((str + str2).toCharArray(), bArr, 1024, 256)).getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.mEncryptor = cipher;
            byte[] bArr2 = IV;
            cipher.init(1, secretKeySpec, new IvParameterSpec(bArr2));
            Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.mDecryptor = cipher2;
            cipher2.init(2, secretKeySpec, new IvParameterSpec(bArr2));
        } catch (GeneralSecurityException e) {
            throw new RuntimeException("Invalid environment", e);
        }
    }

    @Override // com.google.android.vending.licensing.Obfuscator
    public String obfuscate(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return Base64.encode(this.mEncryptor.doFinal((header + str2 + str).getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Invalid environment", e);
        } catch (GeneralSecurityException e2) {
            throw new RuntimeException("Invalid environment", e2);
        }
    }

    @Override // com.google.android.vending.licensing.Obfuscator
    public String unobfuscate(String str, String str2) throws ValidationException {
        if (str == null) {
            return null;
        }
        try {
            String str3 = new String(this.mDecryptor.doFinal(Base64.decode(str)), "UTF-8");
            if (str3.indexOf(header + str2) == 0) {
                return str3.substring(header.length() + str2.length(), str3.length());
            }
            throw new ValidationException("Header not found (invalid data or key):" + str);
        } catch (Base64DecoderException e) {
            throw new ValidationException(e.getMessage() + StringUtils.PROCESS_POSTFIX_DELIMITER + str);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Invalid environment", e2);
        } catch (BadPaddingException e3) {
            throw new ValidationException(e3.getMessage() + StringUtils.PROCESS_POSTFIX_DELIMITER + str);
        } catch (IllegalBlockSizeException e4) {
            throw new ValidationException(e4.getMessage() + StringUtils.PROCESS_POSTFIX_DELIMITER + str);
        }
    }
}
