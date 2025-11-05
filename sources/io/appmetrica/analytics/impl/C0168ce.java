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
/* renamed from: io.appmetrica.analytics.impl.ce  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0168ce {

    /* renamed from: a  reason: collision with root package name */
    public static final C0168ce f829a = new C0168ce();
    public static final LinkedHashMap b = new LinkedHashMap();
    public static final String c = UserAgent.getFor(BuildConfig.LIBRARY_PACKAGE_NAME, "7.13.0", "50142752");

    public final synchronized ExponentialBackoffDataHolder a(EnumC0116ae enumC0116ae) {
        Object obj;
        LinkedHashMap linkedHashMap = b;
        obj = linkedHashMap.get(enumC0116ae);
        if (obj == null) {
            obj = new ExponentialBackoffDataHolder(new Da(C0620ua.H.z(), enumC0116ae), enumC0116ae.name());
            linkedHashMap.put(enumC0116ae, obj);
        }
        return (ExponentialBackoffDataHolder) obj;
    }

    public static final NetworkTask a(C0210e5 c0210e5) {
        AESRSARequestBodyEncrypter aESRSARequestBodyEncrypter = new AESRSARequestBodyEncrypter();
        C0222eh c0222eh = new C0222eh(aESRSARequestBodyEncrypter);
        Fb fb = new Fb(c0210e5);
        return new NetworkTask(new BlockingExecutor(), new C0665w5(c0210e5.f857a), new AllHostsExponentialBackoffPolicy(f829a.a(EnumC0116ae.REPORT)), new C0752zh(c0210e5, c0222eh, fb, new FullUrlFormer(c0222eh, fb), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), c0210e5.i(), c0210e5.p(), c0210e5.u(), aESRSARequestBodyEncrypter), CollectionsKt.listOf(new mo()), c);
    }
}
