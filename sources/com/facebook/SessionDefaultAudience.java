package com.facebook;

import com.facebook.internal.NativeProtocol;
/* loaded from: classes3.dex */
public enum SessionDefaultAudience {
    NONE(null),
    ONLY_ME(NativeProtocol.AUDIENCE_ME),
    FRIENDS(NativeProtocol.AUDIENCE_FRIENDS),
    EVERYONE(NativeProtocol.AUDIENCE_EVERYONE);
    
    private final String nativeProtocolAudience;

    SessionDefaultAudience(String str) {
        this.nativeProtocolAudience = str;
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static SessionDefaultAudience[] valuesCustom() {
        SessionDefaultAudience[] valuesCustom = values();
        int length = valuesCustom.length;
        SessionDefaultAudience[] sessionDefaultAudienceArr = new SessionDefaultAudience[length];
        System.arraycopy(valuesCustom, 0, sessionDefaultAudienceArr, 0, length);
        return sessionDefaultAudienceArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getNativeProtocolAudience() {
        return this.nativeProtocolAudience;
    }
}
