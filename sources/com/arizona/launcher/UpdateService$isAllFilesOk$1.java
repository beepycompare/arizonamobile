package com.arizona.launcher;

import android.content.SharedPreferences;
import android.util.Log;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.UpdateService$isAllFilesOk$1", f = "UpdateService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
public final class UpdateService$isAllFilesOk$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ boolean $checkHash;
    final /* synthetic */ boolean $forceFileEditDate;
    final /* synthetic */ boolean $purgeExtraFiles;
    int label;
    final /* synthetic */ UpdateService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateService$isAllFilesOk$1(UpdateService updateService, boolean z, boolean z2, boolean z3, Continuation<? super UpdateService$isAllFilesOk$1> continuation) {
        super(2, continuation);
        this.this$0 = updateService;
        this.$checkHash = z;
        this.$purgeExtraFiles = z2;
        this.$forceFileEditDate = z3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UpdateService$isAllFilesOk$1(this.this$0, this.$checkHash, this.$purgeExtraFiles, this.$forceFileEditDate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((UpdateService$isAllFilesOk$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        JSONArray jSONArray;
        Map allDamagedFiles;
        List list;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Log.d("UPDATE_SERVICE", "Looking up for corrupted files");
        UpdateService updateService = this.this$0;
        jSONArray = updateService.mDataInfo;
        allDamagedFiles = updateService.getAllDamagedFiles(jSONArray, "", "", this.$checkHash, this.$purgeExtraFiles, this.$forceFileEditDate);
        UpdateService updateService2 = this.this$0;
        for (Map.Entry entry : allDamagedFiles.entrySet()) {
            SharedPreferences sharedPreferences = null;
            File externalFilesDir = updateService2.getExternalFilesDir(null);
            File file = new File((externalFilesDir != null ? externalFilesDir.getPath() : null) + entry.getKey());
            list = UpdateService.excludeFromCheck;
            if (list.contains(file.getName()) || file.isDirectory()) {
                Log.d("UPDATE_SERVICE", "File " + entry.getKey() + " cannot be deleted because it is in exclude list");
            } else {
                SharedPreferences sharedPreferences2 = updateService2.updatePreferences;
                if (sharedPreferences2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("updatePreferences");
                } else {
                    sharedPreferences = sharedPreferences2;
                }
                sharedPreferences.edit().remove(file.getAbsolutePath()).apply();
                file.delete();
                Log.d("UPDATE_SERVICE", "Deleted " + file);
            }
        }
        if (!allDamagedFiles.isEmpty()) {
            return Boxing.boxBoolean(false);
        }
        Log.v("UPDATE_SERVICE", "All files valid");
        return Boxing.boxBoolean(true);
    }
}
