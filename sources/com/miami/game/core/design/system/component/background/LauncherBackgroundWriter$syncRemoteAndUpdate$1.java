package com.miami.game.core.design.system.component.background;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackgroundManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.miami.game.core.design.system.component.background.LauncherBackgroundWriter$syncRemoteAndUpdate$1", f = "BackgroundManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {250}, m = "invokeSuspend", n = {"$this$launch", "key", "remotePath", "remoteFileName", "currentFileName", "dir", "currentFile", "fullUrl", TypedValues.AttributesType.S_TARGET, "tmp", "bmp", "downloaded"}, nl = {251}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "Z$0"}, v = 2)
/* loaded from: classes4.dex */
public final class LauncherBackgroundWriter$syncRemoteAndUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $maxSidePx;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$10;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LauncherBackgroundWriter$syncRemoteAndUpdate$1(int i, Continuation<? super LauncherBackgroundWriter$syncRemoteAndUpdate$1> continuation) {
        super(2, continuation);
        this.$maxSidePx = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LauncherBackgroundWriter$syncRemoteAndUpdate$1 launcherBackgroundWriter$syncRemoteAndUpdate$1 = new LauncherBackgroundWriter$syncRemoteAndUpdate$1(this.$maxSidePx, continuation);
        launcherBackgroundWriter$syncRemoteAndUpdate$1.L$0 = obj;
        return launcherBackgroundWriter$syncRemoteAndUpdate$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LauncherBackgroundWriter$syncRemoteAndUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:81:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0360 A[Catch: all -> 0x0423, TryCatch #1 {all -> 0x0423, blocks: (B:29:0x0103, B:31:0x0169, B:33:0x016f, B:35:0x0177, B:37:0x017f, B:79:0x0358, B:86:0x0385, B:88:0x038d, B:90:0x0395, B:82:0x0360, B:84:0x036b, B:85:0x0381, B:78:0x034e), top: B:111:0x0103 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x038d A[Catch: all -> 0x0423, TryCatch #1 {all -> 0x0423, blocks: (B:29:0x0103, B:31:0x0169, B:33:0x016f, B:35:0x0177, B:37:0x017f, B:79:0x0358, B:86:0x0385, B:88:0x038d, B:90:0x0395, B:82:0x0360, B:84:0x036b, B:85:0x0381, B:78:0x034e), top: B:111:0x0103 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0395 A[Catch: all -> 0x0423, TRY_LEAVE, TryCatch #1 {all -> 0x0423, blocks: (B:29:0x0103, B:31:0x0169, B:33:0x016f, B:35:0x0177, B:37:0x017f, B:79:0x0358, B:86:0x0385, B:88:0x038d, B:90:0x0395, B:82:0x0360, B:84:0x036b, B:85:0x0381, B:78:0x034e), top: B:111:0x0103 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        boolean z;
        String buildLocalFileName;
        SharedPreferences sharedPreferences;
        File ensureDir;
        String buildRemoteUrl;
        Object m9183constructorimpl;
        Throwable m9186exceptionOrNullimpl;
        Boolean bool;
        boolean booleanValue;
        Bitmap decodeBitmapSafe;
        Object emitNew;
        boolean isDecodableImage;
        SharedPreferences sharedPreferences2;
        String str = "syncRemoteAndUpdate: prefs saved result=";
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Log.d("LauncherBgWriter", "syncRemoteAndUpdate: start");
                LauncherBackgroundWriter.INSTANCE.ensureDefaultExists();
                z = LauncherBackgroundWriter.isArizona;
                String str2 = z ? "launcher_background" : "launcher_background_rodina";
                String string = LauncherBackgroundWriter.INSTANCE.getRemoteConfigProvider().getString(str2);
                String str3 = str2;
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String obj2 = StringsKt.trim((CharSequence) string).toString();
                Log.d("LauncherBgWriter", "syncRemoteAndUpdate: remotePath=[" + obj2 + "]");
                if (obj2.length() != 0) {
                    buildLocalFileName = LauncherBackgroundWriter.INSTANCE.buildLocalFileName(obj2);
                    sharedPreferences = LauncherBackgroundWriter.prefs;
                    if (sharedPreferences == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("prefs");
                        sharedPreferences = null;
                    }
                    String string2 = sharedPreferences.getString("current_file_name", "background_home.webp");
                    if (string2 == null) {
                        string2 = "background_home.webp";
                    }
                    try {
                        ensureDir = LauncherBackgroundWriter.INSTANCE.ensureDir();
                        File file = new File(ensureDir, string2);
                        Log.d("LauncherBgWriter", "syncRemoteAndUpdate: remoteFileName=" + buildLocalFileName);
                        Log.d("LauncherBgWriter", "syncRemoteAndUpdate: currentFileName=" + string2);
                        Log.d("LauncherBgWriter", "syncRemoteAndUpdate: currentFile=" + file.getAbsolutePath() + ", exists=" + file.exists() + ", size=" + file.length());
                        if (!Intrinsics.areEqual(string2, buildLocalFileName) || !file.exists() || file.length() <= 0) {
                            buildRemoteUrl = LauncherBackgroundWriter.INSTANCE.buildRemoteUrl(obj2);
                            Log.d("LauncherBgWriter", "syncRemoteAndUpdate: fullUrl=" + buildRemoteUrl);
                            File file2 = new File(ensureDir, buildLocalFileName);
                            File file3 = new File(file2.getParentFile(), file2.getName() + ".tmp");
                            Log.d("LauncherBgWriter", "syncRemoteAndUpdate: target=" + file2.getAbsolutePath());
                            Log.d("LauncherBgWriter", "syncRemoteAndUpdate: tmp=" + file3.getAbsolutePath());
                            try {
                                Result.Companion companion = Result.Companion;
                                if (file3.exists()) {
                                    Log.d("LauncherBgWriter", "syncRemoteAndUpdate: delete old tmp=" + file3.getAbsolutePath());
                                    file3.delete();
                                }
                                LauncherBackgroundWriter.INSTANCE.downloadToFile(buildRemoteUrl, file3);
                                Log.d("LauncherBgWriter", "syncRemoteAndUpdate: after download tmpExists=" + file3.exists() + ", tmpSize=" + file3.length());
                                try {
                                } catch (Throwable th) {
                                    th = th;
                                    Result.Companion companion2 = Result.Companion;
                                    m9183constructorimpl = Result.m9183constructorimpl(ResultKt.createFailure(th));
                                    m9186exceptionOrNullimpl = Result.m9186exceptionOrNullimpl(m9183constructorimpl);
                                    if (m9186exceptionOrNullimpl != null) {
                                    }
                                    booleanValue = ((Boolean) bool).booleanValue();
                                    if (!booleanValue) {
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                str = ensureDir;
                            }
                            if (file3.exists() && file3.length() > 0) {
                                isDecodableImage = LauncherBackgroundWriter.INSTANCE.isDecodableImage(file3);
                                if (!isDecodableImage) {
                                    throw new IllegalStateException("Downloaded file is not decodable image".toString());
                                }
                                if (file2.exists()) {
                                    Log.d("LauncherBgWriter", "syncRemoteAndUpdate: delete old target=" + file2.getAbsolutePath());
                                    file2.delete();
                                }
                                boolean renameTo = file3.renameTo(file2);
                                Log.d("LauncherBgWriter", "syncRemoteAndUpdate: rename tmp->target result=" + renameTo);
                                if (renameTo) {
                                    sharedPreferences2 = LauncherBackgroundWriter.prefs;
                                    if (sharedPreferences2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("prefs");
                                        sharedPreferences2 = null;
                                    }
                                    Log.d("LauncherBgWriter", str + sharedPreferences2.edit().putString("current_file_name", buildLocalFileName).commit());
                                    if (Intrinsics.areEqual(string2, buildLocalFileName)) {
                                        str = ensureDir;
                                    } else {
                                        File file4 = new File(ensureDir, string2);
                                        str = ensureDir;
                                        Log.d("LauncherBgWriter", "syncRemoteAndUpdate: oldFile=" + file4.getAbsolutePath() + ", exists=" + file4.exists() + ", size=" + file4.length());
                                        if (file4.exists() && !Intrinsics.areEqual(file4.getName(), "background_home.webp") && !Intrinsics.areEqual(file4.getName(), buildLocalFileName)) {
                                            Log.d("LauncherBgWriter", "syncRemoteAndUpdate: delete oldFile result=" + file4.delete());
                                        }
                                    }
                                    m9183constructorimpl = Result.m9183constructorimpl(Boxing.boxBoolean(true));
                                    m9186exceptionOrNullimpl = Result.m9186exceptionOrNullimpl(m9183constructorimpl);
                                    if (m9186exceptionOrNullimpl != null) {
                                        bool = m9183constructorimpl;
                                    } else {
                                        Log.e("LauncherBgWriter", "syncRemoteAndUpdate: download/update failed", m9186exceptionOrNullimpl);
                                        if (file3.exists()) {
                                            Log.d("LauncherBgWriter", "syncRemoteAndUpdate: tmp delete after fail result=" + file3.delete());
                                        }
                                        bool = Boxing.boxBoolean(false);
                                    }
                                    booleanValue = ((Boolean) bool).booleanValue();
                                    if (!booleanValue) {
                                        try {
                                            decodeBitmapSafe = LauncherBackgroundWriter.INSTANCE.decodeBitmapSafe(file2, this.$maxSidePx);
                                            Log.d("LauncherBgWriter", "syncRemoteAndUpdate: decoded target bitmapNull=" + (decodeBitmapSafe == null) + ", target=" + file2.getAbsolutePath());
                                            LauncherBackgroundWriter launcherBackgroundWriter = LauncherBackgroundWriter.INSTANCE;
                                            ImageBitmap asImageBitmap = decodeBitmapSafe != null ? AndroidImageBitmap_androidKt.asImageBitmap(decodeBitmapSafe) : null;
                                            this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                                            this.L$1 = SpillingKt.nullOutSpilledVariable(str3);
                                            this.L$2 = SpillingKt.nullOutSpilledVariable(obj2);
                                            this.L$3 = SpillingKt.nullOutSpilledVariable(buildLocalFileName);
                                            this.L$4 = SpillingKt.nullOutSpilledVariable(string2);
                                            this.L$5 = SpillingKt.nullOutSpilledVariable(str);
                                            this.L$6 = SpillingKt.nullOutSpilledVariable(file);
                                            this.L$7 = SpillingKt.nullOutSpilledVariable(buildRemoteUrl);
                                            this.L$8 = SpillingKt.nullOutSpilledVariable(file2);
                                            this.L$9 = SpillingKt.nullOutSpilledVariable(file3);
                                            this.L$10 = SpillingKt.nullOutSpilledVariable(decodeBitmapSafe);
                                            this.Z$0 = booleanValue;
                                            this.label = 1;
                                            emitNew = launcherBackgroundWriter.emitNew(file2, asImageBitmap, this);
                                            if (emitNew == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            Log.e("LauncherBgWriter", "syncRemoteAndUpdate: fatal error", th);
                                            return Unit.INSTANCE;
                                        }
                                    } else {
                                        Log.e("LauncherBgWriter", "syncRemoteAndUpdate: downloaded=false, stop");
                                        return Unit.INSTANCE;
                                    }
                                } else {
                                    throw new IllegalStateException("Rename failed".toString());
                                }
                            } else {
                                throw new IllegalStateException("Empty download".toString());
                            }
                        } else {
                            Log.d("LauncherBgWriter", "syncRemoteAndUpdate: same file already exists, skip download");
                            return Unit.INSTANCE;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } else {
                    Log.e("LauncherBgWriter", "syncRemoteAndUpdate: remotePath is empty, skip");
                    return Unit.INSTANCE;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                Bitmap bitmap = (Bitmap) this.L$10;
                File file5 = (File) this.L$9;
                File file6 = (File) this.L$8;
                String str4 = (String) this.L$7;
                File file7 = (File) this.L$6;
                File file8 = (File) this.L$5;
                String str5 = (String) this.L$4;
                String str6 = (String) this.L$3;
                String str7 = (String) this.L$2;
                String str8 = (String) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
        } catch (Throwable th5) {
            th = th5;
        }
        return Unit.INSTANCE;
    }
}
