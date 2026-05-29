package com.arizona.launcher.downloader;

import android.content.Context;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FilesChek.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.downloader.FilesChek$getFilesToDownload$2", f = "FilesChek.kt", i = {0, 0, 0, 0}, l = {86}, m = "invokeSuspend", n = {"jsonObject", "jsonArray", "jsonDir", CmcdData.OBJECT_TYPE_INIT_SEGMENT}, nl = {90}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 2)
/* loaded from: classes3.dex */
public final class FilesChek$getFilesToDownload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $destDir;
    final /* synthetic */ String $dir;
    final /* synthetic */ JSONArray $sources;
    final /* synthetic */ List<Pair<String, Long>> $updateFiles;
    final /* synthetic */ boolean $useManifest;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ FilesChek this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesChek$getFilesToDownload$2(JSONArray jSONArray, FilesChek filesChek, String str, String str2, boolean z, List<Pair<String, Long>> list, Continuation<? super FilesChek$getFilesToDownload$2> continuation) {
        super(2, continuation);
        this.$sources = jSONArray;
        this.this$0 = filesChek;
        this.$dir = str;
        this.$destDir = str2;
        this.$useManifest = z;
        this.$updateFiles = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FilesChek$getFilesToDownload$2(this.$sources, this.this$0, this.$dir, this.$destDir, this.$useManifest, this.$updateFiles, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FilesChek$getFilesToDownload$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01c8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x009f -> B:15:0x00a2). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0105 -> B:35:0x01c5). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0116 -> B:35:0x01c5). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0118 -> B:35:0x01c5). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0154 -> B:35:0x01c5). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0194 -> B:35:0x01c5). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0196 -> B:35:0x01c5). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int length;
        int i;
        Context context;
        Context context2;
        List list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            length = this.$sources.length();
            i = 0;
            if (i >= length) {
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            length = this.I$1;
            i = this.I$0;
            String str = (String) this.L$2;
            JSONArray jSONArray = (JSONArray) this.L$1;
            JSONObject jSONObject = (JSONObject) this.L$0;
            ResultKt.throwOnFailure(obj);
            Object filesToDownload = obj;
            this.$updateFiles.addAll((List) filesToDownload);
            i++;
            if (i >= length) {
                JSONObject jSONObject2 = this.$sources.getJSONObject(i);
                if (Intrinsics.areEqual(jSONObject2.getString("type"), "dir")) {
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("data");
                    String string = jSONObject2.getString("name");
                    FilesChek filesChek = this.this$0;
                    Intrinsics.checkNotNull(jSONArray2);
                    String str2 = this.$dir;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(jSONObject2);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(jSONArray2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(string);
                    this.I$0 = i;
                    this.I$1 = length;
                    this.label = 1;
                    filesToDownload = filesChek.getFilesToDownload(jSONArray2, str2 + "/" + string, this.$destDir, this.$useManifest, this);
                    if (filesToDownload == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.$updateFiles.addAll((List) filesToDownload);
                    i++;
                    if (i >= length) {
                        return Unit.INSTANCE;
                    }
                } else {
                    if (Intrinsics.areEqual(jSONObject2.getString("type"), "file")) {
                        String string2 = jSONObject2.getString("name");
                        context2 = this.this$0.context;
                        File externalFilesDir = context2.getExternalFilesDir(null);
                        File file = new File((externalFilesDir != null ? externalFilesDir.getPath() : null) + this.$destDir + this.$dir + "/" + string2);
                        list = this.this$0.excludeFromCheck;
                        if (!list.contains(file.getName())) {
                            FilesChek filesChek2 = this.this$0;
                            Intrinsics.checkNotNull(jSONObject2);
                            if (!filesChek2.checkSingleFile(file, jSONObject2, false, false, this.$useManifest)) {
                                this.$updateFiles.add(new Pair<>(this.$destDir + this.$dir + "/" + string2, Boxing.boxLong(jSONObject2.getLong("size"))));
                            }
                        }
                    } else if (Intrinsics.areEqual(jSONObject2.getString("type"), "res")) {
                        String string3 = jSONObject2.getString("name");
                        context = this.this$0.context;
                        File externalFilesDir2 = context.getExternalFilesDir(null);
                        if (!new File((externalFilesDir2 != null ? externalFilesDir2.getPath() : null) + this.$destDir + this.$dir + "/" + string3).exists()) {
                            this.$updateFiles.add(new Pair<>(this.$destDir + this.$dir + "/" + string3, Boxing.boxLong(jSONObject2.getLong("size"))));
                        }
                    }
                    i++;
                    if (i >= length) {
                    }
                }
            }
        }
    }
}
