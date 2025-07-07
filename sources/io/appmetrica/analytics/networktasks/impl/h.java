package io.appmetrica.analytics.networktasks.impl;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.network.internal.NetworkClient;
import io.appmetrica.analytics.network.internal.Request;
import io.appmetrica.analytics.network.internal.Response;
import io.appmetrica.analytics.networktasks.internal.ExponentialBackoffPolicy;
import io.appmetrica.analytics.networktasks.internal.NetworkTask;
import io.appmetrica.analytics.networktasks.internal.RequestDataHolder;
import io.appmetrica.analytics.networktasks.internal.ResponseDataHolder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* loaded from: classes4.dex */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final NetworkTask f1228a;
    public final InterruptionSafeThread b;
    public final f c;

    public h(NetworkTask networkTask, InterruptionSafeThread interruptionSafeThread, f fVar) {
        this.f1228a = networkTask;
        this.b = interruptionSafeThread;
        this.c = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        byte[] postData;
        ExponentialBackoffPolicy exponentialBackoffPolicy = this.f1228a.getExponentialBackoffPolicy();
        boolean canBeExecuted = this.f1228a.getConnectionExecutionPolicy().canBeExecuted();
        boolean canBeExecuted2 = this.f1228a.getExponentialBackoffPolicy().canBeExecuted(this.f1228a.getRetryPolicyConfig());
        if (this.b.isRunning() && canBeExecuted && canBeExecuted2) {
            boolean onCreateNetworkTask = this.f1228a.onCreateNetworkTask();
            Boolean bool = null;
            while (this.b.isRunning() && onCreateNetworkTask && exponentialBackoffPolicy.canBeExecuted(this.f1228a.getRetryPolicyConfig())) {
                f fVar = this.c;
                NetworkTask networkTask = this.f1228a;
                fVar.getClass();
                if (networkTask.onPerformRequest()) {
                    String url = networkTask.getUrl();
                    if (url != null && !TextUtils.isEmpty(StringsKt.trim((CharSequence) url).toString())) {
                        Request.Builder addHeader = new Request.Builder(url).addHeader(HttpHeaders.ACCEPT, "application/json").addHeader("User-Agent", networkTask.getUserAgent());
                        RequestDataHolder requestDataHolder = networkTask.getRequestDataHolder();
                        Iterator<T> it = requestDataHolder.getHeaders().entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            addHeader.addHeader((String) entry.getKey(), CollectionsKt.joinToString$default((Iterable) entry.getValue(), StringUtils.COMMA, null, null, 0, null, null, 62, null));
                        }
                        if (NetworkTask.Method.POST == requestDataHolder.getMethod() && (postData = requestDataHolder.getPostData()) != null) {
                            if (!(postData.length == 0)) {
                                addHeader.post(postData);
                                Long sendTimestamp = requestDataHolder.getSendTimestamp();
                                if (sendTimestamp != null) {
                                    addHeader.addHeader("Send-Timestamp", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(sendTimestamp.longValue())));
                                }
                                Integer sendTimezoneSec = requestDataHolder.getSendTimezoneSec();
                                if (sendTimezoneSec != null) {
                                    addHeader.addHeader("Send-Timezone", String.valueOf(sendTimezoneSec.intValue()));
                                }
                            }
                        }
                        NetworkClient.Builder builder = new NetworkClient.Builder();
                        int i = b.f1225a;
                        Response execute = builder.withConnectTimeout(i).withReadTimeout(i).withSslSocketFactory(networkTask.getSslSocketFactory()).build().newCall(addHeader.build()).execute();
                        int code = execute.getCode();
                        ResponseDataHolder responseDataHolder = networkTask.getResponseDataHolder();
                        responseDataHolder.setResponseCode(code);
                        responseDataHolder.setResponseHeaders(CollectionUtils.convertMapKeysToLowerCase(execute.getHeaders()));
                        if (responseDataHolder.isValidResponse()) {
                            responseDataHolder.setResponseData(execute.getResponseData());
                        }
                        if (execute.isCompleted()) {
                            z = networkTask.onRequestComplete();
                            bool = Boolean.valueOf(z);
                            onCreateNetworkTask = bool.booleanValue() && this.f1228a.shouldTryNextHost();
                            exponentialBackoffPolicy.onHostAttemptFinished(bool.booleanValue());
                        } else {
                            networkTask.onRequestError(execute.getException());
                        }
                    } else {
                        StringBuilder append = new StringBuilder("Task ").append(networkTask.description()).append(" url is `").append(url).append("`. All hosts = ");
                        List<String> allHosts = networkTask.getUnderlyingTask().getFullUrlFormer().getAllHosts();
                        networkTask.onRequestError(new IllegalArgumentException(append.append(allHosts != null ? allHosts.toString() : null).toString()));
                    }
                } else {
                    networkTask.onRequestError(null);
                }
                z = false;
                bool = Boolean.valueOf(z);
                if (bool.booleanValue()) {
                }
                exponentialBackoffPolicy.onHostAttemptFinished(bool.booleanValue());
            }
            exponentialBackoffPolicy.onAllHostsAttemptsFinished(Intrinsics.areEqual(bool, Boolean.TRUE));
            return;
        }
        this.f1228a.onShouldNotExecute();
    }
}
