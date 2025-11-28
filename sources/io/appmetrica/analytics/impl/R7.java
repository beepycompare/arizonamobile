package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.Map;
/* loaded from: classes5.dex */
public final class R7 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f662a;
    public DeferredDeeplinkListener b;
    public DeferredDeeplinkParametersListener c;
    public P7 d;

    public R7(boolean z) {
        this.f662a = z;
    }

    public final void a(int i) {
        DeferredDeeplinkParametersListener.Error error;
        DeferredDeeplinkListener.Error error2;
        P7 p7 = this.d;
        String str = p7 == null ? null : p7.c;
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
        P7 p7 = this.d;
        if (p7 != null) {
            String str = p7.b;
            if (str != null) {
                DeferredDeeplinkListener deferredDeeplinkListener = this.b;
                if (deferredDeeplinkListener != null) {
                    deferredDeeplinkListener.onDeeplinkLoaded(str);
                    this.b = null;
                }
                if (!no.a(this.d.f632a)) {
                    Map<String, String> map = this.d.f632a;
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
            } else if (p7.c != null) {
                a(2);
            } else {
                a(3);
            }
        }
    }
}
