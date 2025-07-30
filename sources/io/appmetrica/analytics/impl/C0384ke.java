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
public final class C0384ke {

    /* renamed from: a  reason: collision with root package name */
    public static final C0384ke f926a = new C0384ke();
    public static final LinkedHashMap b = new LinkedHashMap();
    public static final String c = UserAgent.getFor(BuildConfig.LIBRARY_PACKAGE_NAME, "7.10.0", "50135769");

    public final synchronized ExponentialBackoffDataHolder a(EnumC0335ie enumC0335ie) {
        Object obj;
        LinkedHashMap linkedHashMap = b;
        obj = linkedHashMap.get(enumC0335ie);
        if (obj == null) {
            obj = new ExponentialBackoffDataHolder(new Ra(Ia.F.x(), enumC0335ie), enumC0335ie.name());
            linkedHashMap.put(enumC0335ie, obj);
        }
        return (ExponentialBackoffDataHolder) obj;
    }

    public static final NetworkTask a(C0574s5 c0574s5) {
        AESRSARequestBodyEncrypter aESRSARequestBodyEncrypter = new AESRSARequestBodyEncrypter();
        C0437mh c0437mh = new C0437mh(aESRSARequestBodyEncrypter);
        Tb tb = new Tb(c0574s5);
        return new NetworkTask(new BlockingExecutor(), new K5(c0574s5.f1049a), new AllHostsExponentialBackoffPolicy(f926a.a(EnumC0335ie.REPORT)), new Hh(c0574s5, c0437mh, tb, new FullUrlFormer(c0437mh, tb), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), c0574s5.h(), c0574s5.o(), c0574s5.t(), aESRSARequestBodyEncrypter), CollectionsKt.listOf(new ho()), c);
    }
}
