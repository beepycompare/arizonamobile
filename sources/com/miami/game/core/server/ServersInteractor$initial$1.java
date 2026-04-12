package com.miami.game.core.server;

import androidx.compose.ui.spatial.RectListKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServersInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.server.ServersInteractor$initial$1", f = "ServersInteractor.kt", i = {5, 6}, l = {60, 61, RectListKt.BitOffsetForGesturable, 63, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT, 70, TsExtractor.TS_SYNC_BYTE}, m = "invokeSuspend", n = {"e", "e"}, nl = {61, RectListKt.BitOffsetForGesturable, 63, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT, 68, TsExtractor.TS_SYNC_BYTE, MdtaMetadataEntry.TYPE_INDICATOR_8_BIT_UNSIGNED_INT}, s = {"L$0", "L$0"}, v = 2)
/* loaded from: classes4.dex */
public final class ServersInteractor$initial$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ServersInteractor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServersInteractor$initial$1(ServersInteractor serversInteractor, Continuation<? super ServersInteractor$initial$1> continuation) {
        super(2, continuation);
        this.this$0 = serversInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ServersInteractor$initial$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ServersInteractor$initial$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0097, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.miami.game.core.server.ServersInteractor$initial$1.AnonymousClass1(r5.this$0, null), r5) == r0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00be, code lost:
        if (kotlinx.coroutines.DelayKt.delay(androidx.media3.common.C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, r5) != r0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e0, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.miami.game.core.server.ServersInteractor$initial$1.AnonymousClass2(r5.this$0, null), r5) == r0) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Exception exc;
        Object serversMobileList;
        Object serversDesktopList;
        Object currentServer;
        Object serversVcList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Exception e) {
            exc = e;
            Timber.Forest.tag("exception").d(exc.toString(), new Object[0]);
            this.L$0 = SpillingKt.nullOutSpilledVariable(exc);
            this.label = 6;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                serversMobileList = this.this$0.getServersMobileList(this);
                if (serversMobileList == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.label = 2;
                serversDesktopList = this.this$0.getServersDesktopList(this);
                if (serversDesktopList == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.label = 3;
                currentServer = this.this$0.getCurrentServer(this);
                if (currentServer == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.label = 4;
                serversVcList = this.this$0.getServersVcList(this);
                if (serversVcList == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.label = 5;
                break;
            case 1:
                ResultKt.throwOnFailure(obj);
                this.label = 2;
                serversDesktopList = this.this$0.getServersDesktopList(this);
                if (serversDesktopList == coroutine_suspended) {
                }
                this.label = 3;
                currentServer = this.this$0.getCurrentServer(this);
                if (currentServer == coroutine_suspended) {
                }
                this.label = 4;
                serversVcList = this.this$0.getServersVcList(this);
                if (serversVcList == coroutine_suspended) {
                }
                this.label = 5;
                break;
            case 2:
                ResultKt.throwOnFailure(obj);
                this.label = 3;
                currentServer = this.this$0.getCurrentServer(this);
                if (currentServer == coroutine_suspended) {
                }
                this.label = 4;
                serversVcList = this.this$0.getServersVcList(this);
                if (serversVcList == coroutine_suspended) {
                }
                this.label = 5;
                break;
            case 3:
                ResultKt.throwOnFailure(obj);
                this.label = 4;
                serversVcList = this.this$0.getServersVcList(this);
                if (serversVcList == coroutine_suspended) {
                }
                this.label = 5;
                break;
            case 4:
                ResultKt.throwOnFailure(obj);
                this.label = 5;
                break;
            case 5:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 6:
                exc = (Exception) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.L$0 = SpillingKt.nullOutSpilledVariable(exc);
                this.label = 7;
                break;
            case 7:
                Exception exc2 = (Exception) this.L$0;
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ServersInteractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.miami.game.core.server.ServersInteractor$initial$1$1", f = "ServersInteractor.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT}, m = "invokeSuspend", n = {}, nl = {67}, s = {}, v = 2)
    /* renamed from: com.miami.game.core.server.ServersInteractor$initial$1$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ServersInteractor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ServersInteractor serversInteractor, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = serversInteractor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object firstLaunch;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                firstLaunch = this.this$0.firstLaunch(this);
                if (firstLaunch == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ServersInteractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.miami.game.core.server.ServersInteractor$initial$1$2", f = "ServersInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    /* renamed from: com.miami.game.core.server.ServersInteractor$initial$1$2  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ServersInteractor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ServersInteractor serversInteractor, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = serversInteractor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.retry();
            return Unit.INSTANCE;
        }
    }
}
