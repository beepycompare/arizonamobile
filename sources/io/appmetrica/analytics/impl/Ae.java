package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
/* loaded from: classes5.dex */
public final class Ae implements Vo {

    /* renamed from: a  reason: collision with root package name */
    public final String f458a;

    public Ae(String str) {
        this.f458a = str;
    }

    @Override // io.appmetrica.analytics.impl.Vo
    public final To a(String str) {
        if (StringUtils.isNullOrEmpty(str)) {
            return new To(this, false, this.f458a + " is empty.");
        }
        return new To(this, true, "");
    }
}
