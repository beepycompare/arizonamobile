package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.collection.ArraySet;
import androidx.media3.exoplayer.Renderer;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLogging;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;
/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes3.dex */
public class GoogleApiManager implements Handler.Callback {
    public static final Status zaa = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status zab = new Status(4, "The user must be signed in to make this API call.");
    private static final Object zac = new Object();
    private static GoogleApiManager zad;
    private TelemetryData zag;
    private TelemetryLoggingClient zah;
    private final Context zai;
    private final GoogleApiAvailability zaj;
    private final com.google.android.gms.common.internal.zal zak;
    @NotOnlyInitialized
    private final Handler zar;
    private volatile boolean zas;
    private long zae = Renderer.DEFAULT_DURATION_TO_PROGRESS_US;
    private boolean zaf = false;
    private final AtomicInteger zal = new AtomicInteger(1);
    private final AtomicInteger zam = new AtomicInteger(0);
    private final Map zan = new ConcurrentHashMap(5, 0.75f, 1);
    private zaae zao = null;
    private final Set zap = new ArraySet();
    private final Set zaq = new ArraySet();

    private GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.zas = true;
        this.zai = context;
        com.google.android.gms.internal.base.zau zauVar = new com.google.android.gms.internal.base.zau(looper, this);
        this.zar = zauVar;
        this.zaj = googleApiAvailability;
        this.zak = new com.google.android.gms.common.internal.zal(googleApiAvailability);
        if (DeviceProperties.isAuto(context)) {
            this.zas = false;
        }
        zauVar.sendMessage(zauVar.obtainMessage(6));
    }

    public static void reportSignOut() {
        synchronized (zac) {
            GoogleApiManager googleApiManager = zad;
            if (googleApiManager != null) {
                googleApiManager.zam.incrementAndGet();
                Handler handler = googleApiManager.zar;
                handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status zaF(ApiKey apiKey, ConnectionResult connectionResult) {
        String zaa2 = apiKey.zaa();
        String valueOf = String.valueOf(connectionResult);
        return new Status(connectionResult, "API: " + zaa2 + " is not available on this device. Connection failed with: " + valueOf);
    }

    @ResultIgnorabilityUnspecified
    private final zabq zaG(GoogleApi googleApi) {
        Map map = this.zan;
        ApiKey apiKey = googleApi.getApiKey();
        zabq zabqVar = (zabq) map.get(apiKey);
        if (zabqVar == null) {
            zabqVar = new zabq(this, googleApi);
            this.zan.put(apiKey, zabqVar);
        }
        if (zabqVar.zaA()) {
            this.zaq.add(apiKey);
        }
        zabqVar.zao();
        return zabqVar;
    }

    private final TelemetryLoggingClient zaH() {
        if (this.zah == null) {
            this.zah = TelemetryLogging.getClient(this.zai);
        }
        return this.zah;
    }

    private final void zaI() {
        TelemetryData telemetryData = this.zag;
        if (telemetryData != null) {
            if (telemetryData.zaa() > 0 || zaD()) {
                zaH().log(telemetryData);
            }
            this.zag = null;
        }
    }

    private final void zaJ(TaskCompletionSource taskCompletionSource, int i, GoogleApi googleApi) {
        zacd zaa2;
        if (i == 0 || (zaa2 = zacd.zaa(this, i, googleApi.getApiKey())) == null) {
            return;
        }
        Task task = taskCompletionSource.getTask();
        final Handler handler = this.zar;
        handler.getClass();
        task.addOnCompleteListener(new Executor() { // from class: com.google.android.gms.common.api.internal.zabk
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, zaa2);
    }

    public static GoogleApiManager zaj() {
        GoogleApiManager googleApiManager;
        synchronized (zac) {
            Preconditions.checkNotNull(zad, "Must guarantee manager is non-null before using getInstance");
            googleApiManager = zad;
        }
        return googleApiManager;
    }

    @ResultIgnorabilityUnspecified
    public static GoogleApiManager zak(Context context) {
        GoogleApiManager googleApiManager;
        synchronized (zac) {
            if (zad == null) {
                zad = new GoogleApiManager(context.getApplicationContext(), GmsClientSupervisor.getOrStartHandlerThread().getLooper(), GoogleApiAvailability.getInstance());
            }
            googleApiManager = zad;
        }
        return googleApiManager;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        zabq zabqVar;
        ApiKey apiKey;
        ApiKey apiKey2;
        ApiKey apiKey3;
        ApiKey apiKey4;
        switch (message.what) {
            case 1:
                this.zae = true == ((Boolean) message.obj).booleanValue() ? Renderer.DEFAULT_DURATION_TO_PROGRESS_US : 300000L;
                this.zar.removeMessages(12);
                for (ApiKey apiKey5 : this.zan.keySet()) {
                    Handler handler = this.zar;
                    handler.sendMessageDelayed(handler.obtainMessage(12, apiKey5), this.zae);
                }
                break;
            case 2:
                zal zalVar = (zal) message.obj;
                Iterator it = zalVar.zab().iterator();
                while (true) {
                    if (it.hasNext()) {
                        ApiKey apiKey6 = (ApiKey) it.next();
                        zabq zabqVar2 = (zabq) this.zan.get(apiKey6);
                        if (zabqVar2 != null) {
                            if (zabqVar2.zaz()) {
                                zalVar.zac(apiKey6, ConnectionResult.RESULT_SUCCESS, zabqVar2.zaf().getEndpointPackageName());
                            } else {
                                ConnectionResult zad2 = zabqVar2.zad();
                                if (zad2 != null) {
                                    zalVar.zac(apiKey6, zad2, null);
                                } else {
                                    zabqVar2.zat(zalVar);
                                    zabqVar2.zao();
                                }
                            }
                        } else {
                            zalVar.zac(apiKey6, new ConnectionResult(13), null);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            case 3:
                for (zabq zabqVar3 : this.zan.values()) {
                    zabqVar3.zan();
                    zabqVar3.zao();
                }
                break;
            case 4:
            case 8:
            case 13:
                zach zachVar = (zach) message.obj;
                zabq zabqVar4 = (zabq) this.zan.get(zachVar.zac.getApiKey());
                if (zabqVar4 == null) {
                    zabqVar4 = zaG(zachVar.zac);
                }
                if (!zabqVar4.zaA() || this.zam.get() == zachVar.zab) {
                    zabqVar4.zap(zachVar.zaa);
                    break;
                } else {
                    zachVar.zaa.zad(zaa);
                    zabqVar4.zav();
                    break;
                }
                break;
            case 5:
                int i = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator it2 = this.zan.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        zabq zabqVar5 = (zabq) it2.next();
                        zabqVar = zabqVar5.zab() == i ? zabqVar5 : null;
                    }
                }
                if (zabqVar == null) {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i + " while trying to fail enqueued calls.", new Exception());
                    break;
                } else if (connectionResult.getErrorCode() == 13) {
                    String errorString = this.zaj.getErrorString(connectionResult.getErrorCode());
                    String errorMessage = connectionResult.getErrorMessage();
                    zabq.zai(zabqVar, new Status(17, "Error resolution was canceled by the user, original error message: " + errorString + ": " + errorMessage));
                    break;
                } else {
                    zabq.zai(zabqVar, zaF(zabq.zag(zabqVar), connectionResult));
                    break;
                }
            case 6:
                if (this.zai.getApplicationContext() instanceof Application) {
                    BackgroundDetector.initialize((Application) this.zai.getApplicationContext());
                    BackgroundDetector.getInstance().addListener(new zabl(this));
                    if (!BackgroundDetector.getInstance().readCurrentStateIfPossible(true)) {
                        this.zae = 300000L;
                        break;
                    }
                }
                break;
            case 7:
                zaG((GoogleApi) message.obj);
                break;
            case 9:
                if (this.zan.containsKey(message.obj)) {
                    ((zabq) this.zan.get(message.obj)).zau();
                    break;
                }
                break;
            case 10:
                for (ApiKey apiKey7 : this.zaq) {
                    zabq zabqVar6 = (zabq) this.zan.remove(apiKey7);
                    if (zabqVar6 != null) {
                        zabqVar6.zav();
                    }
                }
                this.zaq.clear();
                break;
            case 11:
                if (this.zan.containsKey(message.obj)) {
                    ((zabq) this.zan.get(message.obj)).zaw();
                    break;
                }
                break;
            case 12:
                if (this.zan.containsKey(message.obj)) {
                    ((zabq) this.zan.get(message.obj)).zaB();
                    break;
                }
                break;
            case 14:
                zaaf zaafVar = (zaaf) message.obj;
                ApiKey zaa2 = zaafVar.zaa();
                if (!this.zan.containsKey(zaa2)) {
                    zaafVar.zab().setResult(false);
                    break;
                } else {
                    zaafVar.zab().setResult(Boolean.valueOf(zabq.zay((zabq) this.zan.get(zaa2), false)));
                    break;
                }
            case 15:
                zabs zabsVar = (zabs) message.obj;
                Map map = this.zan;
                apiKey = zabsVar.zaa;
                if (map.containsKey(apiKey)) {
                    Map map2 = this.zan;
                    apiKey2 = zabsVar.zaa;
                    zabq.zal((zabq) map2.get(apiKey2), zabsVar);
                    break;
                }
                break;
            case 16:
                zabs zabsVar2 = (zabs) message.obj;
                Map map3 = this.zan;
                apiKey3 = zabsVar2.zaa;
                if (map3.containsKey(apiKey3)) {
                    Map map4 = this.zan;
                    apiKey4 = zabsVar2.zaa;
                    zabq.zam((zabq) map4.get(apiKey4), zabsVar2);
                    break;
                }
                break;
            case 17:
                zaI();
                break;
            case 18:
                zace zaceVar = (zace) message.obj;
                if (zaceVar.zac == 0) {
                    zaH().log(new TelemetryData(zaceVar.zab, Arrays.asList(zaceVar.zaa)));
                    break;
                } else {
                    TelemetryData telemetryData = this.zag;
                    if (telemetryData != null) {
                        List zab2 = telemetryData.zab();
                        if (telemetryData.zaa() == zaceVar.zab && (zab2 == null || zab2.size() < zaceVar.zad)) {
                            this.zag.zac(zaceVar.zaa);
                        } else {
                            this.zar.removeMessages(17);
                            zaI();
                        }
                    }
                    if (this.zag == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(zaceVar.zaa);
                        this.zag = new TelemetryData(zaceVar.zab, arrayList);
                        Handler handler2 = this.zar;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), zaceVar.zac);
                        break;
                    }
                }
                break;
            case 19:
                this.zaf = false;
                break;
            default:
                int i2 = message.what;
                Log.w("GoogleApiManager", "Unknown message id: " + i2);
                return false;
        }
        return true;
    }

    public final void zaA(zaae zaaeVar) {
        synchronized (zac) {
            if (this.zao != zaaeVar) {
                this.zao = zaaeVar;
                this.zap.clear();
            }
            this.zap.addAll(zaaeVar.zaa());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zaB(zaae zaaeVar) {
        synchronized (zac) {
            if (this.zao == zaaeVar) {
                this.zao = null;
                this.zap.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zaD() {
        if (this.zaf) {
            return false;
        }
        RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
        if (config == null || config.getMethodInvocationTelemetryEnabled()) {
            int zaa2 = this.zak.zaa(this.zai, 203400000);
            return zaa2 == -1 || zaa2 == 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @ResultIgnorabilityUnspecified
    public final boolean zaE(ConnectionResult connectionResult, int i) {
        return this.zaj.zah(this.zai, connectionResult, i);
    }

    public final int zaa() {
        return this.zal.getAndIncrement();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zabq zai(ApiKey apiKey) {
        return (zabq) this.zan.get(apiKey);
    }

    public final Task zam(Iterable iterable) {
        zal zalVar = new zal(iterable);
        this.zar.sendMessage(this.zar.obtainMessage(2, zalVar));
        return zalVar.zaa();
    }

    @ResultIgnorabilityUnspecified
    public final Task zan(GoogleApi googleApi) {
        zaaf zaafVar = new zaaf(googleApi.getApiKey());
        this.zar.sendMessage(this.zar.obtainMessage(14, zaafVar));
        return zaafVar.zab().getTask();
    }

    public final Task zao(GoogleApi googleApi, RegisterListenerMethod registerListenerMethod, UnregisterListenerMethod unregisterListenerMethod, Runnable runnable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zaJ(taskCompletionSource, registerListenerMethod.zaa(), googleApi);
        this.zar.sendMessage(this.zar.obtainMessage(8, new zach(new zaf(new zaci(registerListenerMethod, unregisterListenerMethod, runnable), taskCompletionSource), this.zam.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final Task zap(GoogleApi googleApi, ListenerHolder.ListenerKey listenerKey, int i) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zaJ(taskCompletionSource, i, googleApi);
        this.zar.sendMessage(this.zar.obtainMessage(13, new zach(new zah(listenerKey, taskCompletionSource), this.zam.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final void zau(GoogleApi googleApi, int i, BaseImplementation.ApiMethodImpl apiMethodImpl) {
        this.zar.sendMessage(this.zar.obtainMessage(4, new zach(new zae(i, apiMethodImpl), this.zam.get(), googleApi)));
    }

    public final void zav(GoogleApi googleApi, int i, TaskApiCall taskApiCall, TaskCompletionSource taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        zaJ(taskCompletionSource, taskApiCall.zaa(), googleApi);
        this.zar.sendMessage(this.zar.obtainMessage(4, new zach(new zag(i, taskApiCall, taskCompletionSource, statusExceptionMapper), this.zam.get(), googleApi)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zaw(MethodInvocation methodInvocation, int i, long j, int i2) {
        this.zar.sendMessage(this.zar.obtainMessage(18, new zace(methodInvocation, i, j, i2)));
    }

    public final void zax(ConnectionResult connectionResult, int i) {
        if (zaE(connectionResult, i)) {
            return;
        }
        Handler handler = this.zar;
        handler.sendMessage(handler.obtainMessage(5, i, 0, connectionResult));
    }

    public final void zay() {
        Handler handler = this.zar;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void zaz(GoogleApi googleApi) {
        Handler handler = this.zar;
        handler.sendMessage(handler.obtainMessage(7, googleApi));
    }
}
