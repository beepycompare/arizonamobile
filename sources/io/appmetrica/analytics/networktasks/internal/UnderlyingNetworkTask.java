package io.appmetrica.analytics.networktasks.internal;

import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes4.dex */
public interface UnderlyingNetworkTask {
    String description();

    FullUrlFormer<?> getFullUrlFormer();

    RequestDataHolder getRequestDataHolder();

    ResponseDataHolder getResponseDataHolder();

    RetryPolicyConfig getRetryPolicyConfig();

    SSLSocketFactory getSslSocketFactory();

    boolean onCreateTask();

    void onPerformRequest();

    void onPostRequestComplete(boolean z);

    boolean onRequestComplete();

    void onRequestError(Throwable th);

    void onShouldNotExecute();

    void onSuccessfulTaskFinished();

    void onTaskAdded();

    void onTaskFinished();

    void onTaskRemoved();

    void onUnsuccessfulTaskFinished();
}
