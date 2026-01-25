package ru.mrlargha.commonui.utils;

import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "ru.mrlargha.commonui.utils.UtilsKt$loadGifFromZipAsync$bytes$1", f = "Utils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* loaded from: classes6.dex */
public final class UtilsKt$loadGifFromZipAsync$bytes$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
    final /* synthetic */ String $folderName;
    final /* synthetic */ String $item;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UtilsKt$loadGifFromZipAsync$bytes$1(String str, String str2, Continuation<? super UtilsKt$loadGifFromZipAsync$bytes$1> continuation) {
        super(2, continuation);
        this.$folderName = str;
        this.$item = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UtilsKt$loadGifFromZipAsync$bytes$1(this.$folderName, this.$item, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
        return ((UtilsKt$loadGifFromZipAsync$bytes$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ZipFile zipFileIcons = UtilsKt.getZipFileIcons();
        if (zipFileIcons != null) {
            ZipEntry entry = zipFileIcons.getEntry(this.$folderName + "/" + this.$item);
            if (entry != null) {
                ZipFile zipFileIcons2 = UtilsKt.getZipFileIcons();
                InputStream inputStream = zipFileIcons2 != null ? zipFileIcons2.getInputStream(entry) : null;
                try {
                    InputStream inputStream2 = inputStream;
                    byte[] readBytes = inputStream2 != null ? ByteStreamsKt.readBytes(inputStream2) : null;
                    CloseableKt.closeFinally(inputStream, null);
                    return readBytes;
                } finally {
                }
            }
        }
        return null;
    }
}
