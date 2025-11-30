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
public final class Wd {

    /* renamed from: a  reason: collision with root package name */
    public static final Wd f739a = new Wd();
    public static final LinkedHashMap b = new LinkedHashMap();
    public static final String c = UserAgent.getFor(BuildConfig.LIBRARY_PACKAGE_NAME, "7.14.0", "50145656");

    public final synchronized ExponentialBackoffDataHolder a(Ud ud) {
        Object obj;
        LinkedHashMap linkedHashMap = b;
        obj = linkedHashMap.get(ud);
        if (obj == null) {
            obj = new ExponentialBackoffDataHolder(new C0695xa(C0471oa.I.y(), ud), ud.name());
            linkedHashMap.put(ud, obj);
        }
        return (ExponentialBackoffDataHolder) obj;
    }

    public static final NetworkTask a(Y4 y4) {
        AESRSARequestBodyEncrypter aESRSARequestBodyEncrypter = new AESRSARequestBodyEncrypter();
        C0119ah c0119ah = new C0119ah(aESRSARequestBodyEncrypter);
        C0746zb c0746zb = new C0746zb(y4);
        return new NetworkTask(new BlockingExecutor(), new C0516q5(y4.f760a), new AllHostsExponentialBackoffPolicy(f739a.a(Ud.REPORT)), new C0652vh(y4, c0119ah, c0746zb, new FullUrlFormer(c0119ah, c0746zb), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), y4.i(), y4.p(), y4.u(), aESRSARequestBodyEncrypter), CollectionsKt.listOf(new lo()), c);
    }
}
