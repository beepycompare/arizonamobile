package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.BuildConfig;
import io.appmetrica.analytics.coreutils.internal.executors.BlockingExecutor;
import io.appmetrica.analytics.coreutils.internal.network.UserAgent;
import io.appmetrica.analytics.networktasks.internal.AESRSARequestBodyEncrypter;
import io.appmetrica.analytics.networktasks.internal.AllHostsExponentialBackoffPolicy;
import io.appmetrica.analytics.networktasks.internal.DefaultResponseValidityChecker;
import io.appmetrica.analytics.networktasks.internal.ExponentialBackoffDataHolder;
import io.appmetrica.analytics.networktasks.internal.FullUrlFormer;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
import io.appmetrica.analytics.networktasks.internal.RequestDataHolder;
import io.appmetrica.analytics.networktasks.internal.ResponseDataHolder;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.ie  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0341ie {

    /* renamed from: a  reason: collision with root package name */
    public static final C0341ie f876a = new C0341ie();
    public static final LinkedHashMap b = new LinkedHashMap();
    public static final String c = UserAgent.getFor(BuildConfig.LIBRARY_PACKAGE_NAME, "7.9.0", "50132373");

    public final synchronized ExponentialBackoffDataHolder a(EnumC0291ge enumC0291ge) {
        Object obj;
        LinkedHashMap linkedHashMap = b;
        obj = linkedHashMap.get(enumC0291ge);
        if (obj == null) {
            obj = new ExponentialBackoffDataHolder(new Pa(Ga.F.x(), enumC0291ge), enumC0291ge.name());
            linkedHashMap.put(enumC0291ge, obj);
        }
        return (ExponentialBackoffDataHolder) obj;
    }

    public static final NetworkTask a(C0580s5 c0580s5) {
        AESRSARequestBodyEncrypter aESRSARequestBodyEncrypter = new AESRSARequestBodyEncrypter();
        C0393kh c0393kh = new C0393kh(aESRSARequestBodyEncrypter);
        Rb rb = new Rb(c0580s5);
        return new NetworkTask(new BlockingExecutor(), new Q9(c0580s5.f1037a), new AllHostsExponentialBackoffPolicy(f876a.a(EnumC0291ge.REPORT)), new Fh(c0580s5, c0393kh, rb, new FullUrlFormer(c0393kh, rb), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), c0580s5.h(), c0580s5.o(), c0580s5.t(), aESRSARequestBodyEncrypter), CollectionsKt.listOf(new eo()), c);
    }
}
