package com.google.android.datatransport.cct;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedDestination;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public final class CCTDestination implements EncodedDestination {
    private static final String DEFAULT_API_KEY;
    static final String DEFAULT_END_POINT;
    static final String DESTINATION_NAME = "cct";
    private static final String EXTRAS_DELIMITER = "\\";
    private static final String EXTRAS_VERSION_MARKER = "1$";
    public static final CCTDestination INSTANCE;
    static final String LEGACY_END_POINT;
    public static final CCTDestination LEGACY_INSTANCE;
    private static final Set<Encoding> SUPPORTED_ENCODINGS;
    private final String apiKey;
    private final String endPoint;

    static {
        String mergeStrings = StringMerger.mergeStrings("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        DEFAULT_END_POINT = mergeStrings;
        String mergeStrings2 = StringMerger.mergeStrings("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        LEGACY_END_POINT = mergeStrings2;
        String mergeStrings3 = StringMerger.mergeStrings("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        DEFAULT_API_KEY = mergeStrings3;
        SUPPORTED_ENCODINGS = Collections.unmodifiableSet(new HashSet(Arrays.asList(Encoding.of("proto"), Encoding.of("json"))));
        INSTANCE = new CCTDestination(mergeStrings, null);
        LEGACY_INSTANCE = new CCTDestination(mergeStrings2, mergeStrings3);
    }

    public CCTDestination(String str, String str2) {
        this.endPoint = str;
        this.apiKey = str2;
    }

    @Override // com.google.android.datatransport.runtime.Destination
    public String getName() {
        return DESTINATION_NAME;
    }

    @Override // com.google.android.datatransport.runtime.Destination
    public byte[] getExtras() {
        return asByteArray();
    }

    @Override // com.google.android.datatransport.runtime.EncodedDestination
    public Set<Encoding> getSupportedEncodings() {
        return SUPPORTED_ENCODINGS;
    }

    public String getAPIKey() {
        return this.apiKey;
    }

    public String getEndPoint() {
        return this.endPoint;
    }

    public byte[] asByteArray() {
        String str = this.apiKey;
        if (str == null && this.endPoint == null) {
            return null;
        }
        String str2 = this.endPoint;
        if (str == null) {
            str = "";
        }
        return String.format("%s%s%s%s", EXTRAS_VERSION_MARKER, str2, EXTRAS_DELIMITER, str).getBytes(Charset.forName("UTF-8"));
    }

    public static CCTDestination fromByteArray(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith(EXTRAS_VERSION_MARKER)) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] split = str.substring(EXTRAS_VERSION_MARKER.length()).split(Pattern.quote(EXTRAS_DELIMITER), 2);
        if (split.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = split[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = split[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new CCTDestination(str2, str3);
    }

    static byte[] encodeString(String str) {
        return str.getBytes(Charset.forName("UTF-8"));
    }

    static String decodeExtras(byte[] bArr) {
        return new String(bArr, Charset.forName("UTF-8"));
    }
}
