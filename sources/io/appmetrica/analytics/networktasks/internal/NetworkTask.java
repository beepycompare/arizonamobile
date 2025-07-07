package io.appmetrica.analytics.networktasks.internal;

import io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy;
import io.appmetrica.analytics.networktasks.impl.e;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes4.dex */
public class NetworkTask {

    /* renamed from: a  reason: collision with root package name */
    private int f1240a = 1;
    private final Executor b;
    private final IExecutionPolicy c;
    private final ExponentialBackoffPolicy d;
    private final UnderlyingNetworkTask e;
    private final List f;
    private final String g;

    /* loaded from: classes4.dex */
    public enum Method {
        GET,
        POST
    }

    /* loaded from: classes4.dex */
    public interface ShouldTryNextHostCondition {
        boolean shouldTryNextHost(int i);
    }

    public NetworkTask(Executor executor, IExecutionPolicy iExecutionPolicy, ExponentialBackoffPolicy exponentialBackoffPolicy, UnderlyingNetworkTask underlyingNetworkTask, List<ShouldTryNextHostCondition> list, String str) {
        this.b = executor;
        this.c = iExecutionPolicy;
        this.d = exponentialBackoffPolicy;
        this.e = underlyingNetworkTask;
        this.f = list;
        this.g = str;
    }

    private synchronized boolean a(int i) {
        if (a(i)) {
            this.f1240a = i;
            return true;
        }
        return false;
    }

    public String description() {
        return this.e.description();
    }

    public IExecutionPolicy getConnectionExecutionPolicy() {
        return this.c;
    }

    public Executor getExecutor() {
        return this.b;
    }

    public ExponentialBackoffPolicy getExponentialBackoffPolicy() {
        return this.d;
    }

    public RequestDataHolder getRequestDataHolder() {
        return this.e.getRequestDataHolder();
    }

    public ResponseDataHolder getResponseDataHolder() {
        return this.e.getResponseDataHolder();
    }

    public RetryPolicyConfig getRetryPolicyConfig() {
        return this.e.getRetryPolicyConfig();
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.e.getSslSocketFactory();
    }

    public UnderlyingNetworkTask getUnderlyingTask() {
        return this.e;
    }

    public String getUrl() {
        return this.e.getFullUrlFormer().getUrl();
    }

    public String getUserAgent() {
        return this.g;
    }

    public boolean isRemoved() {
        return this.f1240a == 9;
    }

    public boolean onCreateNetworkTask() {
        if (a(3)) {
            return this.e.onCreateTask();
        }
        return false;
    }

    public boolean onPerformRequest() {
        boolean a2 = a(4);
        if (a2) {
            this.e.getFullUrlFormer().incrementAttemptNumber();
            this.e.getFullUrlFormer().buildAndSetFullHostUrl();
            this.e.onPerformRequest();
        }
        return a2;
    }

    public boolean onRequestComplete() {
        boolean z;
        boolean z2;
        synchronized (this) {
            if (a(5, 6)) {
                z = this.e.onRequestComplete();
                if (z) {
                    this.f1240a = 5;
                } else {
                    this.f1240a = 6;
                }
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
        }
        if (z2) {
            this.e.onPostRequestComplete(z);
        }
        return z;
    }

    public void onRequestError(Throwable th) {
        if (a(6)) {
            this.e.onRequestError(th);
        }
    }

    public void onShouldNotExecute() {
        if (a(7)) {
            this.e.onShouldNotExecute();
        }
    }

    public boolean onTaskAdded() {
        boolean a2 = a(2);
        if (a2) {
            this.e.onTaskAdded();
        }
        return a2;
    }

    public void onTaskFinished() {
        int i;
        boolean a2;
        synchronized (this) {
            i = this.f1240a;
            a2 = a(8);
        }
        if (a2) {
            this.e.onTaskFinished();
            if (i == 5) {
                this.e.onSuccessfulTaskFinished();
            } else if (i == 6 || i == 7) {
                this.e.onUnsuccessfulTaskFinished();
            }
        }
    }

    public void onTaskRemoved() {
        if (a(9)) {
            this.e.onTaskRemoved();
        }
    }

    public synchronized boolean shouldTryNextHost() {
        boolean z;
        boolean z2;
        boolean hasMoreHosts = this.e.getFullUrlFormer().hasMoreHosts();
        int responseCode = this.e.getResponseDataHolder().getResponseCode();
        Iterator it = this.f.iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                z2 = true;
                break;
            } else if (!((ShouldTryNextHostCondition) it.next()).shouldTryNextHost(responseCode)) {
                z2 = false;
                break;
            }
        }
        int i = this.f1240a;
        if (i != 9 && i != 8 && hasMoreHosts && z2) {
            z = true;
        }
        return z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0062 A[Catch: all -> 0x008c, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000a, B:6:0x0018, B:7:0x001b, B:47:0x0074, B:50:0x007e, B:13:0x0027, B:23:0x003c, B:24:0x003f, B:26:0x0044, B:28:0x0049, B:30:0x004e, B:36:0x005a, B:37:0x005d, B:39:0x0062, B:41:0x0067, B:45:0x006e, B:51:0x0081), top: B:57:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean a(int... iArr) {
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        bool = Boolean.TRUE;
        int i = this.f1240a;
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            if (i2 < length) {
                boolean z = true;
                switch (e.a(iArr[i2])) {
                    case 0:
                        bool3 = null;
                        break;
                    case 1:
                        if (i != 1) {
                            z = false;
                        }
                        bool3 = Boolean.valueOf(z);
                        break;
                    case 2:
                        if (i == 2) {
                            if (i == 9) {
                                bool3 = Boolean.FALSE;
                                break;
                            }
                            bool3 = null;
                            break;
                        } else {
                            bool3 = Boolean.TRUE;
                            break;
                        }
                    case 3:
                        if (i != 3 && i != 5 && i != 6) {
                            if (i == 9) {
                                bool3 = Boolean.FALSE;
                                break;
                            }
                            bool3 = null;
                            break;
                        }
                        bool3 = Boolean.TRUE;
                    case 4:
                    case 5:
                        if (i != 4) {
                            if (i == 9) {
                                bool3 = Boolean.FALSE;
                                break;
                            }
                            bool3 = null;
                            break;
                        } else {
                            bool3 = Boolean.TRUE;
                            break;
                        }
                    case 6:
                        if (i == 3) {
                            bool3 = Boolean.TRUE;
                            break;
                        }
                        if (i == 2) {
                        }
                        break;
                    case 7:
                        if (i != 5 && i != 6 && i != 7 && i != 2 && i != 3 && i != 4) {
                            if (i == 9) {
                                bool3 = Boolean.FALSE;
                                break;
                            }
                            bool3 = null;
                            break;
                        }
                        bool3 = Boolean.TRUE;
                    case 8:
                        if (i != 1) {
                            if (i == 9) {
                                z = false;
                            }
                            bool3 = Boolean.valueOf(z);
                            break;
                        } else {
                            bool3 = null;
                            break;
                        }
                    default:
                        bool3 = Boolean.FALSE;
                        break;
                }
                if (Boolean.TRUE.equals(bool3)) {
                    i2++;
                } else {
                    bool = bool3;
                }
            }
        }
        bool2 = Boolean.TRUE;
        bool2.equals(bool);
        return bool2.equals(bool);
    }
}
