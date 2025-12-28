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
    public static final Wd f837a = new Wd();
    public static final LinkedHashMap b = new LinkedHashMap();
    public static final String c = UserAgent.getFor(BuildConfig.LIBRARY_PACKAGE_NAME, "7.14.0", "50145656");

    public final synchronized ExponentialBackoffDataHolder a(Ud ud) {
        Object obj;
        LinkedHashMap linkedHashMap = b;
        obj = linkedHashMap.get(ud);
        if (obj == null) {
            obj = new ExponentialBackoffDataHolder(new C0694xa(C0470oa.I.y(), ud), ud.name());
            linkedHashMap.put(ud, obj);
        }
        return (ExponentialBackoffDataHolder) obj;
    }

    public static final NetworkTask a(Y4 y4) {
        AESRSARequestBodyEncrypter aESRSARequestBodyEncrypter = new AESRSARequestBodyEncrypter();
        C0118ah c0118ah = new C0118ah(aESRSARequestBodyEncrypter);
        C0745zb c0745zb = new C0745zb(y4);
        return new NetworkTask(new BlockingExecutor(), new C0515q5(y4.f858a), new AllHostsExponentialBackoffPolicy(f837a.a(Ud.REPORT)), new C0651vh(y4, c0118ah, c0745zb, new FullUrlFormer(c0118ah, c0745zb), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), y4.i(), y4.p(), y4.u(), aESRSARequestBodyEncrypter), CollectionsKt.listOf(new lo()), c);
    }
}
