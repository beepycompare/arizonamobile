package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdd;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzib;
import com.google.android.gms.measurement.internal.zzjg;
import com.google.android.gms.measurement.internal.zzjo;
import com.google.android.gms.measurement.internal.zzjp;
import com.google.android.gms.measurement.internal.zzlj;
import com.google.android.gms.measurement.internal.zzls;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
@Deprecated
/* loaded from: classes3.dex */
public class AppMeasurement {
    public static final String CRASH_ORIGIN = "crash";
    public static final String FCM_ORIGIN = "fcm";
    public static final String FIAM_ORIGIN = "fiam";
    private static volatile AppMeasurement zza;
    private final zzc zzb;

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
    /* loaded from: classes3.dex */
    public interface EventInterceptor extends zzjo {
        @Override // com.google.android.gms.measurement.internal.zzjo
        void interceptEvent(String str, String str2, Bundle bundle, long j);
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
    /* loaded from: classes3.dex */
    public interface OnEventListener extends zzjp {
        @Override // com.google.android.gms.measurement.internal.zzjp
        void onEvent(String str, String str2, Bundle bundle, long j);
    }

    public AppMeasurement(zzib zzibVar) {
        this.zzb = new zza(zzibVar);
    }

    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        zzlj zzljVar;
        if (zza == null) {
            synchronized (AppMeasurement.class) {
                if (zza == null) {
                    try {
                        zzljVar = (zzlj) Class.forName("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod("getScionFrontendApiImplementation", Context.class, Bundle.class).invoke(null, context, null);
                    } catch (ClassNotFoundException | Exception unused) {
                        zzljVar = null;
                    }
                    if (zzljVar == null) {
                        zza = new AppMeasurement(zzib.zzy(context, new zzdd(0L, 0L, true, null, null), null));
                    } else {
                        zza = new AppMeasurement(zzljVar);
                    }
                }
            }
        }
        return zza;
    }

    public void beginAdUnitExposure(String str) {
        this.zzb.zzm(str);
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zzb.zzp(str, str2, bundle);
    }

    public void endAdUnitExposure(String str) {
        this.zzb.zzn(str);
    }

    public long generateEventId() {
        return this.zzb.zzl();
    }

    public String getAppInstanceId() {
        return this.zzb.zzj();
    }

    public Boolean getBoolean() {
        return this.zzb.zzs();
    }

    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        List<Bundle> zzq = this.zzb.zzq(str, str2);
        ArrayList arrayList = new ArrayList(zzq == null ? 0 : zzq.size());
        for (Bundle bundle : zzq) {
            arrayList.add(new ConditionalUserProperty(bundle));
        }
        return arrayList;
    }

    public String getCurrentScreenClass() {
        return this.zzb.zzi();
    }

    public String getCurrentScreenName() {
        return this.zzb.zzh();
    }

    public Double getDouble() {
        return this.zzb.zzw();
    }

    public String getGmpAppId() {
        return this.zzb.zzk();
    }

    public Integer getInteger() {
        return this.zzb.zzt();
    }

    public Long getLong() {
        return this.zzb.zzv();
    }

    public int getMaxUserProperties(String str) {
        return this.zzb.zzr(str);
    }

    public String getString() {
        return this.zzb.zzu();
    }

    protected Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return this.zzb.zzd(str, str2, z);
    }

    public void logEventInternal(String str, String str2, Bundle bundle) {
        this.zzb.zza(str, str2, bundle);
    }

    public void logEventInternalNoInterceptor(String str, String str2, Bundle bundle, long j) {
        this.zzb.zzb(str, str2, bundle, j);
    }

    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zzb.zzf(onEventListener);
    }

    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        Bundle bundle = new Bundle();
        String str = conditionalUserProperty.mAppId;
        if (str != null) {
            bundle.putString("app_id", str);
        }
        String str2 = conditionalUserProperty.mOrigin;
        if (str2 != null) {
            bundle.putString("origin", str2);
        }
        String str3 = conditionalUserProperty.mName;
        if (str3 != null) {
            bundle.putString("name", str3);
        }
        Object obj = conditionalUserProperty.mValue;
        if (obj != null) {
            zzjg.zza(bundle, obj);
        }
        String str4 = conditionalUserProperty.mTriggerEventName;
        if (str4 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str4);
        }
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, conditionalUserProperty.mTriggerTimeout);
        String str5 = conditionalUserProperty.mTimedOutEventName;
        if (str5 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, str5);
        }
        Bundle bundle2 = conditionalUserProperty.mTimedOutEventParams;
        if (bundle2 != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, bundle2);
        }
        String str6 = conditionalUserProperty.mTriggeredEventName;
        if (str6 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, str6);
        }
        Bundle bundle3 = conditionalUserProperty.mTriggeredEventParams;
        if (bundle3 != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, bundle3);
        }
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, conditionalUserProperty.mTimeToLive);
        String str7 = conditionalUserProperty.mExpiredEventName;
        if (str7 != null) {
            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str7);
        }
        Bundle bundle4 = conditionalUserProperty.mExpiredEventParams;
        if (bundle4 != null) {
            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle4);
        }
        zzc zzcVar = this.zzb;
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, conditionalUserProperty.mCreationTimestamp);
        bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, conditionalUserProperty.mActive);
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, conditionalUserProperty.mTriggeredTimestamp);
        zzcVar.zzo(bundle);
    }

    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        this.zzb.zze(eventInterceptor);
    }

    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zzb.zzg(onEventListener);
    }

    public AppMeasurement(zzlj zzljVar) {
        this.zzb = new zzb(zzljVar);
    }

    public Map<String, Object> getUserProperties(boolean z) {
        return this.zzb.zzc(z);
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
    /* loaded from: classes3.dex */
    public static class ConditionalUserProperty {
        public boolean mActive;
        public String mAppId;
        public long mCreationTimestamp;
        public String mExpiredEventName;
        public Bundle mExpiredEventParams;
        public String mName;
        public String mOrigin;
        public long mTimeToLive;
        public String mTimedOutEventName;
        public Bundle mTimedOutEventParams;
        public String mTriggerEventName;
        public long mTriggerTimeout;
        public String mTriggeredEventName;
        public Bundle mTriggeredEventParams;
        public long mTriggeredTimestamp;
        public Object mValue;

        public ConditionalUserProperty() {
        }

        ConditionalUserProperty(Bundle bundle) {
            Preconditions.checkNotNull(bundle);
            this.mAppId = (String) zzjg.zzb(bundle, "app_id", String.class, null);
            this.mOrigin = (String) zzjg.zzb(bundle, "origin", String.class, null);
            this.mName = (String) zzjg.zzb(bundle, "name", String.class, null);
            this.mValue = zzjg.zzb(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
            this.mTriggerTimeout = ((Long) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L)).longValue();
            this.mTimedOutEventName = (String) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
            this.mTimedOutEventParams = (Bundle) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
            this.mTriggeredEventName = (String) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
            this.mTriggeredEventParams = (Bundle) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
            this.mTimeToLive = ((Long) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L)).longValue();
            this.mExpiredEventName = (String) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
            this.mExpiredEventParams = (Bundle) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
            this.mActive = ((Boolean) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.class, false)).booleanValue();
            this.mCreationTimestamp = ((Long) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.class, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.class, 0L)).longValue();
        }

        public ConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
            Preconditions.checkNotNull(conditionalUserProperty);
            this.mAppId = conditionalUserProperty.mAppId;
            this.mOrigin = conditionalUserProperty.mOrigin;
            this.mCreationTimestamp = conditionalUserProperty.mCreationTimestamp;
            this.mName = conditionalUserProperty.mName;
            Object obj = conditionalUserProperty.mValue;
            if (obj != null) {
                Object zzb = zzls.zzb(obj);
                this.mValue = zzb;
                if (zzb == null) {
                    this.mValue = conditionalUserProperty.mValue;
                }
            }
            this.mActive = conditionalUserProperty.mActive;
            this.mTriggerEventName = conditionalUserProperty.mTriggerEventName;
            this.mTriggerTimeout = conditionalUserProperty.mTriggerTimeout;
            this.mTimedOutEventName = conditionalUserProperty.mTimedOutEventName;
            Bundle bundle = conditionalUserProperty.mTimedOutEventParams;
            if (bundle != null) {
                this.mTimedOutEventParams = new Bundle(bundle);
            }
            this.mTriggeredEventName = conditionalUserProperty.mTriggeredEventName;
            Bundle bundle2 = conditionalUserProperty.mTriggeredEventParams;
            if (bundle2 != null) {
                this.mTriggeredEventParams = new Bundle(bundle2);
            }
            this.mTriggeredTimestamp = conditionalUserProperty.mTriggeredTimestamp;
            this.mTimeToLive = conditionalUserProperty.mTimeToLive;
            this.mExpiredEventName = conditionalUserProperty.mExpiredEventName;
            Bundle bundle3 = conditionalUserProperty.mExpiredEventParams;
            if (bundle3 != null) {
                this.mExpiredEventParams = new Bundle(bundle3);
            }
        }
    }
}
