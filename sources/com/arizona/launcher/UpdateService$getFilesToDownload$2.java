package com.arizona.launcher;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.sessions.settings.RemoteSettings;
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
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.UpdateService$getFilesToDownload$2", f = "UpdateService.kt", i = {0}, l = {792}, m = "invokeSuspend", n = {CmcdData.OBJECT_TYPE_INIT_SEGMENT}, s = {"I$0"})
/* loaded from: classes3.dex */
public final class UpdateService$getFilesToDownload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $destDir;
    final /* synthetic */ String $dir;
    final /* synthetic */ JSONArray $sources;
    final /* synthetic */ List<Pair<String, Long>> $updateFiles;
    int I$0;
    int I$1;
    int label;
    final /* synthetic */ UpdateService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpdateService$getFilesToDownload$2(JSONArray jSONArray, UpdateService updateService, String str, String str2, List<Pair<String, Long>> list, Continuation<? super UpdateService$getFilesToDownload$2> continuation) {
        super(2, continuation);
        this.$sources = jSONArray;
        this.this$0 = updateService;
        this.$dir = str;
        this.$destDir = str2;
        this.$updateFiles = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UpdateService$getFilesToDownload$2(this.$sources, this.this$0, this.$dir, this.$destDir, this.$updateFiles, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UpdateService$getFilesToDownload$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x018e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0076 -> B:15:0x0079). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00d5 -> B:35:0x018b). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00e2 -> B:35:0x018b). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00e4 -> B:35:0x018b). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x011e -> B:35:0x018b). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x015a -> B:35:0x018b). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x015c -> B:35:0x018b). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int length;
        int i;
        File externalFilesDir;
        File externalFilesDir2;
        List list;
        boolean checkSingleFile;
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
            ResultKt.throwOnFailure(obj);
            this.$updateFiles.addAll((List) obj);
            i++;
            if (i >= length) {
                JSONObject jSONObject = this.$sources.getJSONObject(i);
                if (Intrinsics.areEqual(jSONObject.getString("type"), "dir")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    String string = jSONObject.getString("name");
                    UpdateService updateService = this.this$0;
                    Intrinsics.checkNotNull(jSONArray);
                    String str = this.$dir;
                    this.I$0 = i;
                    this.I$1 = length;
                    this.label = 1;
                    obj = updateService.getFilesToDownload(jSONArray, str + RemoteSettings.FORWARD_SLASH_STRING + string, this.$destDir, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.$updateFiles.addAll((List) obj);
                    i++;
                    if (i >= length) {
                        return Unit.INSTANCE;
                    }
                } else {
                    if (Intrinsics.areEqual(jSONObject.getString("type"), "file")) {
                        String string2 = jSONObject.getString("name");
                        File file = new File((this.this$0.getExternalFilesDir(null) != null ? externalFilesDir2.getPath() : null) + this.$destDir + this.$dir + RemoteSettings.FORWARD_SLASH_STRING + string2);
                        list = UpdateService.excludeFromCheck;
                        if (!list.contains(file.getName())) {
                            UpdateService updateService2 = this.this$0;
                            Intrinsics.checkNotNull(jSONObject);
                            checkSingleFile = updateService2.checkSingleFile(file, jSONObject, false, false);
                            if (!checkSingleFile) {
                                this.$updateFiles.add(new Pair<>(this.$destDir + this.$dir + RemoteSettings.FORWARD_SLASH_STRING + string2, Boxing.boxLong(jSONObject.getLong("size"))));
                            }
                        }
                    } else if (Intrinsics.areEqual(jSONObject.getString("type"), "res")) {
                        String string3 = jSONObject.getString("name");
                        if (!new File((this.this$0.getExternalFilesDir(null) != null ? externalFilesDir.getPath() : null) + this.$destDir + this.$dir + RemoteSettings.FORWARD_SLASH_STRING + string3).exists()) {
                            this.$updateFiles.add(new Pair<>(this.$destDir + this.$dir + RemoteSettings.FORWARD_SLASH_STRING + string3, Boxing.boxLong(jSONObject.getLong("size"))));
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
