package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.d8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0193d8 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f943a;
    public DeferredDeeplinkListener b;
    public DeferredDeeplinkParametersListener c;
    public C0141b8 d;

    public C0193d8(boolean z) {
        this.f943a = z;
    }

    public final void a(int i) {
        DeferredDeeplinkParametersListener.Error error;
        DeferredDeeplinkListener.Error error2;
        C0141b8 c0141b8 = this.d;
        String str = c0141b8 == null ? null : c0141b8.c;
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
        C0141b8 c0141b8 = this.d;
        if (c0141b8 != null) {
            String str = c0141b8.b;
            if (str != null) {
                DeferredDeeplinkListener deferredDeeplinkListener = this.b;
                if (deferredDeeplinkListener != null) {
                    deferredDeeplinkListener.onDeeplinkLoaded(str);
                    this.b = null;
                }
                boolean a2 = Oo.a(this.d.f906a);
                C0141b8 c0141b82 = this.d;
                if (!a2) {
                    Map<String, String> map = c0141b82.f906a;
                    DeferredDeeplinkParametersListener deferredDeeplinkParametersListener = this.c;
                    if (deferredDeeplinkParametersListener != null) {
                        deferredDeeplinkParametersListener.onParametersLoaded(map);
                        this.c = null;
                        return;
                    }
                    return;
                }
                String str2 = c0141b82.c;
                DeferredDeeplinkParametersListener deferredDeeplinkParametersListener2 = this.c;
                if (deferredDeeplinkParametersListener2 != null) {
                    deferredDeeplinkParametersListener2.onError(DeferredDeeplinkParametersListener.Error.PARSE_ERROR, (String) WrapUtils.getOrDefault(str2, ""));
                    this.c = null;
                }
            } else if (c0141b8.c != null) {
                a(2);
            } else {
                a(3);
            }
        }
    }
}
