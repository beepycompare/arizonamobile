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
/* renamed from: io.appmetrica.analytics.impl.ke  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0385ke {

    /* renamed from: a  reason: collision with root package name */
    public static final C0385ke f925a = new C0385ke();
    public static final LinkedHashMap b = new LinkedHashMap();
    public static final String c = UserAgent.getFor(BuildConfig.LIBRARY_PACKAGE_NAME, "7.10.0", "50135769");

    public final synchronized ExponentialBackoffDataHolder a(EnumC0336ie enumC0336ie) {
        Object obj;
        LinkedHashMap linkedHashMap = b;
        obj = linkedHashMap.get(enumC0336ie);
        if (obj == null) {
            obj = new ExponentialBackoffDataHolder(new Ra(Ia.F.x(), enumC0336ie), enumC0336ie.name());
            linkedHashMap.put(enumC0336ie, obj);
        }
        return (ExponentialBackoffDataHolder) obj;
    }

    public static final NetworkTask a(C0575s5 c0575s5) {
        AESRSARequestBodyEncrypter aESRSARequestBodyEncrypter = new AESRSARequestBodyEncrypter();
        C0438mh c0438mh = new C0438mh(aESRSARequestBodyEncrypter);
        Tb tb = new Tb(c0575s5);
        return new NetworkTask(new BlockingExecutor(), new K5(c0575s5.f1048a), new AllHostsExponentialBackoffPolicy(f925a.a(EnumC0336ie.REPORT)), new Hh(c0575s5, c0438mh, tb, new FullUrlFormer(c0438mh, tb), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), c0575s5.h(), c0575s5.o(), c0575s5.t(), aESRSARequestBodyEncrypter), CollectionsKt.listOf(new ho()), c);
    }
}
