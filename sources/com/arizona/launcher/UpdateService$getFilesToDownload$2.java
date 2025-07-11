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
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpdateService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.arizona.launcher.UpdateService$getFilesToDownload$2", f = "UpdateService.kt", i = {0, 0, 0, 0}, l = {799}, m = "invokeSuspend", n = {"jsonObject", "jsonArray", "jsonDir", CmcdData.OBJECT_TYPE_INIT_SEGMENT}, s = {"L$0", "L$1", "L$2", "I$0"})
/* loaded from: classes3.dex */
public final class UpdateService$getFilesToDownload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $destDir;
    final /* synthetic */ String $dir;
    final /* synthetic */ JSONArray $sources;
    final /* synthetic */ List<Pair<String, Long>> $updateFiles;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
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

    /* JADX WARN: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01ad  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0095 -> B:15:0x0098). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00f4 -> B:35:0x01aa). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0101 -> B:35:0x01aa). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0103 -> B:35:0x01aa). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x013d -> B:35:0x01aa). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0179 -> B:35:0x01aa). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x017b -> B:35:0x01aa). Please submit an issue!!! */
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
            String str = (String) this.L$2;
            JSONArray jSONArray = (JSONArray) this.L$1;
            JSONObject jSONObject = (JSONObject) this.L$0;
            ResultKt.throwOnFailure(obj);
            this.$updateFiles.addAll((List) obj);
            i++;
            if (i >= length) {
                JSONObject jSONObject2 = this.$sources.getJSONObject(i);
                if (Intrinsics.areEqual(jSONObject2.getString("type"), "dir")) {
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("data");
                    String string = jSONObject2.getString("name");
                    UpdateService updateService = this.this$0;
                    Intrinsics.checkNotNull(jSONArray2);
                    String str2 = this.$dir;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(jSONObject2);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(jSONArray2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(string);
                    this.I$0 = i;
                    this.I$1 = length;
                    this.label = 1;
                    obj = updateService.getFilesToDownload(jSONArray2, str2 + RemoteSettings.FORWARD_SLASH_STRING + string, this.$destDir, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.$updateFiles.addAll((List) obj);
                    i++;
                    if (i >= length) {
                        return Unit.INSTANCE;
                    }
                } else {
                    if (Intrinsics.areEqual(jSONObject2.getString("type"), "file")) {
                        String string2 = jSONObject2.getString("name");
                        File file = new File((this.this$0.getExternalFilesDir(null) != null ? externalFilesDir2.getPath() : null) + this.$destDir + this.$dir + RemoteSettings.FORWARD_SLASH_STRING + string2);
                        list = UpdateService.excludeFromCheck;
                        if (!list.contains(file.getName())) {
                            UpdateService updateService2 = this.this$0;
                            Intrinsics.checkNotNull(jSONObject2);
                            checkSingleFile = updateService2.checkSingleFile(file, jSONObject2, false, false);
                            if (!checkSingleFile) {
                                this.$updateFiles.add(new Pair<>(this.$destDir + this.$dir + RemoteSettings.FORWARD_SLASH_STRING + string2, Boxing.boxLong(jSONObject2.getLong("size"))));
                            }
                        }
                    } else if (Intrinsics.areEqual(jSONObject2.getString("type"), "res")) {
                        String string3 = jSONObject2.getString("name");
                        if (!new File((this.this$0.getExternalFilesDir(null) != null ? externalFilesDir.getPath() : null) + this.$destDir + this.$dir + RemoteSettings.FORWARD_SLASH_STRING + string3).exists()) {
                            this.$updateFiles.add(new Pair<>(this.$destDir + this.$dir + RemoteSettings.FORWARD_SLASH_STRING + string3, Boxing.boxLong(jSONObject2.getLong("size"))));
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
