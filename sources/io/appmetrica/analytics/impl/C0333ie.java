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
public final class C0333ie {

    /* renamed from: a  reason: collision with root package name */
    public static final C0333ie f877a = new C0333ie();
    public static final LinkedHashMap b = new LinkedHashMap();
    public static final String c = UserAgent.getFor(BuildConfig.LIBRARY_PACKAGE_NAME, "7.9.0", "50132373");

    public final synchronized ExponentialBackoffDataHolder a(EnumC0283ge enumC0283ge) {
        Object obj;
        LinkedHashMap linkedHashMap = b;
        obj = linkedHashMap.get(enumC0283ge);
        if (obj == null) {
            obj = new ExponentialBackoffDataHolder(new Pa(Ga.F.x(), enumC0283ge), enumC0283ge.name());
            linkedHashMap.put(enumC0283ge, obj);
        }
        return (ExponentialBackoffDataHolder) obj;
    }

    public static final NetworkTask a(C0572s5 c0572s5) {
        AESRSARequestBodyEncrypter aESRSARequestBodyEncrypter = new AESRSARequestBodyEncrypter();
        C0385kh c0385kh = new C0385kh(aESRSARequestBodyEncrypter);
        Rb rb = new Rb(c0572s5);
        return new NetworkTask(new BlockingExecutor(), new Q9(c0572s5.f1038a), new AllHostsExponentialBackoffPolicy(f877a.a(EnumC0283ge.REPORT)), new Fh(c0572s5, c0385kh, rb, new FullUrlFormer(c0385kh, rb), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), c0572s5.h(), c0572s5.o(), c0572s5.t(), aESRSARequestBodyEncrypter), CollectionsKt.listOf(new eo()), c);
    }
}
