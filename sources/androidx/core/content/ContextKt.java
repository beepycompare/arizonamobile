package androidx.core.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
/* compiled from: Context.kt */
@Metadata(d1 = {"\u0000t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0086\b¢\u0006\u0002\u0010\u0004\u001aN\u0010\u0005\u001a\u00020\u0006*\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0003\u0010\r\u001a\u00020\f2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u000f¢\u0006\u0002\b\u0011H\u0086\b\u001a8\u0010\u0005\u001a\u00020\u0006*\u00020\u00032\b\b\u0001\u0010\u0012\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u000f¢\u0006\u0002\b\u0011H\u0086\b\u001a[\u0010\u0013\u001a\u00020\u0014*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u001f\u0010\u001c\u001a\u001b\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00020\u00060\u001d¢\u0006\u0002\b\u0011H\u0086@¢\u0006\u0002\u0010 \u001ak\u0010!\u001a\u00020\u0014*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2/\u0010\u001c\u001a+\b\u0001\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060$\u0012\u0006\u0012\u0004\u0018\u00010\u00020\"¢\u0006\u0002\b\u0011H\u0086@¢\u0006\u0002\u0010%¨\u0006&"}, d2 = {"getSystemService", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Object;", "withStyledAttributes", "", "set", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "", "defStyleRes", "block", "Lkotlin/Function1;", "Landroid/content/res/TypedArray;", "Lkotlin/ExtensionFunctionType;", "resourceId", "receiveBroadcasts", "", "filter", "Landroid/content/IntentFilter;", DownloaderServiceMarshaller.PARAMS_FLAGS, "broadcastPermission", "", "scheduler", "Landroid/os/Handler;", "onReceive", "Lkotlin/Function2;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Intent;", "(Landroid/content/Context;Landroid/content/IntentFilter;ILjava/lang/String;Landroid/os/Handler;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveBroadcastsAsync", "Lkotlin/Function3;", "Landroid/content/BroadcastReceiver$PendingResult;", "Lkotlin/coroutines/Continuation;", "(Landroid/content/Context;Landroid/content/IntentFilter;ILjava/lang/String;Landroid/os/Handler;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core-ktx"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ContextKt {
    public static final /* synthetic */ <T> T getSystemService(Context context) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) ContextCompat.getSystemService(context, Object.class);
    }

    public static final void withStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, Function1<? super TypedArray, Unit> function1) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        function1.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void withStyledAttributes$default(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            attributeSet = null;
        }
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        function1.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static final void withStyledAttributes(Context context, int i, int[] iArr, Function1<? super TypedArray, Unit> function1) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, iArr);
        function1.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b7  */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, androidx.core.content.ContinuationBroadcastReceiver] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object receiveBroadcasts(Context context, IntentFilter intentFilter, int i, String str, Handler handler, Function2<? super BroadcastReceiver, ? super Intent, Unit> function2, Continuation<?> continuation) {
        ContextKt$receiveBroadcasts$1 contextKt$receiveBroadcasts$1;
        int i2;
        Ref.ObjectRef objectRef;
        Throwable th;
        Context context2;
        Ref.ObjectRef objectRef2;
        if (continuation instanceof ContextKt$receiveBroadcasts$1) {
            contextKt$receiveBroadcasts$1 = (ContextKt$receiveBroadcasts$1) continuation;
            if ((contextKt$receiveBroadcasts$1.label & Integer.MIN_VALUE) != 0) {
                contextKt$receiveBroadcasts$1.label -= Integer.MIN_VALUE;
                Object obj = contextKt$receiveBroadcasts$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = contextKt$receiveBroadcasts$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    objectRef = new Ref.ObjectRef();
                    try {
                        contextKt$receiveBroadcasts$1.L$0 = context;
                        contextKt$receiveBroadcasts$1.L$1 = intentFilter;
                        contextKt$receiveBroadcasts$1.L$2 = str;
                        contextKt$receiveBroadcasts$1.L$3 = handler;
                        contextKt$receiveBroadcasts$1.L$4 = function2;
                        contextKt$receiveBroadcasts$1.L$5 = objectRef;
                        contextKt$receiveBroadcasts$1.I$0 = i;
                        contextKt$receiveBroadcasts$1.label = 1;
                        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(contextKt$receiveBroadcasts$1), 1);
                        cancellableContinuationImpl.initCancellability();
                        objectRef.element = new ContinuationBroadcastReceiver(cancellableContinuationImpl, function2);
                        ContextCompat.registerReceiver(context, (BroadcastReceiver) objectRef.element, intentFilter, str, handler, i);
                        Object result = cancellableContinuationImpl.getResult();
                        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended(contextKt$receiveBroadcasts$1);
                        }
                        if (result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        context2 = context;
                        objectRef2 = objectRef;
                        if (objectRef2.element != 0) {
                        }
                        throw th;
                    }
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i3 = contextKt$receiveBroadcasts$1.I$0;
                    objectRef2 = (Ref.ObjectRef) contextKt$receiveBroadcasts$1.L$5;
                    Function2 function22 = (Function2) contextKt$receiveBroadcasts$1.L$4;
                    Handler handler2 = (Handler) contextKt$receiveBroadcasts$1.L$3;
                    String str2 = (String) contextKt$receiveBroadcasts$1.L$2;
                    IntentFilter intentFilter2 = (IntentFilter) contextKt$receiveBroadcasts$1.L$1;
                    context2 = (Context) contextKt$receiveBroadcasts$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        objectRef = objectRef2;
                        context = context2;
                    } catch (Throwable th3) {
                        th = th3;
                        if (objectRef2.element != 0) {
                            context2.unregisterReceiver((BroadcastReceiver) objectRef2.element);
                        }
                        throw th;
                    }
                }
                throw new KotlinNothingValueException();
            }
        }
        contextKt$receiveBroadcasts$1 = new ContextKt$receiveBroadcasts$1(continuation);
        Object obj2 = contextKt$receiveBroadcasts$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = contextKt$receiveBroadcasts$1.label;
        if (i2 != 0) {
        }
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Object receiveBroadcasts$default(Context context, IntentFilter intentFilter, int i, String str, Handler handler, Function2 function2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = null;
        }
        if ((i2 & 8) != 0) {
            handler = null;
        }
        return receiveBroadcasts(context, intentFilter, i, str, handler, function2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object receiveBroadcastsAsync(Context context, IntentFilter intentFilter, int i, String str, Handler handler, Function3<? super BroadcastReceiver.PendingResult, ? super Intent, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<?> continuation) {
        ContextKt$receiveBroadcastsAsync$1 contextKt$receiveBroadcastsAsync$1;
        int i2;
        if (continuation instanceof ContextKt$receiveBroadcastsAsync$1) {
            contextKt$receiveBroadcastsAsync$1 = (ContextKt$receiveBroadcastsAsync$1) continuation;
            if ((contextKt$receiveBroadcastsAsync$1.label & Integer.MIN_VALUE) != 0) {
                contextKt$receiveBroadcastsAsync$1.label -= Integer.MIN_VALUE;
                Object obj = contextKt$receiveBroadcastsAsync$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = contextKt$receiveBroadcastsAsync$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    contextKt$receiveBroadcastsAsync$1.label = 1;
                    if (CoroutineScopeKt.coroutineScope(new ContextKt$receiveBroadcastsAsync$2(context, intentFilter, i, str, handler, function3, null), contextKt$receiveBroadcastsAsync$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }
        contextKt$receiveBroadcastsAsync$1 = new ContextKt$receiveBroadcastsAsync$1(continuation);
        Object obj2 = contextKt$receiveBroadcastsAsync$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = contextKt$receiveBroadcastsAsync$1.label;
        if (i2 != 0) {
        }
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Object receiveBroadcastsAsync$default(Context context, IntentFilter intentFilter, int i, String str, Handler handler, Function3 function3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = null;
        }
        if ((i2 & 8) != 0) {
            handler = null;
        }
        return receiveBroadcastsAsync(context, intentFilter, i, str, handler, function3, continuation);
    }
}
