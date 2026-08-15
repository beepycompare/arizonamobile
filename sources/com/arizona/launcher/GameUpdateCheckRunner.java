package com.arizona.launcher;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.launcher.GameUpdateCheckRunResult;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveMirrorRetryPolicy;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckDecision;
import com.arizona.launcher.updater.http.UpdateMetadataHttpResult;
import com.arizona.launcher.updater.http.UpdateMetadataRequest;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: GameUpdateCheckRunner.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\\\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005\u0012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J®\u0001\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u000b2\u001a\b\u0002\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000f0\u001b2F\u0010\u001d\u001aB\b\u0001\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b( \u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001eH\u0086@¢\u0006\u0002\u0010#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b%\u0012\b\b&\u0012\u0004\b\u0003\u0010\u0000¨\u0006$"}, d2 = {"Lcom/arizona/launcher/GameUpdateCheckRunner;", "", TtmlNode.TAG_METADATA, "Lcom/arizona/launcher/updater/http/UpdateMetadataRequest;", "isOnline", "Lkotlin/Function0;", "", "isNetworkValidated", "currentServer", "", "markCurrentServerUnreachable", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "failedServer", "", "<init>", "(Lcom/arizona/launcher/updater/http/UpdateMetadataRequest;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "run", "Lcom/arizona/launcher/GameUpdateCheckRunResult;", "initialServer", "mirrorCount", "", "metadataFileName", "isCurrent", "onMetadataLoaded", "onMirrorRetry", "Lkotlin/Function2;", "Lcom/arizona/launcher/GameUpdateMirrorRetryReason;", "prepare", "Lkotlin/Function3;", "responseBody", "serverBaseUrl", "Lkotlin/coroutines/Continuation;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GameUpdateCheckRunner {
    public static final int $stable = 8;
    private final Function0<String> currentServer;
    private final Function0<Boolean> isNetworkValidated;
    private final Function0<Boolean> isOnline;
    private final Function1<String, Unit> markCurrentServerUnreachable;
    private final UpdateMetadataRequest metadata;

    /* JADX WARN: Multi-variable type inference failed */
    public GameUpdateCheckRunner(UpdateMetadataRequest metadata, Function0<Boolean> isOnline, Function0<Boolean> isNetworkValidated, Function0<String> currentServer, Function1<? super String, Unit> markCurrentServerUnreachable) {
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(isOnline, "isOnline");
        Intrinsics.checkNotNullParameter(isNetworkValidated, "isNetworkValidated");
        Intrinsics.checkNotNullParameter(currentServer, "currentServer");
        Intrinsics.checkNotNullParameter(markCurrentServerUnreachable, "markCurrentServerUnreachable");
        this.metadata = metadata;
        this.isOnline = isOnline;
        this.isNetworkValidated = isNetworkValidated;
        this.currentServer = currentServer;
        this.markCurrentServerUnreachable = markCurrentServerUnreachable;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01b2  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0153 -> B:39:0x0159). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x01e3 -> B:17:0x00b5). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object run(String str, int i, String str2, Function0<Boolean> function0, Function1<? super String, Unit> function1, Function2<? super String, ? super GameUpdateMirrorRetryReason, Unit> function2, Function3<? super String, ? super String, ? super Continuation<? super ArchiveUpdateCheckDecision>, ? extends Object> function3, Continuation<? super GameUpdateCheckRunResult> continuation) {
        GameUpdateCheckRunner$run$1 gameUpdateCheckRunner$run$1;
        int i2;
        String str3;
        Function0<Boolean> function02;
        Function1<? super String, Unit> function12;
        Function2<? super String, ? super GameUpdateMirrorRetryReason, Unit> function22;
        Function3<? super String, ? super String, ? super Continuation<? super ArchiveUpdateCheckDecision>, ? extends Object> function32;
        GameUpdateCheckRunner$run$1 gameUpdateCheckRunner$run$12;
        int coerceAtLeast;
        String str4;
        int i3;
        String str5;
        String str6;
        UpdateMetadataHttpResult updateMetadataHttpResult;
        if (continuation instanceof GameUpdateCheckRunner$run$1) {
            gameUpdateCheckRunner$run$1 = (GameUpdateCheckRunner$run$1) continuation;
            if ((gameUpdateCheckRunner$run$1.label & Integer.MIN_VALUE) != 0) {
                gameUpdateCheckRunner$run$1.label -= Integer.MIN_VALUE;
                Object obj = gameUpdateCheckRunner$run$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = gameUpdateCheckRunner$run$1.label;
                ArchiveUpdateCheckDecision.Block block = null;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    str3 = str2;
                    function02 = function0;
                    function12 = function1;
                    function22 = function2;
                    function32 = function3;
                    gameUpdateCheckRunner$run$12 = gameUpdateCheckRunner$run$1;
                    coerceAtLeast = RangesKt.coerceAtLeast(i, 1);
                    str4 = str;
                    i3 = i;
                    str5 = str4;
                    if (!function02.invoke().booleanValue()) {
                    }
                } else if (i2 == 1) {
                    int i4 = gameUpdateCheckRunner$run$1.I$1;
                    int i5 = gameUpdateCheckRunner$run$1.I$0;
                    function22 = (Function2) gameUpdateCheckRunner$run$1.L$4;
                    Function1<? super String, Unit> function13 = (Function1) gameUpdateCheckRunner$run$1.L$3;
                    String str7 = (String) gameUpdateCheckRunner$run$1.L$1;
                    ResultKt.throwOnFailure(obj);
                    coerceAtLeast = i4;
                    i3 = i5;
                    str3 = str7;
                    function32 = (Function3) gameUpdateCheckRunner$run$1.L$5;
                    function12 = function13;
                    str6 = (String) gameUpdateCheckRunner$run$1.L$6;
                    function02 = (Function0) gameUpdateCheckRunner$run$1.L$2;
                    gameUpdateCheckRunner$run$12 = gameUpdateCheckRunner$run$1;
                    str4 = (String) gameUpdateCheckRunner$run$1.L$0;
                    updateMetadataHttpResult = (UpdateMetadataHttpResult) obj;
                    if (updateMetadataHttpResult instanceof UpdateMetadataHttpResult.Success) {
                    }
                } else if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i6 = gameUpdateCheckRunner$run$1.I$1;
                    int i7 = gameUpdateCheckRunner$run$1.I$0;
                    UpdateMetadataHttpResult updateMetadataHttpResult2 = (UpdateMetadataHttpResult) gameUpdateCheckRunner$run$1.L$7;
                    function22 = (Function2) gameUpdateCheckRunner$run$1.L$4;
                    Function1<? super String, Unit> function14 = (Function1) gameUpdateCheckRunner$run$1.L$3;
                    Function0<Boolean> function03 = (Function0) gameUpdateCheckRunner$run$1.L$2;
                    String str8 = (String) gameUpdateCheckRunner$run$1.L$1;
                    ResultKt.throwOnFailure(obj);
                    gameUpdateCheckRunner$run$12 = gameUpdateCheckRunner$run$1;
                    str4 = (String) gameUpdateCheckRunner$run$1.L$0;
                    str6 = (String) gameUpdateCheckRunner$run$1.L$6;
                    function02 = function03;
                    function32 = (Function3) gameUpdateCheckRunner$run$1.L$5;
                    function12 = function14;
                    ArchiveUpdateCheckDecision archiveUpdateCheckDecision = (ArchiveUpdateCheckDecision) obj;
                    if (!function02.invoke().booleanValue()) {
                        ArchiveUpdateCheckDecision.Block block2 = archiveUpdateCheckDecision instanceof ArchiveUpdateCheckDecision.Block ? (ArchiveUpdateCheckDecision.Block) archiveUpdateCheckDecision : block;
                        if (!ArchiveMirrorRetryPolicy.INSTANCE.shouldRotateCheckMirror(block2 != null ? block2.getCode() : block, i6, this.isNetworkValidated.invoke().booleanValue())) {
                            return new GameUpdateCheckRunResult.Prepared(str6, archiveUpdateCheckDecision);
                        }
                        this.markCurrentServerUnreachable.invoke(str6);
                        str5 = this.currentServer.invoke();
                        function22.invoke(str5, GameUpdateMirrorRetryReason.ARCHIVE_CHECK_BLOCK);
                        String str9 = str8;
                        coerceAtLeast = i6 - 1;
                        i3 = i7;
                        str3 = str9;
                        block = null;
                        if (!function02.invoke().booleanValue()) {
                            if (str5.length() == 0) {
                                return GameUpdateCheckRunResult.ServerEmpty.INSTANCE;
                            }
                            gameUpdateCheckRunner$run$12.L$0 = SpillingKt.nullOutSpilledVariable(str4);
                            gameUpdateCheckRunner$run$12.L$1 = str3;
                            gameUpdateCheckRunner$run$12.L$2 = function02;
                            gameUpdateCheckRunner$run$12.L$3 = function12;
                            gameUpdateCheckRunner$run$12.L$4 = function22;
                            gameUpdateCheckRunner$run$12.L$5 = function32;
                            gameUpdateCheckRunner$run$12.L$6 = str5;
                            gameUpdateCheckRunner$run$12.L$7 = block;
                            gameUpdateCheckRunner$run$12.I$0 = i3;
                            gameUpdateCheckRunner$run$12.I$1 = coerceAtLeast;
                            gameUpdateCheckRunner$run$12.label = 1;
                            Object obj2 = this.metadata.get(str5 + str3, gameUpdateCheckRunner$run$12);
                            if (obj2 != coroutine_suspended) {
                                str6 = str5;
                                obj = obj2;
                                updateMetadataHttpResult = (UpdateMetadataHttpResult) obj;
                                if (updateMetadataHttpResult instanceof UpdateMetadataHttpResult.Success) {
                                    if (!function02.invoke().booleanValue()) {
                                        return GameUpdateCheckRunResult.Stale.INSTANCE;
                                    }
                                    UpdateMetadataHttpResult.Success success = (UpdateMetadataHttpResult.Success) updateMetadataHttpResult;
                                    function12.invoke(success.getBody());
                                    String body = success.getBody();
                                    gameUpdateCheckRunner$run$12.L$0 = SpillingKt.nullOutSpilledVariable(str4);
                                    gameUpdateCheckRunner$run$12.L$1 = str3;
                                    gameUpdateCheckRunner$run$12.L$2 = function02;
                                    gameUpdateCheckRunner$run$12.L$3 = function12;
                                    gameUpdateCheckRunner$run$12.L$4 = function22;
                                    gameUpdateCheckRunner$run$12.L$5 = function32;
                                    gameUpdateCheckRunner$run$12.L$6 = str6;
                                    gameUpdateCheckRunner$run$12.L$7 = SpillingKt.nullOutSpilledVariable(updateMetadataHttpResult);
                                    gameUpdateCheckRunner$run$12.I$0 = i3;
                                    gameUpdateCheckRunner$run$12.I$1 = coerceAtLeast;
                                    gameUpdateCheckRunner$run$12.label = 2;
                                    obj = function32.invoke(body, str6, gameUpdateCheckRunner$run$12);
                                    if (obj != coroutine_suspended) {
                                        String str10 = str3;
                                        i7 = i3;
                                        i6 = coerceAtLeast;
                                        str8 = str10;
                                        ArchiveUpdateCheckDecision archiveUpdateCheckDecision2 = (ArchiveUpdateCheckDecision) obj;
                                        if (!function02.invoke().booleanValue()) {
                                            return GameUpdateCheckRunResult.Stale.INSTANCE;
                                        }
                                    }
                                } else if (!function02.invoke().booleanValue()) {
                                    return GameUpdateCheckRunResult.Stale.INSTANCE;
                                } else {
                                    if (!this.isOnline.invoke().booleanValue()) {
                                        return new GameUpdateCheckRunResult.MetadataFailed(str6, updateMetadataHttpResult);
                                    }
                                    this.markCurrentServerUnreachable.invoke(str6);
                                    if (coerceAtLeast <= 1) {
                                        return new GameUpdateCheckRunResult.MetadataFailed(str6, updateMetadataHttpResult);
                                    }
                                    str5 = this.currentServer.invoke();
                                    coerceAtLeast--;
                                    function22.invoke(str5, GameUpdateMirrorRetryReason.METADATA_FAILURE);
                                    block = null;
                                    if (!function02.invoke().booleanValue()) {
                                        return GameUpdateCheckRunResult.Stale.INSTANCE;
                                    }
                                }
                            }
                            return coroutine_suspended;
                        }
                    }
                }
            }
        }
        gameUpdateCheckRunner$run$1 = new GameUpdateCheckRunner$run$1(this, continuation);
        Object obj3 = gameUpdateCheckRunner$run$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = gameUpdateCheckRunner$run$1.label;
        ArchiveUpdateCheckDecision.Block block3 = null;
        if (i2 != 0) {
        }
    }

    public static /* synthetic */ Object run$default(GameUpdateCheckRunner gameUpdateCheckRunner, String str, int i, String str2, Function0 function0, Function1 function1, Function2 function2, Function3 function3, Continuation continuation, int i2, Object obj) {
        Function1 function12 = function1;
        if ((i2 & 16) != 0) {
            function12 = new Function1() { // from class: com.arizona.launcher.GameUpdateCheckRunner$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return GameUpdateCheckRunner.run$lambda$0((String) obj2);
                }
            };
        }
        return gameUpdateCheckRunner.run(str, i, str2, function0, function12, (i2 & 32) != 0 ? new Function2() { // from class: com.arizona.launcher.GameUpdateCheckRunner$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj2, Object obj3) {
                return GameUpdateCheckRunner.run$lambda$1((String) obj2, (GameUpdateMirrorRetryReason) obj3);
            }
        } : function2, function3, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit run$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit run$lambda$1(String str, GameUpdateMirrorRetryReason gameUpdateMirrorRetryReason) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(gameUpdateMirrorRetryReason, "<unused var>");
        return Unit.INSTANCE;
    }
}
