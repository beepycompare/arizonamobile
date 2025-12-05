package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.rb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0545rb implements to {
    @Override // io.appmetrica.analytics.impl.to
    public final ro a(String str) {
        if (str == null) {
            return new ro(this, false, "key is null");
        }
        if (str.startsWith(H7.b)) {
            return new ro(this, false, "key starts with appmetrica");
        }
        if (str.length() > 200) {
            return new ro(this, false, "key length more then 200 characters");
        }
        return new ro(this, true, "");
    }
}
