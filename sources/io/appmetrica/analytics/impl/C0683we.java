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
public final class C0683we {

    /* renamed from: a  reason: collision with root package name */
    public static final C0683we f1271a = new C0683we();
    public static final LinkedHashMap b = new LinkedHashMap();
    public static final String c = UserAgent.getFor(BuildConfig.LIBRARY_PACKAGE_NAME, "8.2.0", "50163623");

    public static final NetworkTask a(C0441n5 c0441n5) {
        ExponentialBackoffDataHolder exponentialBackoffDataHolder;
        AESRSARequestBodyEncrypter aESRSARequestBodyEncrypter = new AESRSARequestBodyEncrypter();
        C0608th c0608th = new C0608th(aESRSARequestBodyEncrypter);
        C0112ac c0112ac = new C0112ac(c0441n5);
        BlockingExecutor blockingExecutor = new BlockingExecutor();
        F5 f5 = new F5(c0441n5.f1114a);
        C0683we c0683we = f1271a;
        EnumC0631ue enumC0631ue = EnumC0631ue.f1237a;
        synchronized (c0683we) {
            LinkedHashMap linkedHashMap = b;
            Object obj = linkedHashMap.get(enumC0631ue);
            if (obj == null) {
                obj = new ExponentialBackoffDataHolder(new Za(Na.I.y(), enumC0631ue), "REPORT");
                linkedHashMap.put(enumC0631ue, obj);
            }
            exponentialBackoffDataHolder = (ExponentialBackoffDataHolder) obj;
        }
        return new NetworkTask(blockingExecutor, f5, new AllHostsExponentialBackoffPolicy(exponentialBackoffDataHolder), new Nh(c0441n5, c0608th, c0112ac, new FullUrlFormer(c0608th, c0112ac), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), aESRSARequestBodyEncrypter), CollectionsKt.listOf(new No()), c);
    }

    public static final NetworkTask a(C0175cn c0175cn, Dm dm) {
        ExponentialBackoffDataHolder exponentialBackoffDataHolder;
        C0769zm c0769zm = new C0769zm(new Ie(), Na.I.p());
        FinalConfigProvider finalConfigProvider = new FinalConfigProvider(dm);
        SynchronizedBlockingExecutor synchronizedBlockingExecutor = new SynchronizedBlockingExecutor();
        F5 f5 = new F5(c0175cn.f938a.f955a);
        C0683we c0683we = f1271a;
        EnumC0631ue enumC0631ue = EnumC0631ue.b;
        synchronized (c0683we) {
            LinkedHashMap linkedHashMap = b;
            Object obj = linkedHashMap.get(enumC0631ue);
            if (obj == null) {
                obj = new ExponentialBackoffDataHolder(new Za(Na.I.y(), enumC0631ue), "STARTUP");
                linkedHashMap.put(enumC0631ue, obj);
            }
            exponentialBackoffDataHolder = (ExponentialBackoffDataHolder) obj;
        }
        return new NetworkTask(synchronizedBlockingExecutor, f5, new AllHostsExponentialBackoffPolicy(exponentialBackoffDataHolder), new C0123an(c0175cn, new C0613tm(), new FullUrlFormer(c0769zm, finalConfigProvider), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), finalConfigProvider), CollectionsKt.emptyList(), c);
    }
}
