package com.google.firebase.analytics.connector;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzjg;
import com.google.android.gms.measurement.internal.zzls;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zzc;
import com.google.firebase.analytics.connector.internal.zze;
import com.google.firebase.analytics.connector.internal.zzg;
import com.google.firebase.events.Event;
import com.google.firebase.events.Subscriber;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: com.google.android.gms:play-services-measurement-api@@22.5.0 */
/* loaded from: classes4.dex */
public class AnalyticsConnectorImpl implements AnalyticsConnector {
    private static volatile AnalyticsConnector zzc;
    final AppMeasurementSdk zza;
    final Map zzb;

    AnalyticsConnectorImpl(AppMeasurementSdk appMeasurementSdk) {
        Preconditions.checkNotNull(appMeasurementSdk);
        this.zza = appMeasurementSdk;
        this.zzb = new ConcurrentHashMap();
    }

    public static AnalyticsConnector getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(Event event) {
        boolean z = ((DataCollectionDefaultChange) event.getPayload()).enabled;
        synchronized (AnalyticsConnectorImpl.class) {
            ((AnalyticsConnectorImpl) Preconditions.checkNotNull(zzc)).zza.zza(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzc */
    public final boolean zzb(String str) {
        if (str.isEmpty()) {
            return false;
        }
        Map map = this.zzb;
        return map.containsKey(str) && map.get(str) != null;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        if (str2 == null || zzc.zzb(str2, bundle)) {
            this.zza.clearConditionalUserProperty(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public List<AnalyticsConnector.ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : this.zza.getConditionalUserProperties(str, str2)) {
            int i = zzc.zza;
            Preconditions.checkNotNull(bundle);
            AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
            conditionalUserProperty.origin = (String) Preconditions.checkNotNull((String) zzjg.zzb(bundle, "origin", String.class, null));
            conditionalUserProperty.name = (String) Preconditions.checkNotNull((String) zzjg.zzb(bundle, "name", String.class, null));
            conditionalUserProperty.value = zzjg.zzb(bundle, "value", Object.class, null);
            conditionalUserProperty.triggerEventName = (String) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
            conditionalUserProperty.triggerTimeout = ((Long) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L)).longValue();
            conditionalUserProperty.timedOutEventName = (String) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
            conditionalUserProperty.timedOutEventParams = (Bundle) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
            conditionalUserProperty.triggeredEventName = (String) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
            conditionalUserProperty.triggeredEventParams = (Bundle) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
            conditionalUserProperty.timeToLive = ((Long) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L)).longValue();
            conditionalUserProperty.expiredEventName = (String) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
            conditionalUserProperty.expiredEventParams = (Bundle) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
            conditionalUserProperty.active = ((Boolean) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.class, false)).booleanValue();
            conditionalUserProperty.creationTimestamp = ((Long) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.class, 0L)).longValue();
            conditionalUserProperty.triggeredTimestamp = ((Long) zzjg.zzb(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.class, 0L)).longValue();
            arrayList.add(conditionalUserProperty);
        }
        return arrayList;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public int getMaxUserProperties(String str) {
        return this.zza.getMaxUserProperties(str);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public Map<String, Object> getUserProperties(boolean z) {
        return this.zza.getUserProperties(null, null, z);
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void logEvent(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (zzc.zza(str) && zzc.zzb(str2, bundle) && zzc.zze(str, str2, bundle)) {
            if ("clx".equals(str) && "_ae".equals(str2)) {
                bundle.putLong("_r", 1L);
            }
            this.zza.logEvent(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public AnalyticsConnector.AnalyticsConnectorHandle registerAnalyticsConnectorListener(final String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        com.google.firebase.analytics.connector.internal.zza zzgVar;
        Preconditions.checkNotNull(analyticsConnectorListener);
        if (zzc.zza(str) && !zzb(str)) {
            AppMeasurementSdk appMeasurementSdk = this.zza;
            if ("fiam".equals(str)) {
                zzgVar = new zze(appMeasurementSdk, analyticsConnectorListener);
            } else {
                zzgVar = "clx".equals(str) ? new zzg(appMeasurementSdk, analyticsConnectorListener) : null;
            }
            if (zzgVar != null) {
                this.zzb.put(str, zzgVar);
                return new AnalyticsConnector.AnalyticsConnectorHandle(this) { // from class: com.google.firebase.analytics.connector.AnalyticsConnectorImpl.1
                    final /* synthetic */ AnalyticsConnectorImpl zzb;

                    {
                        Objects.requireNonNull(this);
                        this.zzb = this;
                    }

                    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
                    public void registerEventNames(Set<String> set) {
                        AnalyticsConnectorImpl analyticsConnectorImpl = this.zzb;
                        String str2 = str;
                        if (!analyticsConnectorImpl.zzb(str2) || !str2.equals("fiam") || set == null || set.isEmpty()) {
                            return;
                        }
                        ((com.google.firebase.analytics.connector.internal.zza) analyticsConnectorImpl.zzb.get(str2)).zzb(set);
                    }

                    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
                    public final void unregister() {
                        AnalyticsConnectorImpl analyticsConnectorImpl = this.zzb;
                        String str2 = str;
                        if (analyticsConnectorImpl.zzb(str2)) {
                            Map map = analyticsConnectorImpl.zzb;
                            AnalyticsConnector.AnalyticsConnectorListener zza = ((com.google.firebase.analytics.connector.internal.zza) map.get(str2)).zza();
                            if (zza != null) {
                                zza.onMessageTriggered(0, null);
                            }
                            map.remove(str2);
                        }
                    }

                    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorHandle
                    public void unregisterEventNames() {
                        AnalyticsConnectorImpl analyticsConnectorImpl = this.zzb;
                        String str2 = str;
                        if (analyticsConnectorImpl.zzb(str2) && str2.equals("fiam")) {
                            ((com.google.firebase.analytics.connector.internal.zza) analyticsConnectorImpl.zzb.get(str2)).zzc();
                        }
                    }
                };
            }
        }
        return null;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setConditionalUserProperty(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        String str;
        int i = zzc.zza;
        if (conditionalUserProperty == null || (str = conditionalUserProperty.origin) == null || str.isEmpty()) {
            return;
        }
        if ((conditionalUserProperty.value == null || zzls.zzb(conditionalUserProperty.value) != null) && zzc.zza(str) && zzc.zzd(str, conditionalUserProperty.name)) {
            if (conditionalUserProperty.expiredEventName == null || (zzc.zzb(conditionalUserProperty.expiredEventName, conditionalUserProperty.expiredEventParams) && zzc.zze(str, conditionalUserProperty.expiredEventName, conditionalUserProperty.expiredEventParams))) {
                if (conditionalUserProperty.triggeredEventName == null || (zzc.zzb(conditionalUserProperty.triggeredEventName, conditionalUserProperty.triggeredEventParams) && zzc.zze(str, conditionalUserProperty.triggeredEventName, conditionalUserProperty.triggeredEventParams))) {
                    if (conditionalUserProperty.timedOutEventName == null || (zzc.zzb(conditionalUserProperty.timedOutEventName, conditionalUserProperty.timedOutEventParams) && zzc.zze(str, conditionalUserProperty.timedOutEventName, conditionalUserProperty.timedOutEventParams))) {
                        AppMeasurementSdk appMeasurementSdk = this.zza;
                        Bundle bundle = new Bundle();
                        if (conditionalUserProperty.origin != null) {
                            bundle.putString("origin", conditionalUserProperty.origin);
                        }
                        if (conditionalUserProperty.name != null) {
                            bundle.putString("name", conditionalUserProperty.name);
                        }
                        if (conditionalUserProperty.value != null) {
                            zzjg.zza(bundle, conditionalUserProperty.value);
                        }
                        if (conditionalUserProperty.triggerEventName != null) {
                            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, conditionalUserProperty.triggerEventName);
                        }
                        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, conditionalUserProperty.triggerTimeout);
                        if (conditionalUserProperty.timedOutEventName != null) {
                            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, conditionalUserProperty.timedOutEventName);
                        }
                        if (conditionalUserProperty.timedOutEventParams != null) {
                            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, conditionalUserProperty.timedOutEventParams);
                        }
                        if (conditionalUserProperty.triggeredEventName != null) {
                            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, conditionalUserProperty.triggeredEventName);
                        }
                        if (conditionalUserProperty.triggeredEventParams != null) {
                            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, conditionalUserProperty.triggeredEventParams);
                        }
                        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, conditionalUserProperty.timeToLive);
                        if (conditionalUserProperty.expiredEventName != null) {
                            bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, conditionalUserProperty.expiredEventName);
                        }
                        if (conditionalUserProperty.expiredEventParams != null) {
                            bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, conditionalUserProperty.expiredEventParams);
                        }
                        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, conditionalUserProperty.creationTimestamp);
                        bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, conditionalUserProperty.active);
                        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, conditionalUserProperty.triggeredTimestamp);
                        appMeasurementSdk.setConditionalUserProperty(bundle);
                    }
                }
            }
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    public void setUserProperty(String str, String str2, Object obj) {
        if (zzc.zza(str) && zzc.zzd(str, str2)) {
            this.zza.setUserProperty(str, str2, obj);
        }
    }

    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp) {
        return (AnalyticsConnector) firebaseApp.get(AnalyticsConnector.class);
    }

    public static AnalyticsConnector getInstance(FirebaseApp firebaseApp, Context context, Subscriber subscriber) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(subscriber);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzc == null) {
            synchronized (AnalyticsConnectorImpl.class) {
                if (zzc == null) {
                    Bundle bundle = new Bundle(1);
                    if (firebaseApp.isDefaultApp()) {
                        subscriber.subscribe(DataCollectionDefaultChange.class, zzb.zza, zza.zza);
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.isDataCollectionDefaultEnabled());
                    }
                    zzc = new AnalyticsConnectorImpl(zzfb.zza(context, bundle).zzb());
                }
            }
        }
        return zzc;
    }
}
