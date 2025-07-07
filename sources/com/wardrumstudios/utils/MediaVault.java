package com.wardrumstudios.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes4.dex */
public class MediaVault {
    private String secret;

    public MediaVault(String str) {
        this.secret = str;
    }

    private String getMD5Hash(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return toHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    private String toHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            if ((bArr[i] & 255) < 16) {
                sb.append("0");
            }
            sb.append(Long.toString(bArr[i] & 255, 16));
        }
        return sb.toString();
    }

    public String compute() {
        return compute(null);
    }

    public String compute(MediaVaultRequest mediaVaultRequest) throws IllegalArgumentException {
        String str;
        String str2;
        if (mediaVaultRequest != null) {
            if (mediaVaultRequest.getMediaURL() == null || mediaVaultRequest.getMediaURL().length() == 0) {
                throw new IllegalArgumentException("options.getMediaURL() is required.");
            }
            String str3 = this.secret;
            if (str3 == null || str3.length() == 0) {
                throw new IllegalArgumentException("MediaVault.getSecret() is null.");
            }
            StringBuilder sb = new StringBuilder(mediaVaultRequest.getMediaURL());
            if (mediaVaultRequest != null) {
                str = mediaVaultRequest.getURLParamers();
                str2 = mediaVaultRequest.getHashParameters();
            } else {
                str = "";
                str2 = "";
            }
            if (str.length() > 0) {
                sb.append((sb.indexOf("?") > -1 ? new StringBuilder("&") : new StringBuilder("?")).append(str).toString());
            }
            sb.append((sb.indexOf("?") > -1 ? new StringBuilder("&h=") : new StringBuilder("?h=")).append(getMD5Hash(this.secret + str2 + ((Object) sb))).toString());
            return sb.toString();
        }
        throw new IllegalArgumentException("Invalid 'options' parameter.");
    }

    public String getSecret() {
        return this.secret;
    }

    public void setSecret(String str) {
        this.secret = str;
    }
}
