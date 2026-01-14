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
/* loaded from: classes5.dex */
public final class Vd {

    /* renamed from: a  reason: collision with root package name */
    public static final Vd f828a = new Vd();
    public static final LinkedHashMap b = new LinkedHashMap();
    public static final String c = UserAgent.getFor(BuildConfig.LIBRARY_PACKAGE_NAME, "8.0.0", "50147728");

    public final synchronized ExponentialBackoffDataHolder a(Td td) {
        Object obj;
        LinkedHashMap linkedHashMap = b;
        obj = linkedHashMap.get(td);
        if (obj == null) {
            obj = new ExponentialBackoffDataHolder(new C0673wa(C0449na.I.y(), td), td.name());
            linkedHashMap.put(td, obj);
        }
        return (ExponentialBackoffDataHolder) obj;
    }

    public static final NetworkTask a(X4 x4) {
        AESRSARequestBodyEncrypter aESRSARequestBodyEncrypter = new AESRSARequestBodyEncrypter();
        Zg zg = new Zg(aESRSARequestBodyEncrypter);
        C0724yb c0724yb = new C0724yb(x4);
        return new NetworkTask(new BlockingExecutor(), new C0494p5(x4.f849a), new AllHostsExponentialBackoffPolicy(f828a.a(Td.REPORT)), new C0630uh(x4, zg, c0724yb, new FullUrlFormer(zg, c0724yb), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), x4.i(), x4.p(), x4.u(), aESRSARequestBodyEncrypter), CollectionsKt.listOf(new ko()), c);
    }
}
