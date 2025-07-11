package io.appmetrica.analytics.coreutils.internal.services.telephony;

import android.content.Context;
import android.telephony.TelephonyManager;
import androidx.media3.exoplayer.upstream.CmcdData;
import io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable;
import io.appmetrica.analytics.coreutils.internal.AndroidUtils;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \f2\u00020\u0001:\u0003\f\u0005\rB\u000f\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/services/telephony/CellularNetworkTypeExtractor;", "", "", "getNetworkType", "Landroid/content/Context;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Companion", "b", "core-utils_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class CellularNetworkTypeExtractor {
    public static final Companion Companion = new Companion(null);
    public static final String UNKNOWN_NETWORK_TYPE_VALUE = "unknown";

    /* renamed from: a  reason: collision with root package name */
    private final Context f293a;
    private final FunctionWithThrowable b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/services/telephony/CellularNetworkTypeExtractor$Companion;", "", "", "UNKNOWN_NETWORK_TYPE_VALUE", "Ljava/lang/String;", "core-utils_release"}, k = 1, mv = {1, 6, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/services/telephony/CellularNetworkTypeExtractor$a;", "Lio/appmetrica/analytics/coreapi/internal/backport/FunctionWithThrowable;", "Landroid/telephony/TelephonyManager;", "", "input", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroid/telephony/TelephonyManager;)Ljava/lang/Integer;", "<init>", "()V", "core-utils_release"}, k = 1, mv = {1, 6, 0})
    /* loaded from: classes4.dex */
    public static final class a implements FunctionWithThrowable<TelephonyManager, Integer> {
        @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
        /* renamed from: a */
        public Integer apply(TelephonyManager telephonyManager) {
            return Integer.valueOf(telephonyManager.getDataNetworkType());
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/services/telephony/CellularNetworkTypeExtractor$b;", "Lio/appmetrica/analytics/coreapi/internal/backport/FunctionWithThrowable;", "Landroid/telephony/TelephonyManager;", "", "input", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Landroid/telephony/TelephonyManager;)Ljava/lang/Integer;", "<init>", "()V", "core-utils_release"}, k = 1, mv = {1, 6, 0})
    /* loaded from: classes4.dex */
    public static final class b implements FunctionWithThrowable<TelephonyManager, Integer> {
        @Override // io.appmetrica.analytics.coreapi.internal.backport.FunctionWithThrowable
        /* renamed from: a */
        public Integer apply(TelephonyManager telephonyManager) {
            return Integer.valueOf(telephonyManager.getNetworkType());
        }
    }

    public CellularNetworkTypeExtractor(Context context) {
        FunctionWithThrowable bVar;
        this.f293a = context;
        if (AndroidUtils.isApiAchieved(24)) {
            bVar = new a();
        } else {
            bVar = new b();
        }
        this.b = bVar;
    }

    public final Context getContext() {
        return this.f293a;
    }

    public final String getNetworkType() {
        return CellularNetworkTypeConverter.convert((Integer) SystemServiceUtils.accessSystemServiceByNameSafely(this.f293a, "phone", "Extracting cellular networkType", "TelephonyManager", this.b));
    }
}
