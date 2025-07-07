package io.appmetrica.analytics.impl;

import android.telephony.SubscriptionInfo;
import androidx.media3.exoplayer.upstream.CmcdData;
import io.appmetrica.analytics.coreutils.internal.parsing.ParseUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\n"}, d2 = {"Lio/appmetrica/analytics/impl/ml;", "", "Landroid/telephony/SubscriptionInfo;", "subscriptionInfo", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroid/telephony/SubscriptionInfo;)Ljava/lang/Integer;", "b", "<init>", "()V", "analytics_binaryProdRelease"}, k = 1, mv = {1, 6, 0})
/* renamed from: io.appmetrica.analytics.impl.ml  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0447ml {

    /* renamed from: a  reason: collision with root package name */
    public static final C0447ml f944a = new C0447ml();

    private C0447ml() {
    }

    @JvmStatic
    public static final Integer a(SubscriptionInfo subscriptionInfo) {
        return ParseUtils.intValueOf(subscriptionInfo.getMccString());
    }

    @JvmStatic
    public static final Integer b(SubscriptionInfo subscriptionInfo) {
        return ParseUtils.intValueOf(subscriptionInfo.getMncString());
    }
}
