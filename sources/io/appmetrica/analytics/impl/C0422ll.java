package io.appmetrica.analytics.impl;

import android.content.Context;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import androidx.media3.exoplayer.upstream.CmcdData;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\t"}, d2 = {"Lio/appmetrica/analytics/impl/ll;", "", "Landroid/content/Context;", "context", "", "Lio/appmetrica/analytics/impl/fl;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "<init>", "()V", "analytics_binaryProdRelease"}, k = 1, mv = {1, 6, 0})
/* renamed from: io.appmetrica.analytics.impl.ll  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0422ll {

    /* renamed from: a  reason: collision with root package name */
    public static final C0422ll f926a = new C0422ll();

    private C0422ll() {
    }

    @JvmStatic
    public static final List<C0273fl> a(Context context) {
        Integer valueOf;
        Integer valueOf2;
        List<SubscriptionInfo> list = (List) SystemServiceUtils.accessSystemServiceByNameSafely(context, "telephony_subscription_service", "getting active subcription info list", "SubscriptionManager", new FunctionWithThrowable() { // from class: io.appmetrica.analytics.impl.ll$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
            public final Object apply(Object obj) {
                List a2;
                a2 = C0422ll.a((SubscriptionManager) obj);
                return a2;
            }
        });
        if (list != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (SubscriptionInfo subscriptionInfo : list) {
                if (AndroidUtils.isApiAchieved(29)) {
                    valueOf = C0447ml.a(subscriptionInfo);
                } else {
                    valueOf = Integer.valueOf(subscriptionInfo.getMcc());
                }
                if (AndroidUtils.isApiAchieved(29)) {
                    valueOf2 = C0447ml.b(subscriptionInfo);
                } else {
                    valueOf2 = Integer.valueOf(subscriptionInfo.getMnc());
                }
                boolean z = subscriptionInfo.getDataRoaming() == 1;
                CharSequence carrierName = subscriptionInfo.getCarrierName();
                arrayList.add(new C0273fl(valueOf, valueOf2, z, carrierName != null ? carrierName.toString() : null));
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List a(SubscriptionManager subscriptionManager) {
        return subscriptionManager.getActiveSubscriptionInfoList();
    }
}
