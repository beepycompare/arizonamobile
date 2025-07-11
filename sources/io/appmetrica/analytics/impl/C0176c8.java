package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.c8  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0176c8 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f782a;
    public DeferredDeeplinkListener b;
    public DeferredDeeplinkParametersListener c;
    public C0124a8 d;

    public C0176c8(boolean z) {
        this.f782a = z;
    }

    public final void a(int i) {
        DeferredDeeplinkParametersListener.Error error;
        DeferredDeeplinkListener.Error error2;
        C0124a8 c0124a8 = this.d;
        String str = c0124a8 == null ? null : c0124a8.c;
        DeferredDeeplinkListener deferredDeeplinkListener = this.b;
        if (deferredDeeplinkListener != null) {
            if (i != 0) {
                int i2 = i - 1;
                if (i2 == 0) {
                    error2 = DeferredDeeplinkListener.Error.NOT_A_FIRST_LAUNCH;
                } else if (i2 == 1) {
                    error2 = DeferredDeeplinkListener.Error.PARSE_ERROR;
                } else if (i2 != 2) {
                    error2 = DeferredDeeplinkListener.Error.UNKNOWN;
                } else {
                    error2 = DeferredDeeplinkListener.Error.NO_REFERRER;
                }
                deferredDeeplinkListener.onError(error2, (String) WrapUtils.getOrDefault(str, ""));
                this.b = null;
            } else {
                throw null;
            }
        }
        DeferredDeeplinkParametersListener deferredDeeplinkParametersListener = this.c;
        if (deferredDeeplinkParametersListener != null) {
            if (i != 0) {
                int i3 = i - 1;
                if (i3 == 0) {
                    error = DeferredDeeplinkParametersListener.Error.NOT_A_FIRST_LAUNCH;
                } else if (i3 == 1) {
                    error = DeferredDeeplinkParametersListener.Error.PARSE_ERROR;
                } else if (i3 != 2) {
                    error = DeferredDeeplinkParametersListener.Error.UNKNOWN;
                } else {
                    error = DeferredDeeplinkParametersListener.Error.NO_REFERRER;
                }
                deferredDeeplinkParametersListener.onError(error, (String) WrapUtils.getOrDefault(str, ""));
                this.c = null;
                return;
            }
            throw null;
        }
    }

    public final void a() {
        C0124a8 c0124a8 = this.d;
        if (c0124a8 != null) {
            String str = c0124a8.b;
            if (str != null) {
                DeferredDeeplinkListener deferredDeeplinkListener = this.b;
                if (deferredDeeplinkListener != null) {
                    deferredDeeplinkListener.onDeeplinkLoaded(str);
                    this.b = null;
                }
                if (!fo.a(this.d.f752a)) {
                    Map<String, String> map = this.d.f752a;
                    DeferredDeeplinkParametersListener deferredDeeplinkParametersListener = this.c;
                    if (deferredDeeplinkParametersListener != null) {
                        deferredDeeplinkParametersListener.onParametersLoaded(map);
                        this.c = null;
                        return;
                    }
                    return;
                }
                String str2 = this.d.c;
                DeferredDeeplinkParametersListener deferredDeeplinkParametersListener2 = this.c;
                if (deferredDeeplinkParametersListener2 != null) {
                    deferredDeeplinkParametersListener2.onError(DeferredDeeplinkParametersListener.Error.PARSE_ERROR, (String) WrapUtils.getOrDefault(str2, ""));
                    this.c = null;
                }
            } else if (c0124a8.c != null) {
                a(2);
            } else {
                a(3);
            }
        }
    }
}
