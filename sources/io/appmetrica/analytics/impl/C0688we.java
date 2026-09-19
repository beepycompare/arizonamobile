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
public final class C0688we {

    /* renamed from: a  reason: collision with root package name */
    public static final C0688we f1268a = new C0688we();
    public static final LinkedHashMap b = new LinkedHashMap();
    public static final String c = UserAgent.getFor(BuildConfig.LIBRARY_PACKAGE_NAME, "8.2.0", "50163623");

    public static final NetworkTask a(C0446n5 c0446n5) {
        ExponentialBackoffDataHolder exponentialBackoffDataHolder;
        AESRSARequestBodyEncrypter aESRSARequestBodyEncrypter = new AESRSARequestBodyEncrypter();
        C0613th c0613th = new C0613th(aESRSARequestBodyEncrypter);
        C0117ac c0117ac = new C0117ac(c0446n5);
        BlockingExecutor blockingExecutor = new BlockingExecutor();
        F5 f5 = new F5(c0446n5.f1111a);
        C0688we c0688we = f1268a;
        EnumC0636ue enumC0636ue = EnumC0636ue.f1234a;
        synchronized (c0688we) {
            LinkedHashMap linkedHashMap = b;
            Object obj = linkedHashMap.get(enumC0636ue);
            if (obj == null) {
                obj = new ExponentialBackoffDataHolder(new Za(Na.I.y(), enumC0636ue), "REPORT");
                linkedHashMap.put(enumC0636ue, obj);
            }
            exponentialBackoffDataHolder = (ExponentialBackoffDataHolder) obj;
        }
        return new NetworkTask(blockingExecutor, f5, new AllHostsExponentialBackoffPolicy(exponentialBackoffDataHolder), new Nh(c0446n5, c0613th, c0117ac, new FullUrlFormer(c0613th, c0117ac), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), aESRSARequestBodyEncrypter), CollectionsKt.listOf(new No()), c);
    }

    public static final NetworkTask a(C0180cn c0180cn, Dm dm) {
        ExponentialBackoffDataHolder exponentialBackoffDataHolder;
        C0774zm c0774zm = new C0774zm(new Ie(), Na.I.p());
        FinalConfigProvider finalConfigProvider = new FinalConfigProvider(dm);
        SynchronizedBlockingExecutor synchronizedBlockingExecutor = new SynchronizedBlockingExecutor();
        F5 f5 = new F5(c0180cn.f935a.f952a);
        C0688we c0688we = f1268a;
        EnumC0636ue enumC0636ue = EnumC0636ue.b;
        synchronized (c0688we) {
            LinkedHashMap linkedHashMap = b;
            Object obj = linkedHashMap.get(enumC0636ue);
            if (obj == null) {
                obj = new ExponentialBackoffDataHolder(new Za(Na.I.y(), enumC0636ue), "STARTUP");
                linkedHashMap.put(enumC0636ue, obj);
            }
            exponentialBackoffDataHolder = (ExponentialBackoffDataHolder) obj;
        }
        return new NetworkTask(synchronizedBlockingExecutor, f5, new AllHostsExponentialBackoffPolicy(exponentialBackoffDataHolder), new C0128an(c0180cn, new C0618tm(), new FullUrlFormer(c0774zm, finalConfigProvider), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), finalConfigProvider), CollectionsKt.emptyList(), c);
    }
}
