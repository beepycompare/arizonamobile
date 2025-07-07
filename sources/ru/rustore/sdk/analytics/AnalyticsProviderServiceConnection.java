package ru.rustore.sdk.analytics;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.core.exception.RuStoreException;
import ru.vk.store.provider.analytics.AnalyticsProvider;
import ru.vk.store.provider.analytics.AnalyticsProviderCallback;
/* compiled from: AnalyticsProviderServiceConnection.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lru/rustore/sdk/analytics/AnalyticsProviderServiceConnection;", "Landroid/content/ServiceConnection;", "applicationId", "", "eventName", "eventData", "", "onSuccess", "Lkotlin/Function0;", "", "onError", "Lkotlin/Function1;", "Lru/rustore/sdk/core/exception/RuStoreException;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "onServiceConnected", "name", "Landroid/content/ComponentName;", NotificationCompat.CATEGORY_SERVICE, "Landroid/os/IBinder;", "onServiceDisconnected", "sdk-public-analytics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AnalyticsProviderServiceConnection implements ServiceConnection {
    private final String applicationId;
    private final Map<String, String> eventData;
    private final String eventName;
    private final Function1<RuStoreException, Unit> onError;
    private final Function0<Unit> onSuccess;

    /* JADX WARN: Multi-variable type inference failed */
    public AnalyticsProviderServiceConnection(String applicationId, String eventName, Map<String, String> eventData, Function0<Unit> onSuccess, Function1<? super RuStoreException, Unit> onError) {
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.applicationId = applicationId;
        this.eventName = eventName;
        this.eventData = eventData;
        this.onSuccess = onSuccess;
        this.onError = onError;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            AnalyticsProvider.Stub.asInterface(iBinder).postAnalytcsEvent(this.applicationId, this.eventName, MappingExtKt.toBundle(this.eventData), new AnalyticsProviderCallback.Stub() { // from class: ru.rustore.sdk.analytics.AnalyticsProviderServiceConnection$onServiceConnected$callback$1
                @Override // ru.vk.store.provider.analytics.AnalyticsProviderCallback
                public void onSuccess() {
                    Function0 function0;
                    function0 = AnalyticsProviderServiceConnection.this.onSuccess;
                    function0.invoke();
                }

                @Override // ru.vk.store.provider.analytics.AnalyticsProviderCallback
                public void onError(int i, String str) {
                    Function1 function1;
                    function1 = AnalyticsProviderServiceConnection.this.onError;
                    if (str == null) {
                        str = "";
                    }
                    function1.invoke(new RuStoreException(str));
                }
            });
        } catch (Exception e) {
            Function1<RuStoreException, Unit> function1 = this.onError;
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            function1.invoke(new RuStoreException(message));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.onError.invoke(new RuStoreException("onServiceDisconnected"));
    }
}
