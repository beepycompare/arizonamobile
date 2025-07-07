package coil3.network.okhttp.internal;

import androidx.exifinterface.media.ExifInterface;
import coil3.network.NetworkClient;
import coil3.network.NetworkRequest;
import coil3.network.NetworkResponse;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;
/* compiled from: utils.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JQ\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\b\u001a\u00020\t21\u0010\n\u001a-\b\u0001\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000bH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u001b"}, d2 = {"Lcoil3/network/okhttp/internal/CallFactoryNetworkClient;", "Lcoil3/network/NetworkClient;", "callFactory", "Lokhttp3/Call$Factory;", "constructor-impl", "(Lokhttp3/Call$Factory;)Lokhttp3/Call$Factory;", "executeRequest", ExifInterface.GPS_DIRECTION_TRUE, "request", "Lcoil3/network/NetworkRequest;", "block", "Lkotlin/Function2;", "Lcoil3/network/NetworkResponse;", "Lkotlin/ParameterName;", "name", "response", "Lkotlin/coroutines/Continuation;", "", "executeRequest-impl", "(Lokhttp3/Call$Factory;Lcoil3/network/NetworkRequest;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "toString", "", "coil-network-okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes3.dex */
public final class CallFactoryNetworkClient implements NetworkClient {
    private final Call.Factory callFactory;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ CallFactoryNetworkClient m7796boximpl(Call.Factory factory) {
        return new CallFactoryNetworkClient(factory);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static Call.Factory m7797constructorimpl(Call.Factory factory) {
        return factory;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m7798equalsimpl(Call.Factory factory, Object obj) {
        return (obj instanceof CallFactoryNetworkClient) && Intrinsics.areEqual(factory, ((CallFactoryNetworkClient) obj).m7803unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m7799equalsimpl0(Call.Factory factory, Call.Factory factory2) {
        return Intrinsics.areEqual(factory, factory2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m7801hashCodeimpl(Call.Factory factory) {
        return factory.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m7802toStringimpl(Call.Factory factory) {
        return "CallFactoryNetworkClient(callFactory=" + factory + ')';
    }

    public boolean equals(Object obj) {
        return m7798equalsimpl(this.callFactory, obj);
    }

    public int hashCode() {
        return m7801hashCodeimpl(this.callFactory);
    }

    public String toString() {
        return m7802toStringimpl(this.callFactory);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Call.Factory m7803unboximpl() {
        return this.callFactory;
    }

    private /* synthetic */ CallFactoryNetworkClient(Call.Factory factory) {
        this.callFactory = factory;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
        if (r11 == r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008d  */
    /* renamed from: executeRequest-impl  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> Object m7800executeRequestimpl(Call.Factory factory, NetworkRequest networkRequest, Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        CallFactoryNetworkClient$executeRequest$1 callFactoryNetworkClient$executeRequest$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function22;
        Closeable closeable;
        Throwable th;
        Closeable closeable2;
        NetworkResponse networkResponse;
        if (continuation instanceof CallFactoryNetworkClient$executeRequest$1) {
            callFactoryNetworkClient$executeRequest$1 = (CallFactoryNetworkClient$executeRequest$1) continuation;
            if ((callFactoryNetworkClient$executeRequest$1.label & Integer.MIN_VALUE) != 0) {
                callFactoryNetworkClient$executeRequest$1.label -= Integer.MIN_VALUE;
                obj = callFactoryNetworkClient$executeRequest$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = callFactoryNetworkClient$executeRequest$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    callFactoryNetworkClient$executeRequest$1.L$0 = function2;
                    callFactoryNetworkClient$executeRequest$1.L$1 = factory;
                    callFactoryNetworkClient$executeRequest$1.label = 1;
                    obj = UtilsKt.toRequest(networkRequest, callFactoryNetworkClient$executeRequest$1);
                } else if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            closeable2 = (Closeable) callFactoryNetworkClient$executeRequest$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                CloseableKt.closeFinally(closeable2, null);
                                return obj;
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    throw th;
                                } catch (Throwable th3) {
                                    CloseableKt.closeFinally(closeable2, th);
                                    throw th3;
                                }
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function22 = (Function2) callFactoryNetworkClient$executeRequest$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    closeable = (Closeable) obj;
                    try {
                        networkResponse = UtilsKt.toNetworkResponse((Response) closeable);
                        callFactoryNetworkClient$executeRequest$1.L$0 = closeable;
                        callFactoryNetworkClient$executeRequest$1.label = 3;
                        obj = function22.invoke(networkResponse, callFactoryNetworkClient$executeRequest$1);
                        if (obj != coroutine_suspended) {
                            closeable2 = closeable;
                            CloseableKt.closeFinally(closeable2, null);
                            return obj;
                        }
                        return coroutine_suspended;
                    } catch (Throwable th4) {
                        th = th4;
                        closeable2 = closeable;
                        throw th;
                    }
                } else {
                    factory = (Call.Factory) callFactoryNetworkClient$executeRequest$1.L$1;
                    function2 = (Function2) callFactoryNetworkClient$executeRequest$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Call newCall = factory.newCall((Request) obj);
                callFactoryNetworkClient$executeRequest$1.L$0 = function2;
                callFactoryNetworkClient$executeRequest$1.L$1 = null;
                callFactoryNetworkClient$executeRequest$1.label = 2;
                obj = CallsKt.await(newCall, callFactoryNetworkClient$executeRequest$1);
                if (obj != coroutine_suspended) {
                    function22 = function2;
                    closeable = (Closeable) obj;
                    networkResponse = UtilsKt.toNetworkResponse((Response) closeable);
                    callFactoryNetworkClient$executeRequest$1.L$0 = closeable;
                    callFactoryNetworkClient$executeRequest$1.label = 3;
                    obj = function22.invoke(networkResponse, callFactoryNetworkClient$executeRequest$1);
                    if (obj != coroutine_suspended) {
                    }
                }
                return coroutine_suspended;
            }
        }
        callFactoryNetworkClient$executeRequest$1 = new CallFactoryNetworkClient$executeRequest$1(continuation);
        obj = callFactoryNetworkClient$executeRequest$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = callFactoryNetworkClient$executeRequest$1.label;
        if (i != 0) {
        }
        Call newCall2 = factory.newCall((Request) obj);
        callFactoryNetworkClient$executeRequest$1.L$0 = function2;
        callFactoryNetworkClient$executeRequest$1.L$1 = null;
        callFactoryNetworkClient$executeRequest$1.label = 2;
        obj = CallsKt.await(newCall2, callFactoryNetworkClient$executeRequest$1);
        if (obj != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    @Override // coil3.network.NetworkClient
    public <T> Object executeRequest(NetworkRequest networkRequest, Function2<? super NetworkResponse, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return m7800executeRequestimpl(this.callFactory, networkRequest, function2, continuation);
    }
}
