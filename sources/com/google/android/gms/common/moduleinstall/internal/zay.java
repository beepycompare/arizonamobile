package com.google.android.gms.common.moduleinstall.internal;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.moduleinstall.InstallStatusListener;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallClient;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallRequest;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
public final class zay extends GoogleApi implements ModuleInstallClient {
    public static final /* synthetic */ int zab = 0;
    private static final Api.ClientKey zac;
    private static final Api.AbstractClientBuilder zad;
    private static final Api zae;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zac = clientKey;
        zai zaiVar = new zai();
        zad = zaiVar;
        zae = new Api("ModuleInstall.API", zaiVar, clientKey);
    }

    public zay(Activity activity) {
        super(activity, (Api<Api.ApiOptions.NoOptions>) zae, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    static final ApiFeatureRequest zad(boolean z, OptionalModuleApi... optionalModuleApiArr) {
        Preconditions.checkNotNull(optionalModuleApiArr, "Requested APIs must not be null.");
        Preconditions.checkArgument(optionalModuleApiArr.length > 0, "Please provide at least one OptionalModuleApi.");
        for (OptionalModuleApi optionalModuleApi : optionalModuleApiArr) {
            Preconditions.checkNotNull(optionalModuleApi, "Requested API must not be null.");
        }
        return ApiFeatureRequest.zaa(Arrays.asList(optionalModuleApiArr), z);
    }

    @Override // com.google.android.gms.common.moduleinstall.ModuleInstallClient
    public final Task<ModuleAvailabilityResponse> areModulesAvailable(OptionalModuleApi... optionalModuleApiArr) {
        final ApiFeatureRequest zad2 = zad(false, optionalModuleApiArr);
        if (zad2.getApiFeatures().isEmpty()) {
            return Tasks.forResult(new ModuleAvailabilityResponse(true, 0));
        }
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.setFeatures(com.google.android.gms.internal.base.zap.zaa);
        builder.setMethodKey(27301);
        builder.setAutoResolveMissingFeatures(false);
        builder.run(new RemoteCall() { // from class: com.google.android.gms.common.moduleinstall.internal.zax
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                ((zaf) ((zaz) obj).getService()).zae(new zaj(zay.this, (TaskCompletionSource) obj2), zad2);
            }
        });
        return doRead(builder.build());
    }

    @Override // com.google.android.gms.common.moduleinstall.ModuleInstallClient
    public final Task<Void> deferredInstall(OptionalModuleApi... optionalModuleApiArr) {
        final ApiFeatureRequest zad2 = zad(false, optionalModuleApiArr);
        if (zad2.getApiFeatures().isEmpty()) {
            return Tasks.forResult(null);
        }
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.setFeatures(com.google.android.gms.internal.base.zap.zaa);
        builder.setMethodKey(27302);
        builder.setAutoResolveMissingFeatures(false);
        builder.run(new RemoteCall() { // from class: com.google.android.gms.common.moduleinstall.internal.zaq
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                ((zaf) ((zaz) obj).getService()).zaf(new zak(zay.this, (TaskCompletionSource) obj2), zad2, null);
            }
        });
        return doRead(builder.build());
    }

    @Override // com.google.android.gms.common.moduleinstall.ModuleInstallClient
    public final Task<ModuleInstallIntentResponse> getInstallModulesIntent(OptionalModuleApi... optionalModuleApiArr) {
        final ApiFeatureRequest zad2 = zad(true, optionalModuleApiArr);
        if (zad2.getApiFeatures().isEmpty()) {
            return Tasks.forResult(new ModuleInstallIntentResponse(null));
        }
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.setFeatures(com.google.android.gms.internal.base.zap.zaa);
        builder.setMethodKey(27307);
        builder.run(new RemoteCall() { // from class: com.google.android.gms.common.moduleinstall.internal.zav
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                ((zaf) ((zaz) obj).getService()).zag(new zao(zay.this, (TaskCompletionSource) obj2), zad2);
            }
        });
        return doRead(builder.build());
    }

    @Override // com.google.android.gms.common.moduleinstall.ModuleInstallClient
    public final Task<ModuleInstallResponse> installModules(ModuleInstallRequest moduleInstallRequest) {
        ListenerHolder createListenerHolder;
        final ApiFeatureRequest fromModuleInstallRequest = ApiFeatureRequest.fromModuleInstallRequest(moduleInstallRequest);
        final InstallStatusListener listener = moduleInstallRequest.getListener();
        Executor listenerExecutor = moduleInstallRequest.getListenerExecutor();
        if (fromModuleInstallRequest.getApiFeatures().isEmpty()) {
            return Tasks.forResult(new ModuleInstallResponse(0));
        }
        if (listener == null) {
            TaskApiCall.Builder builder = TaskApiCall.builder();
            builder.setFeatures(com.google.android.gms.internal.base.zap.zaa);
            builder.setAutoResolveMissingFeatures(true);
            builder.setMethodKey(27304);
            builder.run(new RemoteCall() { // from class: com.google.android.gms.common.moduleinstall.internal.zar
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final /* synthetic */ void accept(Object obj, Object obj2) {
                    ((zaf) ((zaz) obj).getService()).zaf(new zal(zay.this, (TaskCompletionSource) obj2), fromModuleInstallRequest, null);
                }
            });
            return doRead(builder.build());
        }
        Preconditions.checkNotNull(listener);
        if (listenerExecutor == null) {
            createListenerHolder = registerListener(listener, "InstallStatusListener");
        } else {
            createListenerHolder = ListenerHolders.createListenerHolder(listener, listenerExecutor, "InstallStatusListener");
        }
        final zaab zaabVar = new zaab(createListenerHolder);
        final AtomicReference atomicReference = new AtomicReference();
        RemoteCall remoteCall = new RemoteCall() { // from class: com.google.android.gms.common.moduleinstall.internal.zas
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                ((zaf) ((zaz) obj).getService()).zaf(new zam(zay.this, atomicReference, (TaskCompletionSource) obj2, listener), fromModuleInstallRequest, zaabVar);
            }
        };
        RemoteCall remoteCall2 = new RemoteCall() { // from class: com.google.android.gms.common.moduleinstall.internal.zat
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                ((zaf) ((zaz) obj).getService()).zai(new zan(zay.this, (TaskCompletionSource) obj2), zaabVar);
            }
        };
        RegistrationMethods.Builder builder2 = RegistrationMethods.builder();
        builder2.withHolder(createListenerHolder);
        builder2.setFeatures(com.google.android.gms.internal.base.zap.zaa);
        builder2.setAutoResolveMissingFeatures(true);
        builder2.register(remoteCall);
        builder2.unregister(remoteCall2);
        builder2.setMethodKey(27305);
        return doRegisterEventListener(builder2.build()).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.gms.common.moduleinstall.internal.zau
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final /* synthetic */ Task then(Object obj) {
                Void r1 = (Void) obj;
                int i = zay.zab;
                AtomicReference atomicReference2 = atomicReference;
                if (atomicReference2.get() != null) {
                    return Tasks.forResult((ModuleInstallResponse) atomicReference2.get());
                }
                return Tasks.forException(new ApiException(Status.RESULT_INTERNAL_ERROR));
            }
        });
    }

    @Override // com.google.android.gms.common.moduleinstall.ModuleInstallClient
    public final Task<Void> releaseModules(OptionalModuleApi... optionalModuleApiArr) {
        final ApiFeatureRequest zad2 = zad(false, optionalModuleApiArr);
        if (zad2.getApiFeatures().isEmpty()) {
            return Tasks.forResult(null);
        }
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.setFeatures(com.google.android.gms.internal.base.zap.zaa);
        builder.setMethodKey(27303);
        builder.setAutoResolveMissingFeatures(false);
        builder.run(new RemoteCall() { // from class: com.google.android.gms.common.moduleinstall.internal.zaw
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                ((zaf) ((zaz) obj).getService()).zah(new zap(zay.this, (TaskCompletionSource) obj2), zad2);
            }
        });
        return doRead(builder.build());
    }

    @Override // com.google.android.gms.common.moduleinstall.ModuleInstallClient
    public final Task<Boolean> unregisterListener(InstallStatusListener installStatusListener) {
        return doUnregisterEventListener(ListenerHolders.createListenerKey(installStatusListener, "InstallStatusListener"), 27306);
    }

    public zay(Context context) {
        super(context, zae, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
