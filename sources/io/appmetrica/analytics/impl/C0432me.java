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
/* renamed from: io.appmetrica.analytics.impl.me  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0432me {

    /* renamed from: a  reason: collision with root package name */
    public static final C0432me f967a = new C0432me();
    public static final LinkedHashMap b = new LinkedHashMap();
    public static final String c = UserAgent.getFor(BuildConfig.LIBRARY_PACKAGE_NAME, "7.11.0", "50138503");

    public final synchronized ExponentialBackoffDataHolder a(EnumC0381ke enumC0381ke) {
        Object obj;
        LinkedHashMap linkedHashMap = b;
        obj = linkedHashMap.get(enumC0381ke);
        if (obj == null) {
            obj = new ExponentialBackoffDataHolder(new Ta(Ka.F.x(), enumC0381ke), enumC0381ke.name());
            linkedHashMap.put(enumC0381ke, obj);
        }
        return (ExponentialBackoffDataHolder) obj;
    }

    public static final NetworkTask a(C0572s5 c0572s5) {
        AESRSARequestBodyEncrypter aESRSARequestBodyEncrypter = new AESRSARequestBodyEncrypter();
        C0559rh c0559rh = new C0559rh(aESRSARequestBodyEncrypter);
        Vb vb = new Vb(c0572s5);
        return new NetworkTask(new BlockingExecutor(), new K5(c0572s5.f1054a), new AllHostsExponentialBackoffPolicy(f967a.a(EnumC0381ke.REPORT)), new Mh(c0572s5, c0559rh, vb, new FullUrlFormer(c0559rh, vb), new RequestDataHolder(), new ResponseDataHolder(new DefaultResponseValidityChecker()), c0572s5.h(), c0572s5.o(), c0572s5.t(), aESRSARequestBodyEncrypter), CollectionsKt.listOf(new mo()), c);
    }
}
