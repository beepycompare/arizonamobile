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
public final class C0537qe {

    /* renamed from: a  reason: collision with root package name */
    public static final C0537qe f1050a = new C0537qe();
    public static final LinkedHashMap b = new LinkedHashMap();
    public static final String c = UserAgent.getFor(BuildConfig.LIBRARY_PACKAGE_NAME, "7.12.0", "50139596");

    public final synchronized ExponentialBackoffDataHolder a(EnumC0486oe enumC0486oe) {
        Object obj;
        LinkedHashMap linkedHashMap = b;
        obj = linkedHashMap.get(enumC0486oe);
        if (obj == null) {
            obj = new ExponentialBackoffDataHolder(new Wa(Na.F.x(), enumC0486oe), enumC0486oe.name());
            linkedHashMap.put(enumC0486oe, obj);
        }
        return (ExponentialBackoffDataHolder) obj;
    }

    public static final NetworkTask a(C0652v5 c0652v5) {
        AESRSARequestBodyEncrypter aESRSARequestBodyEncrypter = new AESRSARequestBodyEncrypter();
        C0664vh c0664vh = new C0664vh(aESRSARequestBodyEncrypter);
        Yb yb = new Yb(c0652v5);
        return new NetworkTask(new BlockingExecutor(), new N5(c0652v5.f1120a), new AllHostsExponentialBackoffPolicy(f1050a.a(EnumC0486oe.REPORT)), new Qh(c0652v5, c0664vh, yb, new FullUrlFormer(c0664vh, yb), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), c0652v5.i(), c0652v5.p(), c0652v5.u(), aESRSARequestBodyEncrypter), CollectionsKt.listOf(new qo()), c);
    }
}
