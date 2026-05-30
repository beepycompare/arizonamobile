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
public final class C0690we {

    /* renamed from: a  reason: collision with root package name */
    public static final C0690we f1266a = new C0690we();
    public static final LinkedHashMap b = new LinkedHashMap();
    public static final String c = UserAgent.getFor(BuildConfig.LIBRARY_PACKAGE_NAME, "8.2.0", "50163623");

    public static final NetworkTask a(C0448n5 c0448n5) {
        ExponentialBackoffDataHolder exponentialBackoffDataHolder;
        AESRSARequestBodyEncrypter aESRSARequestBodyEncrypter = new AESRSARequestBodyEncrypter();
        C0615th c0615th = new C0615th(aESRSARequestBodyEncrypter);
        C0119ac c0119ac = new C0119ac(c0448n5);
        BlockingExecutor blockingExecutor = new BlockingExecutor();
        F5 f5 = new F5(c0448n5.f1109a);
        C0690we c0690we = f1266a;
        EnumC0638ue enumC0638ue = EnumC0638ue.f1232a;
        synchronized (c0690we) {
            LinkedHashMap linkedHashMap = b;
            Object obj = linkedHashMap.get(enumC0638ue);
            if (obj == null) {
                obj = new ExponentialBackoffDataHolder(new Za(Na.I.y(), enumC0638ue), "REPORT");
                linkedHashMap.put(enumC0638ue, obj);
            }
            exponentialBackoffDataHolder = (ExponentialBackoffDataHolder) obj;
        }
        return new NetworkTask(blockingExecutor, f5, new AllHostsExponentialBackoffPolicy(exponentialBackoffDataHolder), new Nh(c0448n5, c0615th, c0119ac, new FullUrlFormer(c0615th, c0119ac), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), aESRSARequestBodyEncrypter), CollectionsKt.listOf(new No()), c);
    }

    public static final NetworkTask a(C0182cn c0182cn, Dm dm) {
        ExponentialBackoffDataHolder exponentialBackoffDataHolder;
        C0776zm c0776zm = new C0776zm(new Ie(), Na.I.p());
        FinalConfigProvider finalConfigProvider = new FinalConfigProvider(dm);
        SynchronizedBlockingExecutor synchronizedBlockingExecutor = new SynchronizedBlockingExecutor();
        F5 f5 = new F5(c0182cn.f933a.f950a);
        C0690we c0690we = f1266a;
        EnumC0638ue enumC0638ue = EnumC0638ue.b;
        synchronized (c0690we) {
            LinkedHashMap linkedHashMap = b;
            Object obj = linkedHashMap.get(enumC0638ue);
            if (obj == null) {
                obj = new ExponentialBackoffDataHolder(new Za(Na.I.y(), enumC0638ue), "STARTUP");
                linkedHashMap.put(enumC0638ue, obj);
            }
            exponentialBackoffDataHolder = (ExponentialBackoffDataHolder) obj;
        }
        return new NetworkTask(synchronizedBlockingExecutor, f5, new AllHostsExponentialBackoffPolicy(exponentialBackoffDataHolder), new C0130an(c0182cn, new C0620tm(), new FullUrlFormer(c0776zm, finalConfigProvider), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), finalConfigProvider), CollectionsKt.emptyList(), c);
    }
}
