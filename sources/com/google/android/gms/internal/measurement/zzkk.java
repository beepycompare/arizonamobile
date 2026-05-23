package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.util.Pair;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzkk extends GoogleApi {
    public static final /* synthetic */ int zza = 0;

    static {
        Pair.create(zzkm.zza(0L), Tasks.forResult(null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzkk(Context context) {
        super(context, zzjx.zza, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public final Task zza(final String str, int i, final String[] strArr, @Nullable byte[] bArr) {
        return doRead(TaskApiCall.builder().run(new RemoteCall(str, 0, strArr, null) { // from class: com.google.android.gms.internal.measurement.zzki
            private final /* synthetic */ String zza;
            private final /* synthetic */ String[] zzb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzb = strArr;
            }

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                int i2 = zzkk.zza;
                ((zzkt) ((zzku) obj).getService()).zze(new zzkj((TaskCompletionSource) obj2, null), this.zza, 0, this.zzb, null);
            }
        }).build());
    }

    public final Task zzb(final String str, String str2, @Nullable String str3) {
        return doRead(TaskApiCall.builder().run(new RemoteCall(str, "", null) { // from class: com.google.android.gms.internal.measurement.zzkb
            private final /* synthetic */ String zza;
            private final /* synthetic */ String zzb = "";

            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                int i = zzkk.zza;
                ((zzkt) ((zzku) obj).getService()).zzf(new zzkj((TaskCompletionSource) obj2, null), this.zza, this.zzb, null);
            }
        }).build());
    }

    public final Task zzc(final String str) {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.measurement.zzkc
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                int i = zzkk.zza;
                ((zzkt) ((zzku) obj).getService()).zzg(new zzkj((TaskCompletionSource) obj2, null), str);
            }
        }).build());
    }

    public final Task zzd(final zzme zzmeVar) {
        Preconditions.checkNotNull(zzmeVar);
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.measurement.zzkd
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                int i = zzkk.zza;
                ((zzkt) ((zzku) obj).getService()).zzh(new zzkj((TaskCompletionSource) obj2, null), zzme.this.zzcd());
            }
        }).setFeatures(zzjn.zza).setAutoResolveMissingFeatures(false).build()).continueWithTask(MoreExecutors.directExecutor(), new Continuation() { // from class: com.google.android.gms.internal.measurement.zzke
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                boolean z = task.getException() instanceof UnsupportedApiCallException;
                zzme zzmeVar2 = zzmeVar;
                zzkk zzkkVar = zzkk.this;
                if (z) {
                    return zzkkVar.zzc(zzmeVar2.zza());
                }
                return ((task.getException() instanceof ApiException) && ((ApiException) Preconditions.checkNotNull((ApiException) task.getException())).getStatusCode() == 29514) ? zzkkVar.zzc(zzmeVar2.zza()) : task;
            }
        });
    }

    public final Task zze() {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.measurement.zzkf
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                ((zzkt) ((zzku) obj).getService()).zzi(new zzjy(zzkk.this, (TaskCompletionSource) obj2));
            }
        }).setFeatures(zzjn.zzi).setAutoResolveMissingFeatures(false).build());
    }

    public final Task zzf(zzpm zzpmVar) {
        final String sb;
        final ListenerHolder registerListener = registerListener(zzpmVar, "zzku");
        String myProcessName = ProcessUtils.getMyProcessName();
        if (myProcessName == null) {
            sb = "__PH_INTERNAL__NO_PROCESS__";
        } else {
            int identityHashCode = System.identityHashCode(zzku.class);
            StringBuilder sb2 = new StringBuilder(myProcessName.length() + 1 + String.valueOf(identityHashCode).length());
            sb2.append(myProcessName);
            sb2.append("|");
            sb2.append(identityHashCode);
            sb = sb2.toString();
        }
        return doRegisterEventListener(RegistrationMethods.builder().withHolder(registerListener).register(new RemoteCall() { // from class: com.google.android.gms.internal.measurement.zzkg
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                ((zzkt) ((zzku) obj).getService()).zzj(sb, new zzka(zzkk.this, registerListener));
            }
        }).unregister(zzkh.zza).setFeatures(zzjn.zzd).setAutoResolveMissingFeatures(false).build());
    }
}
