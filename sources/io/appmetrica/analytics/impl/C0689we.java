package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.BuildConfig;
import io.appmetrica.analytics.coreutils.internal.executors.BlockingExecutor;
import io.appmetrica.analytics.coreutils.internal.executors.SynchronizedBlockingExecutor;
import io.appmetrica.analytics.coreutils.internal.network.UserAgent;
import io.appmetrica.analytics.networktasks.internal.AESRSARequestBodyEncrypter;
import io.appmetrica.analytics.networktasks.internal.AllHostsExponentialBackoffPolicy;
import io.appmetrica.analytics.networktasks.internal.DefaultResponseValidityChecker;
import io.appmetrica.analytics.networktasks.internal.ExponentialBackoffDataHolder;
import io.appmetrica.analytics.networktasks.internal.FinalConfigProvider;
import io.appmetrica.analytics.networktasks.internal.FullUrlFormer;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
import io.appmetrica.analytics.networktasks.internal.RequestDataHolder;
import io.appmetrica.analytics.networktasks.internal.ResponseDataHolder;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.we  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0689we {

    /* renamed from: a  reason: collision with root package name */
    public static final C0689we f1268a = new C0689we();
    public static final LinkedHashMap b = new LinkedHashMap();
    public static final String c = UserAgent.getFor(BuildConfig.LIBRARY_PACKAGE_NAME, "8.2.0", "50163623");

    public static final NetworkTask a(C0447n5 c0447n5) {
        ExponentialBackoffDataHolder exponentialBackoffDataHolder;
        AESRSARequestBodyEncrypter aESRSARequestBodyEncrypter = new AESRSARequestBodyEncrypter();
        C0614th c0614th = new C0614th(aESRSARequestBodyEncrypter);
        C0118ac c0118ac = new C0118ac(c0447n5);
        BlockingExecutor blockingExecutor = new BlockingExecutor();
        F5 f5 = new F5(c0447n5.f1111a);
        C0689we c0689we = f1268a;
        EnumC0637ue enumC0637ue = EnumC0637ue.f1234a;
        synchronized (c0689we) {
            LinkedHashMap linkedHashMap = b;
            Object obj = linkedHashMap.get(enumC0637ue);
            if (obj == null) {
                obj = new ExponentialBackoffDataHolder(new Za(Na.I.y(), enumC0637ue), "REPORT");
                linkedHashMap.put(enumC0637ue, obj);
            }
            exponentialBackoffDataHolder = (ExponentialBackoffDataHolder) obj;
        }
        return new NetworkTask(blockingExecutor, f5, new AllHostsExponentialBackoffPolicy(exponentialBackoffDataHolder), new Nh(c0447n5, c0614th, c0118ac, new FullUrlFormer(c0614th, c0118ac), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), aESRSARequestBodyEncrypter), CollectionsKt.listOf(new No()), c);
    }

    public static final NetworkTask a(C0181cn c0181cn, Dm dm) {
        ExponentialBackoffDataHolder exponentialBackoffDataHolder;
        C0775zm c0775zm = new C0775zm(new Ie(), Na.I.p());
        FinalConfigProvider finalConfigProvider = new FinalConfigProvider(dm);
        SynchronizedBlockingExecutor synchronizedBlockingExecutor = new SynchronizedBlockingExecutor();
        F5 f5 = new F5(c0181cn.f935a.f952a);
        C0689we c0689we = f1268a;
        EnumC0637ue enumC0637ue = EnumC0637ue.b;
        synchronized (c0689we) {
            LinkedHashMap linkedHashMap = b;
            Object obj = linkedHashMap.get(enumC0637ue);
            if (obj == null) {
                obj = new ExponentialBackoffDataHolder(new Za(Na.I.y(), enumC0637ue), "STARTUP");
                linkedHashMap.put(enumC0637ue, obj);
            }
            exponentialBackoffDataHolder = (ExponentialBackoffDataHolder) obj;
        }
        return new NetworkTask(synchronizedBlockingExecutor, f5, new AllHostsExponentialBackoffPolicy(exponentialBackoffDataHolder), new C0129an(c0181cn, new C0619tm(), new FullUrlFormer(c0775zm, finalConfigProvider), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), finalConfigProvider), CollectionsKt.emptyList(), c);
    }
}
