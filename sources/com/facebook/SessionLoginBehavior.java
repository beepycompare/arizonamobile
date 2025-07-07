package com.facebook;
/* loaded from: classes3.dex */
public enum SessionLoginBehavior {
    SSO_WITH_FALLBACK(true, true),
    SSO_ONLY(true, false),
    SUPPRESS_SSO(false, true);
    
    private final boolean allowsKatanaAuth;
    private final boolean allowsWebViewAuth;

    SessionLoginBehavior(boolean z, boolean z2) {
        this.allowsKatanaAuth = z;
        this.allowsWebViewAuth = z2;
    }

    /* renamed from: values  reason: to resolve conflict with enum method */
    public static SessionLoginBehavior[] valuesCustom() {
        SessionLoginBehavior[] valuesCustom = values();
        int length = valuesCustom.length;
        SessionLoginBehavior[] sessionLoginBehaviorArr = new SessionLoginBehavior[length];
        System.arraycopy(valuesCustom, 0, sessionLoginBehaviorArr, 0, length);
        return sessionLoginBehaviorArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean allowsKatanaAuth() {
        return this.allowsKatanaAuth;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean allowsWebViewAuth() {
        return this.allowsWebViewAuth;
    }
}
