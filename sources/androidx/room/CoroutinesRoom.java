package androidx.room;

import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.SQLiteConnection;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
/* compiled from: CoroutinesRoom.android.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/room/CoroutinesRoom;", "", "<init>", "()V", "Companion", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CoroutinesRoom {
    public static final Companion Companion = new Companion(null);

    @Deprecated(message = "No longer called by generated implementation")
    @JvmStatic
    public static final <R> Flow<R> createFlow(RoomDatabase roomDatabase, boolean z, String[] strArr, Callable<R> callable) {
        return Companion.createFlow(roomDatabase, z, strArr, callable);
    }

    @Deprecated(message = "No longer called by generated implementation")
    @JvmStatic
    public static final <R> Object execute(RoomDatabase roomDatabase, boolean z, CancellationSignal cancellationSignal, Callable<R> callable, Continuation<? super R> continuation) {
        return Companion.execute(roomDatabase, z, cancellationSignal, callable, continuation);
    }

    @Deprecated(message = "No longer called by generated implementation")
    @JvmStatic
    public static final <R> Object execute(RoomDatabase roomDatabase, boolean z, Callable<R> callable, Continuation<? super R> continuation) {
        return Companion.execute(roomDatabase, z, callable, continuation);
    }

    private CoroutinesRoom() {
    }

    /* compiled from: CoroutinesRoom.android.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000bH\u0087@¢\u0006\u0002\u0010\fJ<\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000bH\u0087@¢\u0006\u0002\u0010\u000fJJ\u0010\u0010\u001a\r\u0012\t\u0012\u0007H\u0005¢\u0006\u0002\b\u00120\u0011\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000bH\u0007¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/room/CoroutinesRoom$Companion;", "", "<init>", "()V", "execute", "R", "db", "Landroidx/room/RoomDatabase;", "inTransaction", "", "callable", "Ljava/util/concurrent/Callable;", "(Landroidx/room/RoomDatabase;ZLjava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Landroidx/room/RoomDatabase;ZLandroid/os/CancellationSignal;Ljava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/jvm/JvmSuppressWildcards;", "tableNames", "", "", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lkotlinx/coroutines/flow/Flow;", "room-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x005a, code lost:
            if (r9 == r1) goto L18;
         */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0071 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0072 A[RETURN] */
        @Deprecated(message = "No longer called by generated implementation")
        @JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final <R> Object execute(RoomDatabase roomDatabase, boolean z, Callable<R> callable, Continuation<? super R> continuation) {
            CoroutinesRoom$Companion$execute$1 coroutinesRoom$Companion$execute$1;
            int i;
            if (continuation instanceof CoroutinesRoom$Companion$execute$1) {
                coroutinesRoom$Companion$execute$1 = (CoroutinesRoom$Companion$execute$1) continuation;
                if ((coroutinesRoom$Companion$execute$1.label & Integer.MIN_VALUE) != 0) {
                    coroutinesRoom$Companion$execute$1.label -= Integer.MIN_VALUE;
                    Object obj = coroutinesRoom$Companion$execute$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = coroutinesRoom$Companion$execute$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (roomDatabase.isOpenInternal() && roomDatabase.inTransaction()) {
                            return callable.call();
                        }
                        coroutinesRoom$Companion$execute$1.L$0 = callable;
                        coroutinesRoom$Companion$execute$1.label = 1;
                        obj = DBUtil.getCoroutineContext(roomDatabase, z, coroutinesRoom$Companion$execute$1);
                    } else if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        callable = (Callable) coroutinesRoom$Companion$execute$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    coroutinesRoom$Companion$execute$1.L$0 = null;
                    coroutinesRoom$Companion$execute$1.label = 2;
                    Object withContext = BuildersKt.withContext((CoroutineContext) obj, new CoroutinesRoom$Companion$execute$2(callable, null), coroutinesRoom$Companion$execute$1);
                    return withContext != coroutine_suspended ? coroutine_suspended : withContext;
                }
            }
            coroutinesRoom$Companion$execute$1 = new CoroutinesRoom$Companion$execute$1(this, continuation);
            Object obj2 = coroutinesRoom$Companion$execute$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = coroutinesRoom$Companion$execute$1.label;
            if (i != 0) {
            }
            coroutinesRoom$Companion$execute$1.L$0 = null;
            coroutinesRoom$Companion$execute$1.label = 2;
            Object withContext2 = BuildersKt.withContext((CoroutineContext) obj2, new CoroutinesRoom$Companion$execute$2(callable, null), coroutinesRoom$Companion$execute$1);
            if (withContext2 != coroutine_suspended2) {
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0088, code lost:
            if (r8 == r4) goto L20;
         */
        /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00d1  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00d6 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00d7 A[RETURN] */
        @Deprecated(message = "No longer called by generated implementation")
        @JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final <R> Object execute(RoomDatabase roomDatabase, boolean z, CancellationSignal cancellationSignal, Callable<R> callable, Continuation<? super R> continuation) {
            CoroutinesRoom$Companion$execute$3 coroutinesRoom$Companion$execute$3;
            int i;
            final CancellationSignal cancellationSignal2;
            Callable<R> callable2;
            Object coroutineContext;
            final Job launch$default;
            Object result;
            RoomDatabase roomDatabase2 = roomDatabase;
            if (continuation instanceof CoroutinesRoom$Companion$execute$3) {
                coroutinesRoom$Companion$execute$3 = (CoroutinesRoom$Companion$execute$3) continuation;
                if ((coroutinesRoom$Companion$execute$3.label & Integer.MIN_VALUE) != 0) {
                    coroutinesRoom$Companion$execute$3.label -= Integer.MIN_VALUE;
                    Object obj = coroutinesRoom$Companion$execute$3.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = coroutinesRoom$Companion$execute$3.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        if (roomDatabase2.isOpenInternal() && roomDatabase2.inTransaction()) {
                            return callable.call();
                        }
                        coroutinesRoom$Companion$execute$3.L$0 = roomDatabase2;
                        cancellationSignal2 = cancellationSignal;
                        coroutinesRoom$Companion$execute$3.L$1 = cancellationSignal2;
                        callable2 = callable;
                        coroutinesRoom$Companion$execute$3.L$2 = callable2;
                        coroutinesRoom$Companion$execute$3.label = 1;
                        coroutineContext = DBUtil.getCoroutineContext(roomDatabase2, z, coroutinesRoom$Companion$execute$3);
                    } else if (i != 1) {
                        if (i == 2) {
                            CoroutineContext coroutineContext2 = (CoroutineContext) coroutinesRoom$Companion$execute$3.L$3;
                            Callable callable3 = (Callable) coroutinesRoom$Companion$execute$3.L$2;
                            CancellationSignal cancellationSignal3 = (CancellationSignal) coroutinesRoom$Companion$execute$3.L$1;
                            RoomDatabase roomDatabase3 = (RoomDatabase) coroutinesRoom$Companion$execute$3.L$0;
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        CancellationSignal cancellationSignal4 = (CancellationSignal) coroutinesRoom$Companion$execute$3.L$1;
                        ResultKt.throwOnFailure(obj);
                        callable2 = (Callable) coroutinesRoom$Companion$execute$3.L$2;
                        roomDatabase2 = (RoomDatabase) coroutinesRoom$Companion$execute$3.L$0;
                        coroutineContext = obj;
                        cancellationSignal2 = cancellationSignal4;
                    }
                    CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext;
                    coroutinesRoom$Companion$execute$3.L$0 = roomDatabase2;
                    coroutinesRoom$Companion$execute$3.L$1 = cancellationSignal2;
                    coroutinesRoom$Companion$execute$3.L$2 = callable2;
                    coroutinesRoom$Companion$execute$3.L$3 = coroutineContext3;
                    coroutinesRoom$Companion$execute$3.label = 2;
                    CoroutinesRoom$Companion$execute$3 coroutinesRoom$Companion$execute$32 = coroutinesRoom$Companion$execute$3;
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(coroutinesRoom$Companion$execute$32), 1);
                    cancellableContinuationImpl.initCancellability();
                    CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                    launch$default = BuildersKt__Builders_commonKt.launch$default(roomDatabase2.getCoroutineScope(), coroutineContext3, null, new CoroutinesRoom$Companion$execute$4$job$1(callable2, cancellableContinuationImpl2, null), 2, null);
                    cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.room.CoroutinesRoom$Companion$execute$4$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th) {
                            CancellationSignal cancellationSignal5 = cancellationSignal2;
                            if (cancellationSignal5 != null) {
                                cancellationSignal5.cancel();
                            }
                            Job.DefaultImpls.cancel$default(launch$default, (CancellationException) null, 1, (Object) null);
                        }
                    });
                    result = cancellableContinuationImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(coroutinesRoom$Companion$execute$32);
                    }
                    return result != coroutine_suspended ? coroutine_suspended : result;
                }
            }
            coroutinesRoom$Companion$execute$3 = new CoroutinesRoom$Companion$execute$3(this, continuation);
            Object obj2 = coroutinesRoom$Companion$execute$3.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = coroutinesRoom$Companion$execute$3.label;
            if (i != 0) {
            }
            CoroutineContext coroutineContext32 = (CoroutineContext) coroutineContext;
            coroutinesRoom$Companion$execute$3.L$0 = roomDatabase2;
            coroutinesRoom$Companion$execute$3.L$1 = cancellationSignal2;
            coroutinesRoom$Companion$execute$3.L$2 = callable2;
            coroutinesRoom$Companion$execute$3.L$3 = coroutineContext32;
            coroutinesRoom$Companion$execute$3.label = 2;
            CoroutinesRoom$Companion$execute$3 coroutinesRoom$Companion$execute$322 = coroutinesRoom$Companion$execute$3;
            CancellableContinuationImpl cancellableContinuationImpl3 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(coroutinesRoom$Companion$execute$322), 1);
            cancellableContinuationImpl3.initCancellability();
            CancellableContinuationImpl cancellableContinuationImpl22 = cancellableContinuationImpl3;
            launch$default = BuildersKt__Builders_commonKt.launch$default(roomDatabase2.getCoroutineScope(), coroutineContext32, null, new CoroutinesRoom$Companion$execute$4$job$1(callable2, cancellableContinuationImpl22, null), 2, null);
            cancellableContinuationImpl22.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.room.CoroutinesRoom$Companion$execute$4$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    CancellationSignal cancellationSignal5 = cancellationSignal2;
                    if (cancellationSignal5 != null) {
                        cancellationSignal5.cancel();
                    }
                    Job.DefaultImpls.cancel$default(launch$default, (CancellationException) null, 1, (Object) null);
                }
            });
            result = cancellableContinuationImpl3.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            }
            if (result != coroutine_suspended2) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object createFlow$lambda$1(Callable callable, SQLiteConnection it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return callable.call();
        }

        @Deprecated(message = "No longer called by generated implementation")
        @JvmStatic
        public final <R> Flow<R> createFlow(RoomDatabase db, boolean z, String[] tableNames, final Callable<R> callable) {
            Intrinsics.checkNotNullParameter(db, "db");
            Intrinsics.checkNotNullParameter(tableNames, "tableNames");
            Intrinsics.checkNotNullParameter(callable, "callable");
            return FlowUtil.createFlow(db, z, tableNames, new Function1() { // from class: androidx.room.CoroutinesRoom$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Object createFlow$lambda$1;
                    createFlow$lambda$1 = CoroutinesRoom.Companion.createFlow$lambda$1(callable, (SQLiteConnection) obj);
                    return createFlow$lambda$1;
                }
            });
        }
    }
}
