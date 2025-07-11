package io.appmetrica.analytics.coreutils.internal.logger;

import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
/* loaded from: classes4.dex */
public abstract class LoggerStorage {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap f275a = new HashMap();
    private static final Object b = new Object();
    private static volatile PublicLogger c = PublicLogger.getAnonymousInstance();

    public static PublicLogger getMainPublicOrAnonymousLogger() {
        return c;
    }

    public static PublicLogger getOrCreateMainPublicLogger(String str) {
        c = getOrCreatePublicLogger(str);
        return c;
    }

    public static PublicLogger getOrCreatePublicLogger(String str) {
        PublicLogger publicLogger;
        if (TextUtils.isEmpty(str)) {
            return PublicLogger.getAnonymousInstance();
        }
        PublicLogger publicLogger2 = (PublicLogger) f275a.get(str);
        if (publicLogger2 == null) {
            synchronized (b) {
                publicLogger = (PublicLogger) f275a.get(str);
                if (publicLogger == null) {
                    publicLogger = new PublicLogger(ApiKeyUtils.createPartialApiKey(str));
                    f275a.put(str, publicLogger);
                }
            }
            return publicLogger;
        }
        return publicLogger2;
    }

    public static void unsetPublicLoggers() {
        f275a = new HashMap();
        c = PublicLogger.getAnonymousInstance();
    }
}
