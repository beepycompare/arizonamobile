package defpackage;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.miami.game.core.connection.resolver.FirebaseConfigHelper;
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
@DebugMetadata(c = "LauncherBackgroundWriter$syncRemoteAndUpdate$1", f = "BackgroundManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {121}, m = "invokeSuspend", n = {"$this$launch", "url", "lastUrl", TypedValues.AttributesType.S_TARGET, "tmp", "baseUrl", "bmp", "downloaded"}, nl = {122}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0"}, v = 2)
/* renamed from: LauncherBackgroundWriter$syncRemoteAndUpdate$1  reason: default package */
/* loaded from: classes2.dex */
public final class LauncherBackgroundWriter$syncRemoteAndUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $maxSidePx;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
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

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SharedPreferences sharedPreferences;
        boolean z;
        Object m9182constructorimpl;
        Bitmap decodeBitmapSafe;
        Object emitNew;
        boolean isDecodableImage;
        SharedPreferences sharedPreferences2;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LauncherBackgroundWriter.INSTANCE.ensureDefaultExists();
            String string = LauncherBackgroundWriter.INSTANCE.getRemoteConfigProvider().getString("launcher_background");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String obj2 = StringsKt.trim((CharSequence) string).toString();
            if (obj2.length() == 0) {
                return Unit.INSTANCE;
            }
            sharedPreferences = LauncherBackgroundWriter.prefs;
            if (sharedPreferences == null) {
                Intrinsics.throwUninitializedPropertyAccessException("prefs");
                sharedPreferences = null;
            }
            String string2 = sharedPreferences.getString("last_url", "");
            String str = string2 != null ? string2 : "";
            if (Intrinsics.areEqual(obj2, str)) {
                return Unit.INSTANCE;
            }
            File targetFile = LauncherBackgroundWriter.INSTANCE.targetFile();
            File file = new File(targetFile.getParentFile(), targetFile.getName() + ".tmp");
            String resourceUrl$default = FirebaseConfigHelper.getResourceUrl$default(FirebaseConfigHelper.INSTANCE, false, 1, null);
            z = LauncherBackgroundWriter.isArizona;
            String str2 = resourceUrl$default + (z ? "projects/arizona-rp" : "projects/rodina-rp");
            try {
                Result.Companion companion = Result.Companion;
                LauncherBackgroundWriter.INSTANCE.downloadToFile(str2 + obj2, file);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m9182constructorimpl = Result.m9182constructorimpl(ResultKt.createFailure(th));
            }
            if (file.exists() && file.length() > 0) {
                isDecodableImage = LauncherBackgroundWriter.INSTANCE.isDecodableImage(file);
                if (!isDecodableImage) {
                    throw new IllegalStateException("Not an image".toString());
                }
                if (targetFile.exists()) {
                    targetFile.delete();
                }
                if (file.renameTo(targetFile)) {
                    sharedPreferences2 = LauncherBackgroundWriter.prefs;
                    if (sharedPreferences2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("prefs");
                        sharedPreferences2 = null;
                    }
                    sharedPreferences2.edit().putString("last_url", obj2).apply();
                    m9182constructorimpl = Result.m9182constructorimpl(Boxing.boxBoolean(true));
                    if (Result.m9185exceptionOrNullimpl(m9182constructorimpl) != null) {
                        file.delete();
                        m9182constructorimpl = Boxing.boxBoolean(false);
                    }
                    boolean booleanValue = ((Boolean) m9182constructorimpl).booleanValue();
                    if (booleanValue) {
                        decodeBitmapSafe = LauncherBackgroundWriter.INSTANCE.decodeBitmapSafe(targetFile, this.$maxSidePx);
                        LauncherBackgroundWriter launcherBackgroundWriter = LauncherBackgroundWriter.INSTANCE;
                        ImageBitmap asImageBitmap = decodeBitmapSafe != null ? AndroidImageBitmap_androidKt.asImageBitmap(decodeBitmapSafe) : null;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(str);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(targetFile);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(file);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(str2);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(decodeBitmapSafe);
                        this.Z$0 = booleanValue;
                        this.label = 1;
                        emitNew = launcherBackgroundWriter.emitNew(targetFile, asImageBitmap, this);
                        if (emitNew == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        return Unit.INSTANCE;
                    }
                } else {
                    throw new IllegalStateException("Rename failed".toString());
                }
            } else {
                throw new IllegalStateException("Empty download".toString());
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Bitmap bitmap = (Bitmap) this.L$6;
            String str3 = (String) this.L$5;
            File file2 = (File) this.L$4;
            File file3 = (File) this.L$3;
            String str4 = (String) this.L$2;
            String str5 = (String) this.L$1;
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
