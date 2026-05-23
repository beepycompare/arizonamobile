package io.appmetrica.analytics.internal;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.gms.measurement.AppMeasurement;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lio/appmetrica/analytics/internal/CounterConfigurationReporterType;", "", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Ljava/lang/String;", "getStringValue", "()Ljava/lang/String;", "stringValue", "Companion", "MAIN", "MANUAL", "SELF_SDK", "COMMUTATION", "SELF_DIAGNOSTIC_MAIN", "SELF_DIAGNOSTIC_MANUAL", "CRASH", "analytics_binaryProdRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class CounterConfigurationReporterType {
    public static final CounterConfigurationReporterType COMMUTATION;
    public static final CounterConfigurationReporterType CRASH;
    public static final Companion Companion;
    public static final CounterConfigurationReporterType MAIN;
    public static final CounterConfigurationReporterType MANUAL;
    public static final CounterConfigurationReporterType SELF_DIAGNOSTIC_MAIN;
    public static final CounterConfigurationReporterType SELF_DIAGNOSTIC_MANUAL;
    public static final CounterConfigurationReporterType SELF_SDK;
    private static final /* synthetic */ CounterConfigurationReporterType[] b;
    private static final /* synthetic */ EnumEntries c;

    /* renamed from: a  reason: collision with root package name */
    private final String f1324a;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¨\u0006\u0006"}, d2 = {"Lio/appmetrica/analytics/internal/CounterConfigurationReporterType$Companion;", "", "", "value", "Lio/appmetrica/analytics/internal/CounterConfigurationReporterType;", "fromStringValue", "analytics_binaryProdRelease"}, k = 1, mv = {1, 9, 0})
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final CounterConfigurationReporterType fromStringValue(String str) {
            CounterConfigurationReporterType counterConfigurationReporterType;
            CounterConfigurationReporterType[] values = CounterConfigurationReporterType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    counterConfigurationReporterType = null;
                    break;
                }
                counterConfigurationReporterType = values[i];
                if (Intrinsics.areEqual(counterConfigurationReporterType.getStringValue(), str)) {
                    break;
                }
                i++;
            }
            return counterConfigurationReporterType == null ? CounterConfigurationReporterType.MAIN : counterConfigurationReporterType;
        }

        private Companion() {
        }
    }

    static {
        CounterConfigurationReporterType counterConfigurationReporterType = new CounterConfigurationReporterType(0, "MAIN", JvmProtoBufUtil.DEFAULT_MODULE_NAME);
        MAIN = counterConfigurationReporterType;
        CounterConfigurationReporterType counterConfigurationReporterType2 = new CounterConfigurationReporterType(1, "MANUAL", "manual");
        MANUAL = counterConfigurationReporterType2;
        CounterConfigurationReporterType counterConfigurationReporterType3 = new CounterConfigurationReporterType(2, "SELF_SDK", "self_sdk");
        SELF_SDK = counterConfigurationReporterType3;
        CounterConfigurationReporterType counterConfigurationReporterType4 = new CounterConfigurationReporterType(3, "COMMUTATION", "commutation");
        COMMUTATION = counterConfigurationReporterType4;
        CounterConfigurationReporterType counterConfigurationReporterType5 = new CounterConfigurationReporterType(4, "SELF_DIAGNOSTIC_MAIN", "self_diagnostic_main");
        SELF_DIAGNOSTIC_MAIN = counterConfigurationReporterType5;
        CounterConfigurationReporterType counterConfigurationReporterType6 = new CounterConfigurationReporterType(5, "SELF_DIAGNOSTIC_MANUAL", "self_diagnostic_manual");
        SELF_DIAGNOSTIC_MANUAL = counterConfigurationReporterType6;
        CounterConfigurationReporterType counterConfigurationReporterType7 = new CounterConfigurationReporterType(6, "CRASH", AppMeasurement.CRASH_ORIGIN);
        CRASH = counterConfigurationReporterType7;
        CounterConfigurationReporterType[] counterConfigurationReporterTypeArr = {counterConfigurationReporterType, counterConfigurationReporterType2, counterConfigurationReporterType3, counterConfigurationReporterType4, counterConfigurationReporterType5, counterConfigurationReporterType6, counterConfigurationReporterType7};
        b = counterConfigurationReporterTypeArr;
        c = EnumEntriesKt.enumEntries(counterConfigurationReporterTypeArr);
        Companion = new Companion(null);
    }

    private CounterConfigurationReporterType(int i, String str, String str2) {
        this.f1324a = str2;
    }

    @JvmStatic
    public static final CounterConfigurationReporterType fromStringValue(String str) {
        return Companion.fromStringValue(str);
    }

    public static EnumEntries<CounterConfigurationReporterType> getEntries() {
        return c;
    }

    public static CounterConfigurationReporterType valueOf(String str) {
        return (CounterConfigurationReporterType) Enum.valueOf(CounterConfigurationReporterType.class, str);
    }

    public static CounterConfigurationReporterType[] values() {
        return (CounterConfigurationReporterType[]) b.clone();
    }

    public final String getStringValue() {
        return this.f1324a;
    }
}
