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
/* renamed from: io.appmetrica.analytics.impl.qe  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0536qe {

    /* renamed from: a  reason: collision with root package name */
    public static final C0536qe f1045a = new C0536qe();
    public static final LinkedHashMap b = new LinkedHashMap();
    public static final String c = UserAgent.getFor(BuildConfig.LIBRARY_PACKAGE_NAME, "7.12.0", "50139596");

    public final synchronized ExponentialBackoffDataHolder a(EnumC0485oe enumC0485oe) {
        Object obj;
        LinkedHashMap linkedHashMap = b;
        obj = linkedHashMap.get(enumC0485oe);
        if (obj == null) {
            obj = new ExponentialBackoffDataHolder(new Wa(Na.F.x(), enumC0485oe), enumC0485oe.name());
            linkedHashMap.put(enumC0485oe, obj);
        }
        return (ExponentialBackoffDataHolder) obj;
    }

    public static final NetworkTask a(C0651v5 c0651v5) {
        AESRSARequestBodyEncrypter aESRSARequestBodyEncrypter = new AESRSARequestBodyEncrypter();
        C0663vh c0663vh = new C0663vh(aESRSARequestBodyEncrypter);
        Yb yb = new Yb(c0651v5);
        return new NetworkTask(new BlockingExecutor(), new N5(c0651v5.f1115a), new AllHostsExponentialBackoffPolicy(f1045a.a(EnumC0485oe.REPORT)), new Qh(c0651v5, c0663vh, yb, new FullUrlFormer(c0663vh, yb), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), c0651v5.i(), c0651v5.p(), c0651v5.u(), aESRSARequestBodyEncrypter), CollectionsKt.listOf(new qo()), c);
    }
}
