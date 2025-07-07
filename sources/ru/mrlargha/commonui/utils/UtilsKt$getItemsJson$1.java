package ru.mrlargha.commonui.utils;

import android.content.Context;
import android.util.Log;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ru.mrlargha.commonui.elements.employmentNote.domain.FractionTasks;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.utils.UtilsKt$getItemsJson$1", f = "Utils.kt", i = {}, l = {285}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
public final class UtilsKt$getItemsJson$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $baseDir;
    final /* synthetic */ Context $context;
    final /* synthetic */ int $type;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UtilsKt$getItemsJson$1(int i, File file, Context context, Continuation<? super UtilsKt$getItemsJson$1> continuation) {
        super(2, continuation);
        this.$type = i;
        this.$baseDir = file;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UtilsKt$getItemsJson$1(this.$type, this.$baseDir, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UtilsKt$getItemsJson$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            int i2 = this.$type;
            String str = "items.json";
            if (i2 != 1) {
                if (i2 == 2) {
                    str = "fraction_tasks.json";
                } else if (i2 != 3) {
                    return Unit.INSTANCE;
                }
            }
            File file = new File(this.$baseDir, str);
            if (!file.exists()) {
                Log.w("getItemsJson", "File " + file.getAbsolutePath() + " isn't found");
                return Unit.INSTANCE;
            }
            String readText$default = FilesKt.readText$default(file, null, 1, null);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$type, readText$default, this.$context, this.$baseDir, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Utils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "ru.mrlargha.commonui.utils.UtilsKt$getItemsJson$1$1", f = "Utils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.mrlargha.commonui.utils.UtilsKt$getItemsJson$1$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $baseDir;
        final /* synthetic */ Context $context;
        final /* synthetic */ String $json;
        final /* synthetic */ int $type;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, String str, Context context, File file, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$type = i;
            this.$json = str;
            this.$context = context;
            this.$baseDir = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$type, this.$json, this.$context, this.$baseDir, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            int i = this.$type;
            if (i == 1) {
                UtilsKt.setItemsName(MapperKt.toListModel(this.$json, ItemsInfo.class));
                UtilsKt.getItemsJson(this.$context, 2, this.$baseDir);
            } else if (i == 2) {
                UtilsKt.setFractionTasks(MapperKt.toListModel(this.$json, FractionTasks.class));
            } else if (i == 3) {
                UtilsKt.setItemsName(MapperKt.toListModel(this.$json, ItemsInfo.class));
                UtilsKt.getItemsJson(this.$context, 2, this.$baseDir);
            }
            return Unit.INSTANCE;
        }
    }
}
