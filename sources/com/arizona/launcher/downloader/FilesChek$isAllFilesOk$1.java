package com.arizona.launcher.downloader;

import android.content.Context;
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
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilesChek.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.downloader.FilesChek$isAllFilesOk$1", f = "FilesChek.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
/* loaded from: classes3.dex */
public final class FilesChek$isAllFilesOk$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ boolean $checkHash;
    final /* synthetic */ boolean $forceFileEditDate;
    final /* synthetic */ JSONArray $mDataInfo;
    final /* synthetic */ boolean $purgeExtraFiles;
    final /* synthetic */ boolean $useManifest;
    int label;
    final /* synthetic */ FilesChek this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesChek$isAllFilesOk$1(FilesChek filesChek, JSONArray jSONArray, boolean z, boolean z2, boolean z3, boolean z4, Continuation<? super FilesChek$isAllFilesOk$1> continuation) {
        super(2, continuation);
        this.this$0 = filesChek;
        this.$mDataInfo = jSONArray;
        this.$checkHash = z;
        this.$purgeExtraFiles = z2;
        this.$forceFileEditDate = z3;
        this.$useManifest = z4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FilesChek$isAllFilesOk$1(this.this$0, this.$mDataInfo, this.$checkHash, this.$purgeExtraFiles, this.$forceFileEditDate, this.$useManifest, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((FilesChek$isAllFilesOk$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        Context context;
        List list;
        String str3;
        SharedPreferences sharedPreferences;
        String str4;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            str = this.this$0.TAG;
            Log.d(str, "Looking up for corrupted files");
            Map<String, String> allDamagedFiles = this.this$0.getAllDamagedFiles(this.$mDataInfo, "", "", this.$checkHash, this.$purgeExtraFiles, this.$forceFileEditDate, this.$useManifest);
            FilesChek filesChek = this.this$0;
            for (Map.Entry<String, String> entry : allDamagedFiles.entrySet()) {
                context = filesChek.context;
                File externalFilesDir = context.getExternalFilesDir(null);
                File file = new File((externalFilesDir != null ? externalFilesDir.getPath() : null) + ((Object) entry.getKey()));
                list = filesChek.excludeFromCheck;
                if (list.contains(file.getName()) || file.isDirectory()) {
                    str3 = filesChek.TAG;
                    Log.d(str3, "File " + ((Object) entry.getKey()) + " cannot be deleted because it is in exclude list");
                } else {
                    sharedPreferences = filesChek.updatePreferences;
                    sharedPreferences.edit().remove(file.getAbsolutePath()).apply();
                    file.delete();
                    str4 = filesChek.TAG;
                    Log.d(str4, "Deleted " + file);
                }
            }
            if (allDamagedFiles.isEmpty()) {
                str2 = this.this$0.TAG;
                Log.v(str2, "All files valid");
                return Boxing.boxBoolean(true);
            }
            return Boxing.boxBoolean(false);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
